// This is a generated file. Not intended for manual editing.
package greycat.idea.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import greycat.idea.GCMNamedElement;

public interface GCMTypeDeclaration extends GCMNamedElement {

  @NotNull
  PsiElement getIdent();

<<<<<<< 50e0da97b4bfe492c7595f1363ff378d9028067a
  //WARNING: setNameIdentifier(...) is skipped
  //matching setNameIdentifier(GCMTypeDeclaration, ...)
  //methods are not found in GCMUtil
=======
  PsiElement setName(String newName);
>>>>>>> 44ffb72f7837a15c79487ff6d0cc87870a9bc0d5

  @Nullable
  PsiElement getNameIdentifier();

}
