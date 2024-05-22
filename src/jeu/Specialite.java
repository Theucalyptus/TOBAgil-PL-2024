package jeu;

/**
 * Classe abstraite représentant une spécialité.
 * Elle peut être étendue en pouvoir ou en peuple.
 */
public abstract class Specialite {
    /**Le nom de la spécialité.*/
    private String nom;

    /**La description de la spécialité.*/
    private String description;

    /**Le nombre de pions supplémentaires qu'apporte la spécialité.*/
    private int nbPions;

    /**Le nombre de jetons de victoire qu'apporte la spécialité en fin de tour.*/
    protected int nbJetons = 0;

    /**La réduction du coût en pions d'attaque d'une case.*/
    protected int reductionAttaque = 0;

    /**Construire une spécialité à partir de son nom, de sa description
     * et de son nombre de pions supplémentaires.
     * @param nom Le nom de la spécialité.
     * @param description La description de la spécialité.
     * @param pionsSup Le nombre de pions suplémentaires qu'apporte la spécialité.
    */
    public Specialite(String nom, String description, int pionsSup) {
        /* if (nom == null || nom.equals("") || description == null
                || description.equals("") || pionsSup < 0) {
            throw new IllegalArgumentException("L'appel n'est pas correct.");
        } */
        this.nom = nom;
        this.description = description;
        this.nbPions = pionsSup;
    }

    /**Donner le nom de la spécialité.
     * @return Le nom de la spécialité.
     */
    public String getNom() {
        return this.nom;
    }

    /**Donner la description de la spécialité.
     * @return La description de la spécialité.
     */
    public String getDescription() {
        return this.description;
    }

    /**Donner le nombre de pions supplémentaire qu'offre cette spécialité.
     * @return Le nombre de pions supplémentaire.
     */
    public int getNbPions() {
        return this.nbPions;
    }

    /**Donner le nombre de jetons supplémentaire qu'offre cette spécialité en fin de tour.
     * @return Le nombre de jetons supplémentaire.
     */
    public int getNbJetons() {
        return this.nbJetons;
    }

    /**Procédure à appeler lors du début du tour du joueur.
     * Le début d'un tour est également le début de l'attaque.
     */
    public void debutTour() {
    }

    /**Procédure à appeler avant la conquête d'une région.
     * @param regionAConquerir La région à conquérir.
     */
    public void avantConquete(Case regionAConquerir) {
        if (regionAConquerir == null) {
            throw new IllegalArgumentException("regionAConquerir ne doit pas être null.");
        }
    }

    /**Procédure à appeler après la conquête d'une région.
     * @param regionConquise La région qui a été conquise.
     */
    public void apresConquete(Case regionConquise) {
        if (regionConquise == null) {
            throw new IllegalArgumentException("regionConquise ne doit pas être null.");
        }
    }

    /**Procédure à appeler après la conquête d'une région du joueur par un autre joueur.
     * @param regionConquise La région qui a été conquise.
     */
    public void apresConqueteAdverse(Case regionConquise) {
        if (regionConquise == null) {
            throw new IllegalArgumentException("regionConquise ne doit pas être null.");
        }
    }

    /**Procédure à appeler une fois la phase d'attaque terminée.
     * Cet instant correspond aussi au redéploiement.
     */
    public void finAttaque() {
    }

    /**Procédure à appeler lors de la fin du tour du joueur.
     * @param enDeclin Si le peuple est en déclin.
     */
    public void finTour(boolean enDeclin) {
    }

}
