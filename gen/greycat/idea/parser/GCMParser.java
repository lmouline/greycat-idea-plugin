// This is a generated file. Not intended for manual editing.
package greycat.idea.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static greycat.idea.psi.GCMTypes.*;
import static greycat.idea.parser.GCMParserUtil.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class GCMParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    if (t == ATTRIBUTE_DECLARATION) {
      r = ATTRIBUTE_DECLARATION(b, 0);
    }
    else if (t == ATTRIBUTE_NAME) {
      r = ATTRIBUTE_NAME(b, 0);
    }
    else if (t == CLASS_DECLARATION) {
      r = CLASS_DECLARATION(b, 0);
    }
    else if (t == CLASS_ELEM_DECLARATION) {
      r = CLASS_ELEM_DECLARATION(b, 0);
    }
    else if (t == DECLARATION) {
      r = DECLARATION(b, 0);
    }
    else if (t == ENUM_DECLARATION) {
      r = ENUM_DECLARATION(b, 0);
    }
    else if (t == ENUM_ELEM_DECLARATION) {
      r = ENUM_ELEM_DECLARATION(b, 0);
    }
    else if (t == INDEX_DECLARATION) {
      r = INDEX_DECLARATION(b, 0);
    }
    else if (t == INDEX_NAME_DECLARATION) {
      r = INDEX_NAME_DECLARATION(b, 0);
    }
    else if (t == PARENTS_DECLARATION) {
      r = PARENTS_DECLARATION(b, 0);
    }
    else if (t == RELATION_DECLARATION) {
      r = RELATION_DECLARATION(b, 0);
    }
    else if (t == RELATION_INDEX_DECLARATION) {
      r = RELATION_INDEX_DECLARATION(b, 0);
    }
    else if (t == RELATION_NAME) {
      r = RELATION_NAME(b, 0);
    }
    else if (t == TO_MANY_DECLARATION) {
      r = TO_MANY_DECLARATION(b, 0);
    }
    else if (t == TO_ONE_DECLARATION) {
      r = TO_ONE_DECLARATION(b, 0);
    }
    else if (t == TYPE_DECLARATION) {
      r = TYPE_DECLARATION(b, 0);
    }
    else {
      r = parse_root_(t, b, 0);
    }
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return GREYCATMODEL(b, l + 1);
  }

  /* ********************************************************** */
  // ATT ATTRIBUTE_NAME COLON TYPE_DECLARATION
  public static boolean ATTRIBUTE_DECLARATION(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ATTRIBUTE_DECLARATION")) return false;
    if (!nextTokenIs(b, ATT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ATT);
    r = r && ATTRIBUTE_NAME(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && TYPE_DECLARATION(b, l + 1);
    exit_section_(b, m, ATTRIBUTE_DECLARATION, r);
    return r;
  }

  /* ********************************************************** */
  // IDENT
  public static boolean ATTRIBUTE_NAME(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ATTRIBUTE_NAME")) return false;
    if (!nextTokenIs(b, IDENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENT);
    exit_section_(b, m, ATTRIBUTE_NAME, r);
    return r;
  }

  /* ********************************************************** */
  // CLASS TYPE_DECLARATION PARENTS_DECLARATION? BODY_OPEN CLASS_ELEM_DECLARATION* BODY_CLOSE
  public static boolean CLASS_DECLARATION(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CLASS_DECLARATION")) return false;
    if (!nextTokenIs(b, CLASS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CLASS);
    r = r && TYPE_DECLARATION(b, l + 1);
    r = r && CLASS_DECLARATION_2(b, l + 1);
    r = r && consumeToken(b, BODY_OPEN);
    r = r && CLASS_DECLARATION_4(b, l + 1);
    r = r && consumeToken(b, BODY_CLOSE);
    exit_section_(b, m, CLASS_DECLARATION, r);
    return r;
  }

  // PARENTS_DECLARATION?
  private static boolean CLASS_DECLARATION_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CLASS_DECLARATION_2")) return false;
    PARENTS_DECLARATION(b, l + 1);
    return true;
  }

  // CLASS_ELEM_DECLARATION*
  private static boolean CLASS_DECLARATION_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CLASS_DECLARATION_4")) return false;
    int c = current_position_(b);
    while (true) {
      if (!CLASS_ELEM_DECLARATION(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "CLASS_DECLARATION_4", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // ATTRIBUTE_DECLARATION | RELATION_DECLARATION | INDEX_DECLARATION
  public static boolean CLASS_ELEM_DECLARATION(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CLASS_ELEM_DECLARATION")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CLASS_ELEM_DECLARATION, "<class elem declaration>");
    r = ATTRIBUTE_DECLARATION(b, l + 1);
    if (!r) r = RELATION_DECLARATION(b, l + 1);
    if (!r) r = INDEX_DECLARATION(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ENUM_DECLARATION | CLASS_DECLARATION | eof | newline | CRLF
  public static boolean DECLARATION(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DECLARATION")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DECLARATION, "<declaration>");
    r = ENUM_DECLARATION(b, l + 1);
    if (!r) r = CLASS_DECLARATION(b, l + 1);
    if (!r) r = consumeToken(b, EOF);
    if (!r) r = consumeToken(b, NEWLINE);
    if (!r) r = consumeToken(b, CRLF);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ENUM TYPE_DECLARATION BODY_OPEN ENUM_ELEM_DECLARATION (COMMA ENUM_ELEM_DECLARATION)* BODY_CLOSE
  public static boolean ENUM_DECLARATION(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ENUM_DECLARATION")) return false;
    if (!nextTokenIs(b, ENUM)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ENUM);
    r = r && TYPE_DECLARATION(b, l + 1);
    r = r && consumeToken(b, BODY_OPEN);
    r = r && ENUM_ELEM_DECLARATION(b, l + 1);
    r = r && ENUM_DECLARATION_4(b, l + 1);
    r = r && consumeToken(b, BODY_CLOSE);
    exit_section_(b, m, ENUM_DECLARATION, r);
    return r;
  }

  // (COMMA ENUM_ELEM_DECLARATION)*
  private static boolean ENUM_DECLARATION_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ENUM_DECLARATION_4")) return false;
    int c = current_position_(b);
    while (true) {
      if (!ENUM_DECLARATION_4_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ENUM_DECLARATION_4", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // COMMA ENUM_ELEM_DECLARATION
  private static boolean ENUM_DECLARATION_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ENUM_DECLARATION_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && ENUM_ELEM_DECLARATION(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // IDENT
  public static boolean ENUM_ELEM_DECLARATION(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ENUM_ELEM_DECLARATION")) return false;
    if (!nextTokenIs(b, IDENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENT);
    exit_section_(b, m, ENUM_ELEM_DECLARATION, r);
    return r;
  }

  /* ********************************************************** */
  // DECLARATION*
  static boolean GREYCATMODEL(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GREYCATMODEL")) return false;
    int c = current_position_(b);
    while (true) {
      if (!DECLARATION(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "GREYCATMODEL", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // INDEXED WITH_TIME? BY ATTRIBUTE_NAME (COMMA ATTRIBUTE_NAME)* (AS INDEX_NAME_DECLARATION)?
  public static boolean INDEX_DECLARATION(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "INDEX_DECLARATION")) return false;
    if (!nextTokenIs(b, INDEXED)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, INDEXED);
    r = r && INDEX_DECLARATION_1(b, l + 1);
    r = r && consumeToken(b, BY);
    r = r && ATTRIBUTE_NAME(b, l + 1);
    r = r && INDEX_DECLARATION_4(b, l + 1);
    r = r && INDEX_DECLARATION_5(b, l + 1);
    exit_section_(b, m, INDEX_DECLARATION, r);
    return r;
  }

  // WITH_TIME?
  private static boolean INDEX_DECLARATION_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "INDEX_DECLARATION_1")) return false;
    consumeToken(b, WITH_TIME);
    return true;
  }

  // (COMMA ATTRIBUTE_NAME)*
  private static boolean INDEX_DECLARATION_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "INDEX_DECLARATION_4")) return false;
    int c = current_position_(b);
    while (true) {
      if (!INDEX_DECLARATION_4_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "INDEX_DECLARATION_4", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // COMMA ATTRIBUTE_NAME
  private static boolean INDEX_DECLARATION_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "INDEX_DECLARATION_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && ATTRIBUTE_NAME(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (AS INDEX_NAME_DECLARATION)?
  private static boolean INDEX_DECLARATION_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "INDEX_DECLARATION_5")) return false;
    INDEX_DECLARATION_5_0(b, l + 1);
    return true;
  }

  // AS INDEX_NAME_DECLARATION
  private static boolean INDEX_DECLARATION_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "INDEX_DECLARATION_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, AS);
    r = r && INDEX_NAME_DECLARATION(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // IDENT
  public static boolean INDEX_NAME_DECLARATION(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "INDEX_NAME_DECLARATION")) return false;
    if (!nextTokenIs(b, IDENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENT);
    exit_section_(b, m, INDEX_NAME_DECLARATION, r);
    return r;
  }

  /* ********************************************************** */
  // EXTENDS TYPE_DECLARATION
  public static boolean PARENTS_DECLARATION(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PARENTS_DECLARATION")) return false;
    if (!nextTokenIs(b, EXTENDS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EXTENDS);
    r = r && TYPE_DECLARATION(b, l + 1);
    exit_section_(b, m, PARENTS_DECLARATION, r);
    return r;
  }

  /* ********************************************************** */
  // TO_ONE_DECLARATION | TO_MANY_DECLARATION
  public static boolean RELATION_DECLARATION(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RELATION_DECLARATION")) return false;
    if (!nextTokenIs(b, "<relation declaration>", REF, REL)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, RELATION_DECLARATION, "<relation declaration>");
    r = TO_ONE_DECLARATION(b, l + 1);
    if (!r) r = TO_MANY_DECLARATION(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // INDEXED_BY ATTRIBUTE_NAME (COMMA ATTRIBUTE_NAME)*
  public static boolean RELATION_INDEX_DECLARATION(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RELATION_INDEX_DECLARATION")) return false;
    if (!nextTokenIs(b, INDEXED_BY)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, INDEXED_BY);
    r = r && ATTRIBUTE_NAME(b, l + 1);
    r = r && RELATION_INDEX_DECLARATION_2(b, l + 1);
    exit_section_(b, m, RELATION_INDEX_DECLARATION, r);
    return r;
  }

  // (COMMA ATTRIBUTE_NAME)*
  private static boolean RELATION_INDEX_DECLARATION_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RELATION_INDEX_DECLARATION_2")) return false;
    int c = current_position_(b);
    while (true) {
      if (!RELATION_INDEX_DECLARATION_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "RELATION_INDEX_DECLARATION_2", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // COMMA ATTRIBUTE_NAME
  private static boolean RELATION_INDEX_DECLARATION_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RELATION_INDEX_DECLARATION_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && ATTRIBUTE_NAME(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // IDENT
  public static boolean RELATION_NAME(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RELATION_NAME")) return false;
    if (!nextTokenIs(b, IDENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENT);
    exit_section_(b, m, RELATION_NAME, r);
    return r;
  }

  /* ********************************************************** */
  // REL RELATION_NAME COLON TYPE_DECLARATION RELATION_INDEX_DECLARATION?
  public static boolean TO_MANY_DECLARATION(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TO_MANY_DECLARATION")) return false;
    if (!nextTokenIs(b, REL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, REL);
    r = r && RELATION_NAME(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && TYPE_DECLARATION(b, l + 1);
    r = r && TO_MANY_DECLARATION_4(b, l + 1);
    exit_section_(b, m, TO_MANY_DECLARATION, r);
    return r;
  }

  // RELATION_INDEX_DECLARATION?
  private static boolean TO_MANY_DECLARATION_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TO_MANY_DECLARATION_4")) return false;
    RELATION_INDEX_DECLARATION(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // REF RELATION_NAME COLON TYPE_DECLARATION
  public static boolean TO_ONE_DECLARATION(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TO_ONE_DECLARATION")) return false;
    if (!nextTokenIs(b, REF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, REF);
    r = r && RELATION_NAME(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && TYPE_DECLARATION(b, l + 1);
    exit_section_(b, m, TO_ONE_DECLARATION, r);
    return r;
  }

  /* ********************************************************** */
  // IDENT
  public static boolean TYPE_DECLARATION(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TYPE_DECLARATION")) return false;
    if (!nextTokenIs(b, IDENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENT);
    exit_section_(b, m, TYPE_DECLARATION, r);
    return r;
  }

  /* ********************************************************** */
  // !(CLASS|ENUM)
  static boolean rule_start(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rule_start")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !rule_start_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // CLASS|ENUM
  private static boolean rule_start_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rule_start_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CLASS);
    if (!r) r = consumeToken(b, ENUM);
    exit_section_(b, m, null, r);
    return r;
  }

}
