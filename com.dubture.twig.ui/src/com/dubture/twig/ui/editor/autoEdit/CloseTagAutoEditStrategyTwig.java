/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 * 
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.ui.editor.autoEdit;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.DocumentCommand;
import org.eclipse.jface.text.IAutoEditStrategy;
import org.eclipse.jface.text.IDocument;
import org.eclipse.php.internal.core.documentModel.parser.PHPRegionContext;
import org.eclipse.php.internal.core.documentModel.parser.regions.PHPRegionTypes;
import org.eclipse.php.internal.ui.text.PHPDocumentRegionEdgeMatcher;
import org.eclipse.wst.sse.core.StructuredModelManager;
import org.eclipse.wst.sse.core.internal.provisional.IStructuredModel;
import org.eclipse.wst.sse.core.internal.provisional.text.IStructuredDocument;
import org.eclipse.wst.sse.core.internal.provisional.text.IStructuredDocumentRegion;
import org.eclipse.wst.sse.core.internal.provisional.text.ITextRegion;
import org.eclipse.wst.sse.core.internal.provisional.text.ITextRegionContainer;
import org.eclipse.wst.xml.core.internal.parser.regions.XMLContentRegion;
import org.eclipse.wst.xml.core.internal.provisional.document.IDOMNode;
import org.eclipse.wst.xml.core.internal.regions.DOMRegionContext;

import com.dubture.twig.core.TwigCorePlugin;
import com.dubture.twig.core.documentModel.parser.TwigRegionContext;
import com.dubture.twig.core.documentModel.parser.partitioner.TwigPartitionTypes;
import com.dubture.twig.core.documentModel.parser.regions.ITwigScriptRegion;
import com.dubture.twig.core.documentModel.parser.regions.TwigRegionTypes;
import com.dubture.twig.core.format.FormatterUtils;
import com.dubture.twig.core.log.Logger;
import com.dubture.twig.ui.TwigUICorePlugin;
import com.dubture.twig.ui.preferences.PreferenceConstants;

/**
 * 
 * Strategy for auto-closing twig tags.
 * 
 * 
 * 
 * @author Robert Gruendler <r.gruendler@gmail.com>
 * 
 */
@SuppressWarnings("restriction")
public class CloseTagAutoEditStrategyTwig implements IAutoEditStrategy
{

    protected static final char CURLY_OPEN = '{';
    protected static final char CURLY_CLOSE = '}';
    protected static final char ROUND_OPEN = '(';
    protected static final char ROUND_CLOSE = ')';
    protected static final char SQUARE_OPEN = '[';
    protected static final char SQUARE_CLOSE = ']';
    protected static final char SINGLE_QOUTE = '\'';
    protected static final char DOUBLE_QOUTES = '\"';
    protected static final char BACK_QOUTE = '`';
    protected static final char BACK_SLASH = '\\';

    protected static PHPDocumentRegionEdgeMatcher matcher = new PHPDocumentRegionEdgeMatcher();

    protected static final int SEARCH_NOT_VALID = -1;
    protected static final int MATCHING_BRACKET_NEEDED = 0;
    protected static final int MATCHING_BRACKET_NOT_NEEDED = 1;

    private IDocument document;
    private DocumentCommand command;

    @Override
    public void customizeDocumentCommand(IDocument doc, DocumentCommand comm)
    {

        document = doc;
        command = comm;

        IStructuredModel model = null;
        try {
            model = StructuredModelManager.getModelManager()
                    .getExistingModelForRead(document);

            if (model != null) {
                if (command.text != null) {

                    int length = command.text.length();
                    if (length == 0 && command.length == 1) {

                        char removedChar = document.getChar(command.offset);
                        if (removedChar == ROUND_OPEN
                                || removedChar == SQUARE_OPEN
                                || removedChar == CURLY_OPEN) {

                            deletePairBreaket((IStructuredDocument) document,
                                    command, removedChar);
                        }
                    }

                    if (length == 1) {

                        IDOMNode node = (IDOMNode) model
                                .getIndexedRegion(command.offset - 1);

                        if (command.text.equals("%")) {

                            if (prefixedWith(document, command.offset, "{")) {
                                autoCloseStatementTag(node);
                            } else if (prefixedWith(document, command.offset,
                                    " ")) {
                                autoCreateStatementTag(node);
                            }

                        } else if (command.text.equals("{")) {

                            autoClosePrintTag(node);
                        }
                    }
                }
            }
        } catch (BadLocationException e) {
            TwigCorePlugin.log(e);
        } finally {
            if (model != null)
                model.releaseFromRead();
        }
    }

