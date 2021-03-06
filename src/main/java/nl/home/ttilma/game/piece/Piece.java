package nl.home.ttilma.game.piece;

import java.util.List;

import nl.home.ttilma.game.board.Color;
import nl.home.ttilma.game.board.Move;
import nl.home.ttilma.game.board.Position;
import nl.home.ttilma.game.board.AbstractBoard;

/**
 * 
 * @author Tsjisse Tilma
 *
 */
public interface Piece<B extends AbstractBoard> {
    public void setPosition(Position pos);
    public Position getPosition();
    
    public void setAtInitialPosition(boolean atInitialPosition);
    public boolean isAtInitPosition(); 
    
    public void setColor(Color color);
    public Color getColor();
    
    public void moveGen(B board, List<Move> moveList);
    public String print();
}
