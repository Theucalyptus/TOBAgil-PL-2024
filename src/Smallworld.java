import ui.MainGui;
import jeu.JeuReel;
import ui.ClasseSelectionMenu;;

public class Smallworld {

    public static void main(String[] args) {

        System.out.println("Lancement GUI");
        new ClasseSelectionMenu();
       
        JeuReel jeu = new JeuReel();
        new MainGui(jeu);
        System.out.println("GUI lancée");

    }
}