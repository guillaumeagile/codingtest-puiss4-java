package com.cegedim.puissance4.service;

import java.util.Optional;

import com.cegedim.puissance4.entity.CouleurCase;
import com.cegedim.puissance4.entity.PlateauDeJeu;

import lombok.Getter;

/*
 * Service métier du plateau de jeu de puissance 4
 * Contiens les méchaniques de jeu à implémenter
 * 
 * @author Romain Féret
 */
public class PlateauDeJeuService {

	@Getter
	private PlateauDeJeu plateauDeJeu;

	/** Implémentation du service en singloton */
	private PlateauDeJeuService() {
		plateauDeJeu = new PlateauDeJeu();
	}

	private static PlateauDeJeuService INSTANCE = new PlateauDeJeuService();

	public static PlateauDeJeuService getInstance() {
		return INSTANCE;
	}

	/*
	 * Initialisation du jeu à un état définit (avec un tableau de cases en
	 * paramètres)
	 */
	public void initialiserJeu(CouleurCase[][] casesDuPlateau) {
		plateauDeJeu.setCases(casesDuPlateau);
	}


	
	/*
	 * Détermine si il y à un vainqueur et si oui quelle est sa couleur
	 * @return La couleur du vainqueur si il y à un vainqueur, sinon vide (Optional.empty)
	 */
	public Optional<CouleurCase> determineVainqueur() {
		for (int i = 0; i < plateauDeJeu.getCases().length; i++) {
			CouleurCase[] colonne = plateauDeJeu.getCases()[i];
			for (int j = 0; j < colonne.length; j++) {
				CouleurCase vainqueur = colonne[j];
				if (vainqueur != CouleurCase.VIDE
						&& (testVictoireHorisontale(i, j) || testVictoireDiagonaleMontante(i, j)
								|| testVictoireVerticale(i, j) || testVictoireDiagonaleDescendante(i, j))) {
					return Optional.of(vainqueur);
				}
			}
		}

		return Optional.empty();
	}
	
	/*
	 * Test si 4 cases d'une même couleur sont allignés verticalement
	 * @param colonne : Rang de la colonne de début pour laquelle le test est effectué
	 * @param ligne : Rang de la ligne de début pour laquelle le test est effectué
	 * @return : true si la condition de victoire est remplie, false sinon
	 */
	private boolean testVictoireVerticale(int colonne, int ligne) {
		CouleurCase couleur = plateauDeJeu.getCases()[colonne][ligne];

		// On vérifie que le test de victoire par ligne ne dépasse pas la dimension du
		// tableau
		if (ligne + 3 < PlateauDeJeu.MAX_LIGNES) {
			return plateauDeJeu.getCases()[colonne][ligne + 1] == couleur
					&& plateauDeJeu.getCases()[colonne][ligne + 2] == couleur
					&& plateauDeJeu.getCases()[colonne][ligne + 3] == couleur;
		} else {
			return false;
		}
	}

	/*
	 * Test si 4 cases d'une même couleur sont allignés horisontalement
	 * @param colonne : Rang de la colonne de début pour laquelle le test est effectué
	 * @param ligne : Rang de la ligne de début pour laquelle le test est effectué
	 * @return : true si la condition de victoire est remplie, false sinon
	 */
	private boolean testVictoireHorisontale(int colonne, int ligne) {
		CouleurCase couleur = plateauDeJeu.getCases()[colonne][ligne];

		// On vérifie que le test de victoire par ligne ne dépasse pas la dimension du
		// tableau
		if (colonne + 3 < PlateauDeJeu.MAX_COLONNES) {

			// On test la victoire par ligne
			return plateauDeJeu.getCases()[colonne + 1][ligne] == couleur
					&& plateauDeJeu.getCases()[colonne + 2][ligne] == couleur
					&& plateauDeJeu.getCases()[colonne + 3][ligne] == couleur;
		} else {
			return false;
		}
	}

	/*
	 * Test si 4 cases d'une même couleur sont allignés en diagonale montante
	 * @param colonne : Rang de la colonne de début pour laquelle le test est effectué
	 * @param ligne : Rang de la ligne de début pour laquelle le test est effectué
	 * @return : true si la condition de victoire est remplie, false sinon
	 */
	private boolean testVictoireDiagonaleMontante(int colonne, int ligne) {
		CouleurCase couleur = plateauDeJeu.getCases()[colonne][ligne];

		// On vérifie que le test de victoire par ligne ne dépasse pas la dimension du
		// tableau
		if (colonne + 3 < PlateauDeJeu.MAX_COLONNES && ligne + 3 < PlateauDeJeu.MAX_LIGNES) {

			// On test la victoire par Diagonale Montante
			return plateauDeJeu.getCases()[colonne + 1][ligne + 1] == couleur
					&& plateauDeJeu.getCases()[colonne + 2][ligne + 2] == couleur
					&& plateauDeJeu.getCases()[colonne + 3][ligne + 3] == couleur;
		} else {
			return false;
		}
	}

	/*
	 * Test si 4 cases d'une même couleur sont allignés en diagonale descendante
	 * @param colonne : Rang de la colonne de début pour laquelle le test est effectué
	 * @param ligne : Rang de la ligne de début pour laquelle le test est effectué
	 * @return : true si la condition de victoire est remplie, false sinon
	 */
	private boolean testVictoireDiagonaleDescendante(int colonne, int ligne) {
		CouleurCase couleur = plateauDeJeu.getCases()[colonne][ligne];

		// On vérifie que le test de victoire par ligne ne dépasse pas la dimension du
		// tableau
		if (colonne + 3 < PlateauDeJeu.MAX_COLONNES && ligne - 3 >= 0) {
			return plateauDeJeu.getCases()[colonne + 1][ligne - 1] == couleur
					&& plateauDeJeu.getCases()[colonne + 2][ligne - 2] == couleur
					&& plateauDeJeu.getCases()[colonne + 3][ligne - 3] == couleur;
		} else {
			return false;
		}
	}

}
