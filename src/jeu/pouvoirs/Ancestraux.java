package jeu.pouvoirs;

/**Classe Ancestraux. L'Ancestral est un pouvoir qui permet d'avoir deux peuples
 * en déclin en même temps.*/
public class Ancestraux extends Pouvoir {
    
    /**Le nom de la classe. */
    private static final String NOM = "Ancestraux";

    /**La description du pouvoir. */
    private static final String DESCRIPTION = "Lorsque votre peuple ancestral est "
            + "en déclin, il ne compte plus dans la limite précisée dans la section "
            + "Passer en declin qui indique qu'un même joueur ne peut avoir qu'un seul "
            + "Peuple en déclin à la fois. Vous pouvez donc avoir deux peuples en déclin"
            + "à la fois, qui vous rapportent des jetons de victoire. Si vous passez un "
            + "Troisième peuple en déclin votre Peuple ancestral reste sur le plateau, "
            + "mais votre autre Peuple en déclin disparaît, comme d'habitude. En faite, "
            + "les pions de votre Peuple ancestral ne quittent le plateau que s'ils sont "
            + "anéantis par l'ennemi.";


    /**Le nombre d'unité suplémentaire qu'offre le jeu. */
    private static final int PIONSSUP = 5;

    /**Construire un Ancestral. */
    public Ancestraux() {
        super(NOM, DESCRIPTION, PIONSSUP);
    }

}
