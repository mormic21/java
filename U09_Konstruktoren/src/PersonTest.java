/**
 * Testprogramm für die Klasse Person.java
 * @author Michael Morandell
 *
 */
public class PersonTest {
	/**
	 * Main-Methode
	 * @param args
	 */
	public static void main(String[] args) {
		//Abbildung des Stammbaums im Speicher mittels Objekt-Instanziierung
		Person annaHuber = new Person("Anna", "Huber", true);
		Person ediGreif = new Person("Edi", "Greif", false);
		Person bertaGreif = new Person("Berta", "Greif", true, annaHuber, ediGreif);
		Person resiRüpel = new Person("Resi", "Rüpel", true);
		Person martinSeeber = new Person("Martin", "Seeber", false);
		Person hansSeeber = new Person("Hans", "Seeber", false, resiRüpel, martinSeeber);
		Person annaSeeber = new Person("Anna", "Seeber", true, bertaGreif, hansSeeber);
		Person eddaHuber = new Person("Edda", "Huber", true);
		Person erwinPircher = new Person("Erwin", "Pircher", false);
		Person elsaPircher = new Person("Elsa", "Pircher", true, eddaHuber, erwinPircher);
		Person astridPrenn = new Person("Astrid", "Prenn", true);
		Person franzAmonn = new Person("Franz", "Amonn", false);
		Person seppAmonn = new Person("Sepp", "Amonn", false, astridPrenn, franzAmonn);
		Person rudiAmonn = new Person("Rudi", "Amonn", false, elsaPircher, seppAmonn);
		Person adamAmonn = new Person("Adam", "Amonn", false, annaSeeber, rudiAmonn);
		//Vater von Adam Amonn suchen
		System.out.println("Vater von Adam Amonn: "+adamAmonn.getVater().getName());
		//Großvater mütterlicherseits von Rudi Amonn finden
		System.out.println("Großvater mütterlicherseits von Rudi Amonn: "+rudiAmonn.getMutter().getVater().getName());
		//Eltern von Adam Amonn
		System.out.println("Eltern von Adam Amonn: ");
		Person [] eltern = adamAmonn.getEltern();
		System.out.println(eltern[0]);
		System.out.println(eltern[1]);
		//Großeltern von Adam Amonn
		System.out.println("Großeltern von Adam Amonn");
		Person [] greltern = adamAmonn.getGrosseltern();
		System.out.println(greltern[0]);
		System.out.println(greltern[1]);
		System.out.println(greltern[2]);
		System.out.println(greltern[3]);
		//Alle Vorfahren als Liste
		System.out.println("Liste");
		System.out.println(adamAmonn.getListe());
		
		
	}

}
