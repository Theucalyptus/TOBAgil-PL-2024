package ui.views;

import java.awt.BorderLayout;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import jeu.Combinaison;
import jeu.Jeu;
import jeu.Joueur;
import ui.utils.ImageFactory;

@SuppressWarnings("deprecation")
public class MainJoueurView extends JPanel implements Observer {

    /** Le label des informations sur le joueur. */
    private JPanel informationsPnl;
    /** Le panneau des conbinaisons du joueur. */
    private JPanel combinaisonsPnl;
    /** La label du nom du joueur. */
    private JLabel nom = new JLabel();
    /** Le label du nomnbre de pions encore plaçable. */
    private JLabel nbPionsAPlacer = new JLabel();
    /** La vue des points du joueur. */
    private PointsView points = new PointsView();
    /** Les vues des combinaisons du joueurs. */
    private List<CombinaisonView> combViews;

    /**
     * Construit la vue d'un joueur.
     */
    public MainJoueurView(Jeu jeu) {
        super();
        jeu.ajouterObservateur(this);
        super.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));


        this.combViews = new ArrayList<>();

        this.informationsPnl = new JPanel();
        this.informationsPnl.setBorder(BorderFactory.createTitledBorder("Informations"));
        this.informationsPnl.add(this.nom);
        this.informationsPnl.add(this.points);
        this.informationsPnl.add(this.nbPionsAPlacer);

        this.combinaisonsPnl = new JPanel();
        this.combinaisonsPnl.setBorder(BorderFactory.createTitledBorder("Combinaisons"));

        super.add(this.informationsPnl);
        super.add(this.combinaisonsPnl);
    }

    /**
     * Définit le joueur à afficher et l'affiche.
     * @param joueur le joueur à afficher
     */
    public void setJoueur(Joueur joueur) {
        for (CombinaisonView cbv : this.combViews) {
            this.combinaisonsPnl.remove(cbv);
        }
        this.combViews.clear();

        this.nom.setText("Nom : " + joueur.getNom());
        this.points.setScore(joueur.getPoints());

        // affichage de la combinaison active
        CombinaisonView activeView = new CombinaisonView(joueur.getCombinaisonActive());
        this.combViews.add(activeView);
        this.combinaisonsPnl.add(activeView);

        // affichages des combinaisons en déclins
        System.out.println(joueur.getCombinaisonsDeclins().size());
        if(joueur.getCombinaisonsDeclins().size() > 0) {
            for(Combinaison comb : joueur.getCombinaisonsDeclins()) {
                CombinaisonView newView = new CombinaisonView(comb);
                this.combViews.add(newView);
                this.combinaisonsPnl.add(newView);
            }
        }


        this.nbPionsAPlacer.setText("Pions à placer : " + joueur.getCombinaisonActive().getNbPionsEnMain());
    }

    /**
     * Composant graphiques réalisant l'affichage des points.
     */
    public class PointsView extends JPanel {

        /** Classe réalisant l'affichage d'un tas de jeton. */
        private class JetonView extends JLabel {

            /**
             * Construit la vue d'un tas de pièce.
             * @param nombre le chiffre sur les pièces
             */
            public JetonView(int nombre) {
                super();
                assert (nombre == 1 || nombre == 3 || nombre == 5 || nombre == 10);
                this.setIcon(new ImageIcon(ImageFactory.pieceImage(nombre)));
                this.setNombre(0);
            }

            /**
             * Définit le nombre de pièece du tas.
             * @param nbPiece le nombre de pièce
             */
            public void setNombre(int nbPiece) {
                this.setText("x" + Integer.toString(nbPiece));
            }
        }

        /** Le tas de pièce 1. */
        private JetonView jeton1 = new JetonView(1);
        /** Le tas de pièce 3. */
        private JetonView jeton3 = new JetonView(3);
        /** Le tas de pièce 5. */
        private JetonView jeton5 = new JetonView(5);
        /** Le tas de pièce 10. */
        private JetonView jeton10 = new JetonView(10);

        /** Construit la vue des points. */
        public PointsView() {
            super();
            this.setScore(0);
            super.add(this.jeton1);
            super.add(this.jeton3);
            super.add(this.jeton5);
            super.add(this.jeton10);

        }

        /**
         * Définit la valeur du score affiché.
         * @param score le score à afficher.
         */
        public void setScore(int score) {
            int nb10 = score / 10;
            score = score % 10;
            int nb5 = score / 5;
            score = score % 5;
            int nb3 = score / 3;
            score = score % 3;
            int nb1 = score;
            this.jeton1.setNombre(nb1);
            this.jeton3.setNombre(nb3);
            this.jeton5.setNombre(nb5);
            this.jeton10.setNombre(nb10);

        }
    }

    @Override
    public void update(Observable arg0, Object arg1) {
        Jeu jeu = (Jeu)arg0;
        this.setJoueur(jeu.getJoueurCourant());
        SwingUtilities.getWindowAncestor(this).pack();
    }

}
