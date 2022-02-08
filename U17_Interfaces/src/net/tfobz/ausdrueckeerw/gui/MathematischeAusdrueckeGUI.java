package net.tfobz.ausdrueckeerw.gui;
import java.awt.Dimension;
import net.tfobz.ausdrueckeerw.*;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.*;

/**
 * MathematischeAusdrueckeGUI
 * realisiert eine GUI welche durch eine Baumstruktur (JTree),
 * mathematische Ausdruecke anzeigt.
 * erbt von JFrame
 * @author Michael Morandell
 *
 */
public class MathematischeAusdrueckeGUI extends JFrame {
	//JTree
	private JTree jTree = null;
	private JScrollPane pane = null;
	
	/**
	 * MathematischeAusdruecke-Constructor
	 */
	public MathematischeAusdrueckeGUI() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//berechnung der bounds
		int height = 550;
		int width = 680;
		Dimension screen_size = Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds((screen_size.width - width) / 2, (screen_size.height - height) / 2, width, height);
		//nicht resizable
		this.setResizable(false);
		//titel
		this.setTitle("Mathematische Ausdrücke");
		//layoutmanager null
		this.getContentPane().setLayout(null);
		
		//TreeNode wird angelegt, mit dem Mathematischen Ausdruck
//		TreeNode k = new Potenz(
//						new Division(
//								new Multiplikation(
//										new Konstante(3),
//										new Potenz(
//												new Addition(
//														new Konstante(6), 
//														new Konstante(7)
//												), 
//												new Konstante(5)
//										)
//								),
//								new Logarithmus(
//										new Argument(10),
//										new Wurzel(
//												new Argument(2),
//												new Addition(
//														new Division(
//																new Konstante(70), 
//																new Konstante(4)
//														),
//														new Division(
//																new Konstante(990), 
//																new Konstante(8)
//														)
//												)
//										)
//								)
//						),
//				new Konstante(4)
//		);
		TreeNode k = new Division(
				new Multiplikation(
						new Konstante(2), 
						new Addition(
								new Konstante(3), 
								new Konstante(4))), 
				new Subtraktion(
						new Konstante(7), 
						new Konstante(2)));
		//TreeNode wird dem default Model übergeben
		TreeModel treeModel = new DefaultTreeModel(k);
		//Neues JTree mit dem default-Model
		jTree = new JTree(treeModel);
		TreeCellRenderer meinRenderer = new MeinTreeCellRenderer();
		jTree.setCellRenderer(meinRenderer);
		pane = new JScrollPane(jTree);
		pane.setBounds(5, 5, this.getWidth()-15, this.getHeight()-45);
		
		this.getContentPane().add(pane);
	}
}
