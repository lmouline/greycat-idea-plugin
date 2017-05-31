package greycat.idea;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class GCMFile extends PsiFileBase {

    public GCMFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, GCMLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return GCMLanguageType.INSTANCE;
    }

    @Override
    public String toString() {
        return "GCM File";
    }

    @Override
    public Icon getIcon(int flags) {
        return super.getIcon(flags);
    }

}
