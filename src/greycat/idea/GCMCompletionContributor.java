package greycat.idea;

import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.util.ProcessingContext;
import greycat.idea.psi.*;
import org.jetbrains.annotations.NotNull;

public class GCMCompletionContributor extends CompletionContributor {

    private void fillInsideClassDecl(CompletionResultSet resultSet) {
        resultSet.addElement(LookupElementBuilder.create("att "));
        resultSet.addElement(LookupElementBuilder.create("rel "));
        resultSet.addElement(LookupElementBuilder.create("ref "));
        resultSet.addElement(LookupElementBuilder.create("key "));
        resultSet.addElement(LookupElementBuilder.create("key with time "));
    }

    public GCMCompletionContributor() {
        extend(CompletionType.BASIC,
                PlatformPatterns.psiElement(GCMTypes.IDENT).withLanguage(GCMLanguage.INSTANCE).afterLeaf(PlatformPatterns.psiElement(GCMTypes.COLON)),
                new CompletionProvider<CompletionParameters>() {
                    public void addCompletions(@NotNull final CompletionParameters parameters,
                                               ProcessingContext context,
                                               @NotNull final CompletionResultSet resultSet) {

                        if (parameters.getPosition().getParent() != null) {
                            if (parameters.getPosition().getParent().getParent() != null) {
                                if (parameters.getPosition().getParent().getParent() instanceof GCMAttributeDeclaration) {
                                    //add all attributes
                                    for (GCMPrimitiveTypes p : GCMPrimitiveTypes.values()) {
                                        resultSet.addElement(LookupElementBuilder.create(p.toString()));
                                    }
                                    parameters.getOriginalFile().acceptChildren(new GCMVisitor() {

                                        @Override
                                        public void visitPsiElement(@NotNull PsiElement o) {
                                            super.visitPsiElement(o);
                                            o.acceptChildren(this);
                                        }

                                        @Override
                                        public void visitCustomTypeDeclaration(@NotNull GCMCustomTypeDeclaration o) {
                                            resultSet.addElement(LookupElementBuilder.create(o.getIdent().getText()));
                                        }

                                    });
                                    resultSet.stopHere();
                                } else if (parameters.getPosition().getParent().getParent() instanceof GCMToManyDeclaration) {
                                    //add all know types
                                    parameters.getOriginalFile().acceptChildren(new PsiElementVisitor() {
                                        @Override
                                        public void visitElement(PsiElement element) {
                                            if (element instanceof GCMDeclaration) {
                                                GCMDeclaration declaration = (GCMDeclaration) element;
                                                if (declaration.getClassDeclaration() != null && declaration.getClassDeclaration().getTypeDeclaration() != null) {
                                                    resultSet.addElement(LookupElementBuilder.create(declaration.getClassDeclaration().getTypeDeclaration()));
                                                }
                                            }
                                            super.visitElement(element);
                                        }
                                    });
                                    resultSet.stopHere();
                                } else if (parameters.getPosition().getParent().getParent() instanceof GCMToOneDeclaration) {
                                    //add all know types
                                    parameters.getOriginalFile().acceptChildren(new PsiElementVisitor() {
                                        @Override
                                        public void visitElement(PsiElement element) {
                                            if (element instanceof GCMDeclaration) {
                                                GCMDeclaration declaration = (GCMDeclaration) element;
                                                if (declaration.getClassDeclaration() != null && declaration.getClassDeclaration().getTypeDeclaration() != null) {
                                                    resultSet.addElement(LookupElementBuilder.create(declaration.getClassDeclaration().getTypeDeclaration()));
                                                }
                                            }
                                            super.visitElement(element);
                                        }
                                    });
                                    resultSet.stopHere();
                                }
                            }
                        }
                    }
                }
        );

        extend(CompletionType.BASIC,
                PlatformPatterns.psiElement(GCMTypes.IDENT).withLanguage(GCMLanguage.INSTANCE).afterLeaf(PlatformPatterns.psiElement(GCMTypes.EXTENDS)),
                new CompletionProvider<CompletionParameters>() {
                    public void addCompletions(@NotNull CompletionParameters parameters,
                                               ProcessingContext context,
                                               @NotNull final CompletionResultSet resultSet) {

                        if (parameters.getPosition().getParent() != null) {
                            if (parameters.getPosition().getParent().getParent() != null) {
                                parameters.getOriginalFile().acceptChildren(new PsiElementVisitor() {
                                    @Override
                                    public void visitElement(PsiElement element) {
                                        if (element instanceof GCMDeclaration) {
                                            GCMDeclaration declaration = (GCMDeclaration) element;
                                            if (declaration.getClassDeclaration() != null && declaration.getClassDeclaration().getTypeDeclaration() != null) {
                                                resultSet.addElement(LookupElementBuilder.create(declaration.getClassDeclaration().getTypeDeclaration()));
                                            }
                                        }
                                        super.visitElement(element);
                                    }
                                });
                                resultSet.stopHere();
                            }
                        }
                    }
                }
        );

        extend(CompletionType.BASIC,
                PlatformPatterns.psiElement().withLanguage(GCMLanguage.INSTANCE).afterLeaf(PlatformPatterns.psiElement(GCMTypes.BODY_CLOSE)),
                new CompletionProvider<CompletionParameters>() {
                    public void addCompletions(@NotNull CompletionParameters parameters,
                                               ProcessingContext context,
                                               @NotNull CompletionResultSet resultSet) {
                        resultSet.addElement(LookupElementBuilder.create("class "));
                        resultSet.addElement(LookupElementBuilder.create("enum "));
                        resultSet.stopHere();
                    }
                }
        );

        extend(CompletionType.BASIC,
                PlatformPatterns.psiElement().withLanguage(GCMLanguage.INSTANCE),
                new CompletionProvider<CompletionParameters>() {
                    public void addCompletions(@NotNull CompletionParameters parameters,
                                               ProcessingContext context,
                                               @NotNull CompletionResultSet resultSet) {

                        if (parameters.getPosition().getParent() != null) {
                            if (parameters.getPosition().getParent() instanceof GCMDeclaration) {
                            } else if (parameters.getPosition().getParent() instanceof GCMFile) {
                                resultSet.addElement(LookupElementBuilder.create("class "));
                                resultSet.addElement(LookupElementBuilder.create("enum "));
                                resultSet.stopHere();
                            }
                        }
                    }
                }
        );

        extend(CompletionType.BASIC,
                PlatformPatterns.psiElement().withLanguage(GCMLanguage.INSTANCE).afterLeaf(PlatformPatterns.psiElement(GCMTypes.KEY)),
                new CompletionProvider<CompletionParameters>() {
                    @Override
                    protected void addCompletions(@NotNull CompletionParameters completionParameters,
                                                  ProcessingContext processingContext,
                                                  @NotNull CompletionResultSet completionResultSet) {

                        GCMClassDeclaration classDeclaration = (GCMClassDeclaration) completionParameters.getPosition().getParent().getParent().getParent().getParent();
                        for (GCMClassElemDeclaration dcl : classDeclaration.getClassElemDeclarationList()) {
                            if(dcl.getAttributeDeclaration() != null) {
                                String att = dcl.getAttributeDeclaration().getAttributeName().getText();
                                completionResultSet.addElement(LookupElementBuilder.create(att));
                            }
                        }
                        completionResultSet.stopHere();
                    }
                }
        );

        extend(CompletionType.BASIC,
                PlatformPatterns.psiElement().withLanguage(GCMLanguage.INSTANCE).afterLeaf(PlatformPatterns.psiElement(GCMTypes.KEY_WITH_TIME)),
                new CompletionProvider<CompletionParameters>() {
                    @Override
                    protected void addCompletions(@NotNull CompletionParameters completionParameters,
                                                  ProcessingContext processingContext,
                                                  @NotNull CompletionResultSet completionResultSet) {

                        GCMClassDeclaration classDeclaration = (GCMClassDeclaration) completionParameters.getPosition().getParent().getParent().getParent().getParent();
                        for (GCMClassElemDeclaration dcl : classDeclaration.getClassElemDeclarationList()) {
                            if(dcl.getAttributeDeclaration() != null) {
                                String att = dcl.getAttributeDeclaration().getAttributeName().getText();
                                completionResultSet.addElement(LookupElementBuilder.create(att));
                            }
                        }
                        completionResultSet.stopHere();
                    }
                }
        );

        extend(CompletionType.BASIC,
                PlatformPatterns.psiElement().withLanguage(GCMLanguage.INSTANCE).afterLeaf(PlatformPatterns.psiElement(GCMTypes.ATT)),
                new CompletionProvider<CompletionParameters>() {
                    public void addCompletions(@NotNull CompletionParameters parameters,
                                               ProcessingContext context,
                                               @NotNull CompletionResultSet resultSet) {
                        resultSet.addElement(LookupElementBuilder.create("attName : "));
                        resultSet.stopHere();
                    }
                }
        );

        extend(CompletionType.BASIC,
                PlatformPatterns.psiElement().withLanguage(GCMLanguage.INSTANCE).afterLeaf(PlatformPatterns.psiElement(GCMTypes.REF)),
                new CompletionProvider<CompletionParameters>() {
                    public void addCompletions(@NotNull CompletionParameters parameters,
                                               ProcessingContext context,
                                               @NotNull CompletionResultSet resultSet) {
                        resultSet.addElement(LookupElementBuilder.create("relationName : "));
                        resultSet.stopHere();
                    }
                }
        );

        /*
        extend(CompletionType.BASIC,
                PlatformPatterns.psiElement().withLanguage(MetaModelLanguage.INSTANCE).afterLeaf(PlatformPatterns.psiElement(MetaModelTypes.INFER_WITH)),
                new CompletionProvider<CompletionParameters>() {
                    public void addCompletions(@NotNull CompletionParameters parameters,
                                               ProcessingContext context,
                                               @NotNull CompletionResultSet resultSet) {
                        resultSet.addElement(LookupElementBuilder.create("\"BinaryPerceptron\""));
                        resultSet.addElement(LookupElementBuilder.create("\"GaussianClassification\""));
                        resultSet.addElement(LookupElementBuilder.create("\"GaussianProfiler\""));
                        resultSet.addElement(LookupElementBuilder.create("\"KMeanCluster\""));
                        resultSet.addElement(LookupElementBuilder.create("\"LinearRegression\""));
                        resultSet.addElement(LookupElementBuilder.create("\"Winnow\""));
                        resultSet.stopHere();
                    }
                }
        );*/

        /*
        extend(CompletionType.BASIC,
                PlatformPatterns.psiElement().withLanguage(MetaModelLanguage.INSTANCE).afterLeaf(PlatformPatterns.psiElement(MetaModelTypes.PRECISION)),
                new CompletionProvider<CompletionParameters>() {
                    public void addCompletions(@NotNull CompletionParameters parameters,
                                               ProcessingContext context,
                                               @NotNull CompletionResultSet resultSet) {
                        resultSet.addElement(LookupElementBuilder.create("0.1"));
                        resultSet.stopHere();
                    }
                }
        );*/


        /*
        extend(CompletionType.BASIC,
                PlatformPatterns.psiElement().withLanguage(MetaModelLanguage.INSTANCE).afterLeaf(PlatformPatterns.psiElement(MetaModelTypes.TEMPORAL_LIMIT)),
                new CompletionProvider<CompletionParameters>() {
                    public void addCompletions(@NotNull CompletionParameters parameters,
                                               ProcessingContext context,
                                               @NotNull CompletionResultSet resultSet) {
                        resultSet.addElement(LookupElementBuilder.create("100000 //max 100000 will be kept in history"));
                        resultSet.stopHere();
                    }
                }
        );

        extend(CompletionType.BASIC,
                PlatformPatterns.psiElement().withLanguage(MetaModelLanguage.INSTANCE).afterLeaf(PlatformPatterns.psiElement(MetaModelTypes.TEMPORAL_RESOLUTION)),
                new CompletionProvider<CompletionParameters>() {
                    public void addCompletions(@NotNull CompletionParameters parameters,
                                               ProcessingContext context,
                                               @NotNull CompletionResultSet resultSet) {
                        resultSet.addElement(LookupElementBuilder.create("86400000 //one value per day"));
                        resultSet.stopHere();
                    }
                }
        );
        */

        /*
        extend(CompletionType.BASIC,
                PlatformPatterns.psiElement().withLanguage(GCMLanguage.INSTANCE).afterLeaf(PlatformPatterns.psiElement(GCMTypes.IDENT).withText("Continuous")),
                new CompletionProvider<CompletionParameters>() {
                    public void addCompletions(@NotNull CompletionParameters parameters,
                                               ProcessingContext context,
                                               @NotNull CompletionResultSet resultSet) {
                        resultSet.addElement(LookupElementBuilder.create("precision "));
                    }
                }
        );*/

        /*
        extend(CompletionType.BASIC,
                PlatformPatterns.psiElement().withLanguage(GCMLanguage.INSTANCE).afterLeaf(PlatformPatterns.psiElement(GCMTypes.IDENT)),
                new CompletionProvider<CompletionParameters>() {
                    public void addCompletions(@NotNull CompletionParameters parameters,
                                               ProcessingContext context,
                                               @NotNull CompletionResultSet resultSet) {

                        if (parameters.getPosition().getParent() != null) {
                            PsiElement elem = parameters.getPosition().getParent();
                            if (elem.toString().contains("oppositeOf")) {
                                resultSet.addElement(LookupElementBuilder.create("oppositeOf"));
                            }
                        }
                    }
                }
        );*/

        /*
        extend(CompletionType.BASIC,
                PlatformPatterns.psiElement().withLanguage(GCMLanguage.INSTANCE).beforeLeaf(PlatformPatterns.psiElement(GCMTypes.ATT)),
                new CompletionProvider<CompletionParameters>() {
                    public void addCompletions(@NotNull CompletionParameters parameters,
                                               ProcessingContext context,
                                               @NotNull CompletionResultSet resultSet) {
                        fillInsideClassDecl(resultSet);
                    }
                }
        );

        extend(CompletionType.BASIC,
                PlatformPatterns.psiElement().withLanguage(GCMLanguage.INSTANCE).beforeLeaf(PlatformPatterns.psiElement(GCMTypes.REF)),
                new CompletionProvider<CompletionParameters>() {
                    public void addCompletions(@NotNull CompletionParameters parameters,
                                               ProcessingContext context,
                                               @NotNull CompletionResultSet resultSet) {
                        fillInsideClassDecl(resultSet);
                    }
                }
        );

        extend(CompletionType.BASIC,
                PlatformPatterns.psiElement().withLanguage(GCMLanguage.INSTANCE).beforeLeaf(PlatformPatterns.psiElement(GCMTypes.REL)),
                new CompletionProvider<CompletionParameters>() {
                    public void addCompletions(@NotNull CompletionParameters parameters,
                                               ProcessingContext context,
                                               @NotNull CompletionResultSet resultSet) {
                        fillInsideClassDecl(resultSet);
                    }
                }
        );*/

        /*
        extend(CompletionType.BASIC,
                PlatformPatterns.psiElement().withLanguage(MetaModelLanguage.INSTANCE).beforeLeaf(PlatformPatterns.psiElement(MetaModelTypes.INFER_WITH)),
                new CompletionProvider<CompletionParameters>() {
                    public void addCompletions(@NotNull CompletionParameters parameters,
                                               ProcessingContext context,
                                               @NotNull CompletionResultSet resultSet) {
                        fillInsideClassDecl(resultSet);
                    }
                }
        );*/

        /*
        extend(CompletionType.BASIC,
                PlatformPatterns.psiElement().withLanguage(MetaModelLanguage.INSTANCE).beforeLeaf(PlatformPatterns.psiElement(MetaModelTypes.DEPENDENCY)),
                new CompletionProvider<CompletionParameters>() {
                    public void addCompletions(@NotNull CompletionParameters parameters,
                                               ProcessingContext context,
                                               @NotNull CompletionResultSet resultSet) {
                        fillInsideClassDecl(resultSet);
                    }
                }
        );

        extend(CompletionType.BASIC,
                PlatformPatterns.psiElement().withLanguage(MetaModelLanguage.INSTANCE).beforeLeaf(PlatformPatterns.psiElement(MetaModelTypes.INPUT)),
                new CompletionProvider<CompletionParameters>() {
                    public void addCompletions(@NotNull CompletionParameters parameters,
                                               ProcessingContext context,
                                               @NotNull CompletionResultSet resultSet) {
                        fillInsideClassDecl(resultSet);
                    }
                }
        );

        extend(CompletionType.BASIC,
                PlatformPatterns.psiElement().withLanguage(MetaModelLanguage.INSTANCE).beforeLeaf(PlatformPatterns.psiElement(MetaModelTypes.OUTPUT)),
                new CompletionProvider<CompletionParameters>() {
                    public void addCompletions(@NotNull CompletionParameters parameters,
                                               ProcessingContext context,
                                               @NotNull CompletionResultSet resultSet) {
                        fillInsideClassDecl(resultSet);
                    }
                }
        );*/

        /*
        extend(CompletionType.BASIC,
                PlatformPatterns.psiElement().withLanguage(MetaModelLanguage.INSTANCE).beforeLeaf(PlatformPatterns.psiElement(MetaModelTypes.TEMPORAL_LIMIT)),
                new CompletionProvider<CompletionParameters>() {
                    public void addCompletions(@NotNull CompletionParameters parameters,
                                               ProcessingContext context,
                                               @NotNull CompletionResultSet resultSet) {
                        fillInsideClassDecl(resultSet);
                    }
                }
        );


        extend(CompletionType.BASIC,
                PlatformPatterns.psiElement().withLanguage(MetaModelLanguage.INSTANCE).beforeLeaf(PlatformPatterns.psiElement(MetaModelTypes.TEMPORAL_RESOLUTION)),
                new CompletionProvider<CompletionParameters>() {
                    public void addCompletions(@NotNull CompletionParameters parameters,
                                               ProcessingContext context,
                                               @NotNull CompletionResultSet resultSet) {
                        fillInsideClassDecl(resultSet);
                    }
                }
        );*/


        extend(CompletionType.BASIC,
                PlatformPatterns.psiElement().withLanguage(GCMLanguage.INSTANCE).beforeLeaf(PlatformPatterns.psiElement(GCMTypes.BODY_CLOSE)),
                new CompletionProvider<CompletionParameters>() {
                    public void addCompletions(@NotNull CompletionParameters parameters,
                                               ProcessingContext context,
                                               @NotNull CompletionResultSet resultSet) {
                        fillInsideClassDecl(resultSet);
                        resultSet.stopHere();
                    }
                }
        );

        extend(CompletionType.BASIC,
                PlatformPatterns.psiElement().withLanguage(GCMLanguage.INSTANCE).afterLeaf(PlatformPatterns.psiElement(GCMTypes.BODY_OPEN)),
                new CompletionProvider<CompletionParameters>() {
                    public void addCompletions(@NotNull CompletionParameters parameters,
                                               ProcessingContext context,
                                               @NotNull CompletionResultSet resultSet) {
                        fillInsideClassDecl(resultSet);
                        resultSet.stopHere();
                    }
                }
        );


    }

}
