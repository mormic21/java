/**
 * Testprogramm für die Klasse Quadrat.java
 * @author Michael Morandell
 *
 */
public class QuadratProgramm {
	//main
	public static void main(String[] args) {
		//Objekt-Array vom Typ Quadrat
		Quadrat [] q = new Quadrat[50];
		//Initialisierung
		double value = 0;
		int index = 0;
		//Instanziierung der einzelnen Quadrat-Ojekten und füllung mit unterschiedlichen Werten
		for(int i = 0; i < q.length; i++) {
			q[i] = new Quadrat();
			q[i].setSeiteA(Math.random()*(10));
			//Ermittlung des Quadrats mit der längsten SeiteA
			if ((q[i].getSeiteA() - value) > 0) {
				value =  q[i].getSeiteA();
				index = i;
			}
		}
		//Ausgabe der größten Quadrats	
		System.out.println(q[index].toString());
	}
}
