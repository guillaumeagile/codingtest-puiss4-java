package com.cegedim.puissance4.service;

import java.util.Optional;

import com.cegedim.puissance4.entity.CouleurCase;
import com.cegedim.puissance4.entity.PlateauDeJeu;

import lombok.Getter;

/*
 * Service m�tier du plateau de jeu de puissance 4
 * Contiens les m�chaniques de jeu � impl�menter
 * 
 * @author Romain F�ret
 */
public class PlateauDeJeuService {

	@Getter
	private PlateauDeJeu plateauDeJeu;

	/** Impl�mentation du service en singloton */
	private PlateauDeJeuService() {
		plateauDeJeu = new PlateauDeJeu();
	}

	private static PlateauDeJeuService INSTANCE = new PlateauDeJeuService();

	public static PlateauDeJeuService getInstance() {
		return INSTANCE;
	}

	/*
	 * Initialisation du jeu � un �tat d�finit (avec un tableau de cases en
	 * param�tres)
	 */
	public void initialiserJeu(CouleurCase[][] casesDuPlateau) {
		plateauDeJeu.setCases(casesDuPlateau);
	}


	
	/*
	 * D�termine si il y � un vainqueur et si oui quelle est sa couleur
	 * @return La couleur du vainqueur si il y � un vainqueur, sinon vide (Optional.empty)
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
	 * Test si 4 cases d'une m�me couleur sont allign�s verticalement
	 * @param colonne : Rang de la colonne de d�but pour laquelle le test est effectu�
	 * @param ligne : Rang de la ligne de d�but pour laquelle le test est effectu�
	 * @return : true si la condition de victoire est remplie, false sinon
	 */
	private boolean testVictoireVerticale(int colonne, int ligne) {
		CouleurCase couleur = plateauDeJeu.getCases()[colonne][ligne];

		// On v�rifie que le test de victoire par ligne ne d�passe pas la dimension du
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
	 * Test si 4 cases d'une m�me couleur sont allign�s horisontalement
	 * @param colonne : Rang de la colonne de d�but pour laquelle le test est effectu�
	 * @param ligne : Rang de la ligne de d�but pour laquelle le test est effectu�
	 * @return : true si la condition de victoire est remplie, false sinon
	 */
	private boolean testVictoireHorisontale(int colonne, int ligne) {
		CouleurCase couleur = plateauDeJeu.getCases()[colonne][ligne];

		// On v�rifie que le test de victoire par ligne ne d�passe pas la dimension du
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
	 * Test si 4 cases d'une m�me couleur sont allign�s en diagonale montante
	 * @param colonne : Rang de la colonne de d�but pour laquelle le test est effectu�
	 * @param ligne : Rang de la ligne de d�but pour laquelle le test est effectu�
	 * @return : true si la condition de victoire est remplie, false sinon
	 */
	private boolean testVictoireDiagonaleMontante(int colonne, int ligne) {
		CouleurCase couleur = plateauDeJeu.getCases()[colonne][ligne];

		// On v�rifie que le test de victoire par ligne ne d�passe pas la dimension du
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
	 * Test si 4 cases d'une m�me couleur sont allign�s en diagonale descendante
	 * @param colonne : Rang de la colonne de d�but pour laquelle le test est effectu�
	 * @param ligne : Rang de la ligne de d�but pour laquelle le test est effectu�
	 * @return : true si la condition de victoire est remplie, false sinon
	 */
	private boolean testVictoireDiagonaleDescendante(int colonne, int ligne) {
		CouleurCase couleur = plateauDeJeu.getCases()[colonne][ligne];

		// On v�rifie que le test de victoire par ligne ne d�passe pas la dimension du
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
