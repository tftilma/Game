package nl.home.ttilma.game.board;

public class Position {
    public static int COL_A = 0;
    public static int COL_B = 1;
    public static int COL_C = 2;
    public static int COL_D = 3;
    public static int COL_E = 4;
    public static int COL_F = 5;
    public static int COL_G = 6;
    public static int COL_H = 7;

    public static int ROW_1 = 0;
    public static int ROW_2 = 1;
    public static int ROW_3 = 2;
    public static int ROW_4 = 3;
    public static int ROW_5 = 4;
    public static int ROW_6 = 5;
    public static int ROW_7 = 6;
    public static int ROW_8 = 7;

    private int col; // also x H=7
    private int row; // also y 8=7

    public Position(int col, int row) {
        this.setCol(col);
        this.setRow(row);
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getCol() {
        return col;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getRow() {
        return row;
    }
}
