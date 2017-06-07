package greycat.idea.structure;

import com.intellij.icons.AllIcons;
import com.intellij.ide.structureView.StructureViewTreeElement;
import com.intellij.ide.util.treeView.smartTree.SortableTreeElement;
import com.intellij.ide.util.treeView.smartTree.TreeElement;
import com.intellij.navigation.ItemPresentation;
import com.intellij.openapi.editor.Editor;
import greycat.idea.psi.GCMTypeDeclaration;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class GCMStructureViewParentElement implements StructureViewTreeElement, SortableTreeElement {

    private GCMTypeDeclaration typeDecl;
    private Editor editor;
    private String simpleType;


    public GCMStructureViewParentElement(GCMTypeDeclaration typeDecl, Editor editor) {
        this.typeDecl = typeDecl;
        this.editor = editor;
        simpleType = typeDecl.getName().substring(typeDecl.getName().lastIndexOf(".") + 1);
    }

    @Override
    public Object getValue() {
        return typeDecl;
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
                return simpleType;
            }

            @Nullable
            @Override
            public String getLocationString() {
                return null;
            }

            @Nullable
            @Override
            public Icon getIcon(boolean b) {
                return AllIcons.Actions.MoveUp;
            }
        };
    }

    @Override
    public TreeElement[] getChildren() {
        return EMPTY_ARRAY;
    }

    @NotNull
    @Override
    public String getAlphaSortKey() {
        return simpleType;
    }
}
