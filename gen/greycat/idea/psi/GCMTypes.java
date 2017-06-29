// This is a generated file. Not intended for manual editing.
package greycat.idea.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import greycat.idea.GCMElementType;
import greycat.idea.GCMTokenType;
import greycat.idea.psi.impl.*;

public interface GCMTypes {

  IElementType ACTION_DECLARATION = new GCMElementType("ACTION_DECLARATION");
  IElementType ACTION_PARAM = new GCMElementType("ACTION_PARAM");
  IElementType ACTION_PARAMS = new GCMElementType("ACTION_PARAMS");
  IElementType ATTRIBUTE_DECLARATION = new GCMElementType("ATTRIBUTE_DECLARATION");
  IElementType ATTRIBUTE_DEFAULT = new GCMElementType("ATTRIBUTE_DEFAULT");
  IElementType ATTRIBUTE_NAME = new GCMElementType("ATTRIBUTE_NAME");
  IElementType CLASS_DECLARATION = new GCMElementType("CLASS_DECLARATION");
  IElementType COMPLEX_VALUE = new GCMElementType("COMPLEX_VALUE");
  IElementType COMPLEX_VALUE_DECLARATION = new GCMElementType("COMPLEX_VALUE_DECLARATION");
  IElementType CONST_DECLARATION = new GCMElementType("CONST_DECLARATION");
  IElementType CONST_VALUE_DECLARATION = new GCMElementType("CONST_VALUE_DECLARATION");
  IElementType CUSTOM_TYPE_DECLARATION = new GCMElementType("CUSTOM_TYPE_DECLARATION");
  IElementType DECLARATION = new GCMElementType("DECLARATION");
  IElementType IMPORT_DECLARATION = new GCMElementType("IMPORT_DECLARATION");
  IElementType INDEX_DECLARATION = new GCMElementType("INDEX_DECLARATION");
  IElementType INDEX_PARAMS = new GCMElementType("INDEX_PARAMS");
  IElementType NTUPLE_VALUE = new GCMElementType("NTUPLE_VALUE");
  IElementType PARENTS_DECLARATION = new GCMElementType("PARENTS_DECLARATION");
  IElementType PROP = new GCMElementType("PROP");
  IElementType RELATION_DECLARATION = new GCMElementType("RELATION_DECLARATION");
  IElementType RELATION_NAME = new GCMElementType("RELATION_NAME");
  IElementType SUB_CONST_DECLARATION = new GCMElementType("SUB_CONST_DECLARATION");
  IElementType SUB_TASK = new GCMElementType("SUB_TASK");
  IElementType TASK_VALUE_DECLARATION = new GCMElementType("TASK_VALUE_DECLARATION");
  IElementType TO_MANY_DECLARATION = new GCMElementType("TO_MANY_DECLARATION");
  IElementType TO_ONE_DECLARATION = new GCMElementType("TO_ONE_DECLARATION");
  IElementType TYPE_DECLARATION = new GCMElementType("TYPE_DECLARATION");
  IElementType VALUE_DECLARATION = new GCMElementType("VALUE_DECLARATION");

  IElementType ATT = new GCMTokenType("att");
  IElementType BLOCK_COMMENT = new GCMTokenType("block_comment");
  IElementType BODY_CLOSE = new GCMTokenType("}");
  IElementType BODY_OPEN = new GCMTokenType("{");
  IElementType CLASS = new GCMTokenType("class");
  IElementType COLON = new GCMTokenType(":");
  IElementType COMMA = new GCMTokenType(",");
  IElementType CONST = new GCMTokenType("const");
  IElementType CRLF = new GCMTokenType("CRLF");
  IElementType EOF = new GCMTokenType("<<EOF>>");
  IElementType EQUALS = new GCMTokenType("=");
  IElementType EXTENDS = new GCMTokenType("extends");
  IElementType IDENT = new GCMTokenType("IDENT");
  IElementType IMPORT = new GCMTokenType("import");
  IElementType INDEX = new GCMTokenType("index");
  IElementType LINE_COMMENT = new GCMTokenType("line_comment");
  IElementType NEWLINE = new GCMTokenType("newline");
  IElementType NUMBER = new GCMTokenType("NUMBER");
  IElementType PCLOSE = new GCMTokenType(")");
  IElementType POINT = new GCMTokenType(".");
  IElementType POPEN = new GCMTokenType("(");
  IElementType REF = new GCMTokenType("ref");
  IElementType REL = new GCMTokenType("rel");
  IElementType STRING = new GCMTokenType("STRING");
  IElementType TYPE = new GCMTokenType("type");
  IElementType USING = new GCMTokenType("using");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
       if (type == ACTION_DECLARATION) {
        return new GCMActionDeclarationImpl(node);
      }
      else if (type == ACTION_PARAM) {
        return new GCMActionParamImpl(node);
      }
      else if (type == ACTION_PARAMS) {
        return new GCMActionParamsImpl(node);
      }
      else if (type == ATTRIBUTE_DECLARATION) {
        return new GCMAttributeDeclarationImpl(node);
      }
      else if (type == ATTRIBUTE_DEFAULT) {
        return new GCMAttributeDefaultImpl(node);
      }
      else if (type == ATTRIBUTE_NAME) {
        return new GCMAttributeNameImpl(node);
      }
      else if (type == CLASS_DECLARATION) {
        return new GCMClassDeclarationImpl(node);
      }
      else if (type == COMPLEX_VALUE) {
        return new GCMComplexValueImpl(node);
      }
      else if (type == COMPLEX_VALUE_DECLARATION) {
        return new GCMComplexValueDeclarationImpl(node);
      }
      else if (type == CONST_DECLARATION) {
        return new GCMConstDeclarationImpl(node);
      }
      else if (type == CONST_VALUE_DECLARATION) {
        return new GCMConstValueDeclarationImpl(node);
      }
      else if (type == CUSTOM_TYPE_DECLARATION) {
        return new GCMCustomTypeDeclarationImpl(node);
      }
      else if (type == DECLARATION) {
        return new GCMDeclarationImpl(node);
      }
      else if (type == IMPORT_DECLARATION) {
        return new GCMImportDeclarationImpl(node);
      }
      else if (type == INDEX_DECLARATION) {
        return new GCMIndexDeclarationImpl(node);
      }
      else if (type == INDEX_PARAMS) {
        return new GCMIndexParamsImpl(node);
      }
      else if (type == NTUPLE_VALUE) {
        return new GCMNtupleValueImpl(node);
      }
      else if (type == PARENTS_DECLARATION) {
        return new GCMParentsDeclarationImpl(node);
      }
      else if (type == PROP) {
        return new GCMPropImpl(node);
      }
      else if (type == RELATION_DECLARATION) {
        return new GCMRelationDeclarationImpl(node);
      }
      else if (type == RELATION_NAME) {
        return new GCMRelationNameImpl(node);
      }
      else if (type == SUB_CONST_DECLARATION) {
        return new GCMSubConstDeclarationImpl(node);
      }
      else if (type == SUB_TASK) {
        return new GCMSubTaskImpl(node);
      }
      else if (type == TASK_VALUE_DECLARATION) {
        return new GCMTaskValueDeclarationImpl(node);
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
      else if (type == VALUE_DECLARATION) {
        return new GCMValueDeclarationImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
