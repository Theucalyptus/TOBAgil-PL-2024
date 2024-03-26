package ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class ClasseSelectionMenu {

    public class ClasseEntry extends JPanel {

        private int numero;

        public ClasseEntry(int i) {
            super();
            this.numero = i;
            super.add(new JLabel("Icon de la classe " + i));
            super.add(new JLabel("Nom de la classe " + i));
            super.add((new JLabel("Descripton de la classe " + i)));
        }

        public int getNumero() {
            return this.numero;
        }
    }

    public static final int NBCLASSE = 5;
    private ClasseEntry selectedClass = null;
    private JFrame fenetre;

    public ClasseSelectionMenu() {
        this.fenetre = new JFrame("Selection d'une classe");
        this.fenetre.setMinimumSize(new Dimension(800, 600));
        Container contentPane = this.fenetre.getContentPane();
        
        JPanel mainPanel = new JPanel();
        contentPane.add(mainPanel);
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));

		MouseEventHandler trace = new MouseEventHandler();

        for(int i=0;i<NBCLASSE;i++){
           ClasseEntry entree = new ClasseEntry(i+1);
           entree.addMouseListener(trace);
           mainPanel.add(entree);
        }

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
                System.out.println("AUCUNE CLASSE SELECTIONNE");
            } else {
                System.out.println("OK");
                fenetre.dispose();
            }
		}
	}

    public class MouseEventHandler extends MouseAdapter {
        
        @Override
        public void mouseEntered(MouseEvent e) {
            ClasseEntry entree = (ClasseEntry) e.getSource();
            if(selectedClass != entree) {
                entree.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.BLUE));
            }
        }
        
        @Override
        public void mouseExited(MouseEvent e) {
            ClasseEntry entree = (ClasseEntry) e.getSource();
            if(selectedClass != entree) {
                entree.setBorder(BorderFactory.createEmptyBorder());
            }
        }    
    
        @Override
        public void mouseClicked(MouseEvent e) {
            ClasseEntry entree = (ClasseEntry) e.getSource();
            if(selectedClass != null) {
                selectedClass.setBorder(BorderFactory.createEmptyBorder());
            }
            
            entree.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.GREEN));
            selectedClass = entree;
        }
    }
}