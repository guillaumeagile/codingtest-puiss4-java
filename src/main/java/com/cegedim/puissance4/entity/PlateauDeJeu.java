package com.cegedim.puissance4.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * Repr�sente le plateau de jeu
 * 
 * @author Romain F�ret
 *
 */

@Getter
@Setter
@RequiredArgsConstructor
public class PlateauDeJeu {
	public static final int MAX_LIGNES = 6;
    public static final int MAX_COLONNES = 7;

    private CouleurCase[][] cases = new CouleurCase[MAX_COLONNES][MAX_LIGNES];

    /*
     * toString personnalis� pour pouvoir afficher proprement le plateau de jeu
     */
	@Override
	public String toString() {
		StringBuilder resultBuilder = new StringBuilder();
		
		//Ligne � vide de haut de tableau
		resultBuilder.append("+");
		for (int i = 0; i < MAX_COLONNES; i++) {
			resultBuilder.append("---");
			resultBuilder.append("+");
			
		}
		resultBuilder.append('\n');
		
		
		for (CouleurCase[] lignes : cases) {
			resultBuilder.append("|");
			for (CouleurCase caseDuPlateau : lignes) {
				resultBuilder.append(" " + caseDuPlateau.getCode() + " ");
				resultBuilder.append("|");
			}
			resultBuilder.append('\n');
			
			resultBuilder.append("+");
			for (int i = 0; i < MAX_COLONNES; i++) {
				resultBuilder.append("---");
				resultBuilder.append("+");
				
			}
			resultBuilder.append('\n');
		}

	    return resultBuilder.toString();
	}
    
}