package ui;

import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import jeu.Combinaison;
import jeu.Jeu;
import jeu.JoueurState;
import jeu.JeuState;
import jeu.peuples.*;
import jeu.pouvoirs.*;
import ui.selecteur.Selecteur;
import ui.views.CombinaisonView;
import jeu.Pioche;

@SuppressWarnings("deprecation")
public class PiocheFenetre implements Observer {

    /** La pioche du jeu. */
    private Pioche pioche;
    /** La vue de la combinaison sélectionnée. */
    private CombinaisonView selectedClass = null;

    private Jeu jeu;


    /** La fenêtre. */
    private JFrame fenetre;
    private Map<CombinaisonView, Integer> combinaisonIndexMap = new HashMap<>();

    private JPanel mainPanel;
    private MouseEventHandler trace;

    private Selecteur<Combinaison> selecteurCombinaison;

    /** Construit une fenêtre affichant la pioche. */
    public PiocheFenetre (Selecteur<Combinaison> selecteurCombinaison, Jeu jeu) {

        this.jeu = jeu;
        this.pioche = jeu.getPioche();
        this.fenetre = new JFrame("SmallWorld - Pioche");
        this.fenetre.setMinimumSize(new Dimension(300, 600));
        this.selecteurCombinaison = selecteurCombinaison;
        Container contentPane = this.fenetre.getContentPane();

        this.mainPanel = new JPanel();
        contentPane.add(mainPanel);
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));

		this.trace = new MouseEventHandler();

        List<Combinaison> visible = pioche.getChoix();
        int maxIndex = Math.min(pioche.lengthPioche(), Pioche.LONGUEURPIOCHE);
        for (int i = 0; i < maxIndex; i++) {
            CombinaisonView entree = new CombinaisonView(visible.get(i));
            entree.addMouseListener(this.trace);
            this.mainPanel.add(entree);
            combinaisonIndexMap.put(entree, i);
        }

        this.fenetre.pack();
        this.fenetre.setVisible(true);
        this.fenetre.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }

    @Override
    public void update(Observable o, Object arg) {
        this.mainPanel.removeAll();
        combinaisonIndexMap.clear();

        List<Combinaison> visible = pioche.getChoix();
        int maxIndex = Math.min(pioche.lengthPioche(), Pioche.LONGUEURPIOCHE);
        for (int i = 0; i < maxIndex; i++) {
            CombinaisonView entree = new CombinaisonView(visible.get(i));
            entree.addMouseListener(this.trace);
            this.mainPanel.add(entree);
            combinaisonIndexMap.put(entree, i);
        }

        this.mainPanel.revalidate();
        this.mainPanel.repaint();
    }

    public class MouseEventHandler extends MouseAdapter {

        @Override
        public void mouseEntered(MouseEvent e) {

            if (jeu.getEtat() == JeuState.PAS_COMMENCEE) {
                return;
            }

            if (jeu.getJoueurCourant().getEtat() != JoueurState.CHOIX_COMBINAISON) {
                return;
            }

            CombinaisonView entree = (CombinaisonView) e.getSource();

            if (selectedClass != entree) {
                entree.setBackground(Color.BLUE);
            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            CombinaisonView entree = (CombinaisonView) e.getSource();
            if (selectedClass != entree) {
                entree.setBackground(Color.WHITE);
            }
        }

        @Override
        public void mouseClicked(MouseEvent e) {

            if (jeu.getEtat() == JeuState.PAS_COMMENCEE) {
                System.out.println("La partie n'a pas encore commence");
                return;
            }

            CombinaisonView entree = (CombinaisonView) e.getSource();

            resetCouleur();

            if (jeu.getJoueurCourant().getEtat() != JoueurState.CHOIX_COMBINAISON) {
                System.out.println("Vous ne pouvez pas choisir une combinaison");
                return;
            }

            Integer indiceChoisi = combinaisonIndexMap.get(entree);
            if (indiceChoisi != null) {
                Combinaison combinaison = pioche.getCombinaison(indiceChoisi);
                selecteurCombinaison.setSelection(combinaison);
            } else {
                System.out.println("AUCUNE CLASSE SELECTIONNE - REESSAYER !");
            }

            entree.setBackground(Color.GREEN);
            selectedClass = entree;
        }

        private void resetCouleur() {
            for (CombinaisonView view : combinaisonIndexMap.keySet()) {
                view.setBackground(Color.WHITE);
            }
        }
    }
}
