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
<<<<<<< 50e0da97b4bfe492c7595f1363ff378d9028067a
    if (t == ATTRIBUTE_DECLARATION) {
      r = ATTRIBUTE_DECLARATION(b, 0);
    }
=======
    if (t == ACTION_DECLARATION) {
      r = ACTION_DECLARATION(b, 0);
    }
    else if (t == ACTION_PARAM) {
      r = ACTION_PARAM(b, 0);
    }
    else if (t == ACTION_PARAMS) {
      r = ACTION_PARAMS(b, 0);
    }
    else if (t == ATTRIBUTE_DECLARATION) {
      r = ATTRIBUTE_DECLARATION(b, 0);
    }
    else if (t == ATTRIBUTE_DEFAULT) {
      r = ATTRIBUTE_DEFAULT(b, 0);
    }
>>>>>>> 44ffb72f7837a15c79487ff6d0cc87870a9bc0d5
    else if (t == ATTRIBUTE_NAME) {
      r = ATTRIBUTE_NAME(b, 0);
    }
    else if (t == CLASS_DECLARATION) {
      r = CLASS_DECLARATION(b, 0);
    }
<<<<<<< 50e0da97b4bfe492c7595f1363ff378d9028067a
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
    else if (t == KEY_DECLARATION) {
      r = KEY_DECLARATION(b, 0);
    }
    else if (t == KEY_NAME_DECLARATION) {
      r = KEY_NAME_DECLARATION(b, 0);
    }
    else if (t == KEY_WITHOUT_TIME_DECLARATION) {
      r = KEY_WITHOUT_TIME_DECLARATION(b, 0);
    }
    else if (t == KEY_WITH_TIME_DECLARATION) {
      r = KEY_WITH_TIME_DECLARATION(b, 0);
=======
    else if (t == COMPLEX_VALUE) {
      r = COMPLEX_VALUE(b, 0);
    }
    else if (t == COMPLEX_VALUE_DECLARATION) {
      r = COMPLEX_VALUE_DECLARATION(b, 0);
    }
    else if (t == CONST_DECLARATION) {
      r = CONST_DECLARATION(b, 0);
    }
    else if (t == CONST_VALUE_DECLARATION) {
      r = CONST_VALUE_DECLARATION(b, 0);
    }
    else if (t == CUSTOM_TYPE_DECLARATION) {
      r = CUSTOM_TYPE_DECLARATION(b, 0);
    }
    else if (t == DECLARATION) {
      r = DECLARATION(b, 0);
    }
    else if (t == IMPORT_DECLARATION) {
      r = IMPORT_DECLARATION(b, 0);
    }
    else if (t == INDEX_DECLARATION) {
      r = INDEX_DECLARATION(b, 0);
    }
    else if (t == INDEX_PARAMS) {
      r = INDEX_PARAMS(b, 0);
    }
    else if (t == NTUPLE_VALUE) {
      r = NTUPLE_VALUE(b, 0);
>>>>>>> 44ffb72f7837a15c79487ff6d0cc87870a9bc0d5
    }
    else if (t == PARENTS_DECLARATION) {
      r = PARENTS_DECLARATION(b, 0);
    }
<<<<<<< 50e0da97b4bfe492c7595f1363ff378d9028067a
    else if (t == RELATION_DECLARATION) {
      r = RELATION_DECLARATION(b, 0);
    }
    else if (t == RELATION_INDEX_DECLARATION) {
      r = RELATION_INDEX_DECLARATION(b, 0);
    }
    else if (t == RELATION_NAME) {
      r = RELATION_NAME(b, 0);
    }
=======
    else if (t == PROP) {
      r = PROP(b, 0);
    }
    else if (t == RELATION_DECLARATION) {
      r = RELATION_DECLARATION(b, 0);
    }
    else if (t == RELATION_NAME) {
      r = RELATION_NAME(b, 0);
    }
    else if (t == SUB_CONST_DECLARATION) {
      r = SUB_CONST_DECLARATION(b, 0);
    }
    else if (t == SUB_TASK) {
      r = SUB_TASK(b, 0);
    }
    else if (t == TASK_VALUE_DECLARATION) {
      r = TASK_VALUE_DECLARATION(b, 0);
    }
>>>>>>> 44ffb72f7837a15c79487ff6d0cc87870a9bc0d5
    else if (t == TO_MANY_DECLARATION) {
      r = TO_MANY_DECLARATION(b, 0);
    }
    else if (t == TO_ONE_DECLARATION) {
      r = TO_ONE_DECLARATION(b, 0);
    }
    else if (t == TYPE_DECLARATION) {
      r = TYPE_DECLARATION(b, 0);
    }
<<<<<<< 50e0da97b4bfe492c7595f1363ff378d9028067a
=======
    else if (t == VALUE_DECLARATION) {
      r = VALUE_DECLARATION(b, 0);
    }
>>>>>>> 44ffb72f7837a15c79487ff6d0cc87870a9bc0d5
    else {
      r = parse_root_(t, b, 0);
    }
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return GREYCATMODEL(b, l + 1);
  }

  /* ********************************************************** */
