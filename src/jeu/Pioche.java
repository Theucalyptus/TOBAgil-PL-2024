package jeu;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import jeu.pouvoirs.*;
import jeu.peuples.*;
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

    private Random rand = new Random();

    /**Construire un pioche. */
    public Pioche() {
        this.pioche = new ArrayList<Combinaison>();
        this.listePeuples = creerListePeuple();
        this.listePouvoirs = creerListePouvoir();
        this.pioche = creerListeCombinaisons();
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
            if (this.listePeuples.size() == 0) {
                this.listePeuples = creerListePeuple();
            }
            if (this.listePouvoirs.size() == 0) {
                this.listePouvoirs = creerListePouvoir();
            }
            this.pioche = creerListeCombinaisons();
            return getChoix();
        }
    }

    public int lengthPioche() {
        return pioche.size();
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

        listePeuplesRetournee.add(new Amazones());
        listePeuplesRetournee.add(new Elfes());
        listePeuplesRetournee.add(new Geants());
        listePeuplesRetournee.add(new HommesRats());
        listePeuplesRetournee.add(new Humains());
        listePeuplesRetournee.add(new Mages());
        listePeuplesRetournee.add(new MiPortions());
        listePeuplesRetournee.add(new Nains());
        listePeuplesRetournee.add(new Orcs());
        listePeuplesRetournee.add(new Sorciers());
        listePeuplesRetournee.add(new Squelettes());
        listePeuplesRetournee.add(new Tritons());
        listePeuplesRetournee.add(new Trolls());
        listePeuplesRetournee.add(new Zombies());

        /**for (NomClassePeuples nompeuple : NomClassePeuples.values()) {
            
            
            try {
                

            } catch (ClassNotFoundException e) {
                System.out.println("Classe non trouvée pour : " + "jeu.peuples." + nompeuple.name());
                //e.printStackTrace();

            } catch (NoSuchMethodException e) {
                System.out.println("Constructeur par défaut non trouvé pour : " + "jeu.peuples." + nompeuple.name());
                //e.printStackTrace();

            } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                System.out.println("Erreur lors de l'instanciation pour : " + "jeu.peuples." + nompeuple.name());
                //e.printStackTrace();
            }
            
        }*/
        return listePeuplesRetournee;
    }


    /**
     * Creer la liste de l'ensemble des pouvoirs du jeu.
     * @return la liste de l'ensemble des pouvoirs du jeu.
     */
    public List<Pouvoir> creerListePouvoir() {
        List<Pouvoir> listePouvoirsRetournee = new ArrayList<>();

        listePouvoirsRetournee.add(new Alchimistes());
        listePouvoirsRetournee.add(new Ancestraux());
        listePouvoirsRetournee.add(new Armes());
        listePouvoirsRetournee.add(new AuxDeuxHeros());
        listePouvoirsRetournee.add(new Batisseurs());
        listePouvoirsRetournee.add(new Berserks());
        listePouvoirsRetournee.add(new DesCavernes());
        listePouvoirsRetournee.add(new DesCollines());
        listePouvoirsRetournee.add(new DesForets());
        listePouvoirsRetournee.add(new DesMarais());
        listePouvoirsRetournee.add(new Diplomates());
        listePouvoirsRetournee.add(new DurACuire());
        listePouvoirsRetournee.add(new EtLeurDragon());
        listePouvoirsRetournee.add(new Fortunes());
        listePouvoirsRetournee.add(new Marchands());
        listePouvoirsRetournee.add(new Marins());
        listePouvoirsRetournee.add(new Montes());
        listePouvoirsRetournee.add(new Pillards());
        listePouvoirsRetournee.add(new Scouts());
        listePouvoirsRetournee.add(new Volants());


        /*for (NomClassePouvoirs nomPouvoir : NomClassePouvoirs.values()) {
            try {
                Class<?> pouvoirClass = Class.forName("jeu.pouvoirs." + nomPouvoir.name());
                Pouvoir pouvoir =
                    (Pouvoir) pouvoirClass.getDeclaredConstructor().newInstance();
                listePouvoirsRetournee.add(pouvoir);
            } catch (ClassNotFoundException e) {
                System.out.println("Classe non trouvée pour : " + "jeu.pouvoirs." + nomPouvoir.name());
                //e.printStackTrace();

            } catch (NoSuchMethodException e) {
                System.out.println("Constructeur par défaut non trouvé pour : " + "jeu.pouvoirs." + nomPouvoir.name());
                //e.printStackTrace();

            } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                System.out.println("Erreur lors de l'instanciation pour : " + "jeu.pouvoirs." + nomPouvoir.name());
                //e.printStackTrace();
            }
        }*/
        return listePouvoirsRetournee;
    }

    /**
     * Creer la liste de l'ensemble des combinaisons du jeu.
     * @return La liste de l'ensemble des combinaisons de la pioche.
     */
    public List<Combinaison> creerListeCombinaisons() {
        List<Combinaison> listeCombinaisons = new ArrayList<>();
        int taille = Math.min(this.listePeuples.size(), this.listePouvoirs.size());
        for (int i = 0; i < taille; i++) {
            if (this.listePeuples.size() == 0) {
                this.listePeuples = creerListePeuple();
            }
            if (this.listePouvoirs.size() == 0) {
                this.listePouvoirs = creerListePouvoir();
            }

            int num1 = this.rand.nextInt(taille - i);
            int num2 = this.rand.nextInt(taille - i);

            Combinaison combinaison = new Combinaison(
                                this.listePeuples.get(num1),
                                this.listePouvoirs.get(num2));
            listeCombinaisons.add(combinaison);
            // On pourrait supprimer les peuples et combinaison de la liste afin qu'ils n'apparaisent plus
            listePeuples.remove(num1);
            listePouvoirs.remove(num2);
        }
        return listeCombinaisons;
    }
    
    
    /**
     * Donner la Combinaison attachée à l'indice donnée en argument.
     * @param indice L'indice de la combinaison voulut.
     */
    public Combinaison combinaisonChoisit(int indice) {

        Combinaison combinaison = this.pioche.get(indice);
        // Remettre l'association au fond de la pioche
        this.pioche.remove(indice);
        return combinaison;
    }

}
