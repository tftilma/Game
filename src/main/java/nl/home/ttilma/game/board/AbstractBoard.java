package nl.home.ttilma.game.board;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import nl.home.ttilma.game.board.Field;
import nl.home.ttilma.game.piece.Piece;

/**
 * 
 * @author Tsjisse Tilma
 *
 */public abstract class AbstractBoard implements Board {
    protected Field[][] fields;
    protected LinkedList<Piece<? extends AbstractBoard>> capturedPieces = 
        new LinkedList<Piece<? extends AbstractBoard>>(); 
    private int maxCol;
    private int maxRow;
    
    protected AbstractBoard(int maxCol, int maxRow) {
       this.maxCol = maxCol;
       this.maxRow = maxRow;
       fields = new Field[maxCol][maxRow];
       for (int col = 0; col < maxCol; col++) {
           for (int row = 0; row < maxRow; row++) {
               fields[col][row] = new Field();
           }
       }
    }
    
    public Field getField(int col, int row) {
        return fields[col][row];
    }
    
    public Field getField(Position pos) {
        return fields[pos.getCol()][pos.getRow()];
    }
    
    public void capturePiece(Piece<? extends AbstractBoard> piece) {
        capturedPieces.push(piece);
    }
    
    public Piece<? extends AbstractBoard> takeBackPiece() {
        return capturedPieces.pop();
    }

    public int getMaxCol() {
        return maxCol;
    }

    public int getMaxRow() {
        return maxRow;
    }
    
    public List<Move> genMoves() {
        List<Move> moveList = new ArrayList<Move>();
        
        return moveList;
    }
}
