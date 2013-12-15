package nl.home.ttilma.game.piece;

import java.util.List;

import nl.home.ttilma.game.board.Color;
import nl.home.ttilma.game.board.Move;
import nl.home.ttilma.game.board.SimpleBoard;

public class SimplePiece extends AbstractPiece<SimpleBoard> implements Piece<SimpleBoard> {

    public SimplePiece(Color color) {
        super(color);
    }

    @Override
    public void moveGen(SimpleBoard board, List<Move> moveList) {
        if (isWhite()) { 
            tryAndCreateMoves(board, moveList, 0, 1, 1); // forward (for white +1)
        } else {
            tryAndCreateMoves(board, moveList, 0, -1, 1); // forward (for black -1)
        }
        tryAndCreateMoves(board, moveList, 0, 1, 1); // left
        tryAndCreateMoves(board, moveList, 0, 1, 1); // right
    }

    @Override
    public String print() {
        return isWhite() ? "X" : "x";
    }


}
