package net.tfobz.ausdrueckeerw;

/**
 * Logarithmus
 * erbt von ArgOperation
 * @author Michael Morandell
 *
 */
public class Logarithmus extends ArgOperation {
	
	/**
	 * Logarithmus
	 * @param argument
	 * @param operand1
	 */
	public Logarithmus(Argument argument, Operand operand1) {
		super(argument, operand1);
	}
	
	/**
	 * Logarithmus
	 */
	public Logarithmus() {
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
			ret = Math.log(ret)/Math.log(this.getArgument().getErgebnis());
		return ret;
	}
	
	/**
	 * toString
	 * @return String
	 */
	@Override
	public String toString() {
		String ret = null;
		ret = "(Log("+
				this.getArgument().toString()+
				","+
				this.getOperand().toString()+
				")="+
				this.getErgebnis()+
				")";
		return ret;
	}
}