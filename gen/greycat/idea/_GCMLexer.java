/* The following code was generated by JFlex 1.7.0-SNAPSHOT tweaked for IntelliJ platform */

package greycat.idea;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static greycat.idea.psi.GCMTypes.*;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.7.0-SNAPSHOT
 * from the specification file <tt>_GCMLexer.flex</tt>
 */
public class _GCMLexer implements FlexLexer {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   * Chosen bits are [7, 7, 7]
   * Total runtime size is 1928 bytes
   */
  public static int ZZ_CMAP(int ch) {
    return ZZ_CMAP_A[(ZZ_CMAP_Y[ZZ_CMAP_Z[ch>>14]|((ch>>7)&0x7f)]<<7)|(ch&0x7f)];
  }

  /* The ZZ_CMAP_Z table has 68 entries */
  static final char ZZ_CMAP_Z[] = zzUnpackCMap(
    "\1\0\103\200");

  /* The ZZ_CMAP_Y table has 256 entries */
  static final char ZZ_CMAP_Y[] = zzUnpackCMap(
    "\1\0\1\1\53\2\1\3\22\2\1\4\37\2\1\3\237\2");

  /* The ZZ_CMAP_A table has 640 entries */
  static final char ZZ_CMAP_A[] = zzUnpackCMap(
    "\11\0\1\2\4\1\22\0\1\17\1\0\1\12\4\0\1\10\1\43\1\44\1\7\1\0\1\37\1\4\1\6\1"+
    "\3\12\5\1\40\1\0\1\45\1\0\1\51\2\0\2\7\1\52\1\7\1\46\1\50\5\7\1\54\2\7\1\47"+
    "\2\7\1\53\10\7\1\34\1\11\1\35\1\0\1\7\1\0\1\27\1\25\1\31\1\23\1\21\2\7\1\16"+
    "\1\14\2\7\1\32\1\20\1\22\3\7\1\36\1\30\1\15\1\33\1\7\1\13\1\24\1\26\1\7\1"+
    "\41\1\0\1\42\7\0\1\1\32\0\1\2\337\0\1\2\177\0\13\2\35\0\2\1\5\0\1\2\57\0\1"+
    "\2\40\0");

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\1\1\1\3\1\4\1\5\1\3"+
    "\2\1\7\3\1\1\1\3\1\6\1\7\1\10\1\11"+
    "\1\12\1\13\1\1\2\3\1\14\1\4\1\0\1\15"+
    "\3\0\5\3\1\16\1\3\1\17\1\3\1\20\1\3"+
    "\1\0\7\3\1\21\1\3\1\22\1\0\1\3\1\23"+
    "\2\3\1\24\3\3\1\0\1\25\1\0\3\3\1\26"+
    "\2\0\3\3\2\0\1\27\1\30\1\31\1\32\2\0"+
    "\1\33\1\0\1\34";

