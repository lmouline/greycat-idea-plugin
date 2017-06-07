// This is a generated file. Not intended for manual editing.
package greycat.idea.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import greycat.idea.GCMElementType;
import greycat.idea.GCMTokenType;
import greycat.idea.psi.impl.*;

public interface GCMTypes {

  IElementType ATTRIBUTE_DECLARATION = new GCMElementType("ATTRIBUTE_DECLARATION");
  IElementType ATTRIBUTE_NAME = new GCMElementType("ATTRIBUTE_NAME");
  IElementType CLASS_DECLARATION = new GCMElementType("CLASS_DECLARATION");
  IElementType CLASS_ELEM_DECLARATION = new GCMElementType("CLASS_ELEM_DECLARATION");
  IElementType DECLARATION = new GCMElementType("DECLARATION");
  IElementType ENUM_DECLARATION = new GCMElementType("ENUM_DECLARATION");
  IElementType ENUM_ELEM_DECLARATION = new GCMElementType("ENUM_ELEM_DECLARATION");
  IElementType INDEX_DECLARATION = new GCMElementType("INDEX_DECLARATION");
  IElementType INDEX_NAME_DECLARATION = new GCMElementType("INDEX_NAME_DECLARATION");
  IElementType PARENTS_DECLARATION = new GCMElementType("PARENTS_DECLARATION");
  IElementType RELATION_DECLARATION = new GCMElementType("RELATION_DECLARATION");
  IElementType RELATION_INDEX_DECLARATION = new GCMElementType("RELATION_INDEX_DECLARATION");
  IElementType RELATION_NAME = new GCMElementType("RELATION_NAME");
  IElementType TO_MANY_DECLARATION = new GCMElementType("TO_MANY_DECLARATION");
  IElementType TO_ONE_DECLARATION = new GCMElementType("TO_ONE_DECLARATION");
  IElementType TYPE_DECLARATION = new GCMElementType("TYPE_DECLARATION");

  IElementType ANNOT_PARAM_CLOSE = new GCMTokenType(")");
  IElementType ANNOT_PARAM_OPEN = new GCMTokenType("(");
  IElementType ARRAY = new GCMTokenType("[]");
  IElementType AS = new GCMTokenType("as");
  IElementType ATT = new GCMTokenType("att");
  IElementType BODY_CLOSE = new GCMTokenType("}");
  IElementType BODY_OPEN = new GCMTokenType("{");
  IElementType BY = new GCMTokenType("by");
  IElementType CLASS = new GCMTokenType("class");
  IElementType COLON = new GCMTokenType(":");
  IElementType COMMA = new GCMTokenType(",");
  IElementType COMMENT = new GCMTokenType("comment");
  IElementType CRLF = new GCMTokenType("CRLF");
  IElementType ENUM = new GCMTokenType("enum");
  IElementType EOF = new GCMTokenType("<<EOF>>");
  IElementType EXTENDS = new GCMTokenType("extends");
  IElementType IDENT = new GCMTokenType("IDENT");
  IElementType INDEXED = new GCMTokenType("indexed");
  IElementType INDEXED_BY = new GCMTokenType("indexed by");
  IElementType MULT_SEP = new GCMTokenType(".");
  IElementType NEWLINE = new GCMTokenType("newline");
  IElementType NUMBER = new GCMTokenType("NUMBER");
  IElementType REF = new GCMTokenType("ref");
  IElementType REL = new GCMTokenType("rel");
  IElementType STRING = new GCMTokenType("string");
  IElementType WITH_TIME = new GCMTokenType("with time");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
       if (type == ATTRIBUTE_DECLARATION) {
        return new GCMAttributeDeclarationImpl(node);
      }
      else if (type == ATTRIBUTE_NAME) {
        return new GCMAttributeNameImpl(node);
      }
      else if (type == CLASS_DECLARATION) {
        return new GCMClassDeclarationImpl(node);
      }
      else if (type == CLASS_ELEM_DECLARATION) {
        return new GCMClassElemDeclarationImpl(node);
      }
      else if (type == DECLARATION) {
        return new GCMDeclarationImpl(node);
      }
      else if (type == ENUM_DECLARATION) {
        return new GCMEnumDeclarationImpl(node);
      }
      else if (type == ENUM_ELEM_DECLARATION) {
        return new GCMEnumElemDeclarationImpl(node);
      }
      else if (type == INDEX_DECLARATION) {
        return new GCMIndexDeclarationImpl(node);
      }
      else if (type == INDEX_NAME_DECLARATION) {
        return new GCMIndexNameDeclarationImpl(node);
      }
      else if (type == PARENTS_DECLARATION) {
        return new GCMParentsDeclarationImpl(node);
      }
      else if (type == RELATION_DECLARATION) {
        return new GCMRelationDeclarationImpl(node);
      }
      else if (type == RELATION_INDEX_DECLARATION) {
        return new GCMRelationIndexDeclarationImpl(node);
      }
      else if (type == RELATION_NAME) {
        return new GCMRelationNameImpl(node);
      }
      else if (type == TO_MANY_DECLARATION) {
        return new GCMToManyDeclarationImpl(node);
      }
      else if (type == TO_ONE_DECLARATION) {
        return new GCMToOneDeclarationImpl(node);
      }
      else if (type == TYPE_DECLARATION) {
        return new GCMTypeDeclarationImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
