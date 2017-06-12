package greycat.idea;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static greycat.idea.psi.GCMTypes.*;

%%

%{
  public _GCMLexer() {
    this((java.io.Reader)null);
  }
%}

%public
%class _GCMLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

EOL=\R
WHITE_SPACE=\s+

COMMENT="//".*
NUMBER=[\-]?[0-9]+[.]?[0-9]*
IDENT=[\*\.a-zA-Z0-9_\-]+
STRING=('([^'\\]|\\.)*'|\"([^\"\\]|\\.)*\")

%%
<YYINITIAL> {
  {WHITE_SPACE}        { return WHITE_SPACE; }

  "key with time"      { return KEY_WITH_TIME; }
  "key"                { return KEY; }
  "as"                 { return AS; }
  "class"              { return CLASS; }
  "enum"               { return ENUM; }
  "att"                { return ATT; }
  "[]"                 { return ARRAY; }
  "ref"                { return REF; }
  "rel"                { return REL; }
  "extends"            { return EXTENDS; }
  ","                  { return COMMA; }
  ":"                  { return COLON; }
  "{"                  { return BODY_OPEN; }
  "}"                  { return BODY_CLOSE; }
  "("                  { return ANNOT_PARAM_OPEN; }
  ")"                  { return ANNOT_PARAM_CLOSE; }
  "."                  { return MULT_SEP; }
  "<<EOF>>"            { return EOF; }
  "newline"            { return NEWLINE; }
  "CRLF"               { return CRLF; }
  "INDEXED_BY"         { return INDEXED_BY; }

  {COMMENT}            { return COMMENT; }
  {NUMBER}             { return NUMBER; }
  {IDENT}              { return IDENT; }
  {STRING}             { return STRING; }

}

[^] { return BAD_CHARACTER; }
