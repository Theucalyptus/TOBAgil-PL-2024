import java.io.IOException;

public class Smallworld {

    public static void main(String[] args) {

        System.out.println("Hello, World!");
        try {
            new MainGui();
        } catch (IOException e) {
            System.out.println("Une erreur d'IO est survenue.");
        }

    }
}