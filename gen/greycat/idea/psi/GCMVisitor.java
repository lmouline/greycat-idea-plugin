// This is a generated file. Not intended for manual editing.
package greycat.idea.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;
import greycat.idea.GCMNamedElement;

public class GCMVisitor extends PsiElementVisitor {

<<<<<<< 50e0da97b4bfe492c7595f1363ff378d9028067a
=======
  public void visitActionDeclaration(@NotNull GCMActionDeclaration o) {
    visitPsiElement(o);
  }

  public void visitActionParam(@NotNull GCMActionParam o) {
    visitPsiElement(o);
  }

  public void visitActionParams(@NotNull GCMActionParams o) {
    visitPsiElement(o);
  }

>>>>>>> 44ffb72f7837a15c79487ff6d0cc87870a9bc0d5
  public void visitAttributeDeclaration(@NotNull GCMAttributeDeclaration o) {
    visitPsiElement(o);
  }

<<<<<<< 50e0da97b4bfe492c7595f1363ff378d9028067a
=======
  public void visitAttributeDefault(@NotNull GCMAttributeDefault o) {
    visitPsiElement(o);
  }

>>>>>>> 44ffb72f7837a15c79487ff6d0cc87870a9bc0d5
  public void visitAttributeName(@NotNull GCMAttributeName o) {
    visitPsiElement(o);
  }

  public void visitClassDeclaration(@NotNull GCMClassDeclaration o) {
    visitPsiElement(o);
  }

<<<<<<< 50e0da97b4bfe492c7595f1363ff378d9028067a
  public void visitClassElemDeclaration(@NotNull GCMClassElemDeclaration o) {
    visitPsiElement(o);
  }

  public void visitDeclaration(@NotNull GCMDeclaration o) {
    visitPsiElement(o);
  }

  public void visitEnumDeclaration(@NotNull GCMEnumDeclaration o) {
    visitPsiElement(o);
  }

  public void visitEnumElemDeclaration(@NotNull GCMEnumElemDeclaration o) {
    visitPsiElement(o);
  }

  public void visitKeyDeclaration(@NotNull GCMKeyDeclaration o) {
    visitPsiElement(o);
  }

  public void visitKeyNameDeclaration(@NotNull GCMKeyNameDeclaration o) {
    visitPsiElement(o);
  }

  public void visitKeyWithoutTimeDeclaration(@NotNull GCMKeyWithoutTimeDeclaration o) {
    visitPsiElement(o);
  }

  public void visitKeyWithTimeDeclaration(@NotNull GCMKeyWithTimeDeclaration o) {
=======
  public void visitComplexValue(@NotNull GCMComplexValue o) {
    visitPsiElement(o);
  }

  public void visitComplexValueDeclaration(@NotNull GCMComplexValueDeclaration o) {
    visitPsiElement(o);
  }

  public void visitConstDeclaration(@NotNull GCMConstDeclaration o) {
    visitPsiElement(o);
  }

  public void visitConstValueDeclaration(@NotNull GCMConstValueDeclaration o) {
    visitPsiElement(o);
  }

  public void visitCustomTypeDeclaration(@NotNull GCMCustomTypeDeclaration o) {
    visitPsiElement(o);
  }

  public void visitDeclaration(@NotNull GCMDeclaration o) {
    visitPsiElement(o);
  }

  public void visitImportDeclaration(@NotNull GCMImportDeclaration o) {
    visitPsiElement(o);
  }

  public void visitIndexDeclaration(@NotNull GCMIndexDeclaration o) {
    visitPsiElement(o);
  }

  public void visitIndexParams(@NotNull GCMIndexParams o) {
    visitPsiElement(o);
  }

  public void visitNtupleValue(@NotNull GCMNtupleValue o) {
>>>>>>> 44ffb72f7837a15c79487ff6d0cc87870a9bc0d5
    visitPsiElement(o);
  }

  public void visitParentsDeclaration(@NotNull GCMParentsDeclaration o) {
    visitPsiElement(o);
  }

<<<<<<< 50e0da97b4bfe492c7595f1363ff378d9028067a
  public void visitRelationDeclaration(@NotNull GCMRelationDeclaration o) {
    visitPsiElement(o);
  }

  public void visitRelationIndexDeclaration(@NotNull GCMRelationIndexDeclaration o) {
=======
  public void visitProp(@NotNull GCMProp o) {
    visitPsiElement(o);
  }

  public void visitRelationDeclaration(@NotNull GCMRelationDeclaration o) {
>>>>>>> 44ffb72f7837a15c79487ff6d0cc87870a9bc0d5
    visitPsiElement(o);
  }

  public void visitRelationName(@NotNull GCMRelationName o) {
    visitPsiElement(o);
  }

<<<<<<< 50e0da97b4bfe492c7595f1363ff378d9028067a
=======
  public void visitSubConstDeclaration(@NotNull GCMSubConstDeclaration o) {
    visitPsiElement(o);
  }

  public void visitSubTask(@NotNull GCMSubTask o) {
    visitPsiElement(o);
  }

  public void visitTaskValueDeclaration(@NotNull GCMTaskValueDeclaration o) {
    visitPsiElement(o);
  }

>>>>>>> 44ffb72f7837a15c79487ff6d0cc87870a9bc0d5
  public void visitToManyDeclaration(@NotNull GCMToManyDeclaration o) {
    visitPsiElement(o);
  }

  public void visitToOneDeclaration(@NotNull GCMToOneDeclaration o) {
    visitPsiElement(o);
  }

  public void visitTypeDeclaration(@NotNull GCMTypeDeclaration o) {
    visitNamedElement(o);
  }

<<<<<<< 50e0da97b4bfe492c7595f1363ff378d9028067a
=======
  public void visitValueDeclaration(@NotNull GCMValueDeclaration o) {
    visitPsiElement(o);
  }

>>>>>>> 44ffb72f7837a15c79487ff6d0cc87870a9bc0d5
  public void visitNamedElement(@NotNull GCMNamedElement o) {
    visitPsiElement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
