//package greycat.idea.structure;
//
//import com.intellij.icons.AllIcons;
//import com.intellij.ide.structureView.StructureViewTreeElement;
//import com.intellij.ide.util.treeView.smartTree.SortableTreeElement;
//import com.intellij.ide.util.treeView.smartTree.TreeElement;
//import com.intellij.navigation.ItemPresentation;
//import com.intellij.openapi.editor.Editor;
//import com.intellij.openapi.editor.ScrollType;
//import greycat.idea.psi.GCMEnumElemDeclaration;
//import org.jetbrains.annotations.NotNull;
//import org.jetbrains.annotations.Nullable;
//
//import javax.swing.*;
//
//public class GCMStructureViewEnumElementElement implements StructureViewTreeElement, SortableTreeElement {
//
//    private GCMEnumElemDeclaration enumDecl;
//    private String presText;
//    private Editor editor;
//
//    public GCMStructureViewEnumElementElement(GCMEnumElemDeclaration enumDecl, Editor editor) {
//        this.enumDecl = enumDecl;
//        this.editor = editor;
//        presText = enumDecl.getText();
//    }
//
//    @Override
//    public Object getValue() {
//        return enumDecl;
//    }
//
//    @Override
//    public void navigate(boolean b) {
//        //System.out.println("Editor:" + editor.getClass());
//        editor.getCaretModel().moveToOffset(enumDecl.getTextOffset());
//        editor.getScrollingModel().scrollToCaret(ScrollType.CENTER_UP);
//    }
//
//    @Override
//    public boolean canNavigate() {
//        return true;
//    }
//
//    @Override
//    public boolean canNavigateToSource() {
//        return true;
//    }
//
//    @NotNull
//    @Override
//    public ItemPresentation getPresentation() {
//        return new ItemPresentation() {
//            @Nullable
//            @Override
//            public String getPresentableText() {
//                return presText;
//            }
//
//            @Nullable
//            @Override
//            public String getLocationString() {
//                return null;
//            }
//
//            @Nullable
//            @Override
//            public Icon getIcon(boolean b) {
//                return AllIcons.Nodes.Static;
//            }
//        };
//    }
//
//    @Override
//    public TreeElement[] getChildren() {
//        return EMPTY_ARRAY;
//    }
//
//    @NotNull
//    @Override
//    public String getAlphaSortKey() {
//        return presText;
//    }
//}
