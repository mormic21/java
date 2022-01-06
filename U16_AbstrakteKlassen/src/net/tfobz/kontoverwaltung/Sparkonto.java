package net.tfobz.kontoverwaltung;

/**
 * Ein Sparkonto hat keinen Überziehungsrahmen, dafür aber eine Sparrate 
 * und darf keine negativen Kontostände aufweisen. Bei jedem Sparkonto kann 
 * eine individuelle Sparrate eingestellt werden, welche durch eine eigene 
 * Operation (buchenSparrate) zum Kontostand dazugebucht wird. Es kann nur unter 
 * Berücksichtigung bestimmter Bedingungen vom Sparkonto abgebucht werden
 * Ein Sparkonto darf keine negativen Kontostände aufweisen. 
 * Es hat zum Unterschied zum Gehaltskonto keinen Überziehungsrahmen
 * Es kann eine individuelle Sparrate eingestellt werden, welche durch eine eigene 
 * Operation zum Kontostand dazugebucht wird
 * Beim Anlegen eines Sparkontos wird der positive Startkontostand und die positive Sparrate eingestellt
 * Beim Buchen vom Sparkonto muss berücksichtig werden, dass der Kontostand nicht negativ sein darf. 
 * Wird abgebucht, so muss anhand einer Buchung der Kontostand auf 0 reduziert werden. 
 * Abbuchungen bis 3000 sind erlaubt. Dabei kann der Kontostand auch nicht auf 0 zurück gehen
 * Die Zinsen des Sparkontos werden immer vom aktuellen Kontostand auf ein Jahr berechnet
 * Die Spesen des Sparkontos belaufen sich auf 0.1% des aktuellen Kontostandes
 * 
 * extends Konto
 * @author Michael Morandell
 *
 */
public class Sparkonto extends Konto {
	//Die für jedes Sparkonto festlegbare Sparrate
	protected double sparrate;
	
	/**
	 * Ein Sparkonto wird erstellt und die erste Zahlung wird auf das Sparkonto gebucht.
	 * Dabei ist zu berücksichtigen, dass die erste Zahlung größer als 0 sein muss. 
	 * Ist dies nicht der Fall, so darf das Sparkonto nicht angelegt werden. 
	 * Weiter wird dem Konstruktor die Höhe der Sparrate übergeben. 
	 * Auch diese muss größer als 0 sein. In beiden Fällen muss ein KontoException 
	 * geworfen werden und eine bereits für das Sparkonto reservierte Kontonummer muss wiederum freigegeben werden.
	 * @param ersteZahlung - stellt den Betrag dar, welcher beim Anlegen des Sparkontos auf das Konto gebucht werden soll
	 * @param sparrate - legt fest wie hoch die Sparrate des Kontos sein soll
	 * @throws KontoException - wird ausgelöst, wenn die Erste Zahlung oder die Sparrate nicht größer als 0 sind
	 */
	public Sparkonto(double ersteZahlung, double sparrate) throws KontoException {
		super();
		if (ersteZahlung > 0) {
			this.kontostand = ersteZahlung;
		}
		else {
			Konto.naechsteKontonummer--;
			throw new KontoException("Erste Zahlung muss groesser als 0 sein!");
		}
		if (sparrate > 0) {
			this.sparrate =  sparrate;
		}
		else {
			Konto.naechsteKontonummer--;
			throw new KontoException("Sparrate muss groesser als 0 sein!");
		}
	}
	
	/**
	 * Setzt die Sparrate für das Konto. Die zu setzende Sparrate darf nicht kleiner oder gleich 0 sein
	 * @param sparrate - die zu setzende Sparrate
	 * @throws KontoException - wenn die zu setzende Sparrate kleiner oder gleich 0 ist
	 */
	public void setSparrate(double sparrate) throws KontoException {
		if (sparrate > 0) {
			this.sparrate =  sparrate;
		}
		else {
			throw new KontoException("Sparrate muss groesser als 0 sein!");
		}
	}
	
	/**
	 * Liefert die für das Sparkonto eingestellte Sparrate zurück
	 * @return die eingestellte Sparrate
	 */
	public double getSparrate() {
		return this.sparrate;
	}
	
	/**
	 * Rechnet vom aktuellen Kontostand die Jahreszinsen aus, also jene Zinsen die für ein gesamtes Jahr anfallen
	 * Specified by: getZinsen in class Konto
	 * @return die Jahreszinsen
	 */
	@Override
	public double getZinsen() {
		double ret = 0.0;
        if (this.kontostand > 0) {
            ret = this.kontostand * (this.zinssatz / 100.0);
        }
        return ret;
	}
	
	/**
	 * Die Spesen des Sparkontos belaufen sich auf 0.1% des aktuellen Kontostandes
	 * Specified by: getSpesen in class Konto
	 * @return die Spesen des Sparkontos
	 */
	@Override
	public double getSpesen() {
		double ret = 0.0;
		if (this.kontostand > 0) {
			ret = (this.kontostand/100.0)*0.1;
		}
		return ret;
	}
	
	/**
	 * Die für das Sparkonto eingestellte Sparrate wird gebucht. 
	 * Dabei tritt kein KontoException auf weil die zu verbuchende Sparrate immer positiv ist
	 */
	public void buchenSparrate() {
		this.kontostand = this.kontostand + this.sparrate;
	}
	
	/**
	 * Bucht den übergebenen Betrag zum Sparkonto dazu bzw. vom Sparkonto ab.
	 * Dabei wird berücksichtig, dass der Kontostand nicht negativ sein darf. 
	 * Weiters darf immer nur zum Sparkonto dazugebucht werden. Wird abgebucht, 
	 * dann muss der Kontostand mit einer einzigen Buchung auf 0 zurückgesetzt werden. 
	 * Abbuchungen von bis zu 3000 sind erlaubt. Dabei kann der Kontostand auch nicht bis auf 0 zurückgehen
	 * Specified by: buchen in class Konto
	 * @param betrag - der zum Sparkonto dazugebucht bzw. abgebucht wird
	 * @throws KontoException - wird ausgelöst, wenn beim Buchen obige Bedingungen nicht eingehalten werden
	 */
	@Override
	public void buchen(double betrag) throws KontoException {
		if (this.kontostand < 0) {
			throw new KontoException("Kontostand ist negativ");
		}
		if (betrag < -3000) {
			throw new KontoException("Betrag("+betrag+") ist zu groß. Max -3000 können abgebucht werden");
		}
		if (this.kontostand + betrag < 0) {
			throw new KontoException("Der abzubuchende Betrag ist groesser als der aktuelle Kontostand: "+this.kontostand);
		}
		if (betrag < 0 && betrag != -3000 && this.kontostand+betrag != 0) {
			throw new KontoException("Abzubuchender Betrag zu klein. Kontostand muss auf 0 zurückgesetzt werden");
		}
		this.kontostand = this.kontostand + betrag;
	}
	
	/**
	 * Ausgabe der Sparkontodaten. Es wird zusätzlich noch die Sparrate ausgegeben
	 * Overrides: toString in class Konto
	 * @return die Stringentsprechung des Kontos
	 */
	@Override
	public java.lang.String toString() {
		String ret = "";
		ret = super.toString() + " Sparrate: "+ this.getSparrate();
		return ret;
	}

}
