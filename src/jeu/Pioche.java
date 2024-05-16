package jeu;
import java.util.ArrayList;
import java.util.List;
import jeu.pouvoirs.Pouvoir;
import jeu.peuples.Peuple;
import jeu.peuples.TypesPeuples;
import jeu.pouvoirs.TypesPouvoirs;
import java.util.Random;


/**
 * Classe d'implémantation de la prioche.
 */
public class Pioche {

    /**Le nombre de Combinaison dans la pioche. */
    public static final int LONGUEURPIOCHE = 6;

    /** Stockage de la pioche. */
    private List<Combinaison> pioche;

    /**Liste l'ensembles des peuples du jeu. */
    private List<Peuple> listePeuples;

    /** Liste l'ensemble des Pouvoirs du jeu. */
    private List<Pouvoir> listePouvoirs;

    /**Construire un pioche. */
    public Pioche() {
        this.pioche = new ArrayList<Combinaison>();
        this.listePeuples = creerListePeuple();
        this.listePouvoirs = creerListePouvoir();
        this.pioche = creerListeCombinaisons(this.listePeuples, this.listePouvoirs);
    }



    //===============================================================
    //                          Getteurs
    //===============================================================


    /**
     * Donner la pioche accessible par le joueur.
     * @return La pioche accessible par le joueur.
     */
    public List<Combinaison> getChoix() {
        int lengthPioche = pioche.size();
        if (lengthPioche >= LONGUEURPIOCHE) {
            return pioche.subList(0, LONGUEURPIOCHE);
        } else if (lengthPioche > 0) {
            return pioche.subList(0, lengthPioche);
        } else {
            this.pioche = creerListeCombinaisons();
            return getChoix();
        }
    }


    //===============================================================
    //                          Commandes
    //===============================================================


    /**
     * Creer la liste de l'ensemble des peuples du jeu.
     * @return La liste de l'ensemble des pouples du jeu.
     */
    public List<Peuple> creerListePeuple() {
        List<Peuple> listePeuplesRetournee = new ArrayList<>();

        for (TypesPeuples nompeuple : TypesPeuples.values()) {
            try {
                Class<?> peupleClass = Class.forName("jeu.peuple." + nompeuple.name());
                Peuple peuple =
                    (Peuple) peupleClass.getDeclaredConstructor().newInstance();

                listePeuplesRetournee.add(peuple);
            } catch (Exception e) {
                System.out.println("Error creating instance for: " + type.name());
                e.printStackTrace();
            }
        }
        return listePeuplesRetournee;
    }


    /**
     * Creer la liste de l'ensemble des pouvoirs du jeu.
     * @return la liste de l'ensemble des pouvoirs du jeu.
     */
    public List<Pouvoir> creerListePouvoir() {
        List<Pouvoir> listePouvoirsRetournee = new ArrayList<>();

        for (TypesPouvoirs nomPouvoir : TypesPouvoirs.values()) {
            try {
                Class<?> peupleClass = Class.forName("jeu.peuple." + nomPouvoir.name());
                Pouvoir pouvoir =
                    (Pouvoir) peupleClass.getDeclaredConstructor().newInstance();
                listePouvoirsRetournee.add(pouvoir);
            } catch (Exception e) {
                System.out.println("Erreur pour : " + type.name());
                e.printStackTrace();
            }
        }
        return listePouvoirsRetournee;
    }

    /**
     * Creer la liste de l'ensemble des combinaisons du jeu.
     * @return La liste de l'ensemble des combinaisons de la pioche.
     */
    public List<Combinaison> creerListeCombinaisons() {
        List<Combinaison> listeCombinaisons = new ArrayList<>();
        Random rand = new Random();
        int taille = Math.min(this.listePeuples.size(), this.listePouvoirs.size());
        for (int i = 0; i < taille; i++) {

            int num1 = rand.nextInt(taille - i);
            int num2 = rand.nextInt(taille - i);

            Combinaison combinaison = new Combinaison(
                                this.listePeuples.get(num1),
                                this.listePouvoirs.get(num2));
            listeCombinaisons.add(combinaison);

            listePeuples.remove(num1);
            listePouvoirs.remove(num2);
        }
        return listeCombinaisons;
    }

    /**
     * Donner la Combinaison attachée à l'indice donnée en argument.
     * @param indice L'indice de la combinaison voulut.
     */
    public void combinaisonChoisit(int indice) {
        if (indice < 0 || indice > LONGUEURPIOCHE) {
            throw new IllegalArgumentException("indice doit "
                + "être en 1 et LONGUEURPIOCHE.");
        }
        Peuple peuple = this.pioche.get(indice).getPeuple();
        Pouvoir pouvoir = this.pioche.get(indice).getPouvoir();
        // ils faudraient les rajouter que si ils ne sont plus utiliser
        this.pioche.remove(indice);
    }

}
