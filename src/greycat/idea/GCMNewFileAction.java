package greycat.idea;

import com.intellij.ide.IdeView;
import com.intellij.ide.actions.CreateFileFromTemplateDialog;
import com.intellij.ide.actions.CreateTemplateInPackageAction;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.actionSystem.LangDataKeys;
import com.intellij.openapi.project.DumbAware;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiDirectory;
import com.intellij.psi.PsiElement;
import com.intellij.util.IncorrectOperationException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.jps.model.java.JavaModuleSourceRootTypes;

public class GCMNewFileAction extends CreateTemplateInPackageAction<PsiElement> implements DumbAware {

    public GCMNewFileAction() {
        super("Create MetaModel file",
                "This will create a new GreyCatModel file in the current project",
                GCMIcons.GCM_ICON_16x16, JavaModuleSourceRootTypes.SOURCES);
    }

    @Nullable
    @Override
    protected PsiElement getNavigationElement(@NotNull PsiElement psiElement) {
        return psiElement;
    }

    @Override
    protected boolean checkPackageExists(PsiDirectory psiDirectory) {
        return true;
    }

    @Nullable
    @Override
    protected PsiElement doCreate(PsiDirectory psiDirectory, String parameterName, String typeName) throws IncorrectOperationException {
        GCMTemplatesFactory.Template template = GCMTemplatesFactory.Template.GreyCatModel;
        String fileName = fileNameFromTypeName(typeName, parameterName);
        StringBuilder sample = new StringBuilder();
        sample.append("class sample.Cloud {\n");
        sample.append("    att name : String\n");
        sample.append("    rel nodes : sample.Node\n");
        sample.append("}\n");
        sample.append("class sample.Node {\n");
        sample.append("    att name : String\n");
        sample.append("    rel softwares : sample.Software\n");
        sample.append("    rel indexedSoftware : sample.Software indexed by name\n");
        sample.append("}\n");
        sample.append("class sample.Software {\n");
        sample.append("    att name : String\n");
        sample.append("    att size : Integer\n");
        sample.append("    indexed by name as MyIndexName\n");
        sample.append("}\n");
        return GCMTemplatesFactory.createFromTemplate(psiDirectory, fileName, template, sample.toString());
    }


    String fileNameFromTypeName(String typeName, String parameterName) {
        return parameterName + ".gcm";
    }

    @Override
    protected void buildDialog(Project project, PsiDirectory psiDirectory, CreateFileFromTemplateDialog.Builder builder) {
        builder.addKind("New MetaModel", GCMIcons.GCM_ICON_16x16, "sample.gcm");
    }

    @Override
    protected String getActionName(PsiDirectory psiDirectory, String s, String s2) {
        return "New GCM File";
    }

    protected boolean isAvailable(final DataContext dataContext) {
        final Project project = CommonDataKeys.PROJECT.getData(dataContext);
        final IdeView view = LangDataKeys.IDE_VIEW.getData(dataContext);
        if (project == null || view == null || view.getDirectories().length == 0) {
            return false;
        }
        return true;
    }

}