    /**
     * Automatically create a twig statement tag and insert the cursor in the
     * middle.
     * 
     * <pre>
     * 
     *   {% | %}
     * </pre>
     * 
     */
    private boolean autoCreateStatementTag(IDOMNode node)
    {

        IPreferenceStore store = TwigUICorePlugin.getDefault()
                .getPreferenceStore();
        boolean autocreate = store
                .getBoolean(PreferenceConstants.AUTOCREATE_STATEMENT_TAGS);

        if (autocreate == false || node == null)
            return true;

        command.text = "{%  %}"; //$NON-NLS-1$
        command.shiftsCaret = false;
        command.caretOffset = command.offset + 3;
        command.doit = false;

        return true;

    }

    /**
     * Automatically close an open twig statement tag and insert the cursor in
     * the middle.
     * 
     * <pre>
     * 
     * 	 {|   <-- type "%" and get
     * 
     *   {% | %}
     * 
     * </pre>
     * 
     */
    private boolean autoCloseStatementTag(IDOMNode node)
    {

        IPreferenceStore store = TwigUICorePlugin.getDefault()
                .getPreferenceStore();
        boolean autoclose = store
                .getBoolean(PreferenceConstants.AUTOCLOSE_STATEMENT_TAGS);

        if (autoclose == false || node == null)
            return true;

        //		command.text += "%"; //$NON-NLS-1$
        // command.shiftsCaret = false;
        // command.caretOffset = command.offset + 1;
        // command.doit = false;

        command.text += "  %"; //$NON-NLS-1$
        command.shiftsCaret = false;
        command.caretOffset = command.offset + 2;
        command.doit = false;

        return true;

    }

    /**
     * Automatically close an open twig print tag and insert the cursor in the
     * middle.
     * 
     * <pre>
     * 
     * 	 {|   <-- type "{" and get
     * 
     *   {{ | }}
     * 
     * </pre>
     * 
     */
    private void autoClosePrintTag(IDOMNode node)
    {

        IPreferenceStore store = TwigUICorePlugin.getDefault()
                .getPreferenceStore();
        boolean autoclose = store
                .getBoolean(PreferenceConstants.AUTOCLOSE_PRINT_TAGS);

        if (autoclose == false)
            return;

        String append = "}"; //$NON-NLS-1$
        int caretOffset = 1;

        if (node != null) {

            if (prefixedWith(document, command.offset, "{")) {
                append = "  }";
                caretOffset = 2;
            }

            command.text += append;
            command.shiftsCaret = false;
            command.caretOffset = command.offset + caretOffset;
            command.doit = false;

            // empty document
        } else {
            command.text += append;
            command.shiftsCaret = false;
            command.caretOffset = command.offset + caretOffset;
            command.doit = false;

        }
    }

    private boolean prefixedWith(IDocument document, int offset, String string)
    {

        try {

            boolean larger = document.getLength() >= string.length();
            String prefix = document.get(offset - string.length(),
                    string.length());

            // we're at the beginning of the line and checking for whitespace
            if (prefix.length() == 0 && string.equals(" "))
                return true;

            return larger && prefix.equals(string);

        } catch (Exception e) {

            return false;
        }
    }

    private void deletePairBreaket(IStructuredDocument document,
            DocumentCommand command, char deletedChar)
    {

        int offset = command.offset;
        IStructuredDocumentRegion sdRegion = document
                .getRegionAtCharacterOffset(offset);

        if (sdRegion == null
                || sdRegion.getType() != DOMRegionContext.XML_CONTENT) {
            return;
        }
        try {
            ITextRegion tRegion = sdRegion.getRegionAtCharacterOffset(offset);

            if (tRegion instanceof XMLContentRegion) {

                char nextChar = document.getChar(offset + 1);
                char matchingChar = getMatchingChar(deletedChar);

                if (nextChar == '}' && nextChar == matchingChar) {
                    command.length = 2;
                }

            }
        } catch (BadLocationException e) {
        }
    }

    protected static char getMatchingChar(final char c)
    {
        switch (c) {
            case CURLY_OPEN :
                return CURLY_CLOSE;
            case CURLY_CLOSE :
                return CURLY_OPEN;
            case ROUND_OPEN :
                return ROUND_CLOSE;
            case ROUND_CLOSE :
                return ROUND_OPEN;
            case SQUARE_OPEN :
                return SQUARE_CLOSE;
            case SQUARE_CLOSE :
                return SQUARE_OPEN;
            case DOUBLE_QOUTES :
            case SINGLE_QOUTE :
            case BACK_QOUTE :
                return c;
        }

        return '-';
    }

