package ustensile;

public class Cuillere extends Ustensile {

	double longueur;

	public Cuillere(int anneeDeFabrication, double longueur) {
		super(anneeDeFabrication);
		this.longueur = longueur;
	}

	public Cuillere(int anneeDeFabrication) {
		super(anneeDeFabrication);
	}

}
