package ustensile;

public class AssietteCarree extends Ustensile {

	double cote;

	public AssietteCarree(int anneeDeFabrication, double cote) {
		super(anneeDeFabrication);
		this.cote = cote;
	}

	public AssietteCarree(int anneeDeFabrication) {
		super(anneeDeFabrication);
	}

	public double calculerSurface() {
		return cote * cote;
	}

}
