package ui.menu;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;

import jeu.Combinaison;
import jeu.JeuReel;
import jeu.Joueur;
import jeu.Monde;
import ui.ActionsFenetre;
import ui.MainJoueurFenetre;
import ui.MainMondeFenetre;
import ui.PiocheFenetre;
import ui.selecteur.Selecteur;
import ui.utils.ImageFactory;
import ui.views.CaseView;

@SuppressWarnings("deprecation")
public class LanceurSmallworld {

    /** La fenêtre. */
    private JFrame fenetre;

    /** Label affichant le logo du jeu. */
    private JLabel logo;

    /** Boutons pour lancer la partie. */
    private JButton jouerBtn;
    /** Bouton pour les options. */
    private JButton optionsBtn;
    /** Bouton pour quitter la partie. */
    private JButton quitterBtn;

    /** Ensemble de nom des joueurs de la partie. */
  
    private List<String> nomsJoueurs;
   
    /** Construit une fenêtre affichant le menu.
     */
    public LanceurSmallworld() {
        this.fenetre = new JFrame("SmallWorld - Menu Principal");
        this.fenetre.setSize(new Dimension(1000, 750));

        JPanel mainPanel = new JPanel();
        fenetre.add(mainPanel);
        mainPanel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(30, 30, 30, 30);

        this.logo = new JLabel();
        this.logo.setIcon(new ImageIcon(ImageFactory.logoSmallworld()));
        gbc.gridy = 0;
        mainPanel.add(logo, gbc);

        gbc.ipadx = 100;
        gbc.ipady = 15;

        this.jouerBtn = new JButton("Jouer");
        this.jouerBtn.addActionListener(new ActionJouer());
        gbc.gridy = 1;
        mainPanel.add(jouerBtn, gbc);

        this.optionsBtn = new JButton("Options");
        this.optionsBtn.addActionListener(new ActionOptions());
        gbc.gridy = 2;
        mainPanel.add(optionsBtn, gbc);

        this.quitterBtn = new JButton("Quitter");
        this.quitterBtn.addActionListener(new ActionQuitter());
        gbc.gridy = 3;
        mainPanel.add(quitterBtn, gbc);
        
        this.nomsJoueurs = new ArrayList<String>(Arrays.asList("Fraise", "Framboise","Pomme"));

        this.fenetre.pack();
        this.fenetre.setVisible(true);
        this.fenetre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    public List<String> getNomsJoueurs() {
    	return this.nomsJoueurs;
    }
    
    public void setNomsJoueurs(List<String> nomsJoueurs) {

    	this.nomsJoueurs = nomsJoueurs;
    }

	/** Action lancée lorsque le bouton Jouer est enclenché.
	 */
	private final class ActionJouer implements ActionListener {

		public void actionPerformed(ActionEvent evt) {
			lancerSmallworld(nomsJoueurs);
			fenetre.dispose();
		}
	}
	
	/** Action lancée lorsque le bouton Options est enclenché.
	 */
	private final class ActionOptions implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			new OptionsFenetre(LanceurSmallworld.this);
		}
	}

	/** Action lancée lorsque le bouton Quitter est enclenché.
	 */
	private final class ActionQuitter implements ActionListener {

		public void actionPerformed(ActionEvent evt) {
			fenetre.dispose();
		}
	}

    /**Lancer le jeu Smallworld à partir de l'ensemble de nom de ses joueurs.
     * @param nomsJoueurs L'ensemble des noms de joueurs jouant au jeu.
     */
    private static void lancerSmallworld(List<String> nomsJoueurs) {
    	
        // MODELE
        JeuReel jeu = new JeuReel();

        for (String nom : nomsJoueurs) {
        	Joueur joueur = new Joueur(nom, 0);
        	jeu.ajouterJoueur(joueur);
        }

        jeu.setMonde(new Monde(nomsJoueurs.size()));

        //SELECTEUR
        Selecteur<CaseView> selecteurCase = new Selecteur<CaseView>();
        Selecteur<Combinaison> selecteurCombinaison = new Selecteur<Combinaison>();

        // VUES
        PiocheFenetre piocheF = new PiocheFenetre(selecteurCombinaison, jeu);
        jeu.getPioche().addObserver(piocheF);

        MainMondeFenetre mondeF = new MainMondeFenetre(jeu, selecteurCase);
        MainJoueurFenetre joueurF = new MainJoueurFenetre(jeu);
        ActionsFenetre actionsF = new ActionsFenetre(jeu, selecteurCase, selecteurCombinaison);
        
        jeu.lancerPartie();
    }
}
