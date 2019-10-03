package com.cegedim.models;

public class PositionPieceEchequier {
	private char colone;
	private char ligne;

	public PositionPieceEchequier() {
	}

	public PositionPieceEchequier(char col, char li) {
		this.colone = col;
		this.ligne = li;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof PositionPieceEchequier) {
			PositionPieceEchequier key = (PositionPieceEchequier) obj;
			return ((this.colone == key.getColone()) && (this.ligne == key.getLigne()));
		}
		return false;
	}

	@Override
	public int hashCode() {
		return (this.getColone() + this.getLigne() + "").hashCode();
	}

	public char getColone() {
		return colone;
	}

	public void setColone(char colone) {
		this.colone = colone;
	}

	public char getLigne() {
		return ligne;
	}

	public void setLigne(char ligne) {
		this.ligne = ligne;
	}

}
