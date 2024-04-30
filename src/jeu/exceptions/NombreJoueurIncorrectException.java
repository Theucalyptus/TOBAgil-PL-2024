package jeu.exceptions;

public class NombreJoueurIncorrectException extends RuntimeException {
    
    public NombreJoueurIncorrectException() {
        super("Le nombre de joueur dans la partie ne permet pas de la lancer (il faut être entre 2 et 5 joueurs.");
    }
}
