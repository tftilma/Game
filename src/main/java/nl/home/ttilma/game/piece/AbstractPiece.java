package nl.home.ttilma.game.piece;

import java.util.List;

import nl.home.ttilma.game.board.AbstractBoard;
import nl.home.ttilma.game.board.Color;
import nl.home.ttilma.game.board.Field;
import nl.home.ttilma.game.board.Move;
import nl.home.ttilma.game.board.MoveResult;
import nl.home.ttilma.game.board.Position;

public abstract class AbstractPiece<B extends AbstractBoard> implements Piece<B> {
    private boolean atInitialPosition;
    private Position position;
    private Color color;

    public AbstractPiece(Color color) {
        this.setColor(color);
        setAtInitialPosition(true);
    }

    public AbstractPiece(Position pos, Color color) {
        this(color);
        this.setColor(color);
    }

    public void setPosition(Position position) {
        setAtInitialPosition(false);
        this.position = position;
    }
  
    public Position getPosition() {
        return position;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
    
    public boolean isWhite() {
        return color == Color.WHITE;
    }

    public boolean isBlack() {
        return color == Color.BLACK;
    }
    
    public void setAtInitialPosition(boolean atInitialPosition) {
        this.atInitialPosition = atInitialPosition;
    }

    public boolean isAtInitPosition() {
        return atInitialPosition;
    }
    
    public MoveResult tryMove(B board, int deltaX, int deltaY, boolean allowCapture, boolean allowMove) {
        Position fromPosition = getPosition();
        Color myColor = board.getField(fromPosition).getPiece().getColor();
        int toCol = fromPosition.getCol() + deltaX; 
        int toRow = fromPosition.getRow() + deltaY; 
        if (toCol < 0 || toCol >= board.getMaxCol() ){
            // piece outside board
            return MoveResult.INVALID;
        }
        if (toRow < 0 || toRow >= board.getMaxRow()) {
            // piece outside board
            return MoveResult.INVALID;
        }
        Position toPosition = new Position(toCol, toRow);
        Field toField = board.getField(toPosition);
        if (toField.getPiece() == null) {
            // empty, so often cont, not always (pawn) true
            if (allowMove) {
                return MoveResult.VALID_CONT;
            } else {
                return MoveResult.INVALID;
            }
        } else if (toField.getPiece().getColor() == myColor) {
            // never capture your own pieces!
            return MoveResult.INVALID; 
        } else {
            // true if allowed to capture 
            if (allowCapture) {
                return MoveResult.VALID_STOP;
            } else {
                return  MoveResult.INVALID;
            }
        }
    }

    public Move createMove(B board, int deltaX, int deltaY) {
        Position fromPosition = getPosition();
        Position toPosition = new Position(fromPosition.getCol() + deltaX, 
                fromPosition.getRow() + deltaY);
        Move m = new Move(fromPosition, toPosition);
        return m;
    }

    public void tryAndCreateMoves(B board, List<Move> moveList, int deltaX, int deltaY, int maxFactor) {
        int factor = 1; 
        MoveResult result = MoveResult.VALID_CONT;
        do {
            result = tryMove(board, factor * deltaX, factor * deltaY, true, true);
            if (result != MoveResult.INVALID ) { 
                // left + forward
                moveList.add(createMove(board, factor * deltaX, factor * deltaY));
                factor++;
            }
        } while(result==MoveResult.VALID_CONT && factor <= maxFactor);
    }
}
