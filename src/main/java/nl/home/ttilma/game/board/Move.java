package nl.home.ttilma.game.board;

import nl.home.ttilma.game.board.Position;
import nl.home.ttilma.game.piece.Piece;

/**
 * 
 * @author Tsjisse Tilma
 *
 */
public class Move {
    private Position from;
    private Position to;
    private double value;
    private boolean capturing;
    private Piece<?> promotedPiece;

    public Piece<?> getPromotedPiece() {
        return promotedPiece;
    }

    public void setPromotedPiece(Piece<?> promotedPiece) {
        this.promotedPiece = promotedPiece;
    }

    public Move(Position from, Position to) {
        this.from = from;
        this.to = to;
    }

    public Position getFrom() {
        return from;
    }

    public Position getTo() {
        return to;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public void setCapturing(boolean capturing) {
        this.capturing = capturing;
    }

    public boolean isCapturing() {
        return capturing;
    }
}
