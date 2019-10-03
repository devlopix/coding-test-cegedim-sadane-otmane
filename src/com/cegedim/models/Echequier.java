package com.cegedim.models;

import java.util.Map;

public class Echequier {
	public static char[] colones = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h' };
	public static char[] lignes = { '1', '2', '3', '4', '5', '6', '7', '8' };

	private Map<PositionPieceEchequier, PieceEchequier> piecesEnJeux;
	private Map<PositionPieceEchequier, PieceEchequier> cimtierePiecesBlanches;
	private Map<PositionPieceEchequier, PieceEchequier> cimtierePiecesNoires;

	public Map<PositionPieceEchequier, PieceEchequier> getPiecesEnJeux() {
		return piecesEnJeux;
	}

	public void setPiecesEnJeux(Map<PositionPieceEchequier, PieceEchequier> piecesEnJeux) {
		this.piecesEnJeux = piecesEnJeux;
	}

	public Map<PositionPieceEchequier, PieceEchequier> getCimtierePiecesBlanches() {
		return cimtierePiecesBlanches;
	}

	public void setCimtierePiecesBlanches(Map<PositionPieceEchequier, PieceEchequier> cimtierePiecesBlanches) {
		this.cimtierePiecesBlanches = cimtierePiecesBlanches;
	}

	public Map<PositionPieceEchequier, PieceEchequier> getCimtierePiecesNoires() {
		return cimtierePiecesNoires;
	}

	public void setCimtierePiecesNoires(Map<PositionPieceEchequier, PieceEchequier> cimtierePiecesNoires) {
		this.cimtierePiecesNoires = cimtierePiecesNoires;
	}

	public char allerADroite(char col) {
		return Character.toString((char) (col + 1)).charAt(0);
	}

	public char allerAGauche(char col) {
		return Character.toString((char) (col - 1)).charAt(0);
	}

	/*
	 * Calculer les différents coups possibles
	 */
	public String listerLesCoupsPossible(PieceEchequier piece) {
		StringBuilder builder = new StringBuilder();
		boolean encore = true;
		if (piece == null) {
			return "";
		} else {
			char col = piece.getPosition().getColone();
			char ligne = piece.getPosition().getLigne();
			do {
// commencer exploration vers le bas jusq

			} while (encore);
		}
		return builder.toString();

	}

	public boolean siPossibleDeBougerHorizontalement(char coordonnee) {
		if ((coordonnee > 'h') || (coordonnee < 'a'))
			return false;
		else
			return true;

	}

	public boolean siPossibleDeBougerVerticalement(char coordonnee) {
		if ((coordonnee > '8') || (coordonnee < '1'))
			return false;
		else
			return true;

	}
}
