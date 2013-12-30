package nl.home.ttilma.game.board;

/**
 * 
 * @author Tsjisse Tilma
 *
 */
public interface Board {
    public void initialBoard();
    public String print();
    public void play(Move move);
}
