package net.tfobz.ausdrueckeerw;

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
}