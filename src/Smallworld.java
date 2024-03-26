import ui.MainGui;
import jeu.JeuReel;
import ui.ClasseSelectionMenu;;

public class Smallworld {

    public static void main(String[] args) {

        System.out.println("Lancement GUI");
        new ClasseSelectionMenu();
        new MainGui(new JeuReel());
        System.out.println("GUI lancée");

    }
}