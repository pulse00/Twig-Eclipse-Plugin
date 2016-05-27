/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 * 
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.core.search;

import org.eclipse.dltk.ast.ASTNode;

import com.dubture.twig.core.log.Logger;
import com.dubture.twig.core.parser.ast.node.TwigModuleDeclaration;
import com.dubture.twig.core.parser.ast.visitor.TwigASTVisitor;

/**
 * 
 * Finds a twig token in a twig template at a given position.
 * 
 * 
 * @author Robert Gruendler <r.gruendler@gmail.com>
 * 
 */
public class NodeFinder {

	/**
	 * @param astRoot
	 * @param offset
	 * @param length
	 * @return
	 */
	public static ASTNode perform(TwigModuleDeclaration astRoot, int offset, int length) {
		try {

			NodeFinder.AstNodeFinder finder = new NodeFinder.AstNodeFinder(offset, length);
			astRoot.traverse(finder);
			return finder.fCoveringNode;

		} catch (Exception e) {
			Logger.logException(e);
			return null;
		}
	}

	private static class AstNodeFinder extends TwigASTVisitor {
		private int fStart;
		private int fEnd;
		private ASTNode fCoveringNode;
		private ASTNode fCoveredNode;

		public AstNodeFinder(int offset, int length) {
			this.fStart = offset;
			this.fEnd = offset + length;

		}

		@Override
		public boolean visitGeneral(ASTNode node) throws Exception {
			int nodeStart = node.sourceStart();
			int nodeEnd = node.sourceEnd();
			if (nodeEnd < fStart || fEnd < nodeStart) {
				return false;
			}
			if (nodeStart <= fStart && fEnd <= nodeEnd) {
				fCoveringNode = node;
			}
			if (fStart <= nodeStart && nodeEnd <= fEnd) {
				if (fCoveringNode == node) { // nodeStart == fStart && nodeEnd
												// ==
					// fEnd
					fCoveredNode = node;
					return true; // look further for node with same length as
									// parent
				} else if (fCoveredNode == null) { // no better found
					fCoveredNode = node;
				}
				return false;
			}
			return true;
		}
	}
}
