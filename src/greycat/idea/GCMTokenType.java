package greycat.idea;

import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class GCMTokenType extends IElementType {

    public GCMTokenType(@NotNull @NonNls String debugName) {
        super(debugName, GCMLanguage.INSTANCE);
    }

    @Override
    public String toString() {
        return "GCMTokenType." + super.toString();
    }

}
