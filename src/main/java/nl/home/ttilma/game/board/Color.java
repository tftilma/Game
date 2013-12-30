package nl.home.ttilma.game.board;

/**
 * 
 * @author Tsjisse Tilma
 *
 */
public enum Color {
    WHITE(1), BLACK(2);

    private int colorNum = 0;

    private Color(int colorNum) {
        this.colorNum = colorNum;
    }

    public int getColorNum() {
        return colorNum;
    }
}
