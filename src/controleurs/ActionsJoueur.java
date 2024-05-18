package controleurs;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

import jeu.Combinaison;
import jeu.Jeu;
import jeu.Joueur;
import jeu.JoueurState;

import ui.selecteur.Selecteur;
import ui.views.CaseView;

import java.util.Observer;
import javax.swing.SwingUtilities;
import ui.BatimentsDialog;

@SuppressWarnings("deprecation")
public class ActionsJoueur extends JPanel implements Observer {

	/**Le jeu dans lequel le joueur est. */
	private Jeu jeu;

	/**Le sélecteur de case du jeu. */
	private Selecteur<CaseView> selecteurCase;
	private Selecteur<Combinaison> selecteurCombinaison;

	// Les boutons disponibles.
	/**Bouton declin. */
	private JButton declinBtn;
	/**Bouton ajouterBatiment. */
	private JButton ajouterBatimentBtn;
	/**Bouton attaquerCase. */
	private JButton attaquerCase;
	/**Bouton placerPion. */
	private JButton placerPion;
	/**Bouton redeployement. */
	private JButton redeployement;
	/**Bouton finTour. */
	private JButton finTourBtn;
	/**Bouton piocher. */
	private JButton piocheBtn;

	/**
	 * Construire le contrôleur du Joueur.
	 * @param jeu Le jeu dans lequel on agit.
	 * @param selecteurCase Le selecteur de Case.
	 */
	public ActionsJoueur(Jeu jeu, Selecteur<CaseView> selecteurCase, Selecteur<Combinaison> selecteurCombinaison) {
		super();
        jeu.ajouterObservateurJoueurCourant(this);

		this.jeu = jeu;
		this.selecteurCase = selecteurCase;
		this.selecteurCombinaison = selecteurCombinaison;

		super.setLayout(new FlowLayout());
		super.setBorder(BorderFactory.createTitledBorder("Actions du Joueur"));

		piocheBtn = new JButton("Piocher");
		piocheBtn.addActionListener(new ActionPiocher());
		piocheBtn.setEnabled(false);
		super.add(piocheBtn);

		declinBtn = new JButton("Passer en déclin");
		declinBtn.addActionListener(new ActionDeclin());
		declinBtn.setEnabled(false);
		super.add(declinBtn);

		ajouterBatimentBtn = new JButton("Ajouter un batiment");
		ajouterBatimentBtn.addActionListener(new ActionAjouterBatiment());
		ajouterBatimentBtn.setEnabled(false);
		super.add(ajouterBatimentBtn);

		attaquerCase = new JButton("Conquérir");
		attaquerCase.addActionListener(new ActionAttaquerCase());
		attaquerCase.setEnabled(false);
		super.add(attaquerCase);

		placerPion = new JButton("Placer un pion");
		placerPion.addActionListener(new ActionPlacerPion());
		placerPion.setEnabled(false);
		super.add(placerPion);

		// A mettre à part avec les boutons pour changer d'état
		redeployement = new JButton("Redéployement");
		redeployement.addActionListener(new ActionRedeployement());
		redeployement.setEnabled(false);
		super.add(redeployement);

		// A mettre à part avec les boutons pour changer d'état
		finTourBtn = new JButton("Fin du Tour");
		finTourBtn.addActionListener(new ActionFinirTour());
		finTourBtn.setEnabled(false);
		super.add(finTourBtn);
	}


	private void messageDialogue(ActionEvent evt, String message) {
		JFrame fenetre =
			(JFrame) SwingUtilities.getWindowAncestor((JButton) evt.getSource());
		JOptionPane.showMessageDialog(fenetre, message);
	}

