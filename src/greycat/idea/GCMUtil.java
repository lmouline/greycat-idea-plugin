package greycat.idea;

import com.intellij.navigation.ItemPresentation;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiManager;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.util.indexing.FileBasedIndex;
import greycat.idea.psi.GCMDeclaration;
import greycat.idea.psi.GCMTypeDeclaration;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GCMUtil {

    public static List<GCMTypeDeclaration> findProperties(Project project) {
        final List<GCMTypeDeclaration> result = new ArrayList<GCMTypeDeclaration>();
        Collection<VirtualFile> virtualFiles = FileBasedIndex.getInstance().getContainingFiles(FileTypeIndex.NAME, GCMLanguageType.INSTANCE,
                GlobalSearchScope.allScope(project));
        for (VirtualFile virtualFile : virtualFiles) {
            GCMFile simpleFile = (GCMFile) PsiManager.getInstance(project).findFile(virtualFile);
            if (simpleFile != null) {


                simpleFile.acceptChildren(new PsiElementVisitor() {
                    @Override
                    public void visitElement(PsiElement element) {
                        if (element instanceof GCMDeclaration) {
                            GCMDeclaration declaration = (GCMDeclaration) element;
                            if (declaration.getClassDeclaration() != null) {
                                result.add(declaration.getClassDeclaration().getTypeDeclaration());
                            }
                            if (declaration.getEnumDeclaration() != null) {
                                result.add(declaration.getEnumDeclaration().getTypeDeclaration());
                            }
                        }
                        super.visitElement(element);
                    }
                });
            }
        }
        return result;
    }

    public static List<GCMTypeDeclaration> findProperties(Project project, final String key) {
        final List<GCMTypeDeclaration> result = new ArrayList<GCMTypeDeclaration>();
        Collection<VirtualFile> virtualFiles = FileBasedIndex.getInstance().getContainingFiles(FileTypeIndex.NAME, GCMLanguageType.INSTANCE,
                GlobalSearchScope.allScope(project));
        for (VirtualFile virtualFile : virtualFiles) {
            GCMFile simpleFile = (GCMFile) PsiManager.getInstance(project).findFile(virtualFile);
            if (simpleFile != null) {
                simpleFile.acceptChildren(new PsiElementVisitor() {
                    @Override
                    public void visitElement(PsiElement element) {
                        if (element instanceof GCMDeclaration) {
                            GCMDeclaration declaration = (GCMDeclaration) element;
                            if (declaration.getClassDeclaration() != null && declaration.getClassDeclaration().getTypeDeclaration() != null) {
                                if (key.equals(declaration.getClassDeclaration().getTypeDeclaration().getName())) {
                                    result.add(declaration.getClassDeclaration().getTypeDeclaration());
                                }
                            }
                            if (declaration.getEnumDeclaration() != null && declaration.getEnumDeclaration().getTypeDeclaration() != null) {
                                if (key.equals(declaration.getEnumDeclaration().getTypeDeclaration().getName())) {
                                    result.add(declaration.getEnumDeclaration().getTypeDeclaration());
                                }
                            }
                        }
                        super.visitElement(element);
                    }
                });
            }
        }
        return result;
    }


    public static PsiElement setName(GCMTypeDeclaration element, String newName) {
        System.err.println("Rename not supported yet !!!");
        /*
        ASTNode keyNode = element.getNode().findChildByType(SimpleTypes.KEY);
        if (keyNode != null) {
            MetaModelTypeDeclaration property = SimpleElementFactory.createProperty(element.getProject(), newName);
            ASTNode newKeyNode = property.getFirstChild().getNode();
            element.getNode().replaceChild(keyNode, newKeyNode);
        }
        */
        return element;
    }

    public static PsiElement getNameIdentifier(GCMTypeDeclaration element) {
        return element.getIdent();
    }

    public static ItemPresentation getPresentation(final GCMTypeDeclaration element) {
        return new ItemPresentation() {
            @Nullable
            @Override
            public String getPresentableText() {
                return element.getName();
            }

            @Nullable
            @Override
            public String getLocationString() {
                return element.getContainingFile().getName();
            }

            @Nullable
            @Override
            public Icon getIcon(boolean unused) {
                return GCMIcons.GCM_ICON_16x16;
            }
        };
    }


}
