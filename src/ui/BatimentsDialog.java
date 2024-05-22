package ui;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

import jeu.batiments.TypesBatiments;
import jeu.peuples.*;
import jeu.pouvoirs.*;
import jeu.Combinaison;
import jeu.JeuProxy;

import ui.views.CaseView;
import ui.utils.ImageFactory;


public class BatimentsDialog extends JDialog {

    /** La case de la page de dialogue. */
    private CaseView caseSelectionnee;

    /**
     * Construire le dialogue du choix du batiment à mettre sur la case.
     * @param parent La frame qui a appelé cette fenêtre.
     * @param caseSelect La case sur laquelle on souhaite mettre un batiment.
     */
    public BatimentsDialog(JFrame parent, CaseView caseSelect) {
        super(parent, "Choix du bâtiment à poser", true);
        if (parent == null)
            throw new IllegalArgumentException("parent ne doit pas être null.");
        else if (caseSelect == null)
            throw new IllegalArgumentException("caseSelect ne doit pas être null.");
        this.caseSelectionnee = caseSelect;
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		//largeur			//hauteur
        this.setSize(200, 800);
		// Centre la fenêtre par rapport à son parent
        this.setLocationRelativeTo(parent);

		// Un GridLayout avec une colonne pour les 4 boutons (4 batiments)
        JPanel fenetrePanel = new JPanel(new GridLayout(4, 1));

        // Ajouter un bouton pour chaque type de bâtiment
        // Bouton pour CAMPEMENT
        JButton buttonCampement = new JButton(TypesBatiments.CAMPEMENT.toString());
        buttonCampement.setIcon(new ImageIcon(ImageFactory.batimentsImage(TypesBatiments.CAMPEMENT)));
        buttonCampement.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                placerBatiment(TypesBatiments.CAMPEMENT);
            }
        });
        buttonCampement.setEnabled(false);

        // Bouton pour FORTERESSE
        JButton buttonForteresse = new JButton(TypesBatiments.FORTERESSE.toString());
        buttonForteresse.setIcon(new ImageIcon(ImageFactory.batimentsImage(TypesBatiments.FORTERESSE)));
        buttonForteresse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                placerBatiment(TypesBatiments.FORTERESSE);
            }
        });
        buttonForteresse.setEnabled(false);

        // Bouton pour ANTRE_DE_TROLL
        JButton buttonAntreDeTroll = new JButton(TypesBatiments.ANTRE_DE_TROLL.toString());
        buttonAntreDeTroll.setIcon(new ImageIcon(ImageFactory.batimentsImage(TypesBatiments.ANTRE_DE_TROLL)));
        buttonAntreDeTroll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                placerBatiment(TypesBatiments.ANTRE_DE_TROLL);
            }
        });
        buttonAntreDeTroll.setEnabled(false);

        // Bouton pour TANIERE
        JButton buttonTaniere = new JButton(TypesBatiments.TANIERE.toString());
        buttonTaniere.setIcon(new ImageIcon(ImageFactory.batimentsImage(TypesBatiments.TANIERE)));
        buttonTaniere.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                placerBatiment(TypesBatiments.TANIERE);
            }
        });
        buttonTaniere.setEnabled(false);

        //Condition de qui peut placer quel batiment
        if (peuple.getType() == TypesPeuples.MIPORTIONS){
            buttonTaniere.setEnabled(true);
        } else if (peuple.getType() == TypesPeuples.TROLLS){
            buttonAntreDeTroll.setEnabled(true);
        } else if (pouvoir.getType() == TypesPouvoirs.BATISSEURS){
            buttonForteresse.setEnabled(true);
        } else if (pouvoir.getType() == TypesPouvoirs.SCOUTS){
            buttonCampement.setEnabled(true);
        }

        fenetrePanel.add(buttonAntreDeTroll);
        fenetrePanel.add(buttonTaniere);
        fenetrePanel.add(buttonForteresse);
        fenetrePanel.add(buttonCampement);
        getContentPane().add(fenetrePanel, BorderLayout.CENTER);

    } 

	/**
     * Place le batiment sélectionné sur la Case.
     * @param typeBat Batiment à placé sur la case
     */
    private void placerBatiment(TypesBatiments typeBat) {
        if (typeBat == null)
            throw new IllegalArgumentException("le type de Batiment ne doit pas être null.");
        caseSelectionnee.getVraieCase().setTypeBatiment(typeBat, 1);
		// Ferme la fenêtre de dialogue après avoir placé le bâtiment
        dispose();
    }
}
