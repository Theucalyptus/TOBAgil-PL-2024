package controleurs;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

import jeu.Jeu;

public class ActionsJoueur extends JPanel {

	private final Jeu jeu;

	public ActionsJoueur(Jeu jeu) {
		super();
		this.jeu = jeu;
		super.setLayout(new FlowLayout());
		super.setBorder(BorderFactory.createTitledBorder("Actions du Joueur"));

		JButton finTourBtn = new JButton("Fin du Tour");
		finTourBtn.addActionListener(new ActionFinirTour());

		super.add(finTourBtn);

	}

	/* On définit une action concernant le joueur dans la classe du contrôlleur correspondant
	  Je suis pas sûr que ce soit la meilleure option, un refactor est probable car on risque
	  de très vite avoir énormément de code dans ces fichiers.

		En attendant, voici en gros comment on réalise la partie "Active" du controlleur, celle
		qui fait vraiment avancer le jeu.
		La méthode actionPerformed est appelé par un widget graphique, comme un bouton ou autre.

	*/
	private class ActionFinirTour implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent evt) {
			jeu.passerTour();
		}
	}


	/* La classe qui suit est semsiblement la même chose, à la différence qu'elle peut être utilisé
		avec n'importe quelle widget Swing, en intéragissant avec la souris. Il est ainsi possible de
		programmer des actions lorsque la souris survol le widget ou lorsque l'utilisateur clique
		dessus.

		Ici, la classe suppose que le widget est de type JButton mais cela peut être remplacé par
		n'importe quelle classe de widget Swing, y compris les custom comme CaseView...
	*/
	private class ActionSouris extends MouseAdapter {
		
		public void mouseCliked(MouseEvent ev) {
			System.out.println("Appui sur "
					+ ((JButton) ev.getSource()).getText());
		}

		@Override
		public void mouseEntered(MouseEvent ev) {
			JButton source = (JButton) ev.getSource();
			System.out.println("Entrée dans "
					+ source.getText());
		}

		@Override
		public void mouseExited(MouseEvent ev) {
			JButton source = (JButton) ev.getSource();
			System.out.println("Sortie de "
					+ source.getText());
		}

	}
}
