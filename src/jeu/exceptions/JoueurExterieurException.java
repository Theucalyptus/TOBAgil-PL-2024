package jeu.exceptions;

public class JoueurExterieurException extends RuntimeException {
    
    /**Construire l'exception qui est levé quand on tente de passer un joueur
     * qui n'est pas dans partie comme joueur courant.
     */
    public JoueurExterieurException() {
        super("Le joueur ne fait pas partie de la partie.");
    }
}
