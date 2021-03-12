
public class Schrank {
	private String material;
	private double preis;
	private int anzahlTeile;

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String s) {
		if (s != null) {
			this.material = s;
		}
	}
	
	public double getPreis() {
		return preis;
	}
	
	public void setPreis(double d) {
		this.preis = d;
	}
	
	public int getAnzahlTeile() {
		return anzahlTeile;
	}
	
	public void setAnzahlTeile(int i) {
		this.anzahlTeile = i;
	}
	
	public Schrank clone() {
		Schrank ret = new Schrank();
		ret.setMaterial(this.material);
		ret.setAnzahlTeile(this.anzahlTeile);
		ret.setPreis(this.preis);
		return ret;
	}
	
	public boolean equals(Object obj) {
		boolean ret =  false;
		if (obj instanceof Schrank) {
			Schrank o = (Schrank)obj;
			
			ret = o.material.equals(this.material) && 
					o.anzahlTeile == this.anzahlTeile &&
					Math.abs(o.preis - this.preis) < Math.pow(10, -10);
		}
		return ret;
	}
	
	public int compareTo(Schrank o) {
		int ret = o.material.compareTo(this.material);
		if (ret == 0) {
			ret = o.anzahlTeile - this.anzahlTeile;
			if (ret == 0) {
				ret = (int)(Math.floor((o.preis - this.preis)*100000)/100000);
			}
		}
		return ret;
	}

}
