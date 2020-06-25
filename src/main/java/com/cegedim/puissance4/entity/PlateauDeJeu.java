package com.cegedim.puissance4.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * Représente le plateau de jeu
 * 
 * @author Romain Féret
 *
 */

@Getter
@Setter
@RequiredArgsConstructor
public class PlateauDeJeu {
	public static final int MAX_LIGNES = 6;
    public static final int MAX_COLONNES = 7;

    private CouleurCase[][] cases = new CouleurCase[MAX_COLONNES][MAX_LIGNES];

	@Override
	public String toString() {
		StringBuilder resultBuilder = new StringBuilder();
		for (CouleurCase[] lignes : cases) {
			for (CouleurCase caseDuPlateau : lignes) {
				resultBuilder.append(caseDuPlateau.getCode());
				resultBuilder.append(" ");
			}
			
			resultBuilder.append('\n');
		}

	    return resultBuilder.toString();
	}
    
}