import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * 
 * @author Michael Morandell
 *
 */
public class KreisGUI extends JFrame{
	//JLabeld deklarieren
	private JLabel lr = null;
	private JLabel lu = null;
	private JLabel lf = null;
	//JTextfiled deklarieren
	private JTextField tr= null;
	private JTextField tu= null;
	private JTextField tf= null;
	//Button deklarieren
	private JButton b = null;
	
	public KreisGUI() {
		//Fenstereigenschaften gesetzt
		setTitle("Kreisberechnung");
		setBounds(10, 10, 260, 210);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		//Kreis-Objekt
		Kreis k = new Kreis();
		//Komponenten anlegen
		//Label anlegen
		lr = new JLabel("Radius:");
		lr.setBounds(20, 30, 50, 25);
		lu = new JLabel("Umfang:");
		lu.setBounds(20, 60, 50, 25);
		lf = new JLabel("Fl�che:");
		lf.setBounds(20, 90, 50, 25);
		//Textfield anlegen
		tr = new JTextField();
		tr.setBounds(80,30,160,25);
		tr.setText(String.valueOf(k.getRadius()));
		tu = new JTextField();
		tu.setBounds(80,60,160,25);
		tu.setText(String.valueOf(k.getUmfang()));
		tf = new JTextField();
		tf.setBounds(80,90,160,25);
		tf.setText(String.valueOf(k.getFl�che()));
		//Button anlegen
		b = new JButton();
		b.setText("Berechne");
		b.setBounds(20,130,220,30);
		//Komponenten zum Fenster f�gen
		Container contentPane =  getContentPane();
		contentPane.setLayout(null);
		contentPane.add(lr);
		contentPane.add(lu);
		contentPane.add(lf);
		contentPane.add(tr);
		contentPane.add(tu);
		contentPane.add(tf);
		contentPane.add(b);
		setVisible(true);
		//add action Listen
		b.addActionListener(
				new ActionListener() {
					//wenn Knopf gedr�ckt wird
					public void actionPerformed(ActionEvent ev) {
						//variable ob fehler w�hrend parsen passiert ist
						int err = 0;
						//radius wird geparst
						try {
							double r = Double.parseDouble(tr.getText());
							//wenn anders, dann wird ins Kreis-Objekt geschrieben
							if (k.getRadius() != r) {
								k.setRadius(r);
							}
							//Anonsten wird Umfang geparst
							else {
								try {
									double u = Double.parseDouble(tu.getText());
									//wenn anders, dann wird Umfang ins Kreis-Objekt geschrieben
									if (k.getUmfang() != u) {
										k.setUmfang(u);
									}
									//Ansonsten wird Fl�che geparst
									else {
										try {
											double f = Double.parseDouble(tf.getText());
											//wenn ander, dann wird Fl�che ins Kreis-Objekt geschrieben
											if (k.getFl�che() != f) {
												k.setFlaeche(f);
											} 
											//wenn parsen von fl�che fehlgeschlagen
										} catch (NumberFormatException e) {
											//ausgabe im jeweiligen Textfeld
											tf.setText("Fehler! Bitte Zahl eingeben!");
											//errorvariable wird erh�ht
											err++;
										}
									}
									//wenn parsen von Umfang fehlschl�gt
								} catch (NumberFormatException e) {
									//error-text im jeweiligen Textfeld
									tu.setText("Fehler! Bitte Zahl eingeben!");
									//errorvariable wird erh�ht
									err++;
								}
							}
							//wenn parsen von Radius fehlschl�gt
						} catch (NumberFormatException e) {
							//error-text im jeweiligen Textfeld
							tr.setText("Fehler! Bitte Zahl eingeben!");
							//errorvariable wird erh�ht
							err++;
						}
						//wenn es zu keinem Parse-Fehler gekommen ist, dann werden die berechneten Werte ausgegeben
						if(err == 0) {
							tr.setText(String.valueOf(k.getRadius()));
							tu.setText(String.valueOf(k.getUmfang()));
							tf.setText(String.valueOf(k.getFl�che()));
						}
					}
				}
		);
	}
}
