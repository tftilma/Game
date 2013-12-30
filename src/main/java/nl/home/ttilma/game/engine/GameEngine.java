package nl.home.ttilma.game.engine;

import nl.home.ttilma.game.board.Board;
import nl.home.ttilma.game.board.Move;

/**
 * 
 * @author Tsjisse Tilma
 *
 */
public interface GameEngine {
    public void setCompStarts(boolean compStarts);
    public boolean isCompStarts();
    public void setGameFinished(boolean gameFinished);
    public boolean isGameFinished();
    
    public void initBoard();
    public void play(Move move);
    public Move thinkMove();
    public Board getBoard();
    public boolean isValid(Move move);
}
