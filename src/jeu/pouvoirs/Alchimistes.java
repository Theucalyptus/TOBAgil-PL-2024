package jeu.pouvoirs;

public class Alchimistes extends Pouvoir {
    
    private static final String NOM = "Alchimistes";
    private static final String DESCRIPTION = "Tant que votre Peuple Alchimiste est actif, prenez 2 jetons de victoire supplémentaires à la fin de chaque tour";


    public Alchimistes() {
        super(TypesPouvoirs.ALCHIMISTES, NOM, DESCRIPTION);
    }
}
