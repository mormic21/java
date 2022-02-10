package net.tfobz.ausdrueckeerw;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import javax.swing.tree.*;

/**
 * Achtung: Die Operanden werden immer der Reihe nach in die Operation gehängt. Mit
 * setOperand kann man beim ersten Aufruf den ersten Operanden füllen, ruft man
 * setOperand nochmals auf, so wird der zweite Operand gefüllt. Beim Löschen werden 
 * die Operanden unter Umständen nach vorne verschoben.
 * @author Michael Wild
 */
public abstract class Operation extends Operand {
	//Membervariable
	private Operand[] operand = new Operand[2];
	
	/**
	 * Operation-Konstruktor
	 * @param operand0
	 * @param operand1
	 */
	public Operation(Operand operand0, Operand operand1) {
		this.setOperand(operand0);
		this.setOperand(operand1);
	}
	
	/**
	 * Operation-Konstruktor
	 */
	public Operation() {
		super();
	}
	
	/**
	 * serOperand
	 * @param operand
	 */
	public void setOperand(Operand operand) {
		if (this.operand[0] == null)
			this.operand[0] = operand;
		else
			if (this.operand[1] == null)
				this.operand[1] = operand;
	}
	
	/**
	 * getOperand
	 * @param position
	 * @return Operand
	 */
	public Operand getOperand(int position) {
		if (position >= 0 && position <= 1)
			return this.operand[position];
		else
			return null;
	}
	
	/**
	 * vertausche
	 */
	public void vertausche() {
		if (this.operand[0] != null && this.operand[1] != null) {
			Operand operand = this.operand[0];
			this.operand[0] = this.operand[1];
			this.operand[1] = operand;
		}
	}
	
	/**
	 * loescheOperand
	 * @param position
	 */
	public void loescheOperand(int position) {
		if (position == 0) {
			this.operand[0] = this.operand[1];
			this.operand[1] = null;
		} else
			if (position == 1)
				this.operand[1] = null;
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
			ret = operand[childIndex];
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
		if (operand[0] != null) {
			ret++;
		}
		if (operand[1] != null) {
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
		if (node.equals(operand[0])) {
			ret = 0;
		}
		else if (node.equals(operand[1])) {
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
	
	/**
	 * insert
	 * @param child, MutableTreeNode
	 * @param index, int
	 */
	@Override
	public void insert(MutableTreeNode child, int index) {
		this.setOperand((Operand)child);
		//set Parent of child
		child.setParent(this);
	}
	
	/**
	 * remove at index
	 * @param index, int
	 */
	@Override
	public void remove(int index) {
		this.loescheOperand(index);
	}
}