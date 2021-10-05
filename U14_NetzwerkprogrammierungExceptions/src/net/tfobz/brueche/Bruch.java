package net.tfobz.brueche;
/**
 * Bruch-Klasse
 * kann Bruch-Exception werfen
 * @author Michael Morandell
 *
 */
public class Bruch {
	//Membervariablen
	private int zaehler;
	private int nenner;
	
	/**
	 * Konstruktor
	 * @param zaehler
	 * @param nenner
	 * @throws BruchException
	 */
	public Bruch(int zaehler, int nenner) throws BruchException{
		if (nenner == 0) {
			throw new BruchException("Nenner ist Null");
		}
		//setzt die Brucheigenschaften
		this.zaehler = zaehler;
		this.nenner = nenner;
		kuerze();
	}

	/**
	 * GetZaehler
	 * @return the zaehler
	 */
	public int getZaehler() {
		return zaehler;
	}

	/**
	 * SetZaehler
	 * @param zaehler the zaehler to set
	 */
	public void setZaehler(int zaehler) {
		this.zaehler = zaehler;
		kuerze();
	}

	/**
	 * GetNenner
	 * @return the nenner
	 */
	public int getNenner() {
		return nenner;
	}

	/**
	 * Setzt den Nenner
	 * @param nenner
	 * @throws BruchException
	 */
	public void setNenner(int nenner) throws BruchException{
		if (nenner == 0) {
			throw new BruchException("Nenner ist Null");
		}
		this.nenner = nenner;
		kuerze();
	}
	
	/**
	 * kuerze
	 * @throws BruchException
	 */
	private void kuerze(){
		int cache;
		int ggtnenner = Math.abs(this.nenner);
		int ggtzaehler = Math.abs(this.zaehler);
		while(ggtnenner > 0) {
			cache = ggtnenner;
			ggtnenner = ggtzaehler%ggtnenner;
			ggtzaehler = cache;
		}
		int ggt = ggtzaehler;
		this.zaehler = this.zaehler/ggt;
		this.nenner = this.nenner/ggt;
	}
	
	/**
	 * to String
	 * @return String
	 */
	@Override
	public String toString() {
		String ret = null;
		ret = getZaehler() + "/" + getNenner();
		return ret;
	}
	
	/**
	 * equals
	 * @param Object obj
	 */
	@Override
	public boolean equals(Object obj) {
		boolean ret = false;
		//Bruch leer
		if (obj == null) {
			throw new NullPointerException("Zweiter Bruch leer");
		}
		if (!(obj instanceof Bruch)) {
			throw new ClassCastException("Typen nicht passend");
		}
		Bruch b = (Bruch)obj;
		if (this.getZaehler() == b.getZaehler() && this.getNenner() == b.getNenner()) {
			ret =  true;
		}
		return ret;
	}
	
	/**
	 * Clont den Bruch
	 * @return Bruch
	 */
	@Override
	public Bruch clone() {
		Bruch ret = null;
		try {
			ret = new Bruch(this.zaehler, this.nenner);
		} catch (BruchException e) {
			e.printStackTrace();
		}
		return ret;
	}
	
	/**
	 * addiere
	 * @param b
	 * @throws BruchException
	 */
	public void addiere(Bruch b) throws BruchException{
		if (b == null) {
			throw new NullPointerException("Zweiter Bruch leer");
		}
		this.setZaehler(this.getZaehler() * b.nenner + b.zaehler * this.getNenner());
		this.setNenner(this.getNenner() * b.nenner);
		kuerze();
	}
	
	/**
	 * subtrahiere
	 * @param b
	 * @throws BruchException
	 */
	public void subtrahiere(Bruch b) throws BruchException{
		if (b == null) {
			throw new NullPointerException("Zweiter Bruch leer");
		}
		this.setZaehler((this.getZaehler() * b.nenner) - (b.zaehler * this.getNenner()));
		this.setNenner(this.getNenner() * b.nenner);
		kuerze();
	}
	
	/**
	 * multipliziere
	 * @param b
	 * @throws BruchException
	 */
	public void multipliziere(Bruch b) throws BruchException{
		if (b == null) {
			throw new NullPointerException("Zweiter Bruch leer");
		}
		this.setZaehler(this.getZaehler() * b.zaehler);
		this.setNenner(this.getNenner() * b.nenner);
		kuerze();
	}
	
	/**
	 * dividiere
	 * @param b
	 * @throws BruchException
	 */
	public void dividiere(Bruch b) throws BruchException{
		if (b == null) {
			throw new NullPointerException("Zweiter Bruch leer");
		}
		this.setZaehler(this.getZaehler() * b.nenner);
		this.setNenner(this.getNenner() * b.zaehler);
		kuerze();
	}
}
