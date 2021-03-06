// This is a generated file. Not intended for manual editing.
package greycat.idea.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static greycat.idea.psi.GCMTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import greycat.idea.psi.*;
import greycat.idea.GCMUtil;

public class GCMDeclarationImpl extends ASTWrapperPsiElement implements GCMDeclaration {

  public GCMDeclarationImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull GCMVisitor visitor) {
    visitor.visitDeclaration(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof GCMVisitor) accept((GCMVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public GCMClassDeclaration getClassDeclaration() {
    return findChildByClass(GCMClassDeclaration.class);
  }

  @Override
  @Nullable
  public GCMConstDeclaration getConstDeclaration() {
    return findChildByClass(GCMConstDeclaration.class);
  }

  @Override
  @Nullable
  public GCMCustomTypeDeclaration getCustomTypeDeclaration() {
    return findChildByClass(GCMCustomTypeDeclaration.class);
  }

  @Override
  @Nullable
  public GCMImportDeclaration getImportDeclaration() {
    return findChildByClass(GCMImportDeclaration.class);
  }

  @Override
  @Nullable
  public GCMIndexDeclaration getIndexDeclaration() {
    return findChildByClass(GCMIndexDeclaration.class);
  }

}
