package ui.selecteur;
/**Classe gérant la sélection d'objets.
 * Elle permet d'abstraire la liaison entre la vue et le contrôleur.*/
public class Selecteur<T> {
	private T objetSelectionne = null;
	
	public Selecteur() {
	}
	
	public void setSelection(T objetSelectionne) {
		this.objetSelectionne = objetSelectionne;
	}
	
	public T getSelection() {
		return this.objetSelectionne;
	}
}
