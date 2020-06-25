package com.cegedim.puissance4.service;

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
	 * Initialisation du jeu à un état définit (avec un tableau de cases en paramètres)
	 */
	public void initialiserJeu(CouleurCase[][] casesDuPlateau) {
		plateauDeJeu.setCases(casesDuPlateau);
	}


	/*
	 * Initialisation du jeu à vide
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
