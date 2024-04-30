package controleurs;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

import jeu.Jeu;

public class ActionsJeu extends JPanel {
    
	private final Jeu jeu;

	public ActionsJeu(Jeu jeu) {
		super();
		super.setName("Actions du Jeu");
		this.jeu = jeu;
		super.setLayout(new FlowLayout());
		super.setBorder(BorderFactory.createTitledBorder("Actions du Joueur"));

		JButton debutPartieBtn = new JButton("Lancer la partie");
		debutPartieBtn.addActionListener(new ActionLancerPartie());

		super.add(debutPartieBtn);

	}

	/* On définit une action concernant le joueur dans la classe du contrôlleur correspondant
	  Je suis pas sûr que ce soit la meilleure option, un refactor est probable car on risque
	  de très vite avoir énormément de code dans ces fichiers.

		En attendant, voici en gros comment on réalise la partie "Active" du controlleur, celle
		qui fait vraiment avancer le jeu. 
		La méthode actionPerformed est appelé par un widget graphique, comme un bouton ou autre.

	*/
	private class ActionLancerPartie implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent evt) {
			System.out.println("ActionDebutPartie déclanchée");
			//jeu.jouerPartie();
			System.out.println("BUGGE donc fait rien");
		}
	}
}