package greycat.idea.structure;

import com.intellij.ide.structureView.StructureViewBuilder;
import com.intellij.ide.structureView.StructureViewModel;
import com.intellij.ide.structureView.TreeBasedStructureViewBuilder;
import com.intellij.lang.PsiStructureViewFactory;
import com.intellij.openapi.editor.Editor;
import com.intellij.psi.PsiFile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class GCMStructureViewFactory implements PsiStructureViewFactory {

    public StructureViewBuilder getStructureViewBuilder(final PsiFile psiFile) {
        return new TreeBasedStructureViewBuilder() {
            @NotNull
            @Override
            public StructureViewModel createStructureViewModel(@Nullable Editor editor) {
                return new GCMStructureViewModel(psiFile, buildTree(psiFile, editor), editor);
            }

        };
    }

    private GCMStructureViewRootElement buildTree(PsiFile psiFile, final Editor editor) {
        final GCMStructureViewRootElement root = new GCMStructureViewRootElement(psiFile, editor);
        root.refresh();
        return root;
    }

}
