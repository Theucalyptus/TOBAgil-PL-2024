package jeu.exceptions;

/**Exception qui est levé quand le joueur tente de tricher. */
public class OperationInterditeException extends RuntimeException {

    /**Constructeur de la classe avec le message d'erreur.
     * @param message Le message de la case
    */
    public OperationInterditeException(String message) {
        super(message);
    }
}
