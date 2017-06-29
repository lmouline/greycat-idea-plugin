// This is a generated file. Not intended for manual editing.
package greycat.idea.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static greycat.idea.psi.GCMTypes.*;
import greycat.idea.GCMNamedElementImpl;
import greycat.idea.psi.*;
import greycat.idea.GCMUtil;

public class GCMTypeDeclarationImpl extends GCMNamedElementImpl implements GCMTypeDeclaration {

  public GCMTypeDeclarationImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull GCMVisitor visitor) {
    visitor.visitTypeDeclaration(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof GCMVisitor) accept((GCMVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public PsiElement getIdent() {
    return findNotNullChildByType(IDENT);
  }

<<<<<<< 50e0da97b4bfe492c7595f1363ff378d9028067a
=======
  public PsiElement setName(String newName) {
    return GCMUtil.setName(this, newName);
  }

>>>>>>> 44ffb72f7837a15c79487ff6d0cc87870a9bc0d5
  public PsiElement getNameIdentifier() {
    return GCMUtil.getNameIdentifier(this);
  }

}
