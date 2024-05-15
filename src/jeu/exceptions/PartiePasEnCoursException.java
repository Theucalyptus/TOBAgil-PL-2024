package jeu.exceptions;

public class PartiePasEnCoursException extends RuntimeException {

    /**Construire l'exception. */
    public PartiePasEnCoursException() {
        super("La partie n'est en cours (pas lancée ou terminée).");
    }
}