    protected int isMatchingCharNeeded(IStructuredDocument document,
            int offset, char bracketChar)
    {
        try {
            String postCharState = FormatterUtils.getPartitionType(document,
                    offset + 1);
            if (!(postCharState == TwigPartitionTypes.TWIG_DEFAULT
                    || postCharState == PHPRegionTypes.PHP_OPENTAG || postCharState == PHPRegionTypes.PHP_CLOSETAG)) {
                if (isSpecialOpenCurlyInQuotes(document, offset)) {
                    postCharState = FormatterUtils.getPartitionType(document,
                            offset + 2);
                }
            }
            if (document.getLength() == offset + 1) { // if we are in the end of
                // the document
                postCharState = FormatterUtils.getPartitionType(document,
                        offset);
                if (postCharState == TwigPartitionTypes.TWIG_DEFAULT
                        || postCharState == PHPRegionTypes.PHP_OPENTAG
                        || postCharState == PHPRegionTypes.PHP_CLOSETAG) {
                    if (document.getChar(offset) == getMatchingChar(bracketChar)) {
                        return MATCHING_BRACKET_NOT_NEEDED;
                    }
                    return MATCHING_BRACKET_NEEDED;
                }
                return MATCHING_BRACKET_NOT_NEEDED;
            }

            if (postCharState != TwigPartitionTypes.TWIG_DEFAULT
                    && postCharState != PHPRegionTypes.PHP_OPENTAG
                    && postCharState != PHPRegionTypes.PHP_CLOSETAG) {
                return SEARCH_NOT_VALID;
            }

            int currOffset = offset + 1;
            IStructuredDocumentRegion sdRegion = document
                    .getRegionAtCharacterOffset(currOffset);
            while (currOffset >= 0 && sdRegion != null) {
                if (sdRegion.getType() != TwigRegionTypes.TWIG_CONTENT) {
                    currOffset = sdRegion.getStartOffset() - 1;
                    sdRegion = document.getRegionAtCharacterOffset(currOffset);
                    continue;
                }

                ITextRegion tRegion = sdRegion
                        .getRegionAtCharacterOffset(currOffset);

                // in case the cursor on the beginning of '?>' tag
                // we decrease the offset to get the PhpScriptRegion
                if (tRegion.getType().equals(PHPRegionContext.PHP_CLOSE)) {
                    tRegion = sdRegion
                            .getRegionAtCharacterOffset(currOffset - 1);
                }

                int regionStart = sdRegion.getStartOffset(tRegion);
                // in case of container we have the extract the PhpScriptRegion
                if (tRegion instanceof ITextRegionContainer) {
                    ITextRegionContainer container = (ITextRegionContainer) tRegion;
                    tRegion = container.getRegionAtCharacterOffset(currOffset);
                    regionStart += tRegion.getStart();
                }

                if (tRegion instanceof ITwigScriptRegion) {

                    ITwigScriptRegion scriptRegion = (ITwigScriptRegion) tRegion;
                    tRegion = scriptRegion.getTwigToken(currOffset
                            - regionStart);

                    while (tRegion != null) {

                        String regionType = tRegion.getType();

                        if (regionType == TwigRegionTypes.TWIG_DELIMITER) {

                            char token = document.getChar(regionStart
                                    + tRegion.getStart());
                            if (token == ROUND_OPEN || token == SQUARE_OPEN
                                    || token == CURLY_OPEN) {
                                if (token == bracketChar) {
                                    if (matcher.match(document, regionStart
                                            + tRegion.getStart() + 1) == null) {
                                        return MATCHING_BRACKET_NEEDED;
                                    }
                                }
                            }
                        } else if (regionType == PHPRegionTypes.PHP_CURLY_OPEN
                                || regionType == PHPRegionTypes.PHP_CURLY_CLOSE
                                || regionType == TwigRegionTypes.TWIG_HASH_END) {
                            return MATCHING_BRACKET_NOT_NEEDED;
                        } else if (regionType == TwigRegionTypes.TWIG_HASH_START) {
                            return MATCHING_BRACKET_NEEDED;
                        }

                        if (tRegion.getStart() > 0) {
                            tRegion = scriptRegion.getTwigToken(tRegion
                                    .getStart() - 1);
                        } else {
                            break;
                        }
                    }
                } else {

                    if (tRegion.getType() == TwigRegionContext.TWIG_CLOSE) {

                        return MATCHING_BRACKET_NEEDED;
                    }
                }

                currOffset = sdRegion.getStartOffset() - 1;
                sdRegion = (currOffset < 0) ? null : document
                        .getRegionAtCharacterOffset(currOffset);

            }
        } catch (BadLocationException e) {
            Logger.logException(e);
        }
        return MATCHING_BRACKET_NOT_NEEDED;
    }

    protected static boolean isSpecialOpenCurlyInQuotes(
            final IStructuredDocument document, final int offset)
            throws BadLocationException
    {
        final IStructuredDocumentRegion sdRegion = document
                .getRegionAtCharacterOffset(offset);
        if (sdRegion == null)
            return false;
        final ITextRegion tRegion = sdRegion.getRegionAtCharacterOffset(offset);
        // TODO need to support heredoc also
        if (tRegion.getType() != PHPRegionTypes.PHP_ENCAPSED_AND_WHITESPACE)
            return false;

        final char firstChar = document.getChar(sdRegion.getStartOffset()
                + tRegion.getStart());
        if (firstChar != DOUBLE_QOUTES && firstChar != BACK_QOUTE)
            return false;

        final char bracketChar = document.getChar(offset + 1);
        return bracketChar == '$';
    }

}
