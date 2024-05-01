package ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import jeu.Combinaison;
import jeu.peuples.Amazones;
import jeu.peuples.Elfes;
import jeu.pouvoirs.Alchimistes;
import jeu.pouvoirs.Volants;
import ui.views.CombinaisonView;


public class PiocheFenetre {

    // TODO : à exporter dans jeu.pioche;
    public static final int NBCLASSE = 2;

    private CombinaisonView selectedClass = null;
    private JFrame fenetre;

    public PiocheFenetre() {
        this.fenetre = new JFrame("SmallWorld - Pioche");
        this.fenetre.setMinimumSize(new Dimension(800, 600));
        Container contentPane = this.fenetre.getContentPane();

        JPanel mainPanel = new JPanel();
        contentPane.add(mainPanel);
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));

		MouseEventHandler trace = new MouseEventHandler();

        // à refactor pour utiliser pioche quand dispo
        //for(int i=0;i<NBCLASSE;i++){
           CombinaisonView entree = new CombinaisonView(new Combinaison(new Elfes(), new Volants()));
           entree.addMouseListener(trace);
           mainPanel.add(entree);

           entree = new CombinaisonView(new Combinaison(new Amazones(), new Alchimistes()));
           entree.addMouseListener(trace);
           mainPanel.add(entree);
        //}

        JButton selectButton = new JButton("Selectionner");
        selectButton.addActionListener(new ActionQuitter());
        selectButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(selectButton);

        this.fenetre.pack();
        this.fenetre.setVisible(true);
        this.fenetre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

	public class ActionQuitter implements ActionListener {
		
        @Override
        public void actionPerformed(ActionEvent evt) {
			if(selectedClass == null) {
                System.out.println("AUCUNE CLASSE SELECTIONNE - REESSAYER !");
            } else {
                System.out.println("OK - combinaison selectionne");
                fenetre.dispose();
            }
		}
	}

    public class MouseEventHandler extends MouseAdapter {

        @Override
        public void mouseEntered(MouseEvent e) {
            CombinaisonView entree = (CombinaisonView) e.getSource();
            if(selectedClass != entree) {
                entree.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.BLUE));
            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            CombinaisonView entree = (CombinaisonView) e.getSource();
            if(selectedClass != entree) {
                entree.setBorder(BorderFactory.createEmptyBorder());
            }
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            CombinaisonView entree = (CombinaisonView) e.getSource();
            if(selectedClass != null) {
                selectedClass.setBorder(BorderFactory.createEmptyBorder());
            }

            entree.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.GREEN));
            selectedClass = entree;
        }
    }
}