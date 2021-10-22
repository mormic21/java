package net.tfobz.ratenrechner;

public class test {
	
	public static void main(String[] args) {
		RatenRechner r = new RatenRechner();
		r.setNachschuessig(true);
		try {
			r.setBarwert("50000.0");
			r.setJahreszinssatz("5.0");
			r.setLaufzeitInJahren("10.0");
			r.setRate("530.33");
			r.setRatenProJahr("12");
			r.getTilgungsplan();
		} catch (RatenRechnerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
