// This is a generated file. Not intended for manual editing.
package greycat.idea.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import greycat.idea.GCMNamedElement;

public interface GCMTypeDeclaration extends GCMNamedElement {

  @NotNull
  PsiElement getIdent();

  PsiElement setName(String s);

  PsiElement setName(String newName);

  @Nullable
  PsiElement getNameIdentifier();

}
