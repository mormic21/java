package net.tfobz.ausdrueckeerw;

/**
 * Multiplikation
 * erbt von Operation
 * @author Michael Morandell
 *
 */
public class Multiplikation extends Operation {
	
	/**
	 * Multiplikation-Konstruktor
	 * @param operand0
	 * @param operand1
	 */
	public Multiplikation(Operand operand0, Operand operand1) {
		super(operand0, operand1);
	}
	
	/**
	 * Multiplikation-Konstruktor
	 */
	public Multiplikation() {
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
			ret = ret * this.getOperand(1).getErgebnis();
		return ret;
	}
	
	/**
	 * toString
	 * @return String
	 */
	public String toString() {
		String ret = null;
		ret = "("+
				this.getOperand(0).toString()+
				"*"+
				this.getOperand(1).toString()+
				"="+
				this.getErgebnis()+
				")";
		return ret;	
	}
}