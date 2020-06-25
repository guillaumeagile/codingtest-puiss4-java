package com.cegedim.puissance4;

import java.util.Optional;

import com.cegedim.puissance4.entity.CouleurCase;
import com.cegedim.puissance4.service.PlateauDeJeuService;

public class Game {
	/**
	 * Point d'entrée de l'application
	 */
	public static void main(String[] args) {

		System.out.println("(1) Initialisation du plateau de jeu à vide");

		PlateauDeJeuService.getInstance().intialiserJeu();

		System.out.println(PlateauDeJeuService.getInstance().getPlateauDeJeu());

		System.out.println("(2) Initialisation du plateau de jeu à l'état décrit dans la consigne");

		PlateauDeJeuService.getInstance()
				.initialiserJeu(new CouleurCase[][] {
						{ CouleurCase.VIDE, CouleurCase.VIDE, CouleurCase.VIDE, CouleurCase.VIDE, CouleurCase.VIDE,
								CouleurCase.VIDE, CouleurCase.VIDE },
						{ CouleurCase.VIDE, CouleurCase.VIDE, CouleurCase.VIDE, CouleurCase.VIDE, CouleurCase.VIDE,
								CouleurCase.VIDE, CouleurCase.VIDE },
						{ CouleurCase.VIDE, CouleurCase.VIDE, CouleurCase.ROUGE, CouleurCase.ROUGE, CouleurCase.VIDE,
								CouleurCase.VIDE, CouleurCase.VIDE },
						{ CouleurCase.VIDE, CouleurCase.VIDE, CouleurCase.JAUNE, CouleurCase.ROUGE, CouleurCase.VIDE,
								CouleurCase.VIDE, CouleurCase.VIDE },
						{ CouleurCase.JAUNE, CouleurCase.ROUGE, CouleurCase.ROUGE, CouleurCase.JAUNE, CouleurCase.ROUGE,
								CouleurCase.VIDE, CouleurCase.JAUNE },
						{ CouleurCase.ROUGE, CouleurCase.JAUNE, CouleurCase.JAUNE, CouleurCase.JAUNE, CouleurCase.ROUGE,
								CouleurCase.ROUGE, CouleurCase.JAUNE } });

		System.out.println(PlateauDeJeuService.getInstance().getPlateauDeJeu());

	}
}