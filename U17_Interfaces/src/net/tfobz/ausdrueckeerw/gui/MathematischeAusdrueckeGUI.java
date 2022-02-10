package net.tfobz.ausdrueckeerw.gui;
import java.awt.Dimension;
import net.tfobz.ausdrueckeerw.*;
import java.awt.Toolkit;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.tree.*;

/**
 * MathematischeAusdrueckeGUI
 * realisiert eine GUI welche durch eine Baumstruktur (JTree),
 * mathematische Ausdruecke anzeigt.
 * erbt von JFrame
 * @author Michael Morandell
 *
 */
@SuppressWarnings("serial")
public class MathematischeAusdrueckeGUI extends JFrame {
	//JTree
	private JTree jTree = null;
	private JScrollPane pane = null;
	private JPopupMenu popupmenu = null;
	//Menus
	private JMenu neu = null;
	private JMenuItem konstante = null;
	private JMenuItem addition = null;
	private JMenuItem subtraktion = null;
	private JMenuItem division = null;
	private JMenuItem multiplikation = null;
	private JMenuItem loeschen = null;
	private JMenuItem vertauschen = null;
	
	/**
	 * MathematischeAusdruecke-Constructor
	 */
	public MathematischeAusdrueckeGUI() {
		//exit on close
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
		
		//Popupmenu
		popupmenu = new JPopupMenu();
		
		//menuItemListener
		MenuItemListener menulistener = new MenuItemListener();
		
		//Neu-Menu
		neu = new JMenu("Neu");
		popupmenu.add(neu);
		
		//Konstante
		konstante = new JMenuItem("Konstante");
	    konstante.addActionListener(menulistener);
	    neu.add(konstante);
	    
	    //Addition
	    addition = new JMenuItem("Addition");
	    addition.addActionListener(menulistener);
	    neu.add(addition);
	    
	    //Subtraktion
	    subtraktion = new JMenuItem("Subtraktion");
	    subtraktion.addActionListener(menulistener);
	    neu.add(subtraktion);
	    
	    //Multiplikation
	    multiplikation = new JMenuItem("Multiplikation");
	    multiplikation.addActionListener(menulistener);
	    neu.add(multiplikation);
	    
	    //Division
	    division = new JMenuItem("Division");
	    division.addActionListener(menulistener);
	    neu.add(division);
	    
	    //Loeschen
	    loeschen = new JMenuItem("Löschen");
	    loeschen.addActionListener(menulistener);
	    popupmenu.add(loeschen);
	    
	    //Vertauschen
	    vertauschen = new JMenuItem("Vertauschen");
	    vertauschen.addActionListener(menulistener);
	    popupmenu.add(vertauschen);
		
	    //unsichtbares Wurzel-Objekt
		DefaultMutableTreeNode wurzel = new DefaultMutableTreeNode("unsichtbareWurzel");
		//DefaultTreeModel
		TreeModel treeModel = new DefaultTreeModel(wurzel);
		//MeinCellRenderer
		TreeCellRenderer meinRenderer = new MeinTreeCellRenderer();
		//JTree
        jTree = new JTree(treeModel);
        jTree.setCellRenderer(meinRenderer);
        //jtree-elemente editierbar
        jTree.setEditable(true);
        //wurzel unsichtbar
        jTree.setRootVisible(false);
        //mouse-listener für jtree
        jTree.addMouseListener(new MousePopupmenuListener());
        //Scrollpane
		pane = new JScrollPane(jTree);
		pane.setBounds(5, 5, this.getWidth()-15, this.getHeight()-45);
		this.getContentPane().add(pane);
	}
	
	/**
	 * MousePopopmenuListener
	 * reagiert auf das betaetigen der rechten Maustaste und oeffnet das Popup-Menu
	 * erbt von MouseAdapter
	 * @author Michael Morandell
	 *
	 */
	private class MousePopupmenuListener extends MouseAdapter {
		/**
		 * mouseReleased
		 * @param e, MouseEvent
		 */
		@Override
		public void mouseReleased(MouseEvent e) {
			//Wenn popup-trigger
            if (e.isPopupTrigger()) {
            	//naehestes Element wird gesucht
                TreePath path = jTree.getClosestPathForLocation(e.getX(), e.getY());
                if (path != null) {
                    jTree.setSelectionPath(path);
                }
                //menu wird an dieser Stelle geoeffnet und angezeigt
                popupmenu.show(e.getComponent(), e.getX(), e.getY());
            }
        }
	}
	
