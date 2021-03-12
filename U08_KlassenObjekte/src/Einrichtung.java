
public class Einrichtung {
	public static void main(String[] args) {
		Schrank sch1 = new Schrank();
		Stuhl stu1 = new Stuhl();
		Stuhl stupol = new Stuhl();
		Polsterung p = stupol.getPolsterung();
		stu1.setAnzahlTeile(50);
		stu1.setMaterial("holz");
		stu1.setPreis(5.25);
		sch1.setAnzahlTeile(25);
		sch1.setMaterial("Holz");
		sch1.setPreis(255.45);
		stupol.setAnzahlTeile(25);
		stupol.setMaterial("holz");
		stupol.setPreis(25.99);
		p.setPolFarbe("black");
		p.setPolMaterial("Leder");
		
		System.out.println("Stuhl1 AnzahlTeile: "+stu1.getAnzahlTeile());
		System.out.println("Stuhl1 Material: "+stu1.getMaterial());
		System.out.println("Stuhl1 Preis:"+stu1.getPreis());
		
		System.out.println("Schrank AnzahlTeile: "+sch1.getAnzahlTeile());
		System.out.println("Schrank Material: "+sch1.getMaterial());
		System.out.println("Schrank Preis:"+sch1.getPreis());
		
		System.out.println("StuhlMitPolsterung AnzahlTeile: "+stupol.getAnzahlTeile());
		System.out.println("StuhlMitPolsterung Material: "+stupol.getMaterial());
		System.out.println("StuhlMitPolsterung Preis: "+stupol.getPreis());
		System.out.println("Polsterung Farbe: "+p.getPolFarbe());
		System.out.println("Polsterung Material: "+p.getPolMaterial());
		
		//test der clone-Methode
		Stuhl stuhlneu = stupol.clone();
		System.out.println("Clone: ");
		System.out.println("schrank1: "+stupol);
		System.out.println("copy: "+stuhlneu);
		System.out.println("Schrank AnzahlTeile: "+stupol.getAnzahlTeile());
		System.out.println("Schrank Material: "+sch1.getMaterial());
		System.out.println("Schrank Preis:"+stupol.getPreis());
		
		//test der equals-Methode
		System.out.println(stuhlneu.equals(stupol));
		
		//test der compareTo-Methode
		System.out.println(stuhlneu.compareTo(stupol));
		
		//Polsterung
		Polsterung polst = p.clone();
		System.out.println("\npolster: " +p);
		System.out.println("copy: " +polst);
		System.out.println("Material: "+polst.getPolMaterial());
		System.out.println("Farbe: "+polst.getPolFarbe());
		
		//test der equals-Methode
		System.out.println(polst.equals(p));
		
		//test der compareTo-Methode
		System.out.println(polst.compareTo(p));
		
	}
	
}

