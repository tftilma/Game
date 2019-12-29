package nl.home.ttilma.game.piece;

import nl.home.ttilma.game.board.*;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * 
 * @author Tsjisse Tilma
 *
 */
public abstract class AbstractPiece<B extends AbstractBoard> implements Piece<B> {
    private static Logger logger = LogManager.getLogger(AbstractPiece.class);
    private boolean atInitialPosition;
    private Position position;
    private Color color;
    private boolean captured;

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
        logger.debug("tryMove fromCol=" + fromPosition.getCol() + " fromRow=" + fromPosition.getRow());
        Field f = board.getField(fromPosition);
        Piece p = board.getField(fromPosition).getPiece();
        Color myColor = p.getColor();
        //Color myColor = board.getField(fromPosition).getPiece().getColor();
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
            logger.debug("capturing");
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

    public void setCaptured(boolean captured) {
        this.captured = captured;
    }

    public boolean isCaptured() {
        return captured;
    }
}
