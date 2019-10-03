package com.cegedim;

import java.util.HashMap;
import java.util.Map;

import com.cegedim.enums.Couleur;
import com.cegedim.models.Echequier;
import com.cegedim.models.PieceEchequier;
import com.cegedim.models.PositionPieceEchequier;

public class Main {
	static Echequier echequier = new Echequier();

	public static void main(String[] args) {
		/*
		 * Initialiser échequier
		 */

		char[] colones = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h' };
		char[] lignes = { '1', '2', '3', '4', '5', '6', '7', '8' };

		// Initialiser les position des pieces
		
		initEchequier();
		
		

	}

	static void initEchequier() {
		Map<PositionPieceEchequier, PieceEchequier> piecesEnJeux = new HashMap<PositionPieceEchequier, PieceEchequier>();
		// tour blanche
		PositionPieceEchequier positionTourBlanche = new PositionPieceEchequier('d', '5');
		PieceEchequier tourBlanche = new PieceEchequier("Tour", Couleur.Blanc, positionTourBlanche);
		piecesEnJeux.put(positionTourBlanche, tourBlanche);

		// pion noir

		PositionPieceEchequier positionPionNoir = new PositionPieceEchequier('d', '7');
		PieceEchequier pionNoir = new PieceEchequier("Pion", Couleur.Noir, positionPionNoir);
		piecesEnJeux.put(positionPionNoir, pionNoir);

		// chevaux blancs

		PositionPieceEchequier positionChevalBlanc1 = new PositionPieceEchequier('d', '5');
		PieceEchequier chevalBlanc1 = new PieceEchequier("Cheval", Couleur.Blanc, positionChevalBlanc1);
		piecesEnJeux.put(positionChevalBlanc1, chevalBlanc1);

		PositionPieceEchequier positionChevalBlanc2 = new PositionPieceEchequier('d', '5');
		PieceEchequier chevalBlanc2 = new PieceEchequier("Cheval", Couleur.Blanc, positionChevalBlanc2);
		piecesEnJeux.put(positionChevalBlanc2, chevalBlanc2);

	}

}
