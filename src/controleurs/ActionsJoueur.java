package controleurs;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

import jeu.Case;
import jeu.Jeu;
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

public class ActionsJoueur extends JPanel {

	/**Le jeu dans lequel le joueur est. */
	private final Jeu jeu;
	
	/**Le sélecteur de case du jeu. */
	private Selecteur<CaseView> selecteurCase;

	/**
	 * Construire le contrôleur du Joueur.
	 * @param jeu Le jeu dans lequel
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
		
		JButton agirCaseBtn = new JButton("Agir sur la case sélectionnée");
		agirCaseBtn.addActionListener(new ActionAgirCase());
		super.add(agirCaseBtn);


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
			//------------------------------------------------------------------------------
			//Compter le nombre de points de victoires gagnés par le joueur à la fin du tour
			//------------------------------------------------------------------------------
			
			int pts_gagnes = 0;
			Joueur joueur_courant = jeu.getJoueurCourant(); //obtenir le joueur dont le tour se finit
			Monde monde_actuel = jeu.getMonde();
			Combinaison combinaison_joueur = joueur_courant.getCombinaison();
			Peuple peuple_joueur = combinaison_joueur.getPeuple();
			Pouvoir pouvoir_joueur = combinaison_joueur.getPouvoir();
			for (int x = 0; x < monde_actuel.getDimX(); x++) {		//parcours de la grille de cases
            	for (int y = 0; y < monde_actuel.getDimY(); y++) {
					Case case_courante = monde_actuel.getCase(x, y); //on recupere la case aux coordonnees (x, y)
					//on verifie si la case contient le peuple du joueur
					if (case_courante.getPeuple() == peuple_joueur) {
						pts_gagnes++;	//on ajoute un point de victoire au joueur
						//effet special pour le peuple HUMAINS
						if ((peuple_joueur.getType() == TypesPeuples.HUMAINS) && (case_courante.getTypeRegion() == TypesRegions.CHAMP)
							&& !(combinaison_joueur.getDeclin())) { 
							pts_gagnes++;
						}
						//effet special pour le peuple MAGES
						if ((peuple_joueur.getType() == TypesPeuples.MAGES) && (case_courante.getTypeRessource() == TypesSymboles.SOURCE_MAGIQUE) 
							&& !(combinaison_joueur.getDeclin())) { 
							pts_gagnes++;
						}
						//effet special pour le peuple NAINS
						if ((peuple_joueur.getType() == TypesPeuples.NAINS) && (case_courante.getTypeRessource() == TypesSymboles.MINE)) { 
							pts_gagnes++;
						}
						//effet special du pouvoir BATISSEURS
						if ((pouvoir_joueur.getType() == TypesPouvoirs.BATISSEURS) && !(combinaison_joueur.getDeclin())) {
							pts_gagnes++;
						}
						//effet special du pouvoir DES_COLLINES
						if ((pouvoir_joueur.getType() == TypesPouvoirs.DES_COLLINES) && (case_courante.getTypeRegion() == TypesRegions.COLLINE)) {
							pts_gagnes++;
						}
						//effet special du pouvoir DES_FORETS
						if ((pouvoir_joueur.getType() == TypesPouvoirs.DES_FORETS) && (case_courante.getTypeRegion() == TypesRegions.FORET)) {
							pts_gagnes++;
						}
						//effet special du pouvoir DES_MARAIS
						if ((pouvoir_joueur.getType() == TypesPouvoirs.DES_MARAIS) && (case_courante.getTypeRegion() == TypesRegions.MARAIS)) {
							pts_gagnes++;
						}
						//effet special du pouvoir MARCHANDS
						if (pouvoir_joueur.getType() == TypesPouvoirs.MARCHANDS) {
							pts_gagnes++;
						}
					}
					//effet special du pouvoir ALCHIMISTES
					if ((pouvoir_joueur.getType() == TypesPouvoirs.ALCHIMISTES) && !(combinaison_joueur.getDeclin())) {
						pts_gagnes = pts_gagnes + 2;
					}
					//effet special du pouvoir FORTUNES
					if ((pouvoir_joueur.getType() == TypesPouvoirs.FORTUNES) && (jeu.getNumeroTour() == 1)) {
						pts_gagnes = pts_gagnes + 7;
					}
				}
			}
			joueur_courant.addPoints(pts_gagnes); //on ajoute les points gagnés au nombre de points que le joueur a déjà
			
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
			jeu.getJoueurCourant().getCombinaison().passageDeclin();
			jeu.passerTour();
		}
	}
	
	/**Classe déclenchée quand le bouton agir case est cliqué. */
	private final class ActionAgirCase implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent evt) {
			CaseView caseSelectionnee = selecteurCase.getSelection();
			if(selecteurCase.getSelection() == null) {
				System.out.println("Aucune case n'est sélectionnée");
			} else {
				System.out.println("Nombre de pions sur la case : " + caseSelectionnee.getVraieCase().getNombrepions());
			}
		}
	}
}
