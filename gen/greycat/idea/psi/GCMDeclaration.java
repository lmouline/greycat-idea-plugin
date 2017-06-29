// This is a generated file. Not intended for manual editing.
package greycat.idea.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface GCMDeclaration extends PsiElement {

  @Nullable
  GCMClassDeclaration getClassDeclaration();

  @Nullable
<<<<<<< 50e0da97b4bfe492c7595f1363ff378d9028067a
  GCMEnumDeclaration getEnumDeclaration();
=======
  GCMConstDeclaration getConstDeclaration();

  @Nullable
  GCMCustomTypeDeclaration getCustomTypeDeclaration();

  @Nullable
  GCMImportDeclaration getImportDeclaration();

  @Nullable
  GCMIndexDeclaration getIndexDeclaration();
>>>>>>> 44ffb72f7837a15c79487ff6d0cc87870a9bc0d5

}