	/**
	 * MenuItemListener
	 * reagiert auf das druecken eines Menu-Items des Popupmenus
	 * implementiert ActionListener
	 * @author Michael Morandell
	 *
	 */
	private class MenuItemListener implements ActionListener {
		/**
		 * actionPerformed
		 * @param e, ActionEvent
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			
			//Wenn Konstante
			if (e.getSource().equals(konstante)) {
				DefaultTreeModel treeModel = (DefaultTreeModel)jTree.getModel();
				if (jTree.getSelectionPath() == null) {
					// Hänge neuen Knoten zur Wurzel
					DefaultMutableTreeNode wurzel = ((DefaultMutableTreeNode)treeModel.getRoot());
					if (wurzel.getChildCount() == 0) {
						treeModel.insertNodeInto(new Konstante(),wurzel,0);
						// Muss gemacht werden, ansonsten wird neuer Knoten nicht angezeigt
						treeModel.reload();
					}
				} 
				else {
				// Hänge neuen Knoten zum ausgewählten Knoten
				MutableTreeNode treeNode = ((MutableTreeNode)jTree.getSelectionPath().getLastPathComponent());
					if (treeNode instanceof Operation && ((Operation)treeNode).getChildCount()<2) {
						treeModel.insertNodeInto(new Konstante(),treeNode,0);
						TreePath treePath = jTree.getSelectionPath();
						treeModel.reload();
						// Damit wird ausgewählter Knoten aufgeklappt
						jTree.expandPath(treePath);
					}
				}
			}
			
			//Wenn Addition
			if (e.getSource().equals(addition)) {
				DefaultTreeModel treeModel = (DefaultTreeModel)jTree.getModel();
				if (jTree.getSelectionPath() == null) {
					// Hänge neuen Knoten zur Wurzel
					DefaultMutableTreeNode wurzel = ((DefaultMutableTreeNode)treeModel.getRoot());
					if (wurzel.getChildCount() == 0) {
						treeModel.insertNodeInto(new Addition(),wurzel,0);
						// Muss gemacht werden, ansonsten wird neuer Knoten nicht angezeigt
						treeModel.reload();
					}
				} 
				else {
					// Hänge neuen Knoten zum ausgewählten Knoten
					MutableTreeNode treeNode = ((MutableTreeNode)jTree.getSelectionPath().getLastPathComponent());
					if (treeNode instanceof Operation && ((Operation)treeNode).getChildCount()<2) {
						treeModel.insertNodeInto(new Addition(),treeNode,0);
						TreePath treePath = jTree.getSelectionPath();
						treeModel.reload();
						// Damit wird ausgewählter Knoten aufgeklappt
						jTree.expandPath(treePath);
					}
				}
			}
			
			//Wenn Subtraktion
			if (e.getSource().equals(subtraktion)) {
				DefaultTreeModel treeModel = (DefaultTreeModel)jTree.getModel();
				if (jTree.getSelectionPath() == null) {
					// Hänge neuen Knoten zur Wurzel
					DefaultMutableTreeNode wurzel = ((DefaultMutableTreeNode)treeModel.getRoot());
					if (wurzel.getChildCount() == 0) {
						treeModel.insertNodeInto(new Subtraktion(),wurzel,0);
						// Muss gemacht werden, ansonsten wird neuer Knoten nicht angezeigt
						treeModel.reload();
					}
				} 
				else {
					// Hänge neuen Knoten zum ausgewählten Knoten
					MutableTreeNode treeNode = ((MutableTreeNode)jTree.getSelectionPath().getLastPathComponent());
					if (treeNode instanceof Operation && ((Operation)treeNode).getChildCount()<2) {
						treeModel.insertNodeInto(new Subtraktion(),treeNode,0);
						TreePath treePath = jTree.getSelectionPath();
						treeModel.reload();
						// Damit wird ausgewählter Knoten aufgeklappt
						jTree.expandPath(treePath);
					}
				}
			}
			
			//Wenn Multiplikation
			if (e.getSource().equals(multiplikation)) {
				DefaultTreeModel treeModel = (DefaultTreeModel)jTree.getModel();
				if (jTree.getSelectionPath() == null) {
					// Hänge neuen Knoten zur Wurzel
					DefaultMutableTreeNode wurzel = ((DefaultMutableTreeNode)treeModel.getRoot());
					if (wurzel.getChildCount() == 0) {
						treeModel.insertNodeInto(new Multiplikation(),wurzel,0);
						// Muss gemacht werden, ansonsten wird neuer Knoten nicht angezeigt
						treeModel.reload();
					}
				} 
				else {
					// Hänge neuen Knoten zum ausgewählten Knoten
					MutableTreeNode treeNode = ((MutableTreeNode)jTree.getSelectionPath().getLastPathComponent());
					if (treeNode instanceof Operation && ((Operation)treeNode).getChildCount()<2) {
						treeModel.insertNodeInto(new Multiplikation(),treeNode,0);
						TreePath treePath = jTree.getSelectionPath();
						treeModel.reload();
						// Damit wird ausgewählter Knoten aufgeklappt
						jTree.expandPath(treePath);
					}
				}
			}
			
			//Wenn Division
			if (e.getSource().equals(division)) {
				DefaultTreeModel treeModel = (DefaultTreeModel)jTree.getModel();
				if (jTree.getSelectionPath() == null) {
					// Hänge neuen Knoten zur Wurzel
					DefaultMutableTreeNode wurzel = ((DefaultMutableTreeNode)treeModel.getRoot());
					if (wurzel.getChildCount() == 0) {
						treeModel.insertNodeInto(new Division(),wurzel,0);
						// Muss gemacht werden, ansonsten wird neuer Knoten nicht angezeigt
						treeModel.reload();
					}
				} 
				else {
					// Hänge neuen Knoten zum ausgewählten Knoten
					MutableTreeNode treeNode = ((MutableTreeNode)jTree.getSelectionPath().getLastPathComponent());
					if (treeNode instanceof Operation && ((Operation)treeNode).getChildCount()<2) {
						treeModel.insertNodeInto(new Division(),treeNode,0);
						TreePath treePath = jTree.getSelectionPath();
						treeModel.reload();
						// Damit wird ausgewählter Knoten aufgeklappt
						jTree.expandPath(treePath);
					}
				}
			}
			
			//Wenn Loeschen
			if (e.getSource().equals(loeschen)) {
				DefaultTreeModel treeModel = (DefaultTreeModel)jTree.getModel();
				if (jTree.getSelectionPath() != null) {
					//treeNode wird geholt
					MutableTreeNode treeNode = ((MutableTreeNode)jTree.getSelectionPath().getLastPathComponent());
					//Wenn TreeNode eine Konstante ist
					if (treeNode instanceof Konstante) {
						//parent wird geholt
						MutableTreeNode parent = ((MutableTreeNode)jTree.getSelectionPath().getParentPath().getLastPathComponent());
						//Wenn Parent eine Operation ist
						if (parent instanceof Operation) {
							//kind wird vom parent geloescht
							((Operation) parent).loescheOperand(parent.getIndex(treeNode));
						}
						//Ansonsten ist es die Wurzel
						else {
							DefaultMutableTreeNode wurzel = ((DefaultMutableTreeNode)treeModel.getRoot());
							//alles wird geloescht
							wurzel.removeAllChildren();
						}
					}
					//Wenn TreeNode keine Konstante, aber eine Operation ist
					else {
						if (treeNode instanceof  Operation) {
							//Operation wird vom Parent geloescht
							treeModel.removeNodeFromParent(treeNode);
						}
					}
					//reload zum Anzeigen der Aenderungen
					treeModel.reload();
					// Damit wird ausgewählter Knoten aufgeklappt
					for (int i = 0; i < jTree.getRowCount(); i++) {
                        jTree.expandRow(i);
                    }
				}
			}
			//vertauschen
			if (e.getSource().equals(vertauschen)) {
                DefaultTreeModel treeModel = (DefaultTreeModel)jTree.getModel();
                if (jTree.getSelectionPath() != null) {
                	//Last Component
                    MutableTreeNode treeNode = ((MutableTreeNode)jTree.getSelectionPath().getLastPathComponent());
                    //Wenn das TreeNode eine Operation ist
                    if (treeNode instanceof Operation) {
                    	//vertausche Methode der Klasse Operation wird angewendet
                        ((Operation) treeNode).vertausche();
                        //TreePath wird geholt
                        TreePath treePath = jTree.getSelectionPath();
                        treeModel.reload();
                        // Damit wird ausgewählter Knoten aufgeklappt
                        jTree.expandPath(treePath);
                    }
                }
			}
		}
	}
}