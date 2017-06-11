// This is a generated file. Not intended for manual editing.
package greycat.idea.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface GCMIndexDeclaration extends PsiElement {

  @NotNull
  List<GCMAttributeName> getAttributeNameList();

  @Nullable
  GCMIndexedWithoutTimeDeclaration getIndexedWithoutTimeDeclaration();

  @Nullable
  GCMIndexedWithTimeDeclaration getIndexedWithTimeDeclaration();

  @Nullable
  GCMIndexNameDeclaration getIndexNameDeclaration();

}
