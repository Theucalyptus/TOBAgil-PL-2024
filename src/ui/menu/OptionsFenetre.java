package ui.menu;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class OptionsFenetre {
	
    /** La fenêtre. */
    private JFrame fenetre;
    
    /** Le lanceur Smallworld ayant créer cette fenêtre d'options. */
    private LanceurSmallworld lanceur;
    
    /** Glissière servant à sélectionner le nombre de joueurs*/
    private JSlider slider;
    
    /** Label affichant le rôle de la glissière. */
    private JLabel titreSlider;
    
    /** Boutons pour enregistrer et annuler les changements. */
    private JButton enregistrerBtn, annulerBtn;
    
    /** Champs de texte pour inscrire le nom des joueurs. */
    private Set<ChampJoueur> champsJoueurs;
    
    public OptionsFenetre(LanceurSmallworld lanceur) {
    	this.fenetre = new JFrame("SmallWorld - Options");
    	this.fenetre.setSize(new Dimension(500, 375));
    	
    	this.champsJoueurs = new HashSet<>();
    	
    	this.lanceur = lanceur;
    	
    	JPanel mainPanel = new JPanel();
    	mainPanel.setLayout(new GridBagLayout());
    	this.fenetre.getContentPane().add(mainPanel);
    	
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(30, 15, 30, 15);
    	
        this.titreSlider = new JLabel("Nombre de joueurs : ");
        gbc.gridx = 1;
        gbc.gridy = 0;
        mainPanel.add(titreSlider, gbc);
        
        this.slider = new JSlider(2,5,3);
        this.slider.setPaintLabels(true);
        this.slider.setMajorTickSpacing(1);
        gbc.gridx = 2;
        gbc.gridy = 0;
        mainPanel.add(slider, gbc);
        
        Set<String> nomsJoueurs = lanceur.getNomsJoueurs();
        
        int numeroJoueur = 1;
        
        for(String nomJoueur : nomsJoueurs) {
        	ChampJoueur champ = new ChampJoueur(numeroJoueur);
        	champ.setText(nomJoueur);
        	
        	slider.addChangeListener(champ);
        	this.champsJoueurs.add(champ);
        	
        	gbc.gridx = numeroJoueur-1;
        	gbc.gridy = 1;
        	mainPanel.add(champ, gbc);
        	numeroJoueur++;
        }
        
        while(numeroJoueur <= 5) {
        	ChampJoueur champ = new ChampJoueur(numeroJoueur);
        	champ.setText("- - - - -");
        	champ.setEditable(false);
        	
        	slider.addChangeListener(champ);
        	this.champsJoueurs.add(champ);
        	
        	gbc.gridx = numeroJoueur-1;
        	gbc.gridy = 1;
        	mainPanel.add(champ, gbc);
        	numeroJoueur++;
        }
        
        this.enregistrerBtn = new JButton("Enregistrer");
        this.enregistrerBtn.addActionListener(new ActionEnregistrer());
        gbc.gridy = 2;
        gbc.gridx = 2;
        mainPanel.add(enregistrerBtn, gbc);
        
        this.annulerBtn = new JButton("Annuler");
        this.annulerBtn.addActionListener(new ActionAnnuler());
        gbc.gridy = 2;
        gbc.gridx = 1;
        mainPanel.add(annulerBtn, gbc);
    	
        this.fenetre.pack();
        this.fenetre.setVisible(true);
        this.fenetre.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }
    
    private class ChampJoueur extends JTextField implements ChangeListener {
    	private int numeroJoueur;
    	
    	public ChampJoueur(int numeroJoueur) {
    		super();
    		this.numeroJoueur = numeroJoueur;
    	}

		public void stateChanged(ChangeEvent e) {
			if(numeroJoueur <= ((JSlider) e.getSource()).getValue()) {
				this.setEditable(true);
			} else {
				this.setEditable(false);
				this.setText("-  -  -");
			}
		}
    }
    
	/** Action lancée lorsque le bouton Annuler est enclenché.
	 */
	private final class ActionAnnuler implements ActionListener {

		public void actionPerformed(ActionEvent evt) {
			fenetre.dispose();
		}
	}
	
	/** Action lancée lorsque le bouton Enregistrer est enclenché.
	 */
	private final class ActionEnregistrer implements ActionListener {

		public void actionPerformed(ActionEvent evt) {
			
			Set<String> nomsJoueurs = new HashSet<>();
			for(ChampJoueur champ : champsJoueurs) {
				if(champ.isEditable()) {
					nomsJoueurs.add(champ.getText());
				}
			}
			
			lanceur.setNomsJoueurs(nomsJoueurs);
			
			fenetre.dispose();
		}
	}

}
