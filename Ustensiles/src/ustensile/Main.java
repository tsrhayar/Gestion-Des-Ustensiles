package ustensile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws SQLException {
		
		Scanner sc = new Scanner(System.in);

		int choix1, choix2, id, newDate, anneeDeFabrication;
		double cote, rayon;

		Ustensile[] us = new Ustensile[5];
		us[0] = new AssietteRonde(1976, 8.4);
		us[1] = new Cuillere(1811, 7.3);
		us[2] = new AssietteCarree(1935, 5.6);
		us[3] = new Cuillere(2001, 8.8);
		us[4] = new AssietteRonde(1901, 5.4);

		afficherCuilleres(us);
		afficherSurfaceAssiettes(us);
		afficherValeurTotale(us);

		boolean quit = false;

		while (quit != true) {
			Connection con = DBInfo.connDB();

			

			System.out.println(
					"Taper:\n1 pour  ajouter un enregistrement\n2 pour modifier l�ann�e d'une ustensile\n0 pour quitter");

			choix1 = sc.nextInt();
			sc.nextLine();
			switch (choix1) {
			case 0:
				System.out.println("A bientot");
				quit = true;
				break;
			case 1:
				System.out.println(
						"Taper:\n1 pour ajouter une assiette ronde\n2 pour ajouter une assiette carr�e\n3 pour ajouter une cuill�re ");
				choix2 = sc.nextInt();
				sc.nextLine();
				switch (choix2) {
				case 1:
					System.out.println("Taper l'ann�e de fabrication de l'assiette ronde.");
					anneeDeFabrication = sc.nextInt();
					sc.nextLine();
					System.out.println("Taper le rayon de l'assiette ronde.");
					rayon = sc.nextDouble();
					sc.nextLine();
					AssietteRonde ar = new AssietteRonde(anneeDeFabrication, rayon);

					try {
						String insrt = "INSERT INTO `assietteronde`(`anneeDeFabrication`, `surface`, `valeur`) VALUES (?, ?, ?)";
						PreparedStatement insrtPS = con.prepareStatement(insrt);
						insrtPS.setInt(1, ar.anneeDeFabrication);
						insrtPS.setDouble(2, ar.calculerSurface());
						insrtPS.setDouble(3, ar.calculerValeur());
						insrtPS.executeUpdate();
						System.out.println("L'assiette ronde bien ins�r�!");
					} catch (SQLException e) {
						System.err.println(e);
					}
					break;
				case 2:
					System.out.println("Taper l'ann�e de fabrication de l'assiette carr�e.");
					anneeDeFabrication = sc.nextInt();
					sc.nextLine();
					System.out.println("Taper le rayon de l'assiette carr�e.");
					cote = sc.nextDouble();
					sc.nextLine();

					AssietteCarree ac = new AssietteCarree(anneeDeFabrication, cote);

					try {
						String insrt = "INSERT INTO `assiettecarree`(`anneeDeFabrication`, `surface`, `valeur`) VALUES (?, ?, ?)";
						PreparedStatement insrtPS = con.prepareStatement(insrt);
						insrtPS.setInt(1, ac.anneeDeFabrication);
						insrtPS.setDouble(2, ac.calculerSurface());
						insrtPS.setDouble(3, ac.calculerValeur());
						insrtPS.executeUpdate();
						System.out.println("L'assiette carr�e bien ins�r�!");
					} catch (SQLException e) {
						System.err.println(e);
					}
					break;
				case 3:
					System.out.println("Taper l'ann�e de fabrication de la cuill�re.");
					anneeDeFabrication = sc.nextInt();
					sc.nextLine();
					System.out.println("Taper le rayon de la cuill�re.");
					rayon = sc.nextDouble();
					sc.nextLine();
					Cuillere cu = new Cuillere(anneeDeFabrication, rayon);

					try {
						String insrt = "INSERT INTO `cuillere`(`anneeDeFabrication`, `valeur`) VALUES ( ?, ?)";
						PreparedStatement insrtPS = con.prepareStatement(insrt);
						insrtPS.setInt(1, cu.anneeDeFabrication);
						insrtPS.setDouble(3, cu.calculerValeur());
						insrtPS.executeUpdate();
						System.out.println("La cuill�re bien ins�r�!");
					} catch (SQLException e) {
						System.err.println(e);
					}
					break;

				}
				break;
			case 2:
				System.out.println(
						"Taper:\n1 pour modifier l�ann�e d'une assiette carr�e\n2 pour modifier l�ann�e d'une assiette ronde\n3 pour modifier l�ann�e d'une cuill�re");
				choix2 = sc.nextInt();
				sc.nextLine();
				switch (choix2) {
				case 1:
					System.out.println(
							"Taper l'id de l'assiette carr�e que vous voulez modifier leur ann�e de fabrication");
					id = sc.nextInt();
					sc.nextLine();
					System.out.println("Taper la nouvelle ann�e de fabrication");
					newDate = sc.nextInt();
					sc.nextLine();
					AssietteCarree ac = new AssietteCarree(newDate);
					try {
						String updt = "UPDATE assiettecarree SET anneeDeFabrication=? WHERE id=?";
						PreparedStatement updtPS = con.prepareStatement(updt);
						updtPS.setInt(1, ac.anneeDeFabrication);
						updtPS.setInt(2, id);
						updtPS.executeUpdate();
						System.out.println(
								"L'ann�e de fabrication de l'assiette carr�e avec l'id:" + id + ", est bien modifi�!");
					} catch (SQLException e) {
						System.err.println(e);
					}
					break;
				case 2:
					System.out.println(
							"Taper l'id de l'assiette ronde que vous voulez modifier leur ann�e de fabrication");
					id = sc.nextInt();
					sc.nextLine();
					System.out.println("Taper la nouvelle ann�e de fabrication");
					newDate = sc.nextInt();
					sc.nextLine();
					AssietteRonde ar = new AssietteRonde(newDate);
					try {
						String updt = "UPDATE assietteronde SET anneeDeFabrication=? WHERE id=?";
						PreparedStatement updtPS = con.prepareStatement(updt);
						updtPS.setInt(1, ar.anneeDeFabrication);
						updtPS.setInt(2, id);
						updtPS.executeUpdate();
						System.out.println(
								"L'ann�e de fabrication de l'assiette ronde avec l'id:" + id + ", est bien modifi�!");
					} catch (SQLException e) {
						System.err.println(e);
					}
					break;
				case 3:
					System.out.println("Taper l'id de la  cuill�re que vous voulez modifier leur ann�e de fabrication");
					id = sc.nextInt();
					sc.nextLine();
					System.out.println("Taper la nouvelle ann�e de fabrication");
					newDate = sc.nextInt();
					sc.nextLine();
					Cuillere cu = new Cuillere(newDate);
					try {
						String updt = "UPDATE assietteronde SET anneeDeFabrication=? WHERE id=?";
						PreparedStatement updtPS = con.prepareStatement(updt);
						updtPS.setInt(1, cu.anneeDeFabrication);
						updtPS.setInt(2, id);
						updtPS.executeUpdate();
						System.out.println(
								"L'ann�e de fabrication de la cuill�re carr�e avec l'id:" + id + ", est bien modifi�!");
					} catch (SQLException e) {
						System.err.println(e);
					}
					break;
				}
			}

		}
		sc.close();
	}

	static void afficherCuilleres(Ustensile[] us) {
		int nbrCuilleres = 0;
		for (int i = 0; i < us.length; i++) {
			if (us[i] instanceof Cuillere) {
				nbrCuilleres++;
			}
		}
		System.out.println("Il y a " + nbrCuilleres + " cuill�res.");
	}

	static void afficherSurfaceAssiettes(Ustensile[] us) {
		double surfaceTotale = 0;
		for (int i = 0; i < us.length; i++) {
			if (us[i] instanceof AssietteRonde) {
				surfaceTotale += (us[i]).calculerSurface();
			}

			if (us[i] instanceof AssietteCarree) {
				surfaceTotale += (us[i]).calculerSurface();
			}
		}

		System.out.println("Surface totale des assiettes: " + surfaceTotale);
	}

	static void afficherValeurTotale(Ustensile[] us) {
		int thisYear = Calendar.getInstance().get(Calendar.YEAR);
		double valeurTotale = 0;
		for (int i = 0; i < us.length; i++) {
			int lessThan = thisYear - us[i].anneeDeFabrication;
			if (lessThan > 50) {
				if (us[i] instanceof AssietteRonde) {
					valeurTotale += thisYear - us[i].anneeDeFabrication - 50;
				}
				if (us[i] instanceof Cuillere) {
					valeurTotale += thisYear - us[i].anneeDeFabrication - 50;
				}
				if (us[i] instanceof AssietteCarree) {
					valeurTotale += ((thisYear - us[i].anneeDeFabrication - 50) * 5);
				}
			}
		}
		System.out.println("La valeur totale est " + valeurTotale + " Dh");
	}

}
