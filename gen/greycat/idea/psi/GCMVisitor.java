// This is a generated file. Not intended for manual editing.
package greycat.idea.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;
import greycat.idea.GCMNamedElement;

public class GCMVisitor extends PsiElementVisitor {

  public void visitAttributeDeclaration(@NotNull GCMAttributeDeclaration o) {
    visitPsiElement(o);
  }

  public void visitAttributeName(@NotNull GCMAttributeName o) {
    visitPsiElement(o);
  }

  public void visitClassDeclaration(@NotNull GCMClassDeclaration o) {
    visitPsiElement(o);
  }

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

  public void visitIndexDeclaration(@NotNull GCMIndexDeclaration o) {
    visitPsiElement(o);
  }

  public void visitIndexNameDeclaration(@NotNull GCMIndexNameDeclaration o) {
    visitPsiElement(o);
  }

  public void visitParentsDeclaration(@NotNull GCMParentsDeclaration o) {
    visitPsiElement(o);
  }

  public void visitRelationDeclaration(@NotNull GCMRelationDeclaration o) {
    visitPsiElement(o);
  }

  public void visitRelationIndexDeclaration(@NotNull GCMRelationIndexDeclaration o) {
    visitPsiElement(o);
  }

  public void visitRelationName(@NotNull GCMRelationName o) {
    visitPsiElement(o);
  }

  public void visitToManyDeclaration(@NotNull GCMToManyDeclaration o) {
    visitPsiElement(o);
  }

  public void visitToOneDeclaration(@NotNull GCMToOneDeclaration o) {
    visitPsiElement(o);
  }

  public void visitTypeDeclaration(@NotNull GCMTypeDeclaration o) {
    visitNamedElement(o);
  }

  public void visitNamedElement(@NotNull GCMNamedElement o) {
    visitPsiElement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
