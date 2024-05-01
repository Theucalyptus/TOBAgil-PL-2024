package ui.views;

import java.awt.BorderLayout;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import jeu.Combinaison;
import jeu.Joueur;
import ui.utils.ImageFactory;

public class MainJoueurView extends JPanel {

    private JPanel informationsPnl;
    private JPanel combinaisonsPnl;

    private JLabel nom = new JLabel();
    private PointsView points = new PointsView();

    private List<CombinaisonView> combViews;

    public MainJoueurView() {
        super();
        super.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));


        this.combViews = new ArrayList<>();

        this.informationsPnl = new JPanel();
        this.informationsPnl.setBorder(BorderFactory.createTitledBorder("Informations"));
        this.informationsPnl.add(this.nom);
        this.informationsPnl.add(this.points);

        this.combinaisonsPnl = new JPanel();
        this.combinaisonsPnl.setBorder(BorderFactory.createTitledBorder("Combinaisons"));

        super.add(this.informationsPnl);
        super.add(this.combinaisonsPnl);
    }


    public void setJoueur(Joueur joueur) {
        for(CombinaisonView cbv : this.combViews) {
            this.combinaisonsPnl.remove(cbv);;
        }
        this.combViews.clear();

        this.nom.setText("Nom : " + joueur.getNom());
        this.points.setScore(joueur.getPoints());

        //for(Combinaison comb : joueur.getCombinaisonList()) {
        Combinaison comb = joueur.getCombinaison();
        this.combViews.add(new CombinaisonView(comb));
        //}

        for(CombinaisonView cbw : this.combViews) {
            this.combinaisonsPnl.add(cbw);
        }
    }


    public class PointsView extends JPanel {

        private class JetonView extends JLabel {
            
            public JetonView(int nombre) {
                super();
                assert(nombre == 1 || nombre == 3 || nombre == 5 || nombre == 10);
                this.setIcon(new ImageIcon(ImageFactory.pieceImage(nombre)));
                this.setNombre(0);
            }

            public void setNombre(int nbPiece) {
                this.setText("x" + Integer.toString(nbPiece));
            }
        }

        private JetonView jeton1 = new JetonView(1);
        private JetonView jeton3 = new JetonView(3);
        private JetonView jeton5 = new JetonView(5);
        private JetonView jeton10 = new JetonView(10);

        public PointsView() {
            super();
            this.setScore(0);
            super.add(this.jeton1);
            super.add(this.jeton3);
            super.add(this.jeton5);
            super.add(this.jeton10);

        }

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

}
