package nl.home.ttilma.game.board;

import nl.home.ttilma.game.piece.SimplePiece;

public class SimpleBoard extends AbstractBoard {
    public static final int MAX_COL = 3;
    public static final int MAX_ROW = 4;
    
    
    protected SimpleBoard() {
        super(MAX_COL, MAX_ROW);
        fields[0][0].setPiece(new SimplePiece(Color.WHITE));
        fields[1][0].setPiece(new SimplePiece(Color.WHITE));
        fields[2][0].setPiece(new SimplePiece(Color.WHITE));
        
        fields[0][3].setPiece(new SimplePiece(Color.BLACK));
        fields[1][3].setPiece(new SimplePiece(Color.BLACK));
        fields[2][3].setPiece(new SimplePiece(Color.BLACK));
    }
    
   
}
