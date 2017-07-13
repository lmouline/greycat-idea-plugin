// This is a generated file. Not intended for manual editing.
package greycat.idea.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface GCMRelationDeclaration extends PsiElement {

  @Nullable
  GCMToManyDeclaration getToManyDeclaration();

  @Nullable
  GCMToOneDeclaration getToOneDeclaration();

  @Nullable
  PsiElement getIdent();

}
