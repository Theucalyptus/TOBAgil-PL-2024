package controleurs;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

import jeu.Case;
import jeu.Jeu;
import jeu.batiments.TypesBatiments;
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
	private final Jeu jeu;

	/**Le sélecteur de case du jeu. */
	private Selecteur<CaseView> selecteurCase;

	/**
	 * Construire le contrôleur du Joueur.
	 * @param jeu Le jeu dans lequel on agit.
	 * @param selecteurCase Le selecteur de Case.
	 */
	public ActionsJoueur(Jeu jeu, Selecteur<CaseView> selecteurCase) {
		super();
		this.jeu = jeu;
		this.selecteurCase = selecteurCase;

		super.setLayout(new FlowLayout());
		super.setBorder(BorderFactory.createTitledBorder("Actions du Joueur"));

		JButton finTourBtn = new JButton("Fin du Tour");
		finTourBtn.addActionListener(new ActionFinirTour());
		super.add(finTourBtn);

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
	}

	/**On définit une action concernant le joueur dans la classe du contrôleur
	 * correspondant. Je suis pas sûr que ce soit la meilleure option, un refactor est
	 * probable car on risque de très vite avoir énormément de code dans ces fichiers.
	 * En attendant, voici en gros comment on réalise la partie "Active" du controlleur,
	 * celle qui fait vraiment avancer le jeu.
	 * La méthode actionPerformed est appelé par un widget graphique, comme un bouton ou
	 * autre.
	 */
	private final class ActionFinirTour implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent evt) {
			//---------------------------------------------------------------------------
			// Compter le nombre de points de victoires gagnés par le joueur à la fin du
			// tour
			//---------------------------------------------------------------------------

			int pointsGagnes = 0;
			 // obtenir le joueur dont le tour se finit
			Joueur joueurCourant = jeu.getJoueurCourant();

			Monde mondeActuel = jeu.getMonde();
			Combinaison combinaisonJoueur = joueurCourant.getCombinaisonActive();
			Peuple peupleJoueur = combinaisonJoueur.getPeuple();
			Pouvoir pouvoirJoueur = combinaisonJoueur.getPouvoir();
			// parcours de la grille de cases
			for (int x = 0; x < mondeActuel.getDimX(); x++) {
            	for (int y = 0; y < mondeActuel.getDimY(); y++) {
					// on recupere la case aux coordonnees (x, y)
					Case caseCourante = mondeActuel.getCase(x, y);

					// on verifie si la case contient le peuple du joueur
					if (caseCourante.getGroupePions().getCombinaison().getPeuple()
							== peupleJoueur) {
						// on ajoute un point de victoire au joueur
						pointsGagnes++;
						// effet special pour le peuple HUMAINS
						if ((peupleJoueur.getType() == TypesPeuples.HUMAINS)
								&& (caseCourante.getTypeRegion() == TypesRegions.CHAMP)
								&& !(combinaisonJoueur.getDeclin())) {
							pointsGagnes++;
						}
						// effet special pour le peuple MAGES
						if ((peupleJoueur.getType() == TypesPeuples.MAGES)
								&& (caseCourante.getTypeRessource()
									== TypesSymboles.SOURCE_MAGIQUE)
								&& !(combinaisonJoueur.getDeclin())) {
							pointsGagnes++;
						}
						// effet special pour le peuple NAINS
						if ((peupleJoueur.getType() == TypesPeuples.NAINS)
								&& (caseCourante.getTypeRessource()
									== TypesSymboles.MINE)) {
							pointsGagnes++;
						}
						// effet special du pouvoir BATISSEURS
						if ((pouvoirJoueur.getType() == TypesPouvoirs.BATISSEURS)
								&& !(combinaisonJoueur.getDeclin())) {
							pointsGagnes++;
						}
						// effet special du pouvoir DES_COLLINES
						if ((pouvoirJoueur.getType() == TypesPouvoirs.DES_COLLINES)
								&& (caseCourante.getTypeRegion()
									== TypesRegions.COLLINE)) {
							pointsGagnes++;
						}
						// effet special du pouvoir DES_FORETS
						if ((pouvoirJoueur.getType() == TypesPouvoirs.DES_FORETS)
								&& (caseCourante.getTypeRegion()
									== TypesRegions.FORET)) {
							pointsGagnes++;
						}
						// effet special du pouvoir DES_MARAIS
						if ((pouvoirJoueur.getType() == TypesPouvoirs.DES_MARAIS)
								&& (caseCourante.getTypeRegion()
								== TypesRegions.MARAIS)) {
							pointsGagnes++;
						}
						// effet special du pouvoir MARCHANDS
						if (pouvoirJoueur.getType() == TypesPouvoirs.MARCHANDS) {
							pointsGagnes++;
						}
					}
					// effet special du pouvoir ALCHIMISTES
					if ((pouvoirJoueur.getType() == TypesPouvoirs.ALCHIMISTES)
							&& !(combinaisonJoueur.getDeclin())) {
						pointsGagnes = pointsGagnes + 2;
					}
					// effet special du pouvoir FORTUNES
					if ((pouvoirJoueur.getType() == TypesPouvoirs.FORTUNES)
							&& (jeu.getNumeroTour() == 1)) {
						pointsGagnes = pointsGagnes + 7;
					}
				}
			}
			System.out.println("Points gagnés : " + pointsGagnes);
			// on ajoute les points gagnés au nombre de points que le joueur a déjà
			joueurCourant.addPoints(pointsGagnes);

			jeu.passerTour();
		}
	}


	/** La classe qui suit est semsiblement la même chose, à la différence qu'elle peut
	 * être utilisé avec n'importe quelle widget Swing, en intéragissant avec la souris.
	 * Il est ainsi possible de programmer des actions lorsque la souris survol le widget
	 * ou lorsque l'utilisateur clique dessus.
	 *
	 * Ici, la classe suppose que le widget est de type JButton mais cela peut être
	 * remplacé par n'importe quelle classe de widget Swing, y compris les custom comme
	 * CaseView...
	*/
	private final class ActionSouris extends MouseAdapter {

		public void mouseCliked(MouseEvent ev) {
			System.out.println("Appui sur "
					+ ((JButton) ev.getSource()).getText());
		}

		@Override
		public void mouseEntered(MouseEvent ev) {
			JButton source = (JButton) ev.getSource();
			System.out.println("Entrée dans "
					+ source.getText());
		}

		@Override
		public void mouseExited(MouseEvent ev) {
			JButton source = (JButton) ev.getSource();
			System.out.println("Sortie de "
					+ source.getText());
		}

	}

	/**Classe déclenchée quand le bouton action déclin est cliqué. */
	private final class ActionDeclin implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent evt) {
			jeu.getJoueurCourant().getCombinaisonActive().passageDeclin();
			jeu.passerTour();
		}
	}


	/**Classe déclenchée quand le bouton ajouterBatiment est cliqué. */
	private final class ActionAjouterBatiment implements ActionListener {

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
				System.out.println("Aucune case n'est sélectionnée");
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
	private final class ActionAttaquerCase implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent evt) {
			CaseView caseSelectionnee = selecteurCase.getSelection();
			if (selecteurCase.getSelection() == null) {
				System.out.println("Aucune case n'est sélectionnée");
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
				System.out.println("Aucune case n'est sélectionnée");
			} else {
				jeu.placerPions(caseSelectionnee.getVraieCase(), 1);
			}
		}
	}
}
