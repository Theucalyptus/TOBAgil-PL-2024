package jeu.exceptions;

public class PartiePleineException extends RuntimeException {

    /**Construire l'éxception. */
    public PartiePleineException() {
        super("La partie est pleine.");
    }
}
