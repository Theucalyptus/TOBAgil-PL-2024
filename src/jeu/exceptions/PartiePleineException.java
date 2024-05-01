package jeu.exceptions;

public class PartiePleineException extends RuntimeException {

    public PartiePleineException() {
        super("La partie est pleine.");
    }
}
