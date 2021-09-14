package geometrischeFiguren;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GeometrischeFigurenTest extends JFrame
{
	public GeometrischeFigurenTest() {
		super("GeometrischeFigurenTest");
		setBounds(0, 0, 240, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contentPane = this.getContentPane();
		contentPane.setLayout(null);
		
		//zeichnet den Punkt
		Punkt p = new Punkt(10, 10);
		p.setFarbe(Color.RED);
		p.setBounds(10, 10, 100, 100);
		contentPane.add(p);
		
	  //zeichnet die Rechtecke
		Rechteck r = new Rechteck(35, 10, 50, 30, false);
		r.setFarbe(Color.BLUE);
		contentPane.add(r);
		Rechteck re = new Rechteck(95, 10, 50, 30, true);
		re.setFarbe(Color.BLUE);
		contentPane.add(re);
		
	  //zeichnet die Quadrate
		Quadrat qe = new Quadrat(5, 50, 60, false);
		qe.setFarbe(Color.GREEN);
		contentPane.add(qe);
		Quadrat q = new Quadrat(75, 50, 60, true);
		q.setFarbe(Color.GREEN);
		contentPane.add(q);
		
	  //zeichnet die Kreise
		Ellipse k = new Ellipse(155, 10, 50, 50, false);
		k.setFarbe(Color.ORANGE);
		contentPane.add(k);
		Ellipse ke = new Ellipse(155, 70, 50, 50, true);
		ke.setFarbe(Color.ORANGE);
		contentPane.add(ke);
		
		//zeichnet die Ellypsen
		Ellipse e = new Ellipse(10, 120, 60, 30, false);
		e.setFarbe(Color.PINK);
		contentPane.add(e);
		Ellipse ee = new Ellipse(80, 120, 60, 30, true);
		ee.setFarbe(Color.PINK);
		contentPane.add(ee);
		setVisible(true);
	}
}
