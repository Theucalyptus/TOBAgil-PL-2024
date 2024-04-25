package jeu;
import java.util.ArrayList;
import java.util.List;
import jeu.Combinaison;
import jeu.pouvoirs.*;
import jeu.peuples.*;
import java.util.Random;


public class Pioche {

    private List<Combinaison> pioche;

    private List<Peuple> listePeuples;

    private List<Pouvoir> listePouvoirs;
    
    public Pioche() {
        this.pioche = new ArrayList<Combinaison>();
        this.listePeuples = creerListePeuple();
        this.listePouvoirs = creerListePouvoir();
        this.pioche = creerListeCombinaisons(this.listePeuples, this.listePouvoirs);
    }



    //===============================================================
    //                          Getteurs
    //===============================================================



    public List<Combinaison> getChoix() {
        int length_pioche = pioche.size();
        if (length_pioche >= 6) {
            return pioche.subList(0, 6);
        } else if (length_pioche > 0) {
            return pioche.subList(0, length_pioche);
        } else {
            this.pioche = creerListeCombinaisons();
            return getChoix();
        }
    }


    //===============================================================
    //                          Commandes
    //===============================================================


    public List<Peuple> creerListePeuple() {
        List<Peuple> listePeuples = new ArrayList<>();
        
        for (TypesPeuples nompeuple : TypesPeuples.values()) {
            try {
                Class<?> peupleClass = Class.forName("jeu.peuple." + nompeuple.name());
                Peuple peuple = (Peuple) peupleClass.getDeclaredConstructor().newInstance();
                listePeuples.add(peuple);
            } catch (Exception e) {
                System.out.println("Error creating instance for: " + type.name());
                e.printStackTrace();
            }
        }
        return listePeuples;
    }



    public List<Pouvoir> creerListePouvoir() {
        List<Pouvoir> listePouvoirs = new ArrayList<>();
        
        for (TypesPouvoirs nomPouvoir : TypesPouvoirs.values()) {
            try {
                Class<?> peupleClass = Class.forName("jeu.peuple." + nomPouvoir.name());
                Pouvoir pouvoir = (Pouvoir) peupleClass.getDeclaredConstructor().newInstance();
                listePouvoirs.add(pouvoir);
            } catch (Exception e) {
                System.out.println("Erreur pour : " + type.name());
                e.printStackTrace();
            }
        }
        return listePouvoirs;
    }


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


    public void combinaisonChoisit(int indice) {

        Peuple peuple = this.pioche.get(indice).getPeuple();
        Pouvoir pouvoir = this.pioche.get(indice).getPouvoir();         // ils faudraient les rajouter que si ils ne sont plus utiliser

        this.pioche.remove(indice);
    }

}
