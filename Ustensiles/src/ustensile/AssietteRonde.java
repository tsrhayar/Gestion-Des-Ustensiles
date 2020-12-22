package ustensile;

import java.util.Calendar;

public class AssietteRonde extends Ustensile {

	double rayon;

	public AssietteRonde(int anneeDeFabrication, double rayon) {
		super(anneeDeFabrication);
		this.rayon = rayon;
	}

	public AssietteRonde(int anneeDeFabrication) {
		super(anneeDeFabrication);
	}

	public double calculerSurface() {
		return Math.PI * rayon * rayon;
	}

	public double calculerValeur() {
		int thisYear = Calendar.getInstance().get(Calendar.YEAR);
		double valeur = 0;
		int lessThan = thisYear - this.anneeDeFabrication;
		if (lessThan > 50) {
			valeur = (thisYear - this.anneeDeFabrication - 50) * 5;
			return valeur;
		}
		return valeur;
	}

}
