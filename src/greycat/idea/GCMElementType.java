package greycat.idea;

import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class GCMElementType extends IElementType {

    public GCMElementType(@NotNull @NonNls String debugName) {
        super(debugName, GCMLanguage.INSTANCE);
    }

}
