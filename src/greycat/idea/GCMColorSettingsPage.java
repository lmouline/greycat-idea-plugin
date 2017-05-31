package greycat.idea;

import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Map;

public class GCMColorSettingsPage implements ColorSettingsPage {

    private static final AttributesDescriptor[] DESCRIPTORS = new AttributesDescriptor[]{
            new AttributesDescriptor("KEYWORD", GCMSyntaxHighlighter.KEYWORD),
            new AttributesDescriptor("STRING", GCMSyntaxHighlighter.STRING),
            new AttributesDescriptor("SEPARATOR", GCMSyntaxHighlighter.SEPARATOR),
            new AttributesDescriptor("COMMENT", GCMSyntaxHighlighter.COMMENT),
            new AttributesDescriptor("IDENT", GCMSyntaxHighlighter.IDENT),
            new AttributesDescriptor("NUMBER", GCMSyntaxHighlighter.NUMBER),
            new AttributesDescriptor("BAD_CHARACTER", GCMSyntaxHighlighter.BAD_CHARACTER),
    };

    @Nullable
    @Override
    public Icon getIcon() {
        return GCMIcons.GCM_ICON_16x16;
    }

    @NotNull
    @Override
    public SyntaxHighlighter getHighlighter() {
        return new GCMSyntaxHighlighter();
    }

    @NotNull
    @Override
    public String getDemoText() {
        return "class TypeDefinition {\n" +
                "    name : String\n" +
                "    properties : Property\n" +
                "}\n" +
                "class ComponentType : TypeDefinition {\n" +
                "    portNumber : Integer\n" +
                "}\n" +
                "class Property {\n" +
                "       name : String\n" +
                "       value : String\n" +
                "}";
    }

    @Nullable
    @Override
    public Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
        return null;
    }

    @NotNull
    @Override
    public AttributesDescriptor[] getAttributeDescriptors() {
        return DESCRIPTORS;
    }

    @NotNull
    @Override
    public ColorDescriptor[] getColorDescriptors() {
        return ColorDescriptor.EMPTY_ARRAY;
    }

    @NotNull
    @Override
    public String getDisplayName() {
        return "GCM";
    }

}
