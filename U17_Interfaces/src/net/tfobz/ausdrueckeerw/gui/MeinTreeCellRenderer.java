package net.tfobz.ausdrueckeerw.gui;
import java.awt.Component;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeNode;
import net.tfobz.ausdrueckeerw.*;

/**
 * MeinTreeCellRenderer
 * rendert die Icon fuer die TreeNodes
 * erbt von DefaultTreeCellRenderer
 * @author Michael Morandell
 *
 */
public class MeinTreeCellRenderer extends DefaultTreeCellRenderer {
	//iconName
	String iconName = null;
	
	/**
	 * getTreeCellRendererComponent
	 * @param JTree tree, Object value, boolean selected, 
	 * 		boolean expanded, boolean leaf, int row, boolean hasFocus
	 * @return Component
	 */
	@Override
	public Component getTreeCellRendererComponent(JTree tree, Object value,
			boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
		Component ret = null;
		//Super-Konstruktor
		ret = super.getTreeCellRendererComponent(tree, value, selected, expanded, leaf, row, hasFocus);
		//Tree Node wird geholt
		TreeNode node = (TreeNode)value;
		//Konstante-Icon
		if (node instanceof Konstante) {
			iconName = "konstante.gif";
		}
		//Addition-Icon
		if (node instanceof Addition) {
			iconName = "addition.gif";
		}
		//Subtraktion-Icon
		if (node instanceof Subtraktion) {
			iconName = "subtraktion.gif";
		}
		//Multiplikation-Icon
		if (node instanceof Multiplikation) {
			iconName = "multiplikation.gif";
		}
		//Division-Icon
		if (node instanceof Division) {
			iconName = "division.gif";
		}
		//wenn icon ausgewaehlt wirde
		if (iconName != null) {
			//wenn icon gefunden wird
			URL imageUrl = getClass().getResource(iconName);
			if (imageUrl != null) {
				//setzen des Icons
				this.setIcon(new ImageIcon(imageUrl));
			}
			else {
				//Fehlermeldung
				System.out.println("[MeinTreeCellRenderer] Icon not found: "+iconName);
			}
		}
		return ret;
	}
}