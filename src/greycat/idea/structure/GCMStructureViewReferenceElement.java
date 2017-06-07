package greycat.idea.structure;

import com.intellij.ide.structureView.StructureViewTreeElement;
import com.intellij.ide.util.treeView.smartTree.SortableTreeElement;
import com.intellij.ide.util.treeView.smartTree.TreeElement;
import com.intellij.navigation.ItemPresentation;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.ScrollType;
import com.intellij.util.PlatformIcons;
import greycat.idea.psi.GCMRelationDeclaration;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class GCMStructureViewReferenceElement implements StructureViewTreeElement, SortableTreeElement {

    private GCMRelationDeclaration refDecl;
    private Editor editor;
    private String simpleType;

    public GCMStructureViewReferenceElement(GCMRelationDeclaration refDecl, Editor editor) {
        this.refDecl = refDecl;
        this.editor = editor;
        simpleType = relText(refDecl).substring(relText(refDecl).lastIndexOf(".") + 1);
    }

    public boolean isAttribute() {
        return false;
    }

    @Override
    public Object getValue() {
        return refDecl;
    }

    @Override
    public void navigate(boolean b) {
        editor.getCaretModel().moveToOffset(refDecl.getTextOffset());
        editor.getScrollingModel().scrollToCaret(ScrollType.CENTER_UP);
    }


    @Override
    public boolean canNavigate() {
        return true;
    }

    @Override
    public boolean canNavigateToSource() {
        return true;
    }

    @NotNull
    @Override
    public ItemPresentation getPresentation() {
        return new ItemPresentation() {
            @Nullable
            @Override
            public String getPresentableText() {
                if (refDecl.getText().trim().startsWith("ref*")) {
                    return "*" + relText(refDecl) + " : " + simpleType;
                } else {
                    return relText(refDecl) + " : " + simpleType;
                }
            }

            @Nullable
            @Override
            public String getLocationString() {
                return null;
            }

            @Nullable
            @Override
            public Icon getIcon(boolean b) {
                return PlatformIcons.PROPERTY_ICON;
            }
        };
    }

    @Override
    public TreeElement[] getChildren() {
        List<TreeElement> all = new ArrayList<TreeElement>();
        return all.toArray(new TreeElement[all.size()]);
    }

    @NotNull
    @Override
    public String getAlphaSortKey() {
        return relText(refDecl);
    }

    private String relText(GCMRelationDeclaration decl) {
        if (decl.getToOneDeclaration() != null) {
            return decl.getToOneDeclaration().getText();
        }
        if (decl.getToManyDeclaration() != null) {
            return decl.getToManyDeclaration().getText();
        }
        return "";
    }

}
