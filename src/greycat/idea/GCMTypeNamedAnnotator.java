package greycat.idea;

import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import greycat.idea.psi.*;
import org.jetbrains.annotations.NotNull;

public class GCMTypeNamedAnnotator implements Annotator {
    @Override
    public void annotate(@NotNull final PsiElement psiElement, @NotNull final AnnotationHolder annotationHolder) {

        if (psiElement instanceof GCMTypeDeclaration) {
            //if (((MetaModelTypeDeclaration) psiElement).getName().indexOf(".") < 1) {
            //for (PrimitiveTypes p : PrimitiveTypes.values()) {
            //    if (((MetaModelTypeDeclaration) psiElement).getName().equals(p.name())) {
            //       return;
            //    }
            //}
            //annotationHolder.createErrorAnnotation(psiElement, "Type identifier must be a qualified name with at least one package as : pack.ClassName");
            //} else {
            final GCMTypeDeclaration casted = (GCMTypeDeclaration) psiElement;
            if (casted != null && casted.getParent() != null && casted.getParent() instanceof GCMAttributeDeclaration) {
                final boolean[] isValidated = {false};

                if (GCMPrimitiveTypes.isPrimitive(casted.getName())) {
                    isValidated[0] = true;
                }

                    /*
                    for (PrimitiveTypes p : PrimitiveTypes.values()) {
                        if (casted.getName().equals(p.name())) {

                        }
                    }*/
                if (!isValidated[0]) {
                    //look for enum
                    PsiElement parent = psiElement.getParent();
                    if (!(parent instanceof GCMClassDeclaration) && !(parent instanceof GCMEnumDeclaration)) {
                        PsiFile file = psiElement.getContainingFile();
                        file.acceptChildren(new GCMVisitor() {
                            @Override
                            public void visitPsiElement(@NotNull PsiElement o) {
                                super.visitPsiElement(o);
                                if (o != null && !isValidated[0]) {
                                    o.acceptChildren(this);
                                }
                            }

                            @Override
                            public void visitEnumDeclaration(@NotNull GCMEnumDeclaration o) {
                                if (o != null && o.getTypeDeclaration() != null && o.getTypeDeclaration().getName() != null && o.getTypeDeclaration().getName().equals(casted.getName())) {
                                    isValidated[0] = true;
                                }
                            }

                        });
                        if (!isValidated[0]) {
                            annotationHolder.createErrorAnnotation(psiElement, "References and Dependencies must have a declared type, please declare corresponding class");
                        }
                    }
                }
                if (!isValidated[0]) {
                    annotationHolder.createErrorAnnotation(psiElement, "Attributes and Outputs must have a primitive type such as Long, Double, Continous, Integer or Bool");
                }
            } else if (casted != null && casted.getParent() != null && casted.getParent() instanceof GCMRelationDeclaration) {
                final boolean[] isValidated = {false};
                if (!isValidated[0]) {
                    PsiElement parent = psiElement.getParent();
                    if (!(parent instanceof GCMClassDeclaration) && !(parent instanceof GCMEnumDeclaration)) {
                        PsiFile file = psiElement.getContainingFile();
                        file.acceptChildren(new GCMVisitor() {
                            @Override
                            public void visitPsiElement(@NotNull PsiElement o) {
                                super.visitPsiElement(o);
                                if (o != null && !isValidated[0]) {
                                    o.acceptChildren(this);
                                }
                            }

                            @Override
                            public void visitClassDeclaration(@NotNull GCMClassDeclaration o) {
                                if (o != null && o.getTypeDeclaration() != null && o.getTypeDeclaration().getName() != null && o.getTypeDeclaration().getName().equals(casted.getName())) {
                                    isValidated[0] = true;
                                }
                            }
                        });
                        if (!isValidated[0]) {
                            annotationHolder.createErrorAnnotation(psiElement, "References and Dependencies must have a declared type, please declare corresponding class");
                        }
                    }
                }
            }
            //}
        }
    }
}
