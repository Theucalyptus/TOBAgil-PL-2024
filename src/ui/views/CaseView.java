package ui.views;

import javax.swing.*;

import jeu.Case;
import jeu.TypesRegions;
import ui.utils.ImageFactory;

import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.Observable;
import java.util.Observer;


@SuppressWarnings("deprecation")
public class CaseView extends JPanel implements Observer {
    private Image bgImage;
    private JLabel bgLabel;

    private CaseOverlay overlay;

    public CaseView(Case caseAffichee) {
        super();
        super.setLayout(new OverlayLayout(this));
        super.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.WHITE));
        this.bgImage = ImageFactory.regionImage(caseAffichee.getTypeRegion());
        
        this.overlay = new CaseOverlay(this);
        super.add(this.overlay);
        
        this.bgLabel = new JLabel(new ImageIcon(this.bgImage));
        super.add(this.bgLabel);

        // Ajout gestion redimensionnement image dynamique
        super.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent ev) {
                CaseView maCase = (CaseView)ev.getSource();
                maCase.resizeIcon();
            }
        });

        caseAffichee.addObserver(this);

        this.update(caseAffichee, null);
    }

    private void resizeIcon() {
        Image imageTemp = this.bgImage.getScaledInstance(this.getWidth(), this.getHeight(), java.awt.Image.SCALE_SMOOTH);
        this.bgLabel.setIcon(new ImageIcon(imageTemp));
    }

    public void update(Observable arg0, Object arg1) {
        Case maCase = (Case)arg0;
        this.overlay.updateOverlay(maCase);

    }
}