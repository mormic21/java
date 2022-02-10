package net.tfobz.ausdrueckeerw;

/**
 * Addition
 * erbt von Operation
 * @author Michael Morandell
 *
 */
public class Addition extends Operation {
	
	/**
	 * Addition-Konstruktor
	 * @param operand0
	 * @param operand1
	 */
	public Addition(Operand operand0, Operand operand1) {
		super(operand0, operand1);
	}
	
	/**
	 * Addition-Konstruktor
	 */
	public Addition() {
		super();
	}
	
	/**
	 * getErgebnis
	 * @return double
	 */
	public double getErgebnis() {
		double ret = 0.0;
		if (this.getOperand(0) != null)
			ret = this.getOperand(0).getErgebnis();
		if (this.getOperand(1) != null)
			ret = ret + this.getOperand(1).getErgebnis();
		return ret;
	}
	
	/**
	 * to String
	 * @return String
	 */
	public String toString() {
		String ret = null;
		if (this.getOperand(0) == null || this.getOperand(1) == null) {
			ret = "";
		}
		else {
			ret = "("+
					this.getOperand(0).toString()+
					"+"+
					this.getOperand(1).toString()+
					"="+
					this.getErgebnis()+
					")";
		}
		return ret;	
	}
}