package ui;

import javax.swing.*;

import jeu.TypesRegions;
import ui.utils.ImageFactory;

import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;


public class CaseMonde extends JPanel {
    private Image bgImage;
    private JLabel bgLabel;
    //private Image ovImage;
    private JLabel ovLabel;

    public CaseMonde(TypesRegions typeCase, int x, int y) {
        super();
        super.setLayout(new OverlayLayout(this));;
        
        super.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.WHITE));


        this.bgImage = ImageFactory.regionImage(typeCase);
        
        
        //this.ovImage = ...;
        this.ovLabel = new JLabel();
        if(true) {
            this.ovLabel.setText("Overlay");
        }
        super.add(this.ovLabel);
        
        
        this.bgLabel = new JLabel(new ImageIcon(this.bgImage));
        super.add(this.bgLabel);

        super.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent ev) {
                CaseMonde maCase = (CaseMonde)ev.getSource();
                maCase.resizeIcon();
            }
        });
    }

    private void resizeIcon() {
        Image imageTemp = this.bgImage.getScaledInstance(this.getWidth(), this.getHeight(), java.awt.Image.SCALE_FAST);
        this.bgLabel.setIcon(new ImageIcon(imageTemp));
    }
}