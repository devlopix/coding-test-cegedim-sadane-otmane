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

	public char avancer(char init, int pas) {
		return Character.toString((char) (init + pas)).charAt(0);
	}

	public char revenir(char init, int pas) {
		return Character.toString((char) (init - pas)).charAt(0);
	}

	/*
	 * Calculer les différents coups possibles
	 */
	public String listerLesCoupsPossibleDeLaTour(PieceEchequier piece) {
		StringBuilder builder = new StringBuilder();
		boolean encore = true;
		if (piece == null) {
			return "";
		} else {
			char col = piece.getPosition().getColone();
			char ligne = piece.getPosition().getLigne();

			/*
			 * Exploration vers le bas ( comme dans l'exemple fournie avec l'enoncé)
			 */
			/*
			 * 
			 */
			int profondeurRecherche = 1;
			do {

				char prochainePositionPossibleLigne = revenir(ligne, profondeurRecherche);
				// Est ce possible de bouger vers le bas ? (on sort pas de l'echeqier)
				if (siPossibleDeBougerVerticalement(prochainePositionPossibleLigne)) {
// Est ce la prochaine case contient quelque chose de mangeable
					PositionPieceEchequier positionPieceEnBas = new PositionPieceEchequier(col,
							prochainePositionPossibleLigne);
					PieceEchequier pieceSetrouvantEnBas = this.getPiecesEnJeux().get(positionPieceEnBas);

					if (pieceSetrouvantEnBas == null) { // si pieceSetrouvantEnBas est null -> c'est une case vide
						builder.append("T" + col + ligne + "-" + col + prochainePositionPossibleLigne + "\n");

					} else { // si pieceSetrouvantEnBas n'est pas null c'est possible qu'elle soit mangeable
						if (piece.siMangeable(pieceSetrouvantEnBas)) {
							builder.append("T" + col + ligne + "x" + col + prochainePositionPossibleLigne + "\n");
						}
						encore = false;
					}

					// On est arrivé à la dérnière ligne possible
					if (prochainePositionPossibleLigne == '1') {
						encore = false;
					}

				}

				profondeurRecherche++;

			} while (encore);

			profondeurRecherche = 1;
			encore = true;
//			/*
//			 * Exploration à droite
//			 */

			do {

				char prochainePositionPossibleColone = avancer(col, profondeurRecherche);
				// Est ce possible de bouger vers le bas ? (on sort pas de l'echeqier)
				if (siPossibleDeBougerHorizontalement(prochainePositionPossibleColone)) {
// Est ce la prochaine case contient quelque chose de mangeable
					PositionPieceEchequier positionPieceADroite = new PositionPieceEchequier(
							prochainePositionPossibleColone, ligne);
					PieceEchequier pieceSetrouvantADroite = this.getPiecesEnJeux().get(positionPieceADroite);

					if (pieceSetrouvantADroite == null) { // si pieceSetrouvantEnBas est null -> c'est une case vide
						builder.append("T" + col + ligne + "-" + prochainePositionPossibleColone + ligne + "\n");

					} else { // si pieceSetrouvantEnBas n'est pas null c'est possible qu'elle soit mangeable
						if (piece.siMangeable(pieceSetrouvantADroite)) {
							builder.append("T" + col + ligne + "x" + col + prochainePositionPossibleColone + "\n");
						}
						encore = false;
					}

					// On est arrivé à la dérnière colone possible
					if (prochainePositionPossibleColone == 'h') {
						encore = false;
					}

				}
				profondeurRecherche++;
			} while (encore);

			/*
			 * Exploration vers le haut
			 */
			profondeurRecherche = 1;
			encore = true;
			do {

				char prochainePositionPossibleLigne = avancer(ligne, profondeurRecherche);
				// Est ce possible de bouger vers le bas ? (on sort pas de l'echeqier)
				if (siPossibleDeBougerVerticalement(prochainePositionPossibleLigne)) {
// Est ce la prochaine case contient quelque chose de mangeable
					PositionPieceEchequier positionPieceEnHaut = new PositionPieceEchequier(col,
							prochainePositionPossibleLigne);
					PieceEchequier pieceSetrouvantEnHaut = this.getPiecesEnJeux().get(positionPieceEnHaut);

					if (pieceSetrouvantEnHaut == null) { // si pieceSetrouvantEnBas est null -> c'est une case vide
						builder.append("T" + col + ligne + "-" + col + prochainePositionPossibleLigne + "\n");
					} else { // si pieceSetrouvantEnBas n'est pas null c'est possible qu'elle soit mangeable
						if (piece.siMangeable(pieceSetrouvantEnHaut)) {
							builder.append("T" + col + ligne + "x" + col + prochainePositionPossibleLigne + "\n");
						}
						encore = false;
					}

					// On est arrivé à la dérnière ligne possible
					if (prochainePositionPossibleLigne == '8') {
						encore = false;
					}

				}
				profondeurRecherche++;
			} while (encore);

			/*
			 * Exploration à gauche
			 */

			profondeurRecherche = 1;
			encore = true;
			do {

				char prochainePositionPossibleColone = revenir(col, profondeurRecherche);
				// Est ce possible de bouger vers le bas ? (on sort pas de l'echeqier)
				if (siPossibleDeBougerHorizontalement(prochainePositionPossibleColone)) {
					// Est ce la prochaine case contient quelque chose de mangeable
					PositionPieceEchequier positionPieceAGauche = new PositionPieceEchequier(
							prochainePositionPossibleColone, ligne);
					PieceEchequier pieceSetrouvantAGauche = this.getPiecesEnJeux().get(positionPieceAGauche);

					if (pieceSetrouvantAGauche == null) { // si pieceSetrouvantEnBas est null -> c'est une case vide
						builder.append("T" + col + ligne + "-" + prochainePositionPossibleColone + ligne + "\n");
					} else { // si pieceSetrouvantEnBas n'est pas null c'est possible qu'elle soit mangeable
						if (piece.siMangeable(pieceSetrouvantAGauche)) {
							builder.append("T" + col + ligne + "x" + col + prochainePositionPossibleColone + "\n");
						}
						encore = false;
					}

					// On est arrivé à la dérnière colone possible
					if (prochainePositionPossibleColone == 'a') {
						encore = false;
					}

				}
				profondeurRecherche++;
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