  private static int [] zzUnpackAction() {
    int [] result = new int[89];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\55\0\132\0\207\0\264\0\341\0\u010e\0\u010e"+
    "\0\u013b\0\u0168\0\u0195\0\u01c2\0\u01ef\0\u021c\0\u0249\0\u0276"+
    "\0\u02a3\0\u02d0\0\u02fd\0\55\0\55\0\55\0\55\0\55"+
    "\0\55\0\u032a\0\u0357\0\u0384\0\u03b1\0\u03de\0\u013b\0\55"+
    "\0\u040b\0\u0168\0\u0438\0\u0465\0\u0492\0\u04bf\0\u04ec\0\u0519"+
    "\0\u010e\0\u0546\0\u010e\0\u0573\0\55\0\u05a0\0\u05cd\0\u05fa"+
    "\0\u0627\0\u0654\0\u0681\0\u06ae\0\u06db\0\u0708\0\u010e\0\u0735"+
    "\0\u010e\0\u0762\0\u078f\0\u010e\0\u07bc\0\u07e9\0\u010e\0\u0816"+
    "\0\u0843\0\u0870\0\u089d\0\u010e\0\u08ca\0\u08f7\0\u0924\0\u0951"+
    "\0\u010e\0\u097e\0\u09ab\0\u09d8\0\u0a05\0\u0a32\0\u0a5f\0\u0a8c"+
    "\0\u0ab9\0\u010e\0\u010e\0\55\0\u0ae6\0\u0b13\0\55\0\u0b40"+
    "\0\55";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[89];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\2\3\1\4\1\5\1\6\1\7\1\10\1\11"+
    "\1\2\1\12\1\13\1\14\2\10\1\3\1\10\1\15"+
    "\1\16\2\10\1\17\1\10\1\20\1\10\1\21\2\10"+
    "\1\22\1\2\1\23\1\24\1\25\1\26\1\27\1\30"+
    "\1\31\1\32\3\10\1\2\1\33\1\34\1\10\56\0"+
    "\2\3\14\0\1\3\40\0\1\35\55\0\1\10\1\6"+
    "\2\10\3\0\4\10\1\0\14\10\2\0\1\10\7\0"+
    "\3\10\1\0\3\10\4\0\1\10\1\6\1\36\1\10"+
    "\3\0\4\10\1\0\14\10\2\0\1\10\7\0\3\10"+
    "\1\0\3\10\4\0\4\10\3\0\4\10\1\0\14\10"+
    "\2\0\1\10\7\0\3\10\1\0\3\10\10\37\1\40"+
    "\1\41\43\37\11\42\1\43\1\40\42\42\4\0\4\10"+
    "\3\0\1\10\1\44\2\10\1\0\14\10\2\0\1\10"+
    "\7\0\3\10\1\0\3\10\4\0\4\10\3\0\4\10"+
    "\1\0\2\10\1\45\11\10\2\0\1\10\7\0\3\10"+
    "\1\0\3\10\4\0\4\10\3\0\4\10\1\0\2\10"+
    "\1\46\1\10\1\47\7\10\2\0\1\10\7\0\3\10"+
    "\1\0\3\10\4\0\4\10\3\0\4\10\1\0\1\10"+
    "\1\50\12\10\2\0\1\10\7\0\3\10\1\0\3\10"+
    "\4\0\4\10\3\0\4\10\1\0\6\10\1\51\5\10"+
    "\2\0\1\10\7\0\3\10\1\0\3\10\4\0\4\10"+
    "\3\0\2\10\1\52\1\10\1\0\10\10\1\53\3\10"+
    "\2\0\1\10\7\0\3\10\1\0\3\10\4\0\4\10"+
    "\3\0\4\10\1\0\12\10\1\54\1\10\2\0\1\10"+
    "\7\0\3\10\1\0\3\10\35\0\1\55\23\0\4\10"+
    "\3\0\4\10\1\0\1\10\1\56\12\10\2\0\1\10"+
    "\7\0\3\10\1\0\3\10\45\0\1\57\13\0\4\10"+
    "\3\0\4\10\1\0\14\10\2\0\1\10\7\0\3\10"+
    "\1\0\1\10\1\60\1\10\4\0\4\10\3\0\4\10"+
    "\1\0\14\10\2\0\1\10\7\0\1\61\2\10\1\0"+
    "\3\10\1\35\1\0\53\35\4\0\1\10\1\36\2\10"+
    "\3\0\4\10\1\0\14\10\2\0\1\10\7\0\3\10"+
    "\1\0\3\10\1\37\1\0\53\37\1\42\1\0\53\42"+
    "\4\0\4\10\3\0\2\10\1\62\1\10\1\0\14\10"+
    "\2\0\1\10\7\0\3\10\1\0\3\10\4\0\4\10"+
    "\3\0\4\10\1\0\3\10\1\63\10\10\2\0\1\10"+
    "\7\0\3\10\1\0\3\10\4\0\4\10\3\0\4\10"+
    "\1\0\13\10\1\64\2\0\1\10\7\0\3\10\1\0"+
    "\3\10\4\0\4\10\3\0\2\10\1\65\1\10\1\0"+
    "\14\10\2\0\1\10\7\0\3\10\1\0\3\10\4\0"+
    "\4\10\3\0\1\66\3\10\1\0\14\10\2\0\1\10"+
    "\7\0\3\10\1\0\3\10\4\0\4\10\3\0\2\10"+
    "\1\67\1\10\1\0\14\10\2\0\1\10\7\0\3\10"+
    "\1\0\3\10\4\0\4\10\3\0\4\10\1\0\7\10"+
    "\1\70\4\10\2\0\1\10\7\0\3\10\1\0\3\10"+
    "\4\0\4\10\3\0\4\10\1\0\12\10\1\71\1\10"+
    "\2\0\1\10\7\0\3\10\1\0\3\10\46\0\1\72"+
    "\12\0\4\10\3\0\4\10\1\0\14\10\2\0\1\10"+
    "\7\0\3\10\1\0\2\10\1\73\4\0\4\10\3\0"+
    "\4\10\1\0\14\10\2\0\1\10\7\0\3\10\1\0"+
    "\2\10\1\74\4\0\4\10\3\0\3\10\1\75\1\0"+
    "\14\10\2\0\1\10\7\0\3\10\1\0\3\10\4\0"+
    "\4\10\3\0\4\10\1\0\1\10\1\76\12\10\2\0"+
    "\1\10\7\0\3\10\1\0\3\10\4\0\4\10\3\0"+
    "\4\10\1\0\1\77\13\10\2\0\1\10\7\0\3\10"+
    "\1\0\3\10\4\0\4\10\3\0\4\10\1\0\1\10"+
    "\1\100\12\10\2\0\1\10\7\0\3\10\1\0\3\10"+
    "\4\0\4\10\3\0\4\10\1\0\12\10\1\101\1\10"+
    "\2\0\1\10\7\0\3\10\1\0\3\10\4\0\4\10"+
    "\3\0\4\10\1\0\10\10\1\102\3\10\2\0\1\10"+
    "\7\0\3\10\1\0\3\10\47\0\1\103\11\0\4\10"+
    "\3\0\4\10\1\0\14\10\2\0\1\10\7\0\2\10"+
    "\1\104\1\0\3\10\4\0\4\10\3\0\4\10\1\105"+
    "\14\10\2\0\1\10\7\0\3\10\1\0\3\10\4\0"+
    "\4\10\3\0\4\10\1\0\4\10\1\106\7\10\2\0"+
    "\1\10\7\0\3\10\1\0\3\10\4\0\4\10\3\0"+
    "\4\10\1\0\2\10\1\107\11\10\2\0\1\10\7\0"+
    "\3\10\1\0\3\10\4\0\4\10\3\0\1\10\1\110"+
    "\2\10\1\0\14\10\2\0\1\10\7\0\3\10\1\0"+
    "\3\10\4\0\4\10\3\0\4\10\1\0\10\10\1\111"+
    "\3\10\2\0\1\10\7\0\3\10\1\0\3\10\50\0"+
    "\1\112\21\0\1\113\43\0\4\10\3\0\4\10\1\0"+
    "\1\10\1\114\12\10\2\0\1\10\7\0\3\10\1\0"+
    "\3\10\4\0\4\10\3\0\4\10\1\0\3\10\1\115"+
    "\10\10\2\0\1\10\7\0\3\10\1\0\3\10\4\0"+
    "\4\10\3\0\4\10\1\0\2\10\1\116\11\10\2\0"+
    "\1\10\7\0\3\10\1\0\3\10\51\0\1\117\17\0"+
    "\1\120\44\0\4\10\3\0\4\10\1\0\3\10\1\121"+
    "\10\10\2\0\1\10\7\0\3\10\1\0\3\10\4\0"+
    "\4\10\3\0\4\10\1\0\10\10\1\122\3\10\2\0"+
    "\1\10\7\0\3\10\1\0\3\10\4\0\4\10\3\0"+
    "\4\10\1\0\1\10\1\123\12\10\2\0\1\10\7\0"+
    "\3\10\1\0\3\10\51\0\1\124\23\0\1\125\40\0"+
    "\4\10\3\0\4\10\1\126\14\10\2\0\1\10\7\0"+
    "\3\10\1\0\3\10\21\0\1\127\60\0\1\130\55\0"+
    "\1\131\26\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[2925];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String[] ZZ_ERROR_MSG = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\21\1\6\11\5\1\1\0\1\11\3\0"+
    "\11\1\1\11\1\1\1\0\12\1\1\0\10\1\1\0"+
    "\1\1\1\0\4\1\2\0\3\1\2\0\3\1\1\11"+
    "\2\0\1\11\1\0\1\11";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[89];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private CharSequence zzBuffer = "";

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /**
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
  public _GCMLexer() {
    this((java.io.Reader)null);
  }


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public _GCMLexer(java.io.Reader in) {
    this.zzReader = in;
  }


  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    int size = 0;
    for (int i = 0, length = packed.length(); i < length; i += 2) {
      size += packed.charAt(i);
    }
    char[] map = new char[size];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < packed.length()) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }

  public final int getTokenStart() {
    return zzStartRead;
  }

  public final int getTokenEnd() {
    return getTokenStart() + yylength();
  }

  public void reset(CharSequence buffer, int start, int end, int initialState) {
    zzBuffer = buffer;
    zzCurrentPos = zzMarkedPos = zzStartRead = start;
    zzAtEOF  = false;
    zzAtBOL = true;
    zzEndRead = end;
    yybegin(initialState);
  }

  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   *
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {
    return true;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final CharSequence yytext() {
    return zzBuffer.subSequence(zzStartRead, zzMarkedPos);
  }


  /**
   * Returns the character at position <tt>pos</tt> from the
   * matched text.
   *
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch.
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer.charAt(zzStartRead+pos);
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of
   * yypushback(int) and a match-all fallback rule) this method
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public IElementType advance() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    CharSequence zzBufferL = zzBuffer;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL/*, zzEndReadL*/);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL/*, zzEndReadL*/);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + ZZ_CMAP(zzInput) ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
        return null;
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1: 
            { return BAD_CHARACTER;
            }
          case 29: break;
          case 2: 
            { return WHITE_SPACE;
            }
          case 30: break;
          case 3: 
            { return IDENT;
            }
          case 31: break;
          case 4: 
            { return NUMBER;
            }
          case 32: break;
          case 5: 
            { return MULT_SEP;
            }
          case 33: break;
          case 6: 
            { return COMMA;
            }
          case 34: break;
          case 7: 
            { return COLON;
            }
          case 35: break;
          case 8: 
            { return BODY_OPEN;
            }
          case 36: break;
          case 9: 
            { return BODY_CLOSE;
            }
          case 37: break;
          case 10: 
            { return ANNOT_PARAM_OPEN;
            }
          case 38: break;
          case 11: 
            { return ANNOT_PARAM_CLOSE;
            }
          case 39: break;
          case 12: 
            { return COMMENT;
            }
          case 40: break;
          case 13: 
            { return STRING;
            }
          case 41: break;
          case 14: 
            { return BY;
            }
          case 42: break;
          case 15: 
            { return AS;
            }
          case 43: break;
          case 16: 
            { return ARRAY;
            }
          case 44: break;
          case 17: 
            { return ATT;
            }
          case 45: break;
          case 18: 
            { return REF;
            }
          case 46: break;
          case 19: 
            { return REL;
            }
          case 47: break;
          case 20: 
            { return ENUM;
            }
          case 48: break;
          case 21: 
            { return CRLF;
            }
          case 49: break;
          case 22: 
            { return CLASS;
            }
          case 50: break;
          case 23: 
            { return INDEXED;
            }
          case 51: break;
          case 24: 
            { return EXTENDS;
            }
          case 52: break;
          case 25: 
            { return NEWLINE;
            }
          case 53: break;
          case 26: 
            { return EOF;
            }
          case 54: break;
          case 27: 
            { return WITH_TIME;
            }
          case 55: break;
          case 28: 
            { return INDEXED_BY;
            }
          case 56: break;
          default:
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
