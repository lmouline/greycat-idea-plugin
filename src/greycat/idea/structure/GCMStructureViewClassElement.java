package greycat.idea.structure;

import com.intellij.ide.structureView.StructureViewTreeElement;
import com.intellij.ide.util.treeView.smartTree.SortableTreeElement;
import com.intellij.ide.util.treeView.smartTree.TreeElement;
import com.intellij.navigation.ItemPresentation;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.ScrollType;
import com.intellij.util.PlatformIcons;
import greycat.idea.psi.GCMClassDeclaration;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class GCMStructureViewClassElement implements StructureViewTreeElement, SortableTreeElement {

    private GCMClassDeclaration classDecl;
    private String presText;
    private Editor editor;

    public List<GCMStructureViewAttributeElement> attributes = new ArrayList<GCMStructureViewAttributeElement>();
    public List<GCMStructureViewReferenceElement> references = new ArrayList<GCMStructureViewReferenceElement>();
    public List<GCMStructureViewParentElement> parents = new ArrayList<GCMStructureViewParentElement>();

    public GCMStructureViewClassElement(GCMClassDeclaration classDecl, Editor editor) {
        this.classDecl = classDecl;
        this.editor = editor;
        int indexOfPoint = classDecl.getTypeDeclaration().getName().lastIndexOf(".");
        if (indexOfPoint > 0) {
            presText = classDecl.getTypeDeclaration().getName().substring(indexOfPoint + 1);
        } else {
            presText = classDecl.getTypeDeclaration().getName();
        }
    }

    @Override
    public Object getValue() {
        return classDecl;
    }

    @Override
    public void navigate(boolean b) {
        editor.getCaretModel().moveToOffset(classDecl.getTextOffset());
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
                return presText;
            }

            @Nullable
            @Override
            public String getLocationString() {
                return null;
            }

            @Nullable
            @Override
            public Icon getIcon(boolean b) {
                return PlatformIcons.CLASS_ICON;
            }
        };
    }

    @Override
    public TreeElement[] getChildren() {
        List<TreeElement> all = new ArrayList<TreeElement>();
        all.addAll(parents);

        all.addAll(attributes);
        all.addAll(references);

        return all.toArray(new TreeElement[all.size()]);
    }

    @NotNull
    @Override
    public String getAlphaSortKey() {
        return presText;
    }
}
