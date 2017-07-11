package greycat.idea;

import com.intellij.formatting.*;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiErrorElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.formatter.common.AbstractBlock;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class GCMFormattingModelBuilder implements FormattingModelBuilder {
    @NotNull
    @Override
    public FormattingModel createModel(PsiElement element, CodeStyleSettings settings) {

        final boolean[] inError = {false};
        element.getContainingFile().accept(new PsiElementVisitor() {
            @Override
            public void visitErrorElement(PsiErrorElement element) {
                inError[0] = true;
                super.visitErrorElement(element);
            }

            @Override
            public void visitElement(PsiElement element) {
                super.visitElement(element);
                element.acceptChildren(this);
            }
        });

        if (inError[0]) {
            return FormattingModelProvider.createFormattingModelForPsiFile(element.getContainingFile(), new AbstractBlock(element.getNode(), Wrap.createWrap(WrapType.NONE, false), Alignment.createAlignment()) {
                @Nullable
                @Override
                public Spacing getSpacing(@Nullable Block block, @NotNull Block block1) {
                    return null;
                }

                @Override
                public boolean isLeaf() {
                    return false;
                }

                @Override
                protected List<Block> buildChildren() {
                    return new ArrayList<Block>();
                }
            }, settings);
        } else {
            return FormattingModelProvider.createFormattingModelForPsiFile(element.getContainingFile(), new GCMBlock(element.getNode(), Alignment.createAlignment(), Wrap.createWrap(WrapType.NONE, false)), settings);
        }
    }

    private static SpacingBuilder createSpaceBuilder(CodeStyleSettings settings) {
        return null;
    }

    @Nullable
    @Override
    public TextRange getRangeAffectingIndent(PsiFile file, int offset, ASTNode elementAtOffset) {
        return null;
    }
}