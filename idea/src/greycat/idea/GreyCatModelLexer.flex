/**
 * Copyright 2017 The GreyCat Authors.  All rights reserved.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package greycat.idea;
import com.intellij.lexer.*;
import com.intellij.psi.tree.IElementType;
import static greycat.idea.psi.GreyCatModelTypes.*;

%%

%{
  public _GreyCatModelLexer() {
    this((java.io.Reader)null);
  }
%}

%public
%class _GreyCatModelLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

EOL="\r"|"\n"|"\r\n"
LINE_WS=[\ \t\f]
WHITE_SPACE=({LINE_WS}|{EOL})+

NEWLINE=\n\t
COMMENT="//".*
NUMBER=[0-9\-]+
IDENT=[\*\.a-zA-Z0-9_\-]+
STRING=('([^'\\]|\\.)*'|\"([^\"\\]|\\.)*\")

%%
<YYINITIAL> {
  {WHITE_SPACE}      { return com.intellij.psi.TokenType.WHITE_SPACE; }

  "class"            { return CLASS; }
  ":"                { return COLON; }
  ","                { return COMMA; }
  "/"                { return SUB; }
  "="                { return EQ; }
  "@id"              { return ID_ANNOT; }
  "@contained"       { return CONT_ANNOT; }
  "["                { return MULT_OPEN; }
  "{"                { return BODY_OPEN; }
  "]"                { return MULT_CLOSE; }
  "}"                { return BODY_CLOSE; }
  "."                { return MULT_SEP; }
  "*"                { return STAR; }
  "<<EOF>>"          { return EOF; }
  "CRLF"             { return CRLF; }

  {NEWLINE}          { return NEWLINE; }
  {COMMENT}          { return COMMENT; }
  {NUMBER}           { return NUMBER; }
  {IDENT}            { return IDENT; }
  {STRING}           { return STRING; }

  [^] { return com.intellij.psi.TokenType.BAD_CHARACTER; }
}
