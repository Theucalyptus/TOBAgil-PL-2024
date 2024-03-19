package ui;

import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class MainMondeView extends JPanel {
    
    public class CaseMonde extends JLabel {
        private int coordX;
        private int coordY;

        private CaseMonde(BufferedImage image, int x, int y) {
            super(new ImageIcon(image));
            this.coordX = x;
            this.coordY = y;
        }
    }

    public CaseMonde creerCase(int x, int y, Boolean isTerre) {
        String path = "../assets/" + (isTerre ? "soil.png" : "water.png");
        try {
            BufferedImage myPicture = ImageIO.read(new File(path));
            return new CaseMonde(myPicture, x, y);
        } catch (Exception e) {
            System.out.println("zehjfozjfez");
            throw new RuntimeException();
        }
    }    
    
    public final static int NbLignes = 4;
    public final static int NbColonnes = 4;


    private final static Boolean[][] terre = { {true, true, true, true}, {true, false, false, false}, {true, true, false, false}, {false, false, false, false}};
    private GridLayout layout;
    private List<CaseMonde> cases;

    public MainMondeView() {
        super();
        this.layout = new GridLayout(NbLignes, NbColonnes);
        super.setLayout(this.layout);
        this.cases = new ArrayList<CaseMonde>();

        for(int i=0;i<NbLignes;i++) {
            for(int j=0;j<NbColonnes; j++) {
                CaseMonde temp = creerCase(i, j, terre[i][j]);
                cases.add(temp);
                super.add(temp);
            }
        }
    }


}
