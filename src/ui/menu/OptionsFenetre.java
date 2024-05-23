package ui.menu;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

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
    private List<ChampJoueur> champsJoueurs;
    
    public OptionsFenetre(LanceurSmallworld lanceur) {
    	this.fenetre = new JFrame("SmallWorld - Options");
    	this.fenetre.setSize(new Dimension(500, 375));
    	
    	this.champsJoueurs = new ArrayList<>();
    	List<String> nomsJoueurs = lanceur.getNomsJoueurs();
    	
    	this.lanceur = lanceur;
    	
    	JPanel mainPanel = new JPanel();
    	mainPanel.setLayout(new GridBagLayout());
    	
        GridBagConstraints gbcMain = new GridBagConstraints();
        gbcMain.insets = new Insets(30, 30, 30, 30);
        
    	this.fenetre.add(mainPanel);
    	
    	JPanel sliderPanel = new JPanel();
    	sliderPanel.setLayout(new GridLayout(1,2));
    	
        this.titreSlider = new JLabel("Nombre de joueurs : ");
        sliderPanel.add(titreSlider);
        
        this.slider = new JSlider(2,5,nomsJoueurs.size());
        this.slider.setPaintLabels(true);
        this.slider.setMajorTickSpacing(1);
        sliderPanel.add(slider);
        
        gbcMain.gridy = 0;
        mainPanel.add(sliderPanel, gbcMain);
        
    	JPanel champsPanel = new JPanel();
    	champsPanel.setLayout(new GridBagLayout());
    	
        GridBagConstraints gbcChamps = new GridBagConstraints();
        gbcChamps.insets = new Insets(0, 30, 0, 30);
        gbcChamps.ipadx = 30;
        gbcChamps.ipady = 15;
        
        int numeroJoueur = 1;
        
        for(String nomJoueur : nomsJoueurs) {
        	ChampJoueur champ = new ChampJoueur(numeroJoueur);
        	champ.setText(nomJoueur);
        	
        	slider.addChangeListener(champ);
        	this.champsJoueurs.add(champ);
        	
        	champsPanel.add(champ, gbcChamps);
        	numeroJoueur++;
        }
        
        while(numeroJoueur <= 5) {
        	ChampJoueur champ = new ChampJoueur(numeroJoueur);
        	champ.setText("- - -");
        	champ.setEditable(false);
        	
        	slider.addChangeListener(champ);
        	this.champsJoueurs.add(champ);
        	
        	champsPanel.add(champ, gbcChamps);
        	numeroJoueur++;
        }
        
        gbcMain.gridy = 1;
        mainPanel.add(champsPanel, gbcMain);
        
    	JPanel boutonsPanel = new JPanel();
    	boutonsPanel.setLayout(new GridBagLayout());
    	
        GridBagConstraints gbcBtn = new GridBagConstraints();
        gbcBtn.insets = new Insets(0, 30, 0, 30);
        
        this.enregistrerBtn = new JButton("Enregistrer");
        this.enregistrerBtn.addActionListener(new ActionEnregistrer());
        boutonsPanel.add(enregistrerBtn, gbcBtn);
        
        this.annulerBtn = new JButton("Annuler");
        this.annulerBtn.addActionListener(new ActionAnnuler());
        boutonsPanel.add(annulerBtn, gbcBtn);
        
        gbcMain.gridy = 2;
        mainPanel.add(boutonsPanel, gbcMain);
    	
        this.fenetre.pack();
        this.fenetre.setVisible(true);
        this.fenetre.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }
    
    private class ChampJoueur extends JTextField implements ChangeListener {
    	private int numeroJoueur;
    	
    	public ChampJoueur(int numeroJoueur) {
    		super();
    		this.setHorizontalAlignment(JTextField.CENTER);
    		this.numeroJoueur = numeroJoueur;
    	}

		public void stateChanged(ChangeEvent e) {
			if(numeroJoueur <= ((JSlider) e.getSource()).getValue()) {
				this.setEditable(true);
			} else {
				this.setEditable(false);
			}
		}
    }
    
	private void messageDialogue(ActionEvent evt, String message) {
		JFrame fenetre =
			(JFrame) SwingUtilities.getWindowAncestor((JButton) evt.getSource());
		JOptionPane.showMessageDialog(fenetre, message);
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
			List<String> nomsJoueurs = new ArrayList<>();
			for(ChampJoueur champ : champsJoueurs) {
				if(champ.isEditable()) {
					nomsJoueurs.add(champ.getText());
				}
			}
			
			boolean peutEnregistrer = true;
			
			for(String nom : nomsJoueurs) {
				if(nom.isEmpty()) {
					peutEnregistrer = false;
				}
			}
			
			if(peutEnregistrer) {
				lanceur.setNomsJoueurs(nomsJoueurs);
				fenetre.dispose();
			} else {
				messageDialogue(evt, "Tous les noms de joueurs ne sont pas renseignés.");
			}
		}
	}

}
