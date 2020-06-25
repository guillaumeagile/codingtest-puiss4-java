package com.cegedim.puissance4.entity;

/**
 * Repr�sente tous les �tas possible d'une case
 * 
 * @author Josef
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
