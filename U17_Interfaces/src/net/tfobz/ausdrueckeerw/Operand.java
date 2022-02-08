package net.tfobz.ausdrueckeerw;
import java.util.Enumeration;

import javax.swing.event.TreeModelListener;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

/**
 * Operand
 * abstrakte Klasse
 * @author Michael Morandell
 *
 */
public abstract class Operand implements TreeNode {
	
	/**
	 * getErgebnis
	 * abstrakte Methode
	 * @return double
	 */
	public abstract double getErgebnis();
	
	/**
	 * TreeNode
	 */
	
	/**
	 * getParent()
	 */
	@Override
	public TreeNode getParent() {
		return null;
	}
	
	/**
	 * Returns true if the receiver is a leaf
	 * @return true, wenn leaf
	 */
	@Override
	public boolean isLeaf() {
		return !(this.getChildCount() > 0);
	}
	
	/**
	 * Konstante erlaubt keine Children
	 * @return false
	 */
	@Override
	public boolean getAllowsChildren() {
		return this.getChildCount() > 0;
	}

	/**
	 * gibt Children als Enumeration zurueck
	 * wird in Operation+ArgOperation ueberschrieben
	 * @return Enumeration
	 */
	@Override
	public Enumeration children() {
		return null;
	}
}