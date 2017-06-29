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
            final GCMTypeDeclaration casted = (GCMTypeDeclaration) psiElement;
            if (casted.getParent() != null && casted.getParent() instanceof GCMAttributeDeclaration) {
                final boolean[] isValidated = {false};
                if (GCMPrimitiveTypes.isPrimitive(casted.getName())) {
                    isValidated[0] = true;
                }
                if (!isValidated[0]) {
                    //look for enum
                    PsiElement parent = psiElement.getParent();
                    if (!(parent instanceof GCMClassDeclaration) && !(parent instanceof GCMCustomTypeDeclaration)) {
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
                            public void visitCustomTypeDeclaration(@NotNull GCMCustomTypeDeclaration o) {
                                if (o != null && o.getIdent() != null && o.getIdent().getText().equals(casted.getName())) {
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
                    annotationHolder.createErrorAnnotation(psiElement, "Attributes must have a primitive type such as Long, Double, Task, Integer (Int) or Boolean (Bool) or user defined Type");
                }
            } else if (casted.getParent() != null && casted.getParent() instanceof GCMToManyDeclaration) {
                final boolean[] isValidated = {false};
                //if (!isValidated[0]) {
                // PsiElement parent = psiElement.getParent();
                // if (!(parent instanceof GCMClassDeclaration) && !(parent instanceof GCMToManyDeclaration)) {
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
                // }
                //}
            } else if (casted.getParent() != null && casted.getParent() instanceof GCMToOneDeclaration) {
                final boolean[] isValidated = {false};
                //if (!isValidated[0]) {
                // final PsiElement parent = casted.getParent().getParent();
                //if (!(parent instanceof GCMClassDeclaration) && !(parent instanceof GCMToOneDeclaration)) {
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
                // }
                //}
            }
        }
    }
}
