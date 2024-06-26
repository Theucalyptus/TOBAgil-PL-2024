package ui;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

import jeu.Jeu;
import jeu.peuples.Peuple;
import jeu.pouvoirs.Pouvoir;
import jeu.Combinaison;
import jeu.Joueur;
import jeu.JoueurState;
import jeu.peuples.TypesPeuples;
import jeu.pouvoirs.TypesPouvoirs;

import ui.selecteur.Selecteur;
import ui.views.CaseView;

import java.util.Observer;
import javax.swing.SwingUtilities;

@SuppressWarnings("deprecation")
public class ActionsJoueur extends JPanel implements Observer {

	/**Le jeu dans lequel le joueur est. */
	private Jeu jeu;

	/**Le sélecteur de case du jeu. */
	private Selecteur<CaseView> selecteurCase;
	/**Le sélecteur de la Combinaison dans la pioche. */
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
	/**Bouton redeploiment. */
	private JButton redeploiment;
	/**Bouton finTour. */
	private JButton finTourBtn;
	/**Bouton piocher. */
	private JButton piocheBtn;

	/**
	 * Construire le contrôleur du Joueur.
	 * @param jeu Le jeu dans lequel on agit.
	 * @param selecteurCase Le selecteur de Case.
	 * @param selecteurCombinaison Le selecteur de la Combinaison dans la pioche.
	 */
	public ActionsJoueur(Jeu jeu,
				Selecteur<CaseView> selecteurCase,
				Selecteur<Combinaison> selecteurCombinaison) {
		super();
		if (jeu == null) {
			throw new IllegalArgumentException("Jeu ne doit pas être null.");
		} else if (selecteurCase == null) {
			throw new IllegalArgumentException("selecteurCase ne doit pas être null.");
		} else if (selecteurCombinaison == null) {
			throw new IllegalArgumentException("selecteurCombinaison ne doit "
				+ "pas être null.");
		}
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
		redeploiment = new JButton("Redéploiment");
		redeploiment.addActionListener(new Actionredeploiment());
		redeploiment.setEnabled(false);
		super.add(redeploiment);

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
	private final class ActionPiocher implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent evt) {
			Combinaison combinaisonSelectionnee = selecteurCombinaison.getSelection();
			if (combinaisonSelectionnee == null) {
				messageDialogue(evt, "Action Impossible ! Aucune "
					+ "combinaison sélectionnée.");
			} else {
				Joueur courant = jeu.getJoueurCourant();
				courant.changerCombinaisonActive(combinaisonSelectionnee);
				courant.setEtat(JoueurState.DEBUT_TOUR);
				selecteurCombinaison.setSelection(null);
				jeu.getPioche().removeCombinaisonChoisit(combinaisonSelectionnee);
				jeu.debutTour();
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
	private final class ActionDeclin implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent evt) {
			jeu.getJoueurCourant().setEtat(JoueurState.CHOIX_COMBINAISON);
			jeu.getJoueurCourant().getCombinaisonActive().passageDeclin();
			jeu.passerTour();
		}
	}

	/** Classe déclenchée quand le bouton ajouterBatiment est cliqué. */
	private final class ActionAjouterBatiment implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent evt) {
			//Combinaison du joueur actuel
			Pouvoir pouvoir = jeu.getJoueurCourant().getCombinaisonActive().getPouvoir();
        	Peuple peuple = jeu.getJoueurCourant().getCombinaisonActive().getPeuple();
			Boolean poserBat = (pouvoir.getType() == TypesPouvoirs.SCOUTS)
				|| (pouvoir.getType() == TypesPouvoirs.BATISSEURS)
				|| (peuple.getType() == TypesPeuples.MIPORTIONS)
				|| (peuple.getType() == TypesPeuples.TROLLS);

			CaseView caseSelectionnee = selecteurCase.getSelection();
			if (caseSelectionnee == null) {
					messageDialogue(evt, "Action Impossible ! Aucune "
						+ "case sélectionnée.");
			} else {
				// Créez et affichez la fenêtre de dialogue
				if (poserBat) {
					JFrame fenetre = (JFrame) SwingUtilities.getWindowAncestor(
						(JButton) evt.getSource());

					BatimentsDialog dialog = new BatimentsDialog(fenetre,
						caseSelectionnee,
						peuple.getType(),
						pouvoir.getType());

					dialog.setVisible(true);
				} else {
					messageDialogue(evt, "Aucun batiment ne peut etre placé "
						+ "avec votre combinaison !");
				}
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

	/**Classe déclenchée quand le bouton Redéploiment est cliqué. */
	private final class Actionredeploiment implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent evt) {
			jeu.redeploiment();
		}
	}

	@Override
	public void update(java.util.Observable o, Object arg) {
		JoueurState etat = this.jeu.getJoueurCourant().getEtat();
		int pionsEnMain = 0;
		try {
			pionsEnMain =
				jeu.getJoueurCourant().getCombinaisonActive().getNbPionsEnMain();
		} catch (NullPointerException e) {
			// rien
		}

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

		// Actualisation bouton redeploiment
		boolean redeploimentBtnActif = (etat == JoueurState.ATTAQUE)
			|| (etat == JoueurState.REDEPLOYMENT);
		this.redeploiment.setEnabled(redeploimentBtnActif);

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
