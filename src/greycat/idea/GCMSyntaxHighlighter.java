package greycat.idea;

import com.intellij.lexer.FlexAdapter;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.editor.markup.TextAttributes;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import com.intellij.ui.JBColor;
import greycat.idea.psi.GCMTypes;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.Arrays;
import java.util.HashSet;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;
import static greycat.idea.psi.GCMTypes.*;

public class GCMSyntaxHighlighter extends SyntaxHighlighterBase {

    public static final TextAttributesKey KEYWORD = createTextAttributesKey("GC_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey STRING = createTextAttributesKey("GC_STRING", DefaultLanguageHighlighterColors.STRING);
    public static final TextAttributesKey SEPARATOR = createTextAttributesKey("GC_SEPARATOR", DefaultLanguageHighlighterColors.INSTANCE_FIELD);
    public static final TextAttributesKey COMMENT = createTextAttributesKey("GC_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
    public static final TextAttributesKey IDENT = createTextAttributesKey("GC_IDENT", DefaultLanguageHighlighterColors.STATIC_METHOD);
    public static final TextAttributesKey NUMBER = createTextAttributesKey("GC_NUMBER", DefaultLanguageHighlighterColors.NUMBER);
    public static final TextAttributesKey ANNOTATION = createTextAttributesKey("GC_ANNOTATION", DefaultLanguageHighlighterColors.METADATA);
    public static final TextAttributesKey BAD_CHARACTER = createTextAttributesKey("GC_BAD_CHARACTER", new TextAttributes(JBColor.RED, null, null, null, Font.BOLD));

    private static final TextAttributesKey[] BAD_CHAR_KEYS = new TextAttributesKey[]{BAD_CHARACTER};
    private static final TextAttributesKey[] KEYWORD_KEYS = new TextAttributesKey[]{KEYWORD};

    private static final TextAttributesKey[] IDENT_KEYS = new TextAttributesKey[]{IDENT};
    private static final TextAttributesKey[] NUMBER_KEYS = new TextAttributesKey[]{NUMBER};

    private static final TextAttributesKey[] STRING_KEYS = new TextAttributesKey[]{STRING};
    private static final TextAttributesKey[] COMMENT_KEYS = new TextAttributesKey[]{COMMENT};
    private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];
    private static final TextAttributesKey[] SEPARATOR_KEYS = new TextAttributesKey[]{SEPARATOR};

    private static final HashSet<IElementType> KEYWORD_SET = new HashSet<IElementType>(Arrays.asList(CONST, CLASS, INDEX, TYPE, USING, IMPORT, ATT, REL, REF, EXTENDS, OPPOSITE_OF));
    private static final HashSet<IElementType> SEPARATOR_SET = new HashSet<IElementType>(Arrays.asList(COLON, COMMA, BODY_OPEN, BODY_CLOSE, POINT, POPEN, PCLOSE, EQUALS));

    private static final TextAttributesKey[] ANNOTATION_KEYS = new TextAttributesKey[]{ANNOTATION};


    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new FlexAdapter(new _GCMLexer());
    }

    @NotNull
    @Override
    public final TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
        /* Entities OPERATIONS */
        if (KEYWORD_SET.contains(tokenType)) {
            return KEYWORD_KEYS;
        }
        if (SEPARATOR_SET.contains(tokenType)) {
            return SEPARATOR_KEYS;
        }
        /* Basic elem */

        if (tokenType.equals(GCMTypes.ANNOTATION)) {
            return ANNOTATION_KEYS;
        }
        if (tokenType.equals(GCMTypes.IDENT)) {
            return IDENT_KEYS;
        }
        if (tokenType.equals(GCMTypes.NUMBER)) {
            return NUMBER_KEYS;
        }
        if (tokenType.equals(GCMTypes.LINE_COMMENT) | tokenType.equals(GCMTypes.BLOCK_COMMENT)) {
            return COMMENT_KEYS;
        }
        if (tokenType.equals(GCMTypes.STRING)) {
            return STRING_KEYS;
        }
        if (tokenType.equals(TokenType.BAD_CHARACTER)) {
            return BAD_CHAR_KEYS;
        }
        return EMPTY_KEYS;

    }

}
