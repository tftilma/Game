package nl.home.ttilma.game.board;

import nl.home.ttilma.game.piece.Piece;

import org.junit.Assert;
import org.junit.Test;

public class AbstractBoardTest {
    @Test
    public void testInitialization() {
        SimpleBoard board = new SimpleBoard();
        Assert.assertNotNull(board);
        Assert.assertEquals("COL", SimpleBoard.MAX_COL, board.getMaxCol());
        Assert.assertEquals("ROW", SimpleBoard.MAX_ROW, board.getMaxRow());
    }

    @Test
    public void testGetField() {
        SimpleBoard board = new SimpleBoard();
        Assert.assertNotNull("getField[0,0]", board.getField(0, 0).getPiece());
        Assert.assertNotNull("getField[1,0]", board.getField(1, 0).getPiece());
        Assert.assertNotNull("getField[2,0]", board.getField(2, 0).getPiece());
        Assert.assertEquals("getField[0,0].Color white", Color.WHITE, board.getField(0, 0).getPiece().getColor());
        Assert.assertEquals("getField[1,0].Color white", Color.WHITE, board.getField(1, 0).getPiece().getColor());
        Assert.assertEquals("getField[2,0].Color white", Color.WHITE, board.getField(2, 0).getPiece().getColor());
        
        Assert.assertNull("getField[0,1]", board.getField(0, 1).getPiece());
        Assert.assertNull("getField[1,1]", board.getField(1, 1).getPiece());
        Assert.assertNull("getField[2,1]", board.getField(2, 1).getPiece());
        
        Assert.assertNull("getField[0,2]", board.getField(0, 2).getPiece());
        Assert.assertNull("getField[1,2]", board.getField(1, 2).getPiece());
        Assert.assertNull("getField[2,2]", board.getField(2, 2).getPiece());
        
        Assert.assertNotNull("getField[0,3]", board.getField(0, 3).getPiece());
        Assert.assertNotNull("getField[1,3]", board.getField(1, 3).getPiece());
        Assert.assertNotNull("getField[2,3]", board.getField(2, 3).getPiece());
        Assert.assertEquals("getField[0,3].Color black", Color.BLACK, board.getField(0, 3).getPiece().getColor());
        Assert.assertEquals("getField[1,3].Color black", Color.BLACK, board.getField(1, 3).getPiece().getColor());
        Assert.assertEquals("getField[2,3].Color black", Color.BLACK, board.getField(2, 3).getPiece().getColor());
    }
    
    @Test
    public void testCapturing(){
        SimpleBoard board = new SimpleBoard();
        Piece<?> p = board.getField(1, 0).getPiece();
        board.capturePiece(p);
        Assert.assertEquals("taken piece at [0,1]", Color.WHITE, board.takeBackPiece().getColor());
    }
}
