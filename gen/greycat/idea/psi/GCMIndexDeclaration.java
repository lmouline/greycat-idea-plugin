// This is a generated file. Not intended for manual editing.
package greycat.idea.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface GCMIndexDeclaration extends PsiElement {

  @NotNull
<<<<<<< 50e0da97b4bfe492c7595f1363ff378d9028067a
  List<GCMAttributeName> getAttributeNameList();

  @Nullable
  GCMIndexedWithoutTimeDeclaration getIndexedWithoutTimeDeclaration();

  @Nullable
  GCMIndexedWithTimeDeclaration getIndexedWithTimeDeclaration();

  @Nullable
  GCMIndexNameDeclaration getIndexNameDeclaration();
=======
  GCMIndexParams getIndexParams();

  @NotNull
  GCMTypeDeclaration getTypeDeclaration();

  @NotNull
  PsiElement getIdent();
>>>>>>> 44ffb72f7837a15c79487ff6d0cc87870a9bc0d5

}
