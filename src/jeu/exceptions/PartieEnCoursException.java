package jeu.exceptions;

public class PartieEnCoursException extends RuntimeException {

    /**Construire l'exception. */
    public PartieEnCoursException() {
        super("La partie est en Cours.");
    }
}
