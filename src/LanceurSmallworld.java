import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import ui.utils.ImageFactory;

public class LanceurSmallworld {

    /** La fenêtre. */
    private JFrame fenetre;

    /** Label affichant le logo du jeu. */
    private JLabel logo;

    /** Boutons pour lancer la partie et quitter la partie. */
    private JButton jouerBtn, quitterBtn;
    
    /** Label affichant le rôle de la glissière. */
    private JLabel titreSlider;
    
    /** Glissière servant à sélectionner le nombre de joueurs*/
    private JSlider slider;

    /** Construit une fenêtre affichant le menu.
     */
    public LanceurSmallworld() {
        this.fenetre = new JFrame("SmallWorld - Menu Principal");
        this.fenetre.setSize(new Dimension(1000, 750));
        Container contenu = this.fenetre.getContentPane();

        JPanel mainPanel = new JPanel();
        contenu.add(mainPanel);
        mainPanel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(30, 0, 30, 0);

        this.logo = new JLabel();
        this.logo.setIcon(new ImageIcon(ImageFactory.logoSmallworld()));
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        mainPanel.add(logo, gbc);

        this.jouerBtn = new JButton("Jouer");
        this.jouerBtn.addActionListener(new ActionJouer());
        gbc.gridy = 1;
        mainPanel.add(jouerBtn, gbc);

        this.titreSlider = new JLabel("Nombre de joueurs : ");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(30, 300, 30, 0);
        gbc.anchor = GridBagConstraints.EAST;
        mainPanel.add(titreSlider, gbc);
        
        this.slider = new JSlider(2,5,3);
        this.slider.setPaintLabels(true);
        this.slider.setMajorTickSpacing(1);
        gbc.gridx = 1;
        gbc.insets = new Insets(30, 30, 30, 0);
        gbc.anchor = GridBagConstraints.WEST;
        mainPanel.add(slider, gbc);
        
        this.quitterBtn = new JButton("Quitter");
        this.quitterBtn.addActionListener(new ActionQuitter());
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(30, 0, 30, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(quitterBtn, gbc);
        
        this.fenetre.pack();
        this.fenetre.setVisible(true);
        this.fenetre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

	/** Action lancée lorsque le bouton Jouer est enclenché.
	 */
	private final class ActionJouer implements ActionListener {

		public void actionPerformed(ActionEvent evt) {
			Smallworld.lancerSmallworld(slider.getValue());
			fenetre.dispose();
		}
	}

	/** Action lancée lorsque le bouton Quitter est enclenché.
	 */
	private final class ActionQuitter implements ActionListener {

		public void actionPerformed(ActionEvent evt) {
			fenetre.dispose();
		}
	}
}