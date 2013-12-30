package nl.home.ttilma.game.engine;

import nl.home.ttilma.game.board.Board;

/**
 * 
 * @author Tsjisse Tilma
 *
 */
public abstract class AbstractGameEngine<B extends Board> {
    private boolean compStarts;
    private boolean gameFinished = false;
    private B board;
    
    protected AbstractGameEngine(B board) {
        this.board = board;
    }
    
    public void setCompStarts(boolean compStarts) {
        this.compStarts = compStarts;
    }
    public boolean isCompStarts() {
        return compStarts;
    }
    public void setGameFinished(boolean gameFinished) {
        this.gameFinished = gameFinished;
    }
    public boolean isGameFinished() {
        return gameFinished;
    }

    public B getBoard() {
        return board;
    }
}
