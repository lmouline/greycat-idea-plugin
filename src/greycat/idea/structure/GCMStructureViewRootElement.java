package greycat.idea.structure;

import com.intellij.ide.structureView.StructureViewTreeElement;
import com.intellij.ide.util.treeView.smartTree.TreeElement;
import com.intellij.navigation.ItemPresentation;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.editor.Editor;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import greycat.idea.GCMIcons;
import greycat.idea.psi.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GCMStructureViewRootElement implements StructureViewTreeElement {

    private PsiFile element;
    private Editor editor;
    public List<StructureViewTreeElement> innerClasses = new ArrayList<StructureViewTreeElement>();
    public HashMap<String, GCMStructureViewPackageElement> packages = new HashMap<String, GCMStructureViewPackageElement>();

    public GCMStructureViewRootElement(PsiFile element, Editor editor) {
        this.element = element;
        this.editor = editor;
    }

    public void refresh() {
        ApplicationManager.getApplication().runReadAction(new Runnable() {
            public void run() {
                // do whatever you need to do

                innerClasses.clear();
                packages.clear();
                GCMVisitor visitor = new GCMVisitor() {

                    @Override
                    public void visitClassDeclaration(@NotNull GCMClassDeclaration o) {
                        super.visitClassDeclaration(o);
                        if (o.getTypeDeclaration() != null) {
                            GCMStructureViewClassElement classElement = new GCMStructureViewClassElement(o, editor);
                            if (o.getParentsDeclaration() != null) {
                                //for (GCMTypeDeclaration d : o.getParentsDeclaration()) {
                                classElement.parents.add(new GCMStructureViewParentElement(o.getParentsDeclaration().getTypeDeclaration(), editor));
                                // }
                            }
                            processSubDec(o, classElement, editor);
                            if (o.getTypeDeclaration().getName().lastIndexOf(".") != -1) {
                                processPackages(GCMStructureViewRootElement.this, o.getTypeDeclaration().getName()).innerClasses.add(classElement);
                            } else {
                                GCMStructureViewRootElement.this.innerClasses.add(classElement);
                            }
                        }
                    }

                    @Override
                    public void visitEnumDeclaration(@NotNull GCMEnumDeclaration o) {
                        super.visitEnumDeclaration(o);
                        if (o.getTypeDeclaration() != null) {
                            GCMStructureViewEnumElement enumElement = new GCMStructureViewEnumElement(o, editor);
                            processEnumValues(o, enumElement, editor);
                            if (o.getTypeDeclaration().getName().lastIndexOf(".") != -1) {
                                processPackages(GCMStructureViewRootElement.this, o.getTypeDeclaration().getName()).innerClasses.add(enumElement);
                            } else {
                                GCMStructureViewRootElement.this.innerClasses.add(enumElement);
                            }
                        }
                    }

                    @Override
                    public void visitKeyDeclaration(@NotNull GCMKeyDeclaration o) {
                        super.visitKeyDeclaration(o);
                        /*
                        GCMStructureViewIndexElement indexElement = new GCMStructureViewIndexElement(o, editor);
                        processIndexValues(o, indexElement, editor);
                        if (o.getTypeDeclarationList().get(0).getName().lastIndexOf(".") != -1) {
                            processPackages(GCMStructureViewRootElement.this, o.getTypeDeclarationList().get(0).getName()).innerClasses.add(indexElement);
                        } else {
                            GCMStructureViewRootElement.this.innerClasses.add(indexElement);
                        }
                        */
                    }

                    @Override
                    public void visitPsiElement(@NotNull PsiElement o) {
                        super.visitPsiElement(o);
                        o.acceptChildren(this);
                    }
                };
                element.acceptChildren(visitor);
            }
        });
    }

    @Override
    public Object getValue() {
        return element;
    }

    @Override
    public void navigate(boolean b) {

    }

    @Override
    public boolean canNavigate() {
        return false;
    }

    @Override
    public boolean canNavigateToSource() {
        return false;
    }

    @NotNull
    @Override
    public ItemPresentation getPresentation() {
        return new ItemPresentation() {
            @Nullable
            @Override
            public String getPresentableText() {
                return element.getVirtualFile().getName().toString();
            }

            @Nullable
            @Override
            public String getLocationString() {
                return element.getVirtualFile().getCanonicalPath();
            }

            @Nullable
            @Override
            public Icon getIcon(boolean b) {
                return GCMIcons.GCM_ICON_16x16;
            }
        };
    }

    @Override
    public TreeElement[] getChildren() {
        List<TreeElement> res = new ArrayList<TreeElement>();
        res.addAll(packages.values());
        res.addAll(innerClasses);
        return res.toArray(new TreeElement[res.size()]);
    }

    private GCMStructureViewPackageElement processPackages(GCMStructureViewRootElement root, String name) {
        GCMStructureViewPackageElement currentPackage = null;
        String fqPackage = name.substring(0, name.lastIndexOf("."));
        String[] packages = fqPackage.split(".");

        if (packages.length == 0) {
            currentPackage = getOrPut(root.packages, fqPackage);
        } else {
            for (String pack : packages) {
                if (currentPackage == null) {
                    currentPackage = getOrPut(root.packages, pack);
                } else {
                    currentPackage = getOrPut(currentPackage.packages, pack);
                }
            }
        }
        return currentPackage;
    }


    private GCMStructureViewPackageElement getOrPut(Map<String, GCMStructureViewPackageElement> packageMap, String packageName) {
        GCMStructureViewPackageElement pack = packageMap.get(packageName);
        if (pack == null) {
            pack = new GCMStructureViewPackageElement(packageName);
            packageMap.put(packageName, pack);
        }
        return pack;
    }

    private void processSubDec(GCMClassDeclaration o, GCMStructureViewClassElement classElement, Editor editor) {
        for (GCMClassElemDeclaration relDec : o.getClassElemDeclarationList()) {
            if (relDec.getRelationDeclaration() != null) {
                GCMStructureViewReferenceElement referenceElement = new GCMStructureViewReferenceElement(relDec.getRelationDeclaration(), editor);
                classElement.references.add(referenceElement);
            } else if (relDec.getAttributeDeclaration() != null) {
                GCMStructureViewAttributeElement attributeElement = new GCMStructureViewAttributeElement(relDec.getAttributeDeclaration(), editor);
                classElement.attributes.add(attributeElement);
            } else {
                System.err.println("Could not find appropriate ClassElem declaration type in processReference for Structure view");
            }
        }


    }
/*
    private void processIndexValues(MetaModelIndexDeclaration o, GCMStructureViewIndexElement enumElement, Editor editor) {
        for (MetaModelIndexElemDeclaration indexValDec : o.getIndexElemDeclarationList()) {
            GCMStructureViewIndexElementElement indexValElement = new GCMStructureViewIndexElementElement(indexValDec, editor);
            enumElement.elements.add(indexValElement);
        }
    }*/

    private void processEnumValues(GCMEnumDeclaration o, GCMStructureViewEnumElement enumElement, Editor editor) {
        for (GCMEnumElemDeclaration enumValDec : o.getEnumElemDeclarationList()) {
            GCMStructureViewEnumElementElement enumValElement = new GCMStructureViewEnumElementElement(enumValDec, editor);
            enumElement.elements.add(enumValElement);
        }
    }
}
