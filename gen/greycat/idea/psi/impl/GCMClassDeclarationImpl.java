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

public class GCMClassDeclarationImpl extends ASTWrapperPsiElement implements GCMClassDeclaration {

  public GCMClassDeclarationImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull GCMVisitor visitor) {
    visitor.visitClassDeclaration(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof GCMVisitor) accept((GCMVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
<<<<<<< 50e0da97b4bfe492c7595f1363ff378d9028067a
  @NotNull
  public List<GCMClassElemDeclaration> getClassElemDeclarationList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, GCMClassElemDeclaration.class);
  }

  @Override
=======
>>>>>>> 44ffb72f7837a15c79487ff6d0cc87870a9bc0d5
  @Nullable
  public GCMParentsDeclaration getParentsDeclaration() {
    return findChildByClass(GCMParentsDeclaration.class);
  }

  @Override
  @NotNull
<<<<<<< 50e0da97b4bfe492c7595f1363ff378d9028067a
=======
  public List<GCMProp> getPropList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, GCMProp.class);
  }

  @Override
  @NotNull
>>>>>>> 44ffb72f7837a15c79487ff6d0cc87870a9bc0d5
  public GCMTypeDeclaration getTypeDeclaration() {
    return findNotNullChildByClass(GCMTypeDeclaration.class);
  }

}
