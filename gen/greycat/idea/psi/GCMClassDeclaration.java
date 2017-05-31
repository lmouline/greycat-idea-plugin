// This is a generated file. Not intended for manual editing.
package greycat.idea.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface GCMClassDeclaration extends PsiElement {

  @NotNull
  List<GCMClassElemDeclaration> getClassElemDeclarationList();

  @Nullable
  GCMParentsDeclaration getParentsDeclaration();

  @NotNull
  GCMTypeDeclaration getTypeDeclaration();

}
