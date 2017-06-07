package greycat.idea;

import com.intellij.ide.fileTemplates.FileTemplateDescriptor;
import com.intellij.ide.fileTemplates.FileTemplateGroupDescriptor;
import com.intellij.ide.fileTemplates.FileTemplateGroupDescriptorFactory;
import com.intellij.psi.PsiDirectory;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiFileFactory;

import java.io.File;

public class GCMTemplatesFactory implements FileTemplateGroupDescriptorFactory {

    public enum Template {
        GreyCatModel("GreyCatModel");
        final String file;

        Template(String file) {
            this.file = file;
        }

        public String getFile() {
            return file;
        }
    }

    public FileTemplateGroupDescriptor getFileTemplatesDescriptor() {
        String title = "GCM file templates";
        final FileTemplateGroupDescriptor group =
                new FileTemplateGroupDescriptor(title, GCMIcons.GCM_ICON_16x16);

        for (Template template : Template.values()) {
            group.addTemplate(new FileTemplateDescriptor(template.getFile(), GCMIcons.GCM_ICON_16x16));
        }

        return group;
    }

    public static PsiElement createFromTemplate(PsiDirectory directory, String fileName, Template template, String text2) {
        final PsiFileFactory factory = PsiFileFactory.getInstance(directory.getProject());
        if ((new File(fileName)).exists()) {
            throw new RuntimeException("File already exists");
        }
        final PsiFile file = factory.createFileFromText(fileName, GCMLanguageType.INSTANCE, text2);
        return directory.add(file);
    }
}
