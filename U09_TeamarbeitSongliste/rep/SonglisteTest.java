
public class SonglisteTest {

	public static void main(String[] args) {
		Songliste s = new Songliste(612);
		Song a = new Song();
		a.setSong("LOL;fsefaef;Fesafaf;1234");
		s.setPfad("C:\\Users\\elija\\Desktop\\tracklist.csv");
		System.out.println(s.lesenSongs());
		System.out.println(s.getAktueller());
		System.out.println(s.getLetzter());
		System.out.println(s.getMaxAnzahl());
		System.out.println(s.getAnzahl());
		System.out.println("Einfügen: " + s.anfuegenNeuen(a));
		System.out.println(s.getAktueller());
		System.out.println(s.getAnzahl());
		System.out.println(s.getMaxAnzahl());

	}

}
