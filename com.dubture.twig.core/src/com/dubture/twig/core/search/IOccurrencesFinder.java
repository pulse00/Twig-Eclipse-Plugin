/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 * 
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.core.search;

import com.dubture.twig.core.parser.TwigNode;

/**
 * 
 * Interface for finding occurrences in twig templates.
 * 
 * 
 * @author Robert Gruendler <r.gruendler@gmail.com>
 * 
 */
public interface IOccurrencesFinder
{

    public static final int K_OCCURRENCE = 5;

    public static final int F_WRITE_OCCURRENCE = 1;
    public static final int F_READ_OCCURRENCE = 2;

    /**
     * Element representing a occurrence
     */
    public static class OccurrenceLocation
    {
        private final int fOffset;
        private final int fLength;
        private final int fFlags;
        private final String fDescription;

        public OccurrenceLocation(int offset, int length, int flags,
                String description)
        {
            fOffset = offset;
            fLength = length;
            fFlags = flags;
            fDescription = description;
        }

        public int getOffset()
        {
            return fOffset;
        }

        public int getLength()
        {
            return fLength;
        }

        public int getFlags()
        {
            return fFlags;
        }

        public String getDescription()
        {
            return fDescription;
        }

        public String toString()
        {
            return "[" + fOffset + " / " + fLength + "] " + fDescription; //$NON-NLS-1$//$NON-NLS-2$ //$NON-NLS-3$
        }

    }

    public String initialize(String source, TwigNode node);

    /**
     * Returns the occurrences
     * 
     * @return the occurrences
     */
    public OccurrenceLocation[] getOccurrences();

}
