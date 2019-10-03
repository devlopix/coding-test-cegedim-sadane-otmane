package com.cegedim.models;

import com.cegedim.enums.Couleur;

public class PieceEchequier {

	private String Nom;
	private Couleur couleur;
	private PositionPieceEchequier position;

	public PieceEchequier() {
	}

	public PieceEchequier(String nom, Couleur couleur, PositionPieceEchequier position) {
		super();
		Nom = nom;
		this.couleur = couleur;
		this.position = position;
	}

	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		Nom = nom;
	}

	public Couleur getCouleur() {
		return couleur;
	}

	public void setCouleur(Couleur couleur) {
		this.couleur = couleur;
	}

	public PositionPieceEchequier getPosition() {
		return position;
	}

	public void setPosition(PositionPieceEchequier position) {
		this.position = position;
	}

	public boolean siMangeable(PieceEchequier piece) {
		if(this.getCouleur() != piece.getCouleur()) return true;
		else return false;
	}
	
	

}
