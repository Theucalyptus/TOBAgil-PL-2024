package ui;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import jeu.peuples.*;
import jeu.pouvoirs.*;
import ui.utils.ImageFactory;

public class MainBotttomBar extends JPanel {
 
    public static class JoueurDebug {
        public static final Peuple peuple = new Elfes();    
        public static final Pouvoir pouvoir = new Alchimistes(); 
    }


    private JLabel peuple = new JLabel();
    private JLabel pouvoir = new JLabel();


    public MainBotttomBar() {
        super();

        super.setBackground(Color.BLACK);

        this.peuple.setIcon(new ImageIcon(ImageFactory.peupleLogoImage(JoueurDebug.peuple.getTypePeuple())));
        this.peuple.setText(JoueurDebug.peuple.getNom() + " : " + JoueurDebug.peuple.getDescription());
        this.pouvoir.setIcon(new ImageIcon(ImageFactory.pouvoirLogoImage(JoueurDebug.pouvoir.getTypePouvoir())));
        this.pouvoir.setText(JoueurDebug.pouvoir.getNom() + " : " + JoueurDebug.pouvoir.getDescription());
        this.peuple.setForeground(Color.WHITE);
        this.pouvoir.setForeground(Color.WHITE);
        super.add(this.peuple);
        super.add(this.pouvoir);
    }

}
