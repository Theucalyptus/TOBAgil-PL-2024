package controleurs;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

import jeu.Case;
import jeu.Jeu;
import jeu.JeuState;
import jeu.batiments.TypesBatiments;
import jeu.exceptions.CoupInvalideException;
import jeu.Monde;
import jeu.Combinaison;
import jeu.Joueur;
import jeu.JoueurState;
import jeu.peuples.Peuple;
import jeu.pouvoirs.Pouvoir;
import jeu.peuples.TypesPeuples;
import jeu.pouvoirs.TypesPouvoirs;
import jeu.TypesRegions;
import jeu.TypesSymboles;

import ui.selecteur.Selecteur;
import ui.views.CaseView;

import java.util.Observer;
import java.util.Scanner;

@SuppressWarnings("deprecation")
public class ActionsJoueur extends JPanel implements Observer {

	/**Le jeu dans lequel le joueur est. */
	private Jeu jeu;

	/**Le sélecteur de case du jeu. */
	private Selecteur<CaseView> selecteurCase;

	// Les boutons disponibles.
	// TODO mettre la portée : public, privée, protégée
	/**Bouton declin. */
	JButton declinBtn;
	/**Bouton ajouterBatiment. */
	JButton ajouterBatimentBtn;
	/**Bouton attaquerCase. */
	JButton attaquerCase;
	/**Bouton placerPion. */
	JButton placerPion;
	/**Bouton redeployement. */
	JButton redeployement;
	/**BOuton finTour. */
	JButton finTourBtn;

	/**
	 * Construire le contrôleur du Joueur.
	 * @param jeu Le jeu dans lequel on agit.
	 * @param selecteurCase Le selecteur de Case.
	 */
	public ActionsJoueur(Jeu jeu, Selecteur<CaseView> selecteurCase) {
		super();
        jeu.ajouterObservateurJoueurCourant(this);

		this.jeu = jeu;
		this.selecteurCase = selecteurCase;

		super.setLayout(new FlowLayout());
		super.setBorder(BorderFactory.createTitledBorder("Actions du Joueur"));

		declinBtn = new JButton("Passer en déclin");
		declinBtn.addActionListener(new ActionDeclin());
		super.add(declinBtn);

		ajouterBatimentBtn = new JButton("Ajouter un batiment");
		ajouterBatimentBtn.addActionListener(new ActionAjouterBatiment());
		super.add(ajouterBatimentBtn);

		attaquerCase = new JButton("Conquérir");
		attaquerCase.addActionListener(new ActionAttaquerCase());
		super.add(attaquerCase);

		placerPion = new JButton("Placer un pion");
		placerPion.addActionListener(new ActionPlacerPion());
		super.add(placerPion);

		// A mettre à part avec les boutons pour changer d'état
		redeployement = new JButton("Redéployement");
		redeployement.addActionListener(new ActionRedeployement());
		super.add(redeployement);

		// A mettre à part avec les boutons pour changer d'état
		finTourBtn = new JButton("Fin du Tour");
		finTourBtn.addActionListener(new ActionFinirTour());
		super.add(finTourBtn);
	}


	private void messageDialogue(ActionEvent evt, String message) {
		JFrame fenetre =
			(JFrame) SwingUtilities.getWindowAncestor((JButton) evt.getSource());
		JOptionPane.showMessageDialog(fenetre, message);
	}

	/**Classe déclenchée quand le bouton action Finir le tour est pressé. */
	private /*final*/ class ActionFinirTour implements ActionListener {
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

	/**Classe déclenchée quand le bouton ajouterBatiment est cliqué. */
	private /*final*/ class ActionAjouterBatiment implements ActionListener {

		//Permet d'avoir un seul scanner en continue
		// TODO mettre la portée de la variable
		/**Le Scanner qui demande quel type de Batiment. */
		Scanner scanner;

		public ActionAjouterBatiment() {
			// Initialisez le scanner dans le constructeur
			scanner = new Scanner(System.in);
		}


		@Override
		public void actionPerformed(ActionEvent evt) {
			CaseView caseSelectionnee = selecteurCase.getSelection();
			if (selecteurCase.getSelection() == null) {
				messageDialogue(evt, "Action Impossible ! Aucune case sélectionnée.");
			} else {
				String input;
				//Initialisation du type de batiment
				TypesBatiments newbatiment = TypesBatiments.AUCUN;
				//On boucle tant que l'utilisateur ne donne pas un bon Type de batiment
				//Condition pour rester dans la boucle
				Boolean correcte = false;
				do {
					//Demande du batiment à ajouter
					System.out.println("Vous souhaitez ajouter : CAMPEMENT, FORTERESSE, "
						+ "ANTRE_DE_TROLL, TANIERE ?");
					input = scanner.nextLine();
					System.out.println("Vous souhaitez rajouter : " + input);
					//On detecte quel batiment a été choisi
					switch (input) {
						case "CAMPEMENT":
							newbatiment = TypesBatiments.CAMPEMENT;
							correcte = true;
							break;
						case "FORTERESSE":
							newbatiment = TypesBatiments.FORTERESSE;
							correcte = true;
							break;
						case "ANTRE_DE_TROLL":
							newbatiment = TypesBatiments.ANTRE_DE_TROLL;
							correcte = true;
							break;
						case "TANIERE":
							newbatiment = TypesBatiments.TANIERE;
							correcte = true;
							break;
						default:
							scanner = new Scanner(System.in);
							System.out.println("Type de batiment inexistant.");
					}
				} while (!correcte);
				//Rajouter le batiment à la case sélectionné
				caseSelectionnee.getVraieCase().setTypeBatiment(newbatiment, 1);
			}
		}
	}

	/**Classe déclenchée quand le bouton attaquer case est cliqué. */
	private class ActionAttaquerCase implements ActionListener {
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
	private /*final*/ class ActionPlacerPion implements ActionListener {
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

	}
}
