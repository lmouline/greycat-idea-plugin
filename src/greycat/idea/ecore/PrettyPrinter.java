package greycat.idea.ecore;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.*;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

public class PrettyPrinter {

    void prettyPrint(File ecoreModel, Writer writer) throws IOException {
        ResourceSet rs = getEcoreModel(ecoreModel);
        TreeIterator<Notifier> iterator = rs.getAllContents();
        while (iterator.hasNext()) {
            Notifier notifier = iterator.next();
            if (notifier instanceof EClass) {
                printClass(writer, (EClass) notifier);
            }
            if (notifier instanceof EEnum) {
                printEnum(writer, (EEnum) notifier);
            }
        }
    }

    static String convertType(String originalNameFull) {
        String originalName = originalNameFull;
        if (originalName.startsWith("ecore.")) {
            originalName = originalName.substring(6);
        }
        if (originalName.startsWith("java.lang.")) {
            originalName = originalName.substring(10);
        }
        if (originalName.equals("String") || originalName.equals("EString") || originalName.equals("EStringObject")) {
            return "String";
        }
        if (originalName.equals("Boolean") || originalName.equals("boolean") || originalName.equals("EBoolean") || originalName.equals("EBooleanObject")) {
            return "Bool";
        }
        if (originalName.equals("Integer") || originalName.equals("EInt") || originalName.equals("EIntegerObject")) {
            return "Integer";
        }
        if (originalName.equals("Long") || originalName.equals("ELong") || originalName.equals("ELongObject")) {
            return "Long";
        }
        if (originalName.equals("Short") || originalName.equals("EShort") || originalName.equals("EShortObject")) {
            return "Short";
        }
        if (originalName.equals("Double") || originalName.equals("EDouble") || originalName.equals("EDoubleObject")) {
            return "Double";
        }
        if (originalName.equals("Float") || originalName.equals("EFloat") || originalName.equals("EFloatObject")) {
            return "Float";
        }
        return originalName;
    }

    private void printEnum(Writer sw, EEnum en) throws IOException {
        sw.write("\n");
        sw.write("enum " + fqn(en) + " {\n");
        for (EEnumLiteral literal : en.getELiterals()) {
            sw.append("    " + literal.getLiteral() + "\n");
        }
        sw.write("}\n");
    }

    private void printClass(Writer sw, EClass cls) throws IOException {
        String superTypes = "";
        if (!cls.getESuperTypes().isEmpty()) {
            for (EClassifier st : cls.getESuperTypes()) {
                superTypes = superTypes + (superTypes.equals("") ? "extends " : ",") + fqn(st);
            }
        }

        sw.write("\n");
        sw.write("class " + fqn(cls) + " " + superTypes + " {\n");

        StringBuffer ids = new StringBuffer();
        for (EAttribute eAttribute : cls.getEAttributes()) {
            /*
            for (EAnnotation ea : eAttribute.getEAnnotations()) {
                if (ea.getSource().equals("precision")) {
                    String level = ea.getDetails().get("level");
                    if (level != null) {
                        sw.write("    @precision(" + level + ")\n");
                    } else {
                        sw.write("    @precision\n");
                    }
                }
            }*/
            if (eAttribute.isID()) {
                if (ids.length() == 0) {
                    ids.append("\n\tindexed by " + eAttribute.getName());
                } else {
                    ids.append("," + eAttribute.getName());
                }
            }
            sw.append("    att " + eAttribute.getName() + " : " + convertType(fqn(eAttribute.getEType())) + /*multiplicity +*/ "\n");
        }
        if (ids.length() > 0) {
            sw.write(ids.toString() + "\n");
        }
        for (EReference eRef : cls.getEReferences()) {
            /*
            String multiplicity = "";
            String opposite = "";
            if (eRef.getUpperBound() != 1 || eRef.getLowerBound() != 1) {
                multiplicity = multiplicity + "[";
                if (eRef.getLowerBound() == -1) {
                    multiplicity = multiplicity + "*";
                } else {
                    multiplicity = multiplicity + eRef.getLowerBound();
                }
                multiplicity = multiplicity + ",";
                if (eRef.getUpperBound() == -1) {
                    multiplicity = multiplicity + "*";
                } else {
                    multiplicity = multiplicity + eRef.getUpperBound();
                }
                multiplicity = multiplicity + "]";
            }
            if (eRef.getEOpposite() != null) {
                opposite = " oppositeOf " + eRef.getEOpposite().getName();
            }*/
            sw.append("    rel " + eRef.getName() + " : " + convertType(fqn(eRef.getEType())) + /*multiplicity + opposite +*/ "\n");
        }

        for (EOperation eOperation : cls.getEOperations()) {
            sw.append("    func " + eOperation.getName());
            if (!eOperation.getEParameters().isEmpty()) {
                sw.append("(");
                boolean isFirst = true;
                for (EParameter p : eOperation.getEParameters()) {
                    if (!isFirst) {
                        sw.append(" ,");
                    }
                    sw.append(p.getName() + " : " + convertType(fqn(p.getEType())));
                    isFirst = false;
                }
                sw.append(")");
            }
            if (eOperation.getEType() != null) {
                sw.append(" : " + convertType(fqn(eOperation.getEType())));
            }
            sw.write("\n");
        }

        sw.write("}\n");
    }


    protected ResourceSet getEcoreModel(File ecorefile) {

        ResourceSetImpl rs = new ResourceSetImpl();
        Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
        try {
            URI fileUri = URI.createFileURI(ecorefile.getCanonicalPath());
            Resource resource = rs.createResource(fileUri);
            resource.load(null);
            EcoreUtil.resolveAll(resource);
            rs.getResources().add(resource);
            EcoreUtil.resolveAll(rs);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return rs;
    }


    /**
     * Computes the Fully Qualified Name of the package in the context of the model.
     *
     * @param pack the package which FQN has to be computed
     * @return the Fully Qualified package name
     */
    public String fqn(EPackage pack) {

        if (pack == null) {
            try {
                throw new Exception("Null Package , stop generation");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String locFqn = pack.getName().toLowerCase();
        EPackage parentPackage = pack.getESuperPackage();
        while (parentPackage != null) {
            locFqn = parentPackage.getName() + "." + locFqn;
            parentPackage = parentPackage.getESuperPackage();
        }
        return locFqn;
    }

    /**
     * Computes the Fully Qualified Name of the class in the context of the model.
     *
     * @param cls the class which FQN has to be computed
     * @return the Fully Qualified Class name
     */
    public String fqn(EClassifier cls) {
        if (cls.getInstanceClassName() != null) {
            return cls.getInstanceClassName();
        } else {
            if (cls.getEPackage() == null) {
                return cls.getName();
            } else {
                return fqn(cls.getEPackage()) + "." + cls.getName();
            }
        }
    }

}