
public class Polsterung {

	private String polMaterial;
	private String polFarbe;
	
	public String getPolMaterial() {
		return polMaterial;
	}
	
	public void setPolMaterial(String s) {
		if (s != null) {
			this.polMaterial = s;
		}
	}
	public String getPolFarbe() {
		return polFarbe;
	}
	
	public void setPolFarbe(String s) {
		if (s != null) {
			this.polFarbe= s;
		}
	}
	
	public Polsterung clone() {
		Polsterung ret = new Polsterung();
		ret.setPolMaterial(this.polMaterial);
		ret.setPolFarbe(this.polFarbe);
		return ret;
	}
	
	public boolean equals(Object obj) {
		boolean ret =  false;
		if (obj instanceof Polsterung) {
			Polsterung o = (Polsterung)obj;
			ret = o.polMaterial.equals(this.polMaterial) && 
					o.polFarbe.equals(this.polFarbe);
		}
		return ret;
	}
	
	public int compareTo(Polsterung o) {
		int ret = o.polMaterial.compareTo(this.polMaterial);
		if (ret == 0) {
			ret = o.polFarbe.compareTo(this.polFarbe);
		}
		return ret;
		
	}

}
