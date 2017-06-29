// This is a generated file. Not intended for manual editing.
package greycat.idea.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface GCMClassDeclaration extends PsiElement {

<<<<<<< 50e0da97b4bfe492c7595f1363ff378d9028067a
  @NotNull
  List<GCMClassElemDeclaration> getClassElemDeclarationList();

=======
>>>>>>> 44ffb72f7837a15c79487ff6d0cc87870a9bc0d5
  @Nullable
  GCMParentsDeclaration getParentsDeclaration();

  @NotNull
<<<<<<< 50e0da97b4bfe492c7595f1363ff378d9028067a
=======
  List<GCMProp> getPropList();

  @NotNull
>>>>>>> 44ffb72f7837a15c79487ff6d0cc87870a9bc0d5
  GCMTypeDeclaration getTypeDeclaration();

}
