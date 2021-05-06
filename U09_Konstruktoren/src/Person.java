
public class Person {
	//statische Klassenvariable, welche jedem neunen Obejkt eine neue Nummer gibt
	private static int nextnumber = 0;
	//private Memberkonstate, welche die spezifische Nummer für eine Person speichert. Wird erst in Konstruktor initialisiert.
	private final int number;
	private String vorname;
	private String nachname;
	private boolean weiblich;
	private Person mutter;
	private Person vater;
	
	/**
	 * Custom-Konstruktor. Erzeugt ein Obejkt vom Typ Person und setzt dabei folegende Eigenschaften:
	 * @param vorname, vorname der Person, als String
	 * @param nachname, nachname der Person, als String
	 * @param weiblich, also boolean, true wenn person weiblich
	 */
	public Person(String vorname, String nachname, boolean weiblich) {
		this.number = nextnumber;
		this.vorname = vorname;
		this.nachname = nachname;
		this.weiblich = weiblich;
		nextnumber++;
	}
	
	/**
	 * Custom-Konstruktor. Erzeugt ein Obejkt vom Typ Person und setzt dabei folegende Eigenschaften:
	 * @param vorname, vorname der Person, als String
	 * @param nachname, nachname der Person, als String
	 * @param weiblich, also boolean, true wenn person weiblich
	 * @param mutter, mutter vom typ Person
	 * @param vater, vater vom typ Person
	 */
	public Person(String vorname, String nachname, boolean weiblich, Person mutter, Person vater) {
		this(vorname, nachname, weiblich); 
		this.setMutter(mutter); 
		this.setVater(vater);
	}
	
	/**
	 * Copy-Konstruktor. Ein neues Objekt vom Typ Person wird erstellt und folgende Eigenschaften von der
	 * Parameter-Person kopiert: vorname, nachname, weiblich. mutter und vater werden dabei auf null gesetzt
	 * @param p
	 */
	public Person(Person p) {
		this(p.vorname, p.nachname, p.weiblich); 
		this.mutter = null; 
		this.vater = null;
	}
	/**
	 * @return the number
	 */
	public int getNumber() {
		return number;
	}
	/**
	 * @return the nextnumber
	 */
	public static int getNextnumber() {
		return nextnumber;
	}
	/**
	 * @param nextnumber the nextnumber to set
	 */
	public static void setNextnumber(int nextnumber) {
		Person.nextnumber = nextnumber;
	}
	/**
	 * @return the vorname
	 */
	public String getVorname() {
		return vorname;
	}
	/**
	 * @param vorname the vorname to set
	 */
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	/**
	 * @return the nachname
	 */
	public String getNachname() {
		return nachname;
	}
	/**
	 * @param nachname the nachname to set
	 */
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}
	/**
	 * @return the weiblich
	 */
	public boolean isWeiblich() {
		return weiblich;
	}
	/**
	 * @param weiblich the weiblich to set
	 */
	public void setWeiblich(boolean weiblich) {
		this.weiblich = weiblich;
	}
	/**
	 * @return Vor- und Nachname, mit einem Leerzeichen getrennt
	 */
	public String getName() {
		return this.vorname +" "+ this.nachname;
	}
	/**
	 * @return the mutter
	 */
	public Person getMutter() {
		return mutter;
	}
	/**
	 * @param mutter the mutter to set
	 */
	public void setMutter(Person mutter) {
		if (mutter.weiblich == true)
			this.mutter = mutter;
	}
	/**
	 * @return the vater
	 */
	public Person getVater() {
		return vater;
	}
	/**
	 * @param vater the vater to set
	 */
	public void setVater(Person vater) {
		if (vater.weiblich == false)
			this.vater = vater;
	}
	
	/**
	 * To-String-Methode. Gibt die Inhalte der Membervariablen als String zum Ausgeben zurück.
	 * @return String mit den Inhalten der Membervariablen
	 */
	public String toString() {
		String mutter;
		String vater;
		//überprüft ob Mutterobjekt vorhanden ist, wenn nicht, wird der STring null ausgegeben
		if (this.getMutter() == null)
			mutter = "null";
		else 
			mutter = this.getMutter().getName();
		//überprüft Vater-Objekt
		if (this.getVater() == null) 
			vater = "null";
		else 
			vater = this.getVater().getName();
		//rückgabe nummer, name, weiblich, vater + mutter
		return this.getNumber()+": "+this.getName()+" w = "+this.isWeiblich()+" m = "+mutter+" v = "+vater;
	}
	
	/**
	 * Methode getEltern
	 * Gibt die Eltern einer Person, als Person-Objekt in einem Person-Array zurück.
	 * @return Person-Array mit den Person-Objekten der Eltern der Person
	 */
	public Person [] getEltern() {
		Person [] ret = new Person [2];
		//wenn Objekt vorhanden, wird ein neues mit dem Copy-Construktor erstellt
		if (this.getMutter() != null)
			ret[0] = new Person(this.getMutter());
		if (this.getVater() != null)
			ret[1] = new Person(this.getVater());
		return ret;
	}
	
	/**
	 * Methode get Grosseltern
	 * Liefert die Großeltern einer Person, als Person-Objekt in einem Person-Array zurück.
	 * @return Person-Array, mit den Person-Objekten der Grosseltern der Person
	 */
	public Person [] getGrosseltern() {
		Person [] ret = new Person [4];
		//wenn Mutter-Objekt und Großmutter Objekt vorhanden, wird ein neues Objekt mit Copy-Construktor erstellt
		if (this.getMutter() != null && this.getMutter().getMutter() != null)
			ret [0] = new Person(this.getMutter().getMutter());
		if (this.getMutter() != null && this.getMutter().getVater() != null)
			ret [1] = new Person(this.getMutter().getVater());
		if (this.getVater() != null && this.getVater().getMutter() != null)
			ret [2] = new Person(this.getVater().getMutter());
		if (this.getVater() != null && this.getVater().getVater() != null)
			ret [3] = new Person(this.getVater().getVater());
		return ret;
	}
	
	/**
	 * Methode getListe
	 * Liefert alle Vorfahren einer Person als String zurück. Durch '\n' zeilenweise getrennt
	 * @return String, alle Vorfahren einer Person
	 */
	public String getListe() {
		String ret = this.toString()+ "\n";
		//Wenn Mutter vorhanden
		if (this.getMutter() != null) {
			ret = ret + this.getMutter().getListe();
		}
		//Wenn Vater vorhanden
		if (this.getVater() != null) {
			ret = ret + this.getVater().getListe();
		}
		return ret;
	}
}
