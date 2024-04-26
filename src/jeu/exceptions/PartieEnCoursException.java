package jeu.exceptions;

public class PartieEnCoursException extends RuntimeException {
    
    public PartieEnCoursException() {
        super("La partie est en Cours.");
    }
}