<<<<<<< 50e0da97b4bfe492c7595f1363ff378d9028067a
  // ATT ATTRIBUTE_NAME COLON TYPE_DECLARATION
=======
  // IDENT ACTION_PARAMS?
  public static boolean ACTION_DECLARATION(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ACTION_DECLARATION")) return false;
    if (!nextTokenIs(b, IDENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENT);
    r = r && ACTION_DECLARATION_1(b, l + 1);
    exit_section_(b, m, ACTION_DECLARATION, r);
    return r;
  }

  // ACTION_PARAMS?
  private static boolean ACTION_DECLARATION_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ACTION_DECLARATION_1")) return false;
    ACTION_PARAMS(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // STRING | NUMBER | SUB_TASK
  public static boolean ACTION_PARAM(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ACTION_PARAM")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ACTION_PARAM, "<action param>");
    r = consumeToken(b, STRING);
    if (!r) r = consumeToken(b, NUMBER);
    if (!r) r = SUB_TASK(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // POPEN ACTION_PARAM (COMMA ACTION_PARAM)* PCLOSE
  public static boolean ACTION_PARAMS(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ACTION_PARAMS")) return false;
    if (!nextTokenIs(b, POPEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, POPEN);
    r = r && ACTION_PARAM(b, l + 1);
    r = r && ACTION_PARAMS_2(b, l + 1);
    r = r && consumeToken(b, PCLOSE);
    exit_section_(b, m, ACTION_PARAMS, r);
    return r;
  }

  // (COMMA ACTION_PARAM)*
  private static boolean ACTION_PARAMS_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ACTION_PARAMS_2")) return false;
    int c = current_position_(b);
    while (true) {
      if (!ACTION_PARAMS_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ACTION_PARAMS_2", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // COMMA ACTION_PARAM
  private static boolean ACTION_PARAMS_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ACTION_PARAMS_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && ACTION_PARAM(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ATT ATTRIBUTE_NAME COLON TYPE_DECLARATION (EQUALS ATTRIBUTE_DEFAULT)?
>>>>>>> 44ffb72f7837a15c79487ff6d0cc87870a9bc0d5
  public static boolean ATTRIBUTE_DECLARATION(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ATTRIBUTE_DECLARATION")) return false;
    if (!nextTokenIs(b, ATT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ATT);
    r = r && ATTRIBUTE_NAME(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && TYPE_DECLARATION(b, l + 1);
<<<<<<< 50e0da97b4bfe492c7595f1363ff378d9028067a
=======
    r = r && ATTRIBUTE_DECLARATION_4(b, l + 1);
>>>>>>> 44ffb72f7837a15c79487ff6d0cc87870a9bc0d5
    exit_section_(b, m, ATTRIBUTE_DECLARATION, r);
    return r;
  }

<<<<<<< 50e0da97b4bfe492c7595f1363ff378d9028067a
=======
  // (EQUALS ATTRIBUTE_DEFAULT)?
  private static boolean ATTRIBUTE_DECLARATION_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ATTRIBUTE_DECLARATION_4")) return false;
    ATTRIBUTE_DECLARATION_4_0(b, l + 1);
    return true;
  }

  // EQUALS ATTRIBUTE_DEFAULT
  private static boolean ATTRIBUTE_DECLARATION_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ATTRIBUTE_DECLARATION_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EQUALS);
    r = r && ATTRIBUTE_DEFAULT(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // TASK_VALUE_DECLARATION|VALUE_DECLARATION
  public static boolean ATTRIBUTE_DEFAULT(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ATTRIBUTE_DEFAULT")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ATTRIBUTE_DEFAULT, "<attribute default>");
    r = TASK_VALUE_DECLARATION(b, l + 1);
    if (!r) r = VALUE_DECLARATION(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

>>>>>>> 44ffb72f7837a15c79487ff6d0cc87870a9bc0d5
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
<<<<<<< 50e0da97b4bfe492c7595f1363ff378d9028067a
  // CLASS TYPE_DECLARATION PARENTS_DECLARATION? BODY_OPEN CLASS_ELEM_DECLARATION* BODY_CLOSE
=======
  // CLASS TYPE_DECLARATION PARENTS_DECLARATION? BODY_OPEN PROP* BODY_CLOSE
>>>>>>> 44ffb72f7837a15c79487ff6d0cc87870a9bc0d5
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

<<<<<<< 50e0da97b4bfe492c7595f1363ff378d9028067a
  // CLASS_ELEM_DECLARATION*
=======
  // PROP*
>>>>>>> 44ffb72f7837a15c79487ff6d0cc87870a9bc0d5
  private static boolean CLASS_DECLARATION_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CLASS_DECLARATION_4")) return false;
    int c = current_position_(b);
    while (true) {
<<<<<<< 50e0da97b4bfe492c7595f1363ff378d9028067a
      if (!CLASS_ELEM_DECLARATION(b, l + 1)) break;
=======
      if (!PROP(b, l + 1)) break;
>>>>>>> 44ffb72f7837a15c79487ff6d0cc87870a9bc0d5
      if (!empty_element_parsed_guard_(b, "CLASS_DECLARATION_4", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
<<<<<<< 50e0da97b4bfe492c7595f1363ff378d9028067a
  // ATTRIBUTE_DECLARATION | RELATION_DECLARATION | KEY_DECLARATION
  public static boolean CLASS_ELEM_DECLARATION(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CLASS_ELEM_DECLARATION")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CLASS_ELEM_DECLARATION, "<class elem declaration>");
    r = ATTRIBUTE_DECLARATION(b, l + 1);
    if (!r) r = RELATION_DECLARATION(b, l + 1);
    if (!r) r = KEY_DECLARATION(b, l + 1);
=======
  // IDENT | STRING | NUMBER | NTUPLE_VALUE
  public static boolean COMPLEX_VALUE(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "COMPLEX_VALUE")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, COMPLEX_VALUE, "<complex value>");
    r = consumeToken(b, IDENT);
    if (!r) r = consumeToken(b, STRING);
    if (!r) r = consumeToken(b, NUMBER);
    if (!r) r = NTUPLE_VALUE(b, l + 1);
>>>>>>> 44ffb72f7837a15c79487ff6d0cc87870a9bc0d5
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
<<<<<<< 50e0da97b4bfe492c7595f1363ff378d9028067a
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
=======
  // POPEN COMPLEX_VALUE (COMMA COMPLEX_VALUE)* PCLOSE
  public static boolean COMPLEX_VALUE_DECLARATION(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "COMPLEX_VALUE_DECLARATION")) return false;
    if (!nextTokenIs(b, POPEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, POPEN);
    r = r && COMPLEX_VALUE(b, l + 1);
    r = r && COMPLEX_VALUE_DECLARATION_2(b, l + 1);
    r = r && consumeToken(b, PCLOSE);
    exit_section_(b, m, COMPLEX_VALUE_DECLARATION, r);
    return r;
  }

  // (COMMA COMPLEX_VALUE)*
  private static boolean COMPLEX_VALUE_DECLARATION_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "COMPLEX_VALUE_DECLARATION_2")) return false;
    int c = current_position_(b);
    while (true) {
      if (!COMPLEX_VALUE_DECLARATION_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "COMPLEX_VALUE_DECLARATION_2", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // COMMA COMPLEX_VALUE
  private static boolean COMPLEX_VALUE_DECLARATION_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "COMPLEX_VALUE_DECLARATION_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && COMPLEX_VALUE(b, l + 1);
    exit_section_(b, m, null, r);
>>>>>>> 44ffb72f7837a15c79487ff6d0cc87870a9bc0d5
    return r;
  }

  /* ********************************************************** */
<<<<<<< 50e0da97b4bfe492c7595f1363ff378d9028067a
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
=======
  // CONST IDENT COLON TYPE_DECLARATION (EQUALS CONST_VALUE_DECLARATION)?
  public static boolean CONST_DECLARATION(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CONST_DECLARATION")) return false;
    if (!nextTokenIs(b, CONST)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, CONST, IDENT, COLON);
    r = r && TYPE_DECLARATION(b, l + 1);
    r = r && CONST_DECLARATION_4(b, l + 1);
    exit_section_(b, m, CONST_DECLARATION, r);
    return r;
  }

  // (EQUALS CONST_VALUE_DECLARATION)?
  private static boolean CONST_DECLARATION_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CONST_DECLARATION_4")) return false;
    CONST_DECLARATION_4_0(b, l + 1);
    return true;
  }

  // EQUALS CONST_VALUE_DECLARATION
  private static boolean CONST_DECLARATION_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CONST_DECLARATION_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EQUALS);
    r = r && CONST_VALUE_DECLARATION(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // TASK_VALUE_DECLARATION|VALUE_DECLARATION
  public static boolean CONST_VALUE_DECLARATION(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CONST_VALUE_DECLARATION")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONST_VALUE_DECLARATION, "<const value declaration>");
    r = TASK_VALUE_DECLARATION(b, l + 1);
    if (!r) r = VALUE_DECLARATION(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // TYPE IDENT BODY_OPEN (PROP)* BODY_CLOSE
  public static boolean CUSTOM_TYPE_DECLARATION(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CUSTOM_TYPE_DECLARATION")) return false;
    if (!nextTokenIs(b, TYPE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, TYPE, IDENT, BODY_OPEN);
    r = r && CUSTOM_TYPE_DECLARATION_3(b, l + 1);
    r = r && consumeToken(b, BODY_CLOSE);
    exit_section_(b, m, CUSTOM_TYPE_DECLARATION, r);
    return r;
  }

  // (PROP)*
  private static boolean CUSTOM_TYPE_DECLARATION_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CUSTOM_TYPE_DECLARATION_3")) return false;
    int c = current_position_(b);
    while (true) {
      if (!CUSTOM_TYPE_DECLARATION_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "CUSTOM_TYPE_DECLARATION_3", c)) break;
>>>>>>> 44ffb72f7837a15c79487ff6d0cc87870a9bc0d5
      c = current_position_(b);
    }
    return true;
  }

<<<<<<< 50e0da97b4bfe492c7595f1363ff378d9028067a
  // COMMA ENUM_ELEM_DECLARATION
  private static boolean ENUM_DECLARATION_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ENUM_DECLARATION_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && ENUM_ELEM_DECLARATION(b, l + 1);
=======
  // (PROP)
  private static boolean CUSTOM_TYPE_DECLARATION_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CUSTOM_TYPE_DECLARATION_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = PROP(b, l + 1);
>>>>>>> 44ffb72f7837a15c79487ff6d0cc87870a9bc0d5
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
<<<<<<< 50e0da97b4bfe492c7595f1363ff378d9028067a
  // IDENT
  public static boolean ENUM_ELEM_DECLARATION(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ENUM_ELEM_DECLARATION")) return false;
    if (!nextTokenIs(b, IDENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENT);
    exit_section_(b, m, ENUM_ELEM_DECLARATION, r);
=======
  // CLASS_DECLARATION | CONST_DECLARATION | INDEX_DECLARATION | CUSTOM_TYPE_DECLARATION | IMPORT_DECLARATION | eof | newline | CRLF
  public static boolean DECLARATION(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DECLARATION")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DECLARATION, "<declaration>");
    r = CLASS_DECLARATION(b, l + 1);
    if (!r) r = CONST_DECLARATION(b, l + 1);
    if (!r) r = INDEX_DECLARATION(b, l + 1);
    if (!r) r = CUSTOM_TYPE_DECLARATION(b, l + 1);
    if (!r) r = IMPORT_DECLARATION(b, l + 1);
    if (!r) r = consumeToken(b, EOF);
    if (!r) r = consumeToken(b, NEWLINE);
    if (!r) r = consumeToken(b, CRLF);
    exit_section_(b, l, m, r, false, null);
>>>>>>> 44ffb72f7837a15c79487ff6d0cc87870a9bc0d5
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
<<<<<<< 50e0da97b4bfe492c7595f1363ff378d9028067a
  // (KEY_WITH_TIME_DECLARATION | KEY_WITHOUT_TIME_DECLARATION) ATTRIBUTE_NAME (COMMA ATTRIBUTE_NAME)* (AS KEY_NAME_DECLARATION)?
  public static boolean KEY_DECLARATION(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "KEY_DECLARATION")) return false;
    if (!nextTokenIs(b, "<key declaration>", KEY, KEY_WITH_TIME)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, KEY_DECLARATION, "<key declaration>");
    r = KEY_DECLARATION_0(b, l + 1);
    r = r && ATTRIBUTE_NAME(b, l + 1);
    r = r && KEY_DECLARATION_2(b, l + 1);
    r = r && KEY_DECLARATION_3(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // KEY_WITH_TIME_DECLARATION | KEY_WITHOUT_TIME_DECLARATION
  private static boolean KEY_DECLARATION_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "KEY_DECLARATION_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = KEY_WITH_TIME_DECLARATION(b, l + 1);
    if (!r) r = KEY_WITHOUT_TIME_DECLARATION(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA ATTRIBUTE_NAME)*
  private static boolean KEY_DECLARATION_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "KEY_DECLARATION_2")) return false;
    int c = current_position_(b);
    while (true) {
      if (!KEY_DECLARATION_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "KEY_DECLARATION_2", c)) break;
=======
  // IMPORT STRING
  public static boolean IMPORT_DECLARATION(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IMPORT_DECLARATION")) return false;
    if (!nextTokenIs(b, IMPORT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IMPORT, STRING);
    exit_section_(b, m, IMPORT_DECLARATION, r);
    return r;
  }

  /* ********************************************************** */
  // INDEX IDENT COLON TYPE_DECLARATION USING INDEX_PARAMS
  public static boolean INDEX_DECLARATION(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "INDEX_DECLARATION")) return false;
    if (!nextTokenIs(b, INDEX)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, INDEX, IDENT, COLON);
    r = r && TYPE_DECLARATION(b, l + 1);
    r = r && consumeToken(b, USING);
    r = r && INDEX_PARAMS(b, l + 1);
    exit_section_(b, m, INDEX_DECLARATION, r);
    return r;
  }

  /* ********************************************************** */
  // IDENT (COMMA IDENT)*
  public static boolean INDEX_PARAMS(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "INDEX_PARAMS")) return false;
    if (!nextTokenIs(b, IDENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENT);
    r = r && INDEX_PARAMS_1(b, l + 1);
    exit_section_(b, m, INDEX_PARAMS, r);
    return r;
  }

  // (COMMA IDENT)*
  private static boolean INDEX_PARAMS_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "INDEX_PARAMS_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!INDEX_PARAMS_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "INDEX_PARAMS_1", c)) break;
>>>>>>> 44ffb72f7837a15c79487ff6d0cc87870a9bc0d5
      c = current_position_(b);
    }
    return true;
  }

<<<<<<< 50e0da97b4bfe492c7595f1363ff378d9028067a
  // COMMA ATTRIBUTE_NAME
  private static boolean KEY_DECLARATION_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "KEY_DECLARATION_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && ATTRIBUTE_NAME(b, l + 1);
=======
  // COMMA IDENT
  private static boolean INDEX_PARAMS_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "INDEX_PARAMS_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, COMMA, IDENT);
>>>>>>> 44ffb72f7837a15c79487ff6d0cc87870a9bc0d5
    exit_section_(b, m, null, r);
    return r;
  }

<<<<<<< 50e0da97b4bfe492c7595f1363ff378d9028067a
  // (AS KEY_NAME_DECLARATION)?
  private static boolean KEY_DECLARATION_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "KEY_DECLARATION_3")) return false;
    KEY_DECLARATION_3_0(b, l + 1);
    return true;
  }

  // AS KEY_NAME_DECLARATION
  private static boolean KEY_DECLARATION_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "KEY_DECLARATION_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, AS);
    r = r && KEY_NAME_DECLARATION(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // IDENT
  public static boolean KEY_NAME_DECLARATION(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "KEY_NAME_DECLARATION")) return false;
    if (!nextTokenIs(b, IDENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENT);
    exit_section_(b, m, KEY_NAME_DECLARATION, r);
    return r;
  }

  /* ********************************************************** */
  // KEY
  public static boolean KEY_WITHOUT_TIME_DECLARATION(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "KEY_WITHOUT_TIME_DECLARATION")) return false;
    if (!nextTokenIs(b, KEY)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KEY);
    exit_section_(b, m, KEY_WITHOUT_TIME_DECLARATION, r);
    return r;
  }

  /* ********************************************************** */
  // KEY_WITH_TIME
  public static boolean KEY_WITH_TIME_DECLARATION(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "KEY_WITH_TIME_DECLARATION")) return false;
    if (!nextTokenIs(b, KEY_WITH_TIME)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KEY_WITH_TIME);
    exit_section_(b, m, KEY_WITH_TIME_DECLARATION, r);
=======
  /* ********************************************************** */
  // POPEN (IDENT | STRING | NUMBER) (COMMA (IDENT | STRING | NUMBER))* PCLOSE
  public static boolean NTUPLE_VALUE(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NTUPLE_VALUE")) return false;
    if (!nextTokenIs(b, POPEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, POPEN);
    r = r && NTUPLE_VALUE_1(b, l + 1);
    r = r && NTUPLE_VALUE_2(b, l + 1);
    r = r && consumeToken(b, PCLOSE);
    exit_section_(b, m, NTUPLE_VALUE, r);
    return r;
  }

  // IDENT | STRING | NUMBER
  private static boolean NTUPLE_VALUE_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NTUPLE_VALUE_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENT);
    if (!r) r = consumeToken(b, STRING);
    if (!r) r = consumeToken(b, NUMBER);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA (IDENT | STRING | NUMBER))*
  private static boolean NTUPLE_VALUE_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NTUPLE_VALUE_2")) return false;
    int c = current_position_(b);
    while (true) {
      if (!NTUPLE_VALUE_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "NTUPLE_VALUE_2", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // COMMA (IDENT | STRING | NUMBER)
  private static boolean NTUPLE_VALUE_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NTUPLE_VALUE_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && NTUPLE_VALUE_2_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // IDENT | STRING | NUMBER
  private static boolean NTUPLE_VALUE_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NTUPLE_VALUE_2_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENT);
    if (!r) r = consumeToken(b, STRING);
    if (!r) r = consumeToken(b, NUMBER);
    exit_section_(b, m, null, r);
>>>>>>> 44ffb72f7837a15c79487ff6d0cc87870a9bc0d5
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
<<<<<<< 50e0da97b4bfe492c7595f1363ff378d9028067a
=======
  // ATTRIBUTE_DECLARATION | RELATION_DECLARATION | INDEX_DECLARATION | SUB_CONST_DECLARATION
  public static boolean PROP(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PROP")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PROP, "<prop>");
    r = ATTRIBUTE_DECLARATION(b, l + 1);
    if (!r) r = RELATION_DECLARATION(b, l + 1);
    if (!r) r = INDEX_DECLARATION(b, l + 1);
    if (!r) r = SUB_CONST_DECLARATION(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
>>>>>>> 44ffb72f7837a15c79487ff6d0cc87870a9bc0d5
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
<<<<<<< 50e0da97b4bfe492c7595f1363ff378d9028067a
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
=======
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
  // CONST IDENT COLON TYPE_DECLARATION (EQUALS CONST_VALUE_DECLARATION)?
  public static boolean SUB_CONST_DECLARATION(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SUB_CONST_DECLARATION")) return false;
    if (!nextTokenIs(b, CONST)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, CONST, IDENT, COLON);
    r = r && TYPE_DECLARATION(b, l + 1);
    r = r && SUB_CONST_DECLARATION_4(b, l + 1);
    exit_section_(b, m, SUB_CONST_DECLARATION, r);
    return r;
  }

  // (EQUALS CONST_VALUE_DECLARATION)?
  private static boolean SUB_CONST_DECLARATION_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SUB_CONST_DECLARATION_4")) return false;
    SUB_CONST_DECLARATION_4_0(b, l + 1);
    return true;
  }

  // EQUALS CONST_VALUE_DECLARATION
  private static boolean SUB_CONST_DECLARATION_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SUB_CONST_DECLARATION_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EQUALS);
    r = r && CONST_VALUE_DECLARATION(b, l + 1);
>>>>>>> 44ffb72f7837a15c79487ff6d0cc87870a9bc0d5
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
<<<<<<< 50e0da97b4bfe492c7595f1363ff378d9028067a
  // IDENT
  public static boolean RELATION_NAME(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RELATION_NAME")) return false;
    if (!nextTokenIs(b, IDENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENT);
    exit_section_(b, m, RELATION_NAME, r);
=======
  // BODY_OPEN TASK_VALUE_DECLARATION BODY_CLOSE
  public static boolean SUB_TASK(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SUB_TASK")) return false;
    if (!nextTokenIs(b, BODY_OPEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BODY_OPEN);
    r = r && TASK_VALUE_DECLARATION(b, l + 1);
    r = r && consumeToken(b, BODY_CLOSE);
    exit_section_(b, m, SUB_TASK, r);
>>>>>>> 44ffb72f7837a15c79487ff6d0cc87870a9bc0d5
    return r;
  }

  /* ********************************************************** */
<<<<<<< 50e0da97b4bfe492c7595f1363ff378d9028067a
  // REL RELATION_NAME COLON TYPE_DECLARATION (RELATION_INDEX_DECLARATION)?
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

  // (RELATION_INDEX_DECLARATION)?
  private static boolean TO_MANY_DECLARATION_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TO_MANY_DECLARATION_4")) return false;
    TO_MANY_DECLARATION_4_0(b, l + 1);
    return true;
  }

  // (RELATION_INDEX_DECLARATION)
  private static boolean TO_MANY_DECLARATION_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TO_MANY_DECLARATION_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = RELATION_INDEX_DECLARATION(b, l + 1);
=======
  // ACTION_DECLARATION (POINT ACTION_DECLARATION)*
  public static boolean TASK_VALUE_DECLARATION(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TASK_VALUE_DECLARATION")) return false;
    if (!nextTokenIs(b, IDENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ACTION_DECLARATION(b, l + 1);
    r = r && TASK_VALUE_DECLARATION_1(b, l + 1);
    exit_section_(b, m, TASK_VALUE_DECLARATION, r);
    return r;
  }

  // (POINT ACTION_DECLARATION)*
  private static boolean TASK_VALUE_DECLARATION_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TASK_VALUE_DECLARATION_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!TASK_VALUE_DECLARATION_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "TASK_VALUE_DECLARATION_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // POINT ACTION_DECLARATION
  private static boolean TASK_VALUE_DECLARATION_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TASK_VALUE_DECLARATION_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, POINT);
    r = r && ACTION_DECLARATION(b, l + 1);
>>>>>>> 44ffb72f7837a15c79487ff6d0cc87870a9bc0d5
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
<<<<<<< 50e0da97b4bfe492c7595f1363ff378d9028067a
=======
  // REL RELATION_NAME COLON TYPE_DECLARATION
  public static boolean TO_MANY_DECLARATION(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TO_MANY_DECLARATION")) return false;
    if (!nextTokenIs(b, REL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, REL);
    r = r && RELATION_NAME(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && TYPE_DECLARATION(b, l + 1);
    exit_section_(b, m, TO_MANY_DECLARATION, r);
    return r;
  }

  /* ********************************************************** */
>>>>>>> 44ffb72f7837a15c79487ff6d0cc87870a9bc0d5
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
<<<<<<< 50e0da97b4bfe492c7595f1363ff378d9028067a
  // !(CLASS|ENUM)
=======
  // IDENT | STRING | NUMBER | COMPLEX_VALUE_DECLARATION
  public static boolean VALUE_DECLARATION(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VALUE_DECLARATION")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VALUE_DECLARATION, "<value declaration>");
    r = consumeToken(b, IDENT);
    if (!r) r = consumeToken(b, STRING);
    if (!r) r = consumeToken(b, NUMBER);
    if (!r) r = COMPLEX_VALUE_DECLARATION(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // !(CLASS|INDEX|TYPE|CONST)
>>>>>>> 44ffb72f7837a15c79487ff6d0cc87870a9bc0d5
  static boolean rule_start(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rule_start")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !rule_start_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

<<<<<<< 50e0da97b4bfe492c7595f1363ff378d9028067a
  // CLASS|ENUM
=======
  // CLASS|INDEX|TYPE|CONST
>>>>>>> 44ffb72f7837a15c79487ff6d0cc87870a9bc0d5
  private static boolean rule_start_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rule_start_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CLASS);
<<<<<<< 50e0da97b4bfe492c7595f1363ff378d9028067a
    if (!r) r = consumeToken(b, ENUM);
=======
    if (!r) r = consumeToken(b, INDEX);
    if (!r) r = consumeToken(b, TYPE);
    if (!r) r = consumeToken(b, CONST);
>>>>>>> 44ffb72f7837a15c79487ff6d0cc87870a9bc0d5
    exit_section_(b, m, null, r);
    return r;
  }

}
