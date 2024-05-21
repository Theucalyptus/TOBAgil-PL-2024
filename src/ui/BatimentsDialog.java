package ui;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

import jeu.batiments.TypesBatiments;

import ui.views.CaseView;
import ui.utils.ImageFactory;

public class BatimentsDialog extends JDialog {

    /** La case de la page de dialogue. */
    private CaseView caseSelectionnee;

    public BatimentsDialog(JFrame parent, CaseView caseSelect) {
        super(parent, "Choix du bâtiment à poser", true);
        this.caseSelectionnee = caseSelect;
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		//largeur			//hauteur
        this.setSize(200, 800);
		// Centre la fenêtre par rapport à son parent
        this.setLocationRelativeTo(parent);

		// Un GridLayout avec une colonne pour les 4 boutons (4 batiments)
        JPanel fenetrePanel = new JPanel(new GridLayout(4, 1));

        // Ajouter un bouton pour chaque type de bâtiment
        for (TypesBatiments typeBat : TypesBatiments.values()) {
            if (typeBat != TypesBatiments.AUCUN) {
                JButton button = new JButton(typeBat.toString());
			    button.setIcon(new ImageIcon(ImageFactory.batimentsImage(typeBat)));
                button.addActionListener(new ActionListener() {
				    //Permet de mettre une action différente pour chaque boutons
                    @Override
                    public void actionPerformed(ActionEvent e) {
					    // Placez le bâtiment sélectionné sur la case sélectionnée
                        placerBatiment(typeBat);
                    }
                });
                fenetrePanel.add(button);
            }
            getContentPane().add(fenetrePanel, BorderLayout.CENTER);
        }
    }

	/**
     * Place le batiment sélectionné sur la Case.
     * @param typeBat Batiment à placé sur la case
     */
    private void placerBatiment(TypesBatiments typeBat) {
        caseSelectionnee.getVraieCase().setTypeBatiment(typeBat, 1);
		// Ferme la fenêtre de dialogue après avoir placé le bâtiment
        dispose();
    }
}
