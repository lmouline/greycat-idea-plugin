package greycat.idea;

import com.intellij.lang.BracePair;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;
import greycat.idea.psi.GCMTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class GCMBraceMatcher implements com.intellij.lang.PairedBraceMatcher {
    private static BracePair[] ourBracePairs =
            {
                    new BracePair(GCMTypes.BODY_OPEN, GCMTypes.BODY_CLOSE, true),
            };

    @Override
    public BracePair[] getPairs() {
        return ourBracePairs;
    }

    @Override
    public boolean isPairedBracesAllowedBeforeType(@NotNull IElementType lbraceType, @Nullable IElementType contextType) {
        return true;
    }

    @Override
    public int getCodeConstructStart(PsiFile file, int openingBraceOffset) {
        return openingBraceOffset;
    }
}
