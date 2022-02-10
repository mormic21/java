package net.tfobz.ausdrueckeerw;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

import javax.swing.tree.TreeNode;

/**
 * ArgOperation
 * erbt von Operand
 * @author Michael Morandell
 *
 */
public abstract class ArgOperation extends Operand {
	//Membervariablen
	private Argument argument;
	private Operand operand;
	
	/**
	 * ArgOperation-Konstruktor
	 * @param argument
	 * @param operand
	 */
	public ArgOperation(Argument argument, Operand operand) {
		this.argument = argument;
		this.operand = operand;
	}
	
	/**
	 * ArgOperation-Konstruktor
	 */
	public ArgOperation() {
		super();
	}
	
	/**
	 * getArgument
	 * @return Argument
	 */
	public Argument getArgument() {
		return argument;
	}

	/**
	 * setArgument
	 * @param argument
	 */
	public void setArgument (Argument argument) {
		this.argument = argument;
	}

	/**
	 * getOperand
	 * @return Operand
	 */
	public Operand getOperand() {
		return operand;
	}

	/**
	 * setOperand
	 * @param operand
	 */
	public void setOperand (Operand operand) {
		this.operand = operand;
	}
	
	/**
	 * TreeNode - Methoden
	 */
	
	/**
	 * Returns the child TreeNode at index childIndex.
	 * @param childIndex, int
	 * @return TreeNode
	 */
	@Override
	public TreeNode getChildAt(int childIndex) {
		TreeNode ret = null;
		//Wenn Index out of bound, dann null
		if (childIndex < 0 || childIndex > 1) {
			ret = null;
		}
		else {
			if (childIndex == 0) {
				ret = argument;
			}
			else if (childIndex == 1){
				ret = operand;
			}
		}
		return ret;
	}
	
	/**
	 * Returns the number of children TreeNodes the receiver contains.
	 * @return anzahl der Kinder, int
	 */
	@Override
	public int getChildCount() {
		int ret = 0;
		if (argument != null) {
			ret++;
		}
		if (argument != null) {
			ret++;
		}
		return ret;
	}
		
	/**
	 * getIndex
	 * gibt den Index des TreeNodes zurzueck
	 * @param node, Treenode
	 * @return Index of Node
	 */
	@Override
	public int getIndex(TreeNode node) {
		int ret = 0;
		if (node.equals(argument)) {
			ret = 0;
		}
		else if (node.equals(operand)) {
			ret = 1;
		}
		return ret;
	}
	
	/**
	 * gibt die Kinder als Enumeration zurueck
	 * @return Enumeration
	 */
	@Override
	public Enumeration<TreeNode> children() {
		List<TreeNode> arrlist = new ArrayList<TreeNode>();
		arrlist.add(getChildAt(0));
		arrlist.add(getChildAt(1));
		return Collections.enumeration(arrlist);
	}
}