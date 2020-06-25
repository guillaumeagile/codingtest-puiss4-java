package com.cegedim.puissance4.entity;

/**
 * Représente tous les étas possible d'une case
 * 
 * @author Romain Féret
 *
 */
public enum CouleurCase {
	VIDE(" "), ROUGE("R"), JAUNE("J");

	public final String code;

	private CouleurCase(String code) {
		this.code = code;
	}

	public String toString() {
		return this.code;
	}
}
