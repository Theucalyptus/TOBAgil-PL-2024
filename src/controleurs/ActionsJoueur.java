package controleurs;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

import jeu.Case;
import jeu.Jeu;
import jeu.batiments.TypesBatiments;
import jeu.exceptions.CoupInvalideException;
import jeu.Monde;
import jeu.Combinaison;
import jeu.Joueur;
import jeu.peuples.Peuple;
import jeu.pouvoirs.Pouvoir;
import jeu.peuples.TypesPeuples;
import jeu.pouvoirs.TypesPouvoirs;
import jeu.TypesRegions;
import jeu.TypesSymboles;

import ui.selecteur.Selecteur;
import ui.views.CaseView;

import java.util.Scanner;

public class ActionsJoueur extends JPanel {

	/**Le jeu dans lequel le joueur est. */
	private Jeu jeu;

	/**Le sélecteur de case du jeu. */
	private Selecteur<CaseView> selecteurCase;
	private Selecteur<Combinaison> selecteurCombinaison;

	/**
	 * Construire le contrôleur du Joueur.
	 * @param jeu Le jeu dans lequel on agit.
	 * @param selecteurCase Le selecteur de Case.
	 */
	public ActionsJoueur(Jeu jeu, Selecteur<CaseView> selecteurCase, Selecteur<Combinaison> selecteurCombinaison) {
		super();
		this.jeu = jeu;
		this.selecteurCase = selecteurCase;
		this.selecteurCombinaison = selecteurCombinaison;

		super.setLayout(new FlowLayout());
		super.setBorder(BorderFactory.createTitledBorder("Actions du Joueur"));

		JButton PiocheBtn = new JButton("Piocher");
		PiocheBtn.addActionListener(new ActionPiocher());
		super.add(PiocheBtn);

		JButton declinBtn = new JButton("Passer en déclin");
		declinBtn.addActionListener(new ActionDeclin());
		super.add(declinBtn);

		JButton ajouterBatimentBtn = new JButton("Ajouter un batiment");
		ajouterBatimentBtn.addActionListener(new ActionAjouterBatiment());
		super.add(ajouterBatimentBtn);

		JButton attaquerCase = new JButton("Attaquer");
		attaquerCase.addActionListener(new ActionAttaquerCase());
		super.add(attaquerCase);

		JButton placerPion = new JButton("Placer un pion");
		placerPion.addActionListener(new ActionPlacerPion());
		super.add(placerPion);

		JButton redeployement = new JButton("Redéployement");
		redeployement.addActionListener(new ActionRedeployement());
		super.add(redeployement);

		JButton finTourBtn = new JButton("Fin du Tour");
		finTourBtn.addActionListener(new ActionFinirTour());
		super.add(finTourBtn);
	}


	private void messageDialogue(ActionEvent evt, String message) {
		JFrame fenetre = (JFrame) SwingUtilities.getWindowAncestor((JButton)evt.getSource());
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
	private class ActionFinirTour implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent evt) {
			jeu.passerTour();
		}
	}

	/**Classe déclenchée quand le bouton action déclin est cliqué. */
	private class ActionDeclin implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent evt) {
			jeu.getJoueurCourant().getCombinaisonActive().passageDeclin();
			jeu.passerTour();
		}
	}

	/**Classe déclenchée quand le bouton ajouterBatiment est cliqué. */
	private class ActionAjouterBatiment implements ActionListener {

		//Permet d'avoir un seul scanner en continue
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
					System.out.println("Vous souhaitez ajouter : CAMPEMENT, FORTERESSE,	ANTRE_DE_TROLL, TANIERE ?");
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
				System.out.println("Attaque de la case : " + caseSelectionnee.getVraieCase().getCoordonnees().toString());
				jeu.attaquerCase(caseSelectionnee.getVraieCase());
			}
		}
	}	
	
	/**Classe déclenchée quand le bouton placer pion est cliqué. */
	private class ActionPlacerPion implements ActionListener {
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
}