	/**Classe déclenchée quand le bouton action piocher est cliqué. */
	private class ActionPiocher implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent evt) {
			Combinaison CombinaisonSelectionnee = selecteurCombinaison.getSelection();
			if (CombinaisonSelectionnee == null) {
				messageDialogue(evt, "Action Impossible ! Aucune combinaison sélectionnée.");
			} else {
				Joueur courant = jeu.getJoueurCourant();
				courant.changerCombinaisonActive(CombinaisonSelectionnee);
			}
		}
	}

	/**Classe déclenchée quand le bouton action Finir le tour est pressé. */
	private final class ActionFinirTour implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent evt) {
			jeu.passerTour();
		}
	}

	/**Classe déclenchée quand le bouton action déclin est cliqué. */
	private /*final*/ class ActionDeclin implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent evt) {
			jeu.getJoueurCourant().getCombinaisonActive().passageDeclin();
			jeu.passerTour();
		}
	}

	/** Classe déclenchée quand le bouton ajouterBatiment est cliqué. */
	private final class ActionAjouterBatiment implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent evt) {
			CaseView caseSelectionnee = selecteurCase.getSelection();
			if (caseSelectionnee == null) {
				System.out.println("Aucune case n'est sélectionnée");
			} else {
				// Créez et affichez la fenêtre de dialogue
				// 'SwingUtilities' prend un composant Swing en paramètre et renvoie la fenêtre
				// parente de ce composant
				// 'this' fait référence à l'élément graphique actuel
				// spécifie que la fenêtre parente est de type JFrame
				JFrame fenetre = (JFrame) SwingUtilities.getWindowAncestor((JButton) evt.getSource());
				BatimentsDialog dialog = new BatimentsDialog(fenetre, caseSelectionnee);
				dialog.setVisible(true);
			}
		}
	}

	/**Classe déclenchée quand le bouton attaquer case est cliqué. */
	private final class ActionAttaquerCase implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent evt) {
			CaseView caseSelectionnee = selecteurCase.getSelection();
			if (selecteurCase.getSelection() == null) {
				messageDialogue(evt, "Action Impossible ! Aucune case sélectionnée.");
			} else {
				System.out.println("Attaque de la case : "
					+ caseSelectionnee.getVraieCase().getCoordonnees().toString());
				jeu.attaquerCase(caseSelectionnee.getVraieCase());
			}
		}
	}

	/**Classe déclenchée quand le bouton placer pion est cliqué. */
	private final class ActionPlacerPion implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent evt) {
			CaseView caseSelectionnee = selecteurCase.getSelection();
			if (selecteurCase.getSelection() == null) {
				messageDialogue(evt, "Action Impossible ! Aucune case sélectionnée.");
			} else {
				jeu.placerPions(caseSelectionnee.getVraieCase(), 1);
			}
		}
	}

	/**Classe déclenchée quand le bouton redéployement est cliqué. */
	private final class ActionRedeployement implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent evt) {
			jeu.redeployement();
		}
	}


	public void update(java.util.Observable o, Object arg) {
		JoueurState etat = this.jeu.getJoueurCourant().getEtat();
		int pionsEnMain =
			jeu.getJoueurCourant().getCombinaisonActive().getNbPionsEnMain();

		// Actualisation bouton déclin
		boolean declinBtnActif = etat == JoueurState.DEBUT_TOUR;
		this.declinBtn.setEnabled(declinBtnActif);

		// Actualisation bouton batiment
		boolean batimentBtnActif = etat != JoueurState.CHOIX_COMBINAISON;
		this.ajouterBatimentBtn.setEnabled(batimentBtnActif);

		// Actualisation bouton Conquerir
		boolean conquerirBtnActif = (etat == JoueurState.ATTAQUE
			|| etat == JoueurState.DEBUT_TOUR) && (pionsEnMain >= 2);
		this.attaquerCase.setEnabled(conquerirBtnActif);

		// Actualisation bouton Redeployement
		boolean redeployementBtnActif = (etat == JoueurState.ATTAQUE)
			|| (etat == JoueurState.REDEPLOYMENT);
		this.redeployement.setEnabled(redeployementBtnActif);

		// Actualisation bouton placer pion
		boolean placerPionBtnActif = ((etat == JoueurState.ATTAQUE)
			|| (etat == JoueurState.REDEPLOYMENT))
			&& pionsEnMain > 0;
		this.placerPion.setEnabled(placerPionBtnActif);

		// Actualisation bouton Fin de tour
		boolean finTourBtnActif = (etat == JoueurState.ATTAQUE
			|| etat == JoueurState.REDEPLOYMENT)
			&& pionsEnMain == 0;
		this.finTourBtn.setEnabled(finTourBtnActif);

		// Actualisation du bouton Piocher
		boolean piocheBtnActif = (etat == JoueurState.CHOIX_COMBINAISON);
		this.piocheBtn.setEnabled(piocheBtnActif);

	}
}
