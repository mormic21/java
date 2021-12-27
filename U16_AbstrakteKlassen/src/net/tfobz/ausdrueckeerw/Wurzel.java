package net.tfobz.ausdrueckeerw;

public class Wurzel extends ArgOperation {
	
	public Wurzel(Argument argument, Operand operand1) {
		super(argument, operand1);
	}
	public Wurzel() {
		super();
	}
	
	
	@Override
	public double getErgebnis() {
		double ret = 0.0;
		if (this.getOperand() != null)
			ret = this.getOperand().getErgebnis();
		if (this.getArgument() != null)
			ret = Math.pow(Math.E, (1/this.getArgument().getErgebnis())*Math.log(ret));
		return ret;
	}
	
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
