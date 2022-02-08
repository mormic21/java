package net.tfobz.ausdrueckeerw;

import javax.swing.tree.TreeNode;

/**
 * Konstante
 * erbt von Operand
 * @author Michael Morandell
 *
 */
public class Konstante extends Operand {
	//Membervariable
	protected double ergebnis = 0.0;
	
	/**
	 * Konstante-Konstruktor
	 * @param ergebnis
	 */
	public Konstante(double ergebnis) {
		this.ergebnis = ergebnis;
	}
	
	/**
	 * Konstante-Konstruktor
	 */
	public Konstante() {
		super();
	}
	
	/**
	 * setErgebnis
	 * @param ergebnis
	 */
	public void setErgebnis(double ergebnis) {
		this.ergebnis = ergebnis;
	}
	
	/**
	 * getErgebnis
	 * @return double
	 */
	public double getErgebnis() {
		return this.ergebnis;
	}
	
	/**
	 * toString
	 * @return String
	 */
	public String toString() {
		return String.valueOf(this.ergebnis);
	}
	
	/**
	 * Returns the child TreeNode at index childIndex.
	 * @param childIndex, int
	 * @return TreeNode
	 */
	@Override
	public TreeNode getChildAt(int childIndex) {
		return null;
	}
	
	/**
	 * Returns the number of children TreeNodes the receiver contains.
	 * @return anzahl der Kinder, int
	 */
	@Override
	public int getChildCount() {
		return 0;
	}
	
	
	
	/**
	 * getIndex
	 * gibt immer 0 zurueck, da keine children
	 * @param node, Treenode
	 * @return Index of Node
	 */
	@Override
	public int getIndex(TreeNode node) {
		return 0;
	}
}