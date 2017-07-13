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

  public PsiElement setName(String newName) {
    return GCMUtil.setName(this, newName);
  }

  public PsiElement getNameIdentifier() {
    return GCMUtil.getNameIdentifier(this);
  }

}
