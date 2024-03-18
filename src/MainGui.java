import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import javax.swing.*;


public class MainGui {

    private static final String NOM = "SmallWorld";

    public MainGui() throws IOException {
        JFrame fenetre = new JFrame(NOM);
        Container contenu = fenetre.getContentPane();
        contenu.setLayout(new BorderLayout());

        
        // MENU DU HAUT
        JPanel haut = new JPanel(new FlowLayout());
        contenu.add(haut, BorderLayout.NORTH);
        JLabel txt1 = new JLabel("Information 1");
        haut.add(txt1);
        JLabel txt2 = new JLabel("Information 2");
        txt2.setFont(txt2.getFont().deriveFont(18f));
        haut.add(txt2);
        JLabel txt3 = new JLabel("Information 3");
        haut.add(txt3);
        
        // MENU DU BAS
        JPanel bas = new JPanel(new FlowLayout());
        contenu.add(bas, BorderLayout.SOUTH);
        JButton btn1 = new JButton("Bouton 1");
        btn1.addActionListener(ev -> {
            actionBouton();
        });
        bas.add(btn1);
        JButton btn2 = new JButton("Bouton 2");
        bas.add(btn2);
        JButton btn3 = new JButton("Bouton 3");
        bas.add(btn3);




        // CENTRE
        BufferedImage myPicture = ImageIO.read(new File("../assets/board.jpg"));
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        contenu.add(picLabel, BorderLayout.CENTER);
    
        fenetre.pack();
        fenetre.setVisible(true);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionBouton() {
        System.out.println("Bouton 1 cliqué !");
    }

}