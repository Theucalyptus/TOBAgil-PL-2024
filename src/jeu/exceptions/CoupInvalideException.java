package jeu.exceptions;

/**Exception qui est levé si les mouvements proposés par le Joueurs ne sont pas
 * valable.
 */
public class CoupInvalideException extends Exception {
    
    /**Constructeur de l'éxception.
     * @param message Le message du Problème
    */
    public CoupInvalideException(String message) {
        super(message);
    }
}
