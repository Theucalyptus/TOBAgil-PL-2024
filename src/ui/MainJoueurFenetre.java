package ui;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

import jeu.Jeu;
import ui.views.MainJoueurView;

@SuppressWarnings("deprecation")
public class MainJoueurFenetre implements Observer {

    // constantes de classe
    private static final String NOM = "SmallWorld - Joueur Courant";

    // composants de la gui
    private final MainJoueurView view = new MainJoueurView();

    private final Jeu jeu;

    private JFrame fenetre;

    public MainJoueurFenetre(Jeu jeu) {
        this.jeu = jeu;
        jeu.addJoueurCourantObserver(this);

        this.fenetre = new JFrame(NOM);
        Container contenu = fenetre.getContentPane();
        contenu.setLayout(new BorderLayout());
        contenu.add(this.view, BorderLayout.CENTER);


        this.fenetre.pack();
        this.fenetre.setVisible(true);
        this.fenetre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    @Override
    public void update(Observable arg0, Object arg1) {
        this.view.setJoueur(jeu.getJoueurCourant());
        this.fenetre.pack();
    }

}
