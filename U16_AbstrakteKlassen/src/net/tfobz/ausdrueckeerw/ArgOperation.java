package net.tfobz.ausdrueckeerw;

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
}