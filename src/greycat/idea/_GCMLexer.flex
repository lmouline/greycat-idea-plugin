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

LINE_COMMENT="//".*
BLOCK_COMMENT="/"\*([^]|\n)*\*"/"
NUMBER=[\-]?[0-9]+[.]?[0-9]*
IDENT=[a-zA-Z_][a-zA-Z_0-9]*
ANNOT_ID=[@][a-zA-Z_0-9]*
STRING=('([^'\\]|\\.)*'|\"([^\"\\]|\\.)*\")

%%
<YYINITIAL> {
  {WHITE_SPACE}        { return WHITE_SPACE; }

  "const"              { return CONST; }
  "type"               { return TYPE; }
  "using"              { return USING; }
  "index"              { return INDEX; }
  "class"              { return CLASS; }
  "att"                { return ATT; }
  "="                  { return EQUALS; }
  "ref"                { return REF; }
  "rel"                { return REL; }
  "import"             { return IMPORT; }
  "extends"            { return EXTENDS; }
  ","                  { return COMMA; }
  ":"                  { return COLON; }
  "{"                  { return BODY_OPEN; }
  "}"                  { return BODY_CLOSE; }
  "("                  { return POPEN; }
  ")"                  { return PCLOSE; }
  "."                  { return POINT; }
  "oppositeOf"         { return OPPOSITE_OF; }
  "<<EOF>>"            { return EOF; }
  "newline"            { return NEWLINE; }
  "CRLF"               { return CRLF; }

  {LINE_COMMENT}       { return LINE_COMMENT; }
  {BLOCK_COMMENT}      { return BLOCK_COMMENT; }
  {NUMBER}             { return NUMBER; }
  {IDENT}              { return IDENT; }
  {ANNOT_ID}           { return ANNOT_ID; }
  {STRING}             { return STRING; }

}

[^] { return BAD_CHARACTER; }
