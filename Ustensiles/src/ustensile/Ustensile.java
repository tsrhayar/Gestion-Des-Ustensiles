package ustensile;

import java.util.Calendar;

public class Ustensile {

	int anneeDeFabrication;

	public Ustensile(int anneeDeFabrication) {
		this.anneeDeFabrication = anneeDeFabrication;
	}

	public double calculerSurface() {
		return 0;
	}
	
	public double calculerValeur() {
		int thisYear = Calendar.getInstance().get(Calendar.YEAR);
		double valeur = 0;
		int lessThan = thisYear - this.anneeDeFabrication;
		if (lessThan > 50) {
			valeur = thisYear - this.anneeDeFabrication - 50;
			return valeur;
		}
		return valeur;
	}

}
