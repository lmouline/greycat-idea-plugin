package greycat.idea;

import com.intellij.formatting.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.TokenType;
import com.intellij.psi.formatter.common.AbstractBlock;
import com.intellij.psi.tree.IElementType;
import greycat.idea.psi.GCMTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class GCMBlock extends AbstractBlock {

    public GCMBlock(@NotNull ASTNode astNode, @Nullable Alignment alignment, @Nullable Wrap wrap) {
        super(astNode, wrap, alignment);
    }

    @Override
    protected List<Block> buildChildren() {
        List<Block> blocks = new ArrayList<Block>();
        Alignment innerBodyAlignment = Alignment.createAlignment();
        ASTNode child = getNode().getFirstChildNode();
        while (child != null) {
            if (child.getElementType() != TokenType.WHITE_SPACE) {
                if (child.getElementType() == GCMTypes.PROP) {
                    blocks.add(new GCMBlock(child, innerBodyAlignment, getWrap()));
                } else {
                    blocks.add(new GCMBlock(child, getAlignment(), getWrap()));
                }
            }
            child = child.getTreeNext();
        }
        return blocks;
    }

    @Override
    public Indent getIndent() {
        if (getNode().getElementType() == GCMTypes.PROP) {
            return Indent.getNormalIndent();
        }
        return super.getIndent();
    }

    @Nullable
    @Override
    public Spacing getSpacing(Block child1, @NotNull Block child2) {
        if (child1 != null) {
            IElementType type1 = ((AbstractBlock) child1).getNode().getElementType();
            IElementType type2 = ((AbstractBlock) child2).getNode().getElementType();
            if (type1 == GCMTypes.DECLARATION) {
                return Spacing.createSpacing(1, 1, 2, false, 1);
            }

            if (type1 == GCMTypes.CLASS || type1 == GCMTypes.ATT || type1 == GCMTypes.REF || type1 == GCMTypes.REL || type1 == GCMTypes.INDEX || type1 == GCMTypes.TYPE || type1 == GCMTypes.CONST) {
                return singleSpace();
            }
            if (type1 == GCMTypes.COLON || type2 == GCMTypes.COLON || type1 == GCMTypes.COMMA || type1 == GCMTypes.EQUALS || type2 == GCMTypes.EQUALS || type2 == GCMTypes.BODY_OPEN || type1 == GCMTypes.USING || type2 == GCMTypes.USING || type1 == GCMTypes.OPPOSITE_OF || type2 == GCMTypes.OPPOSITE_OF) {
                return singleSpace();
            }
            if (type1 == GCMTypes.POPEN || type2 == GCMTypes.PCLOSE || type1 == GCMTypes.POINT || type2 == GCMTypes.POINT || type2 == GCMTypes.ACTION_PARAMS || type2 == GCMTypes.COMMA) {
                return noSpace();
            }
            
            //attribute are always indented
            /*
            if (type2 == GCMTypes.PROP) {
                if (type1 == GCMTypes.PROP) {
                    return newLine();
                } else {
                    return Spacing.createSpacing(1, 1, 2, false, 1);
                }
            }*/

            if (type1 == GCMTypes.TYPE_DECLARATION) {
                if (type2 == GCMTypes.BODY_OPEN) {
                    return singleSpace();
                }
            }
            //default rules
            if (type1 == GCMTypes.BODY_OPEN || type2 == GCMTypes.BODY_CLOSE) {
                ASTNode parent = (((AbstractBlock) child1).getNode()).getTreeParent();
                if (parent != null) {
                    if (parent.getElementType() == GCMTypes.SUB_TASK) {
                        return singleSpace();
                    }
                }
                return newLine();
            }
            if (type1 == GCMTypes.PROP && type2 == GCMTypes.PROP) {
                return newLine();
            }
            if (type1 == GCMTypes.ANNOTATION && type2 == GCMTypes.PROP) {
                return newLine();
            }
            if (type2 == GCMTypes.ANNOTATION && type1 == GCMTypes.PROP) {
                return newLine();
            }
            //other rules
            if (type1 == GCMTypes.LINE_COMMENT) {
                return Spacing.createSpacing(1, 1, 2, false, 1);
                //return newLine();
            }
            if (type1 == GCMTypes.BLOCK_COMMENT) {
                return Spacing.createSpacing(1, 1, 2, false, 1);
                //return newLine();
            }

            /*
            if (type1 == MetaModelTypes.DECLARATION && type2 == MetaModelTypes.COMMENT) {
                return newLine();
            }
            if (type1 == MetaModelTypes.COMMENT && type2 == MetaModelTypes.DECLARATION) {
                return newLine();
            }
            if (type1 == MetaModelTypes.COMMENT && type2 == MetaModelTypes.COMMENT) {
                return newLine();
            }
            if (type1 == MetaModelTypes.COMMENT || type2 != MetaModelTypes.COMMENT) {
                return newLine();
            }

            if (type1 == MetaModelTypes.BODY_OPEN) {
                return Spacing.createSpacing(1, 1, 1, false, 1);
            }
            if (type1 == MetaModelTypes.BODY_CLOSE) {
                return Spacing.createSpacing(1, 1, 1, false, 1);
            }

            if (type2 == MetaModelTypes.BODY_CLOSE) {
                return newLine();
            }

            if (type1 == MetaModelTypes.RELATION_DECLARATION && type2 == MetaModelTypes.RELATION_DECLARATION) {
                return Spacing.createSpacing(1, 1, 1, false, 1);
            }
            if (type1 == MetaModelTypes.CLASS_ELEM_DECLARATION && type2 == MetaModelTypes.CLASS_ELEM_DECLARATION) {
                return Spacing.createSpacing(1, 1, 1, false, 1);
            }
            if (type1 == MetaModelTypes.DECLARATION && type2 == MetaModelTypes.DECLARATION) {
                return Spacing.createSpacing(1, 1, 2, false, 1);
            }*/


/*
            if (type1 == MetaModelTypes.WITH && type2 == MetaModelTypes.IDENT) {
                return singleSpace();
            }
            if (type1 == MetaModelTypes.CLASS && type2 == MetaModelTypes.TYPE_DECLARATION) {
                return singleSpace();
            }
            if (type1 == MetaModelTypes.EXTENDS && type2 == MetaModelTypes.TYPE_DECLARATION) {
                return singleSpace();
            }
            if (type1 == MetaModelTypes.FUNC && type2 == MetaModelTypes.OPERATION_NAME) {
                return singleSpace();
            }
            if (type1 == MetaModelTypes.ENUM && type2 == MetaModelTypes.TYPE_DECLARATION) {
                return singleSpace();
            }
            if (type1 == MetaModelTypes.TYPE_DECLARATION && type2 == MetaModelTypes.PARENTS_DECLARATION) {
                return singleSpace();
            }
            if (type1 == MetaModelTypes.OPERATION_NAME && type2 == MetaModelTypes.OPERATION_RETURN) {
                return singleSpace();
            }
            if (type1 == MetaModelTypes.COLON && type2 == MetaModelTypes.TYPE_DECLARATION) {
                return singleSpace();
            }
            if (type1 == MetaModelTypes.ATT && type2 == MetaModelTypes.ATTRIBUTE_NAME) {
                return singleSpace();
            }
            if (type1 == MetaModelTypes.REF && type2 == MetaModelTypes.RELATION_NAME) {
                return singleSpace();
            }
            if (type1 == MetaModelTypes.MREF && type2 == MetaModelTypes.RELATION_NAME) {
                return singleSpace();
            }
            if (type1 == MetaModelTypes.ATTRIBUTE_NAME && type2 == MetaModelTypes.COLON) {
                return singleSpace();
            }
            if (type1 == MetaModelTypes.TYPE_DECLARATION && type2 == MetaModelTypes.BODY_OPEN) {
                return singleSpace();
            }
            if (type1 == MetaModelTypes.PARENTS_DECLARATION && type2 == MetaModelTypes.BODY_OPEN) {
                return singleSpace();
            }
            if (type1 == MetaModelTypes.RELATION_NAME && type2 == MetaModelTypes.COLON) {
                return singleSpace();
            }
            if (type1 == MetaModelTypes.FROM && type2 == MetaModelTypes.STRING) {
                return singleSpace();
            }

            if (type1 == MetaModelTypes.RELATION_DECLARATION && type2 == MetaModelTypes.BODY_CLOSE) {
                return newLine();
            }
            */

            /*
            if (type1 == MetaModelTypes.ENUM_ELEM_DECLARATION && type2 == MetaModelTypes.BODY_CLOSE) {
                return newLine();
            }
            if (type1 == MetaModelTypes.CLASS_ELEM_DECLARATION && type2 == MetaModelTypes.BODY_CLOSE) {
                return newLine();
            }
            if (type1 == MetaModelTypes.ENUM_ELEM_DECLARATION && type2 == MetaModelTypes.ENUM_ELEM_DECLARATION) {
                return newLine();
            }
            if (type1 == MetaModelTypes.INPUT && type2 == MetaModelTypes.INPUT_NAME) {
                return singleSpace();
            }
            if (type1 == MetaModelTypes.INPUT_NAME && type2 == MetaModelTypes.STRING) {
                return singleSpace();
            }
            if (type1 == MetaModelTypes.OUTPUT && type2 == MetaModelTypes.OUTPUT_NAME) {
                return singleSpace();
            }
            if (type1 == MetaModelTypes.OUTPUT_NAME && type2 == MetaModelTypes.COLON) {
                return singleSpace();
            }
            if (type1 == MetaModelTypes.DEPENDENCY && type2 == MetaModelTypes.DEPENDENCY_NAME) {
                return singleSpace();
            }
            if (type1 == MetaModelTypes.DEPENDENCY_NAME && type2 == MetaModelTypes.COLON) {
                return singleSpace();
            }
            if (type1 == MetaModelTypes.ANNOT_PARAM_OPEN && type2 == MetaModelTypes.NUMBER) {
                return noSpace();
            }
            if (type1 == MetaModelTypes.NUMBER && type2 == MetaModelTypes.ANNOT_PARAM_CLOSE) {
                return noSpace();
            }
            if (type1 == MetaModelTypes.OPERATION_NAME && type2 == MetaModelTypes.ANNOT_PARAM_OPEN) {
                return noSpace();
            }
            if (type1 == MetaModelTypes.ANNOT_PARAM_OPEN && type2 == MetaModelTypes.OPERATION_PARAMS) {
                return noSpace();
            }
            if (type1 == MetaModelTypes.OPERATION_PARAM && type2 == MetaModelTypes.COMMA) {
                return noSpace();
            }
            if (type1 == MetaModelTypes.COMMA && type2 == MetaModelTypes.OPERATION_PARAM) {
                return singleSpace();
            }
            if (type1 == MetaModelTypes.OPERATION_PARAMS && type2 == MetaModelTypes.ANNOT_PARAM_CLOSE) {
                return noSpace();
            }
            if (type1 == MetaModelTypes.ANNOT_PARAM_CLOSE && type2 == MetaModelTypes.OPERATION_RETURN) {
                return singleSpace();
            }
            */
            /*
            if (type1 == MetaModelTypes.IDENT) {
                return singleSpace();
            }*/
            /*
            if (type1 == MetaModelTypes.BODY_OPEN) {
                return Spacing.createSpacing(1, 1, 1, false, 1);
            }
            if (type1 == MetaModelTypes.BODY_CLOSE) {
                return Spacing.createSpacing(1, 1, 1, false, 1);
            }
            if (type1 == TokenType.ERROR_ELEMENT || type2 == TokenType.ERROR_ELEMENT || type1 == GeneratedParserUtilBase.DUMMY_BLOCK || type2 == GeneratedParserUtilBase.DUMMY_BLOCK) {
                return singleSpace();
            }
            if (type1 != MetaModelTypes.COMMENT || type2 == MetaModelTypes.COMMENT) {
                return singleSpace();
            }*/
            System.out.println("Formatting Warning. Spacing unspecified between t1:" + type1 + " type2:" + type2);
        }
        return singleSpace();
    }

    private Spacing noSpace() {
        return Spacing.createSpacing(0, 0, 0, false, 0);
    }

    private Spacing newLine() {
        return Spacing.createSpacing(1, 1, 1, false, 0);
    }

    private Spacing singleSpace() {
        return Spacing.createSpacing(1, 1, 0, false, 0);
    }

    @Override
    public boolean isLeaf() {
        return myNode.getFirstChildNode() == null;
    }
}
