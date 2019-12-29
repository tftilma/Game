package nl.home.ttilma.game.board;

import nl.home.ttilma.game.piece.Piece;

/**
 * Seems as if using Piece directly is better, not sure
 * 
 * @author tft
 *
 */
public class Field {
    private Piece<?> piece;

    public void setPiece(Piece<?> piece) {
        this.piece = piece;
    }

    public Piece<?> getPiece() {
        return piece;
    }
}
