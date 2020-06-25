package com.cegedim.puissance4.service;

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
	 * Initialisation du jeu � vide
	 */
	public void intialiserJeu() {
		CouleurCase[][] casesDuPlateau = new CouleurCase[PlateauDeJeu.MAX_COLONNES][PlateauDeJeu.MAX_LIGNES];
		for (int j = 0; j < PlateauDeJeu.MAX_LIGNES; j++) {
			for (int i = 0; i < PlateauDeJeu.MAX_COLONNES; i++) {
				casesDuPlateau[i][j] = CouleurCase.VIDE;
			}
		}
		PlateauDeJeuService.getInstance().initialiserJeu(casesDuPlateau);
	}

}
