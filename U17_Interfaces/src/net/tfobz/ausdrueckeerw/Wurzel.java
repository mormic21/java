package net.tfobz.ausdrueckeerw;

/**
 * Wurzel
 * erbt von ArgOperation
 * @author Michael Morandell
 *
 */
public class Wurzel extends ArgOperation {
	
	/**
	 * Wurzel-Konstruktor
	 * @param argument
	 * @param operand1
	 */
	public Wurzel(Argument argument, Operand operand1) {
		super(argument, operand1);
	}
	
	/**
	 * Wurzel-Konstuktor
	 */
	public Wurzel() {
		super();
	}
	
	/**
	 * getErgebnis
	 * @return double
	 */
	@Override
	public double getErgebnis() {
		double ret = 0.0;
		if (this.getOperand() != null)
			ret = this.getOperand().getErgebnis();
		if (this.getArgument() != null)
			ret = Math.pow(Math.E, (1/this.getArgument().getErgebnis())*Math.log(ret));
		return ret;
	}
	
	/**
	 * toString
	 * @return String
	 */
	@Override
	public String toString() {
		String ret = null;
		ret = "(Wurzel("+
				this.getArgument().toString()+
				","+
				this.getOperand().toString()+
				")="+
				this.getErgebnis()+
				")";
		return ret;
	}
}