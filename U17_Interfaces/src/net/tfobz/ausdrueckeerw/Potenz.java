package net.tfobz.ausdrueckeerw;

/**
 * Potenz
 * erbt von Operation
 * @author Michael Morandell
 *
 */
public class Potenz extends Operation {
	
	/**
	 * Potenz-Konstruktor
	 * @param operand0
	 * @param operand1
	 */
	public Potenz(Operand operand0, Operand operand1) {
		super(operand0, operand1);
	}
	
	/**
	 * getErgebnis
	 * @return double
	 */
	@Override
	public double getErgebnis() {
		double ret = 0.0;
		if (this.getOperand(0) != null)
			ret = this.getOperand(0).getErgebnis();
		if (this.getOperand(1) != null)
			ret = Math.pow(ret, this.getOperand(1).getErgebnis());
		return ret;
	}
	
	/**
	 * toString
	 * @return String
	 */
	@Override
	public String toString() {
		String ret = null;
		ret = "("+
				this.getOperand(0).toString()+
				"^"+
				this.getOperand(1).toString()+
				"="+
				this.getErgebnis()+
				")";
		return ret;	
	}
}