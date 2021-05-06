
public class SonglisteTest {

	public static void main(String[] args) {
		Songliste s = new Songliste(650);
		Song a = new Song();
		a.setSong("qwertz;qwerty;abc;1234");
		s.setPfad("D:\\Laraib\\TFO_Max_Valier_Bozen\\3InfB\\Informatik\\EclipseDownload\\Info\\Work\\U09TeamarbeitSongliste\\src\\tracklist.csv");
		System.out.println("1.lesen: "+s.lesenSongs());
		System.out.println("2.getAnzahl: "+s.getAnzahl());
		System.out.println("3.getVorheriger: "+s.getVoriger());
		System.out.println("4.getAktueller: "+s.getAktueller());
		System.out.println("5.getNaechster: "+s.getNaechster());
		System.out.println("6.getLetzterer: "+s.getLetzter());
		System.out.println("7.getMaxAnzahl: "+s.getMaxAnzahl());
		
		System.out.println("10.getErsterer: "+s.getErster());
		System.out.println("11.l�sche Aktuellen: "+s.loeschenAktuellen());
		System.out.println("getAktueller: "+s.getAktueller());
		
		System.out.println("getNaechster: "+s.getNaechster());
		System.out.println("11.l�sche Aktuellen: "+s.loeschenAktuellen());
		System.out.println("getAktueller: "+s.getAktueller());
		
		System.out.println("6.getLetzterer: "+s.getLetzter());
		System.out.println("11.l�sche Aktuellen: "+s.loeschenAktuellen());
		System.out.println("getAktueller: "+s.getAktueller());
		
		System.out.println("12.l�sche Alle: "+s.loeschenAlle());
		System.out.println("getAktueller: "+s.getAktueller());
		//System.out.println("getAnzahl: "+s.getAnzahl());
		//System.out.println("8.anf�genNeuen: " + s.anfuegenNeuen(a));
		//System.out.println("getAktueller: "+s.getAktueller());
		//System.out.println("getAnzahl: "+s.getAnzahl());
		//System.out.println("getMaxAnzahl: "+s.getMaxAnzahl());
		System.out.println("9.schreiben: "+s.schreibenSongs());

	}

}
