package net.tfobz.listen;

/**
 * MeineDefaultListe
 * @author Michael Morandell
 *
 */
public class MeineDefaultListe implements MeineListe {
	private ListenElement erstesElem = null;

	// Lokale Klasse
	class ListenElement extends Object
	{
		private Object element = null;
		private ListenElement naechstesElem = null;
		private ListenElement(
			Object element, ListenElement naechstesElem) {
			this.element = element;
			this.naechstesElem = naechstesElem;
		}
	}

	public boolean einfuegenErstesElement(Object element) {
		boolean ret = false;
		if (element != null) {
			ret = true;
			this.erstesElem = new ListenElement(element, erstesElem);
		}
		return ret;
	}

	public boolean loeschenErstesElement() {
		boolean ret = false;
		if (erstesElem != null) {
			ret = true;
			this.erstesElem = this.erstesElem.naechstesElem;
		}
		return ret;
	}

	public boolean istLeer() {
		return this.erstesElem == null;
	}

	public void leeren() {
		this.erstesElem = null;
	}

	public MeinIterator elemente() {
		// Anonyme Klasse
		return new MeinIterator() {

			private ListenElement aktuellesElem = null;

			public boolean hatNaechstesElement() {
				boolean ret = false;
				if (this.aktuellesElem == null)
					ret = MeineDefaultListe.this.erstesElem != null;
				else
					ret = this.aktuellesElem.naechstesElem != null;
				return ret;
			}

			public Object naechstesElement() {
				Object ret = null;
				if (this.aktuellesElem == null) {
					if (MeineDefaultListe.this.erstesElem != null) {
						this.aktuellesElem=MeineDefaultListe.this.erstesElem;
						ret = this.aktuellesElem.element;
					}
				} else
					if (this.aktuellesElem.naechstesElem == null) 
						this.aktuellesElem = null; 
					else {
						this.aktuellesElem = this.aktuellesElem.naechstesElem;
						ret = this.aktuellesElem.element;
					}
				return ret;
			}

			public boolean einfuegenElement(Object element) {
				boolean ret = false;
				if (element != null) {
					ret = true;
					if (this.aktuellesElem == null) {
						MeineDefaultListe.this.erstesElem = new ListenElement(element,
							MeineDefaultListe.this.erstesElem);
						this.aktuellesElem = MeineDefaultListe.this.erstesElem;
					} else {
						this.aktuellesElem.naechstesElem = 
							new ListenElement(element,this.aktuellesElem.naechstesElem);
						this.aktuellesElem = this.aktuellesElem.naechstesElem;
					}
				}
				return ret;
			}

			/**
			 * Setzt das Element auf welchem momentan der Iterator zeigt, indem es das in der 
			 * Liste vorhandene Element mit dem übergebenen Element ersetzt. Die Position des 
			 * Iterators wird dabei nicht verändert.
			 * @param element das zu setzen ist
			 * @return false falls das übergebene Element null ist oder kein aktuelles Element 
			 * angesprungen wurde
			 */
			public boolean setzenAktuellesElement(Object element) {
				boolean ret = false;
                if (element != null && this.aktuellesElem != null) {
                	//element wird an stelle gesetzt
                	this.aktuellesElem.element = element;
                	ret = true;
                }
                return ret;
			}

			/**
			 * Löscht das Element, welches momentan das aktuelle Element des Iterators ist. Beim 
			 * Löschen des aktuellen Elementes wird als neues aktuelles Element jenes Element 
			 * genommen, welches nach dem zu löschenden Element steht. Dabei wird von dieser 
			 * Methode der Iterator so gesetzt, dass der nachfolgende Aufruf von naechstesElement() 
			 * dieses Element zurückliefert. 
			 * @return false falls es noch kein aktuelles Element gibt, das gelöscht werden könnte
			 */
			public boolean loeschenAktuellesElement() {
				boolean ret = false;
				//solang der iterator gesetzt ist
				if (this.aktuellesElem != null) {
					//zu löschendes Element
					ListenElement deleted = this.aktuellesElem;
					//vorheriges Element
					ListenElement before = MeineDefaultListe.this.erstesElem;
					//wenn zu löschendes Element das erste Listenelement ist
					if (deleted == before) {
						//Wenn in der Liste noch andere Elemente enthält
						if (MeineDefaultListe.this.erstesElem.naechstesElem != null) {
							//das neue aktuelle Element ist das erste Element
							this.aktuellesElem = MeineDefaultListe.this.erstesElem;
							//erstes Element wird geloescht
							loeschenErstesElement();
						}
						//Wenn erstes Element das einzige in der Liste ist
						else {
							//Liste wird geleert
							leeren();
							this.aktuellesElem = null;
						}
					}
					//Wenn das zu löschende Element nicht das 1. Element ist
					else {
						//das vorherige Element wird bestimmt
						while (before != null && before.naechstesElem != deleted) {
							before = before.naechstesElem;
						}
						//das naechste Element ist das Element nach dem geloeschten Element
						before.naechstesElem = deleted.naechstesElem;
						//Iterator wird auf das Element davor gesetzt
						this.aktuellesElem = before;
					}
					//Erfolgreich
					ret = true;
				}
				//return
				return ret;
			}
		};
	}
}