package greycat.idea;

import com.intellij.openapi.fileTypes.LanguageFileType;
import com.intellij.openapi.vfs.CharsetToolkit;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class GCMLanguageType extends LanguageFileType {

    public static final GCMLanguageType INSTANCE = new GCMLanguageType();

    protected GCMLanguageType() {
        super(GCMLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "GCM";
    }

    @NonNls
    public static final String DEFAULT_EXTENSION = "gcm";

    @NotNull
    @Override
    public String getDescription() {
        return "GreyCat Model is a data schema descriptor";
    }

    @NotNull
    @NonNls
    public String getDefaultExtension() {
        return DEFAULT_EXTENSION;
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return GCMIcons.GCM_ICON_16x16;
    }

    @Override
    public String getCharset(@NotNull VirtualFile file, byte[] content) {
        return CharsetToolkit.UTF8;
    }

}
