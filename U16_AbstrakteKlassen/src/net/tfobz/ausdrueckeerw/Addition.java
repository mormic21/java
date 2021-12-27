package net.tfobz.ausdrueckeerw;

public class Addition extends Operation
{
	public Addition(Operand operand0, Operand operand1) {
		super(operand0, operand1);
	}
	public Addition() {
		super();
	}
	public double getErgebnis() {
		double ret = 0.0;
		if (this.getOperand(0) != null)
			ret = this.getOperand(0).getErgebnis();
		if (this.getOperand(1) != null)
			ret = ret + this.getOperand(1).getErgebnis();
		return ret;
	}
	public String toString() {
		String ret = null;
		ret = "("+
				this.getOperand(0).toString()+
				"+"+
				this.getOperand(1).toString()+
				"="+
				this.getErgebnis()+
				")";
		return ret;	
	}
}
