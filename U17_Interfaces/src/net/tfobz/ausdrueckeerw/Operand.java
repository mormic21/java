package net.tfobz.ausdrueckeerw;
import java.util.Enumeration;
import javax.swing.tree.*;

/**
 * Operand
 * abstrakte Klasse
 * @author Michael Morandell
 *
 */
public abstract class Operand implements TreeNode, MutableTreeNode {
	//parent-Object vom Typ MutableTreeNode
	protected MutableTreeNode parent = null;
	
	/**
	 * getErgebnis
	 * abstrakte Methode
	 * @return double
	 */
	public abstract double getErgebnis();
	
	/**
	 * MutableTreeNode - Methoden
	 */

	/**
	 * insert
	 * implemented in Operation
	 */
	@Override
	public void insert(MutableTreeNode child, int index) {
	}

	/**
	 * remove at index
	 * implemented in Operation
	 */
	@Override
	public void remove(int index) {
	}

	/**
	 * remove node
	 * not implemented
	 */
	@Override
	public void remove(MutableTreeNode node) {
	}

	/**
	 * setUserObject
	 * implemented in Konstante
	 */
	@Override
	public void setUserObject(Object object) {
	}

	/**
	 * removeFromParent
	 * not implemented
	 */
	@Override
	public void removeFromParent() {
	}

	/**
	 * setParent
	 * @param newParent, MutableTreeNode
	 */
	@Override
	public void setParent(MutableTreeNode newParent) {
		this.parent = newParent;
	}
	
	/**
	 * TreeNode - Methoden
	 */
	
	/**
	 * getParent
	 * @return the Parent as Treenode
	 */
	@Override
	public TreeNode getParent() {
		return this.parent;
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
	 * implemented in Operation
	 * @return Enumeration
	 */
	@Override
	public Enumeration<TreeNode> children() {
		return null;
	}
}