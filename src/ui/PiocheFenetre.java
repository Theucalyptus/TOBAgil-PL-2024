package ui;

import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jeu.Combinaison;
import jeu.Jeu;
import jeu.JoueurState;
import jeu.peuples.*;
import jeu.pouvoirs.*;
import ui.selecteur.Selecteur;
import ui.views.CombinaisonView;
import jeu.Pioche;


public class PiocheFenetre {

    // TODO : à exporter dans jeu.pioche;
    public static final int NBCLASSE = 5;
    private Pioche pioche;
    private CombinaisonView selectedClass = null;

    /** Le jeu affiché. */
    private final Jeu jeu;

    /** La fenêtre. */
    private JFrame fenetre;
    private Map<CombinaisonView, Integer> combinaisonIndexMap = new HashMap<>();

    private JPanel mainPanel;
    private MouseEventHandler trace;

    private Selecteur<Combinaison> selecteurCombinaison;

    /** Construit une fenêtre affichant la pioche. */
    public PiocheFenetre(Selecteur<Combinaison> selecteurCombinaison) {
        this.pioche = new Pioche();
        this.fenetre = new JFrame("SmallWorld - Pioche");
        this.fenetre.setMinimumSize(new Dimension(800, 600));
        this.selecteurCombinaison = selecteurCombinaison;
        Container contentPane = this.fenetre.getContentPane();

        this.mainPanel = new JPanel();
        contentPane.add(mainPanel);
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));

		this.trace = new MouseEventHandler();

        updateView();

        //List<Combinaison> Visible = pioche.getChoix();
        //for (int i = 0; i <= Math.min(pioche.lengthPioche(), pioche.LONGUEURPIOCHE) ; i++) {

        //    CombinaisonView entree =
        //        new CombinaisonView(Visible.get(i));
        //    entree.addMouseListener(trace);
        //    mainPanel.add(entree);
        //    combinaisonIndexMap.put(entree, i);
        // à refactor pour utiliser pioche quand dispo
        //for(int i=0;i<NBCLASSE;i++){
        //   CombinaisonView entree =
        //        new CombinaisonView(new Combinaison(new Elfes(), new Volants()));
        //   entree.addMouseListener(trace);
        //   mainPanel.add(entree);

        //   entree =
        //        new CombinaisonView(new Combinaison(new Amazones(), new Alchimistes()));
        //   entree.addMouseListener(trace);
        //   mainPanel.add(entree);
        //}
        //}

        this.fenetre.pack();
        this.fenetre.setVisible(true);
        this.fenetre.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }

    private void updateView() {
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

        JButton selectButton = new JButton("Selectionner");
        selectButton.addActionListener(new ActionQuitter());
        selectButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(selectButton);
    }

	public class ActionQuitter implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evt) {
			if (selectedClass == null) {
                System.out.println("AUCUNE CLASSE SELECTIONNE - REESSAYER !");
            } else {
                System.out.println("OK - combinaison selectionne");
                int indiceChoisi = combinaisonIndexMap.get(selectedClass);
                Combinaison combinaison = pioche.combinaisonChoisit(indiceChoisi);
                selecteurCombinaison.setSelection(combinaison);
                updateView();
            }
		}
	}

    public class MouseEventHandler extends MouseAdapter {

        @Override
        public void mouseEntered(MouseEvent e) {
            CombinaisonView entree = (CombinaisonView) e.getSource();
            if (selectedClass != entree) {
                entree.setBackground(Color.BLUE);
            //    entree.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.BLUE));
            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            CombinaisonView entree = (CombinaisonView) e.getSource();
            if (selectedClass != entree) {
                entree.setBackground(Color.WHITE);
                entree.setBorder(BorderFactory.createEmptyBorder());
            }
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            CombinaisonView entree = (CombinaisonView) e.getSource();
            if (selectedClass != null) {
                entree.setBackground(Color.WHITE);
            //    selectedClass.setBorder(BorderFactory.createEmptyBorder());
            }
            entree.setBackground(Color.GREEN);
            //entree.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.GREEN));
            selectedClass = entree;
        }
    }
}
