package jeu.exceptions;

public class JoueurDejaDansLaPartieException extends RuntimeException {

    public JoueurDejaDansLaPartieException() {
        super("Le joueur que vous essayé d'ajouter fait déjà partie de la partie.");
    }
}
