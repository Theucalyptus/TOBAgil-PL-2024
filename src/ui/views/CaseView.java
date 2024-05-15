package ui.views;

import javax.swing.*;

import jeu.Case;
import ui.utils.ImageFactory;

import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.Observable;
import java.util.Observer;


@SuppressWarnings("deprecation")
public class CaseView extends JPanel implements Observer {
    /** L'image de fond de la case. */
    private Image bgImage;
    /** Le label de fond de la case. */
    private JLabel bgLabel;
    /** La case affichée. */
    private Case caseAffichee = null;
    /** L'overlay affiché par dessus la case. */
    private CaseOverlay overlay;

    /**
     * Construit la vue d'une case du jeu.
     * @param caseAffichee La case à afficher.
     */
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
                CaseView maCase = (CaseView) ev.getSource();
                maCase.resizeIcon();
            }
        });

        caseAffichee.addObserver(this);
        this.overlay.updateOverlay(caseAffichee);

        this.caseAffichee = caseAffichee;
    }

    /** Redimensionne l'image de fond quand la taille de la fenêtre change. */
    private void resizeIcon() {
        Image imageTemp = this.bgImage.getScaledInstance(this.getWidth(),
            this.getHeight(),
            java.awt.Image.SCALE_SMOOTH);

        this.bgLabel.setIcon(new ImageIcon(imageTemp));
    }

    @Override
    public void update(Observable arg0, Object arg1) {
        Case maCase = (Case) arg0;
        this.overlay.updateOverlay(maCase);

    }

    /**
     * Renvoie la case affichée par la vue.
     * @return la case
     */
    public Case getVraieCase() {
    	return this.caseAffichee;
    }
}
