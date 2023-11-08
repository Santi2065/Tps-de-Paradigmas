package linea;

import java.util.ArrayList;

public class NoPiece extends Piece{
    public boolean isRed() {
        return false;
    }

    public boolean isBlue() {
        return false;
    }

    public Piece pieceBelow(ArrayList<ArrayList<Piece>> board, int row, int col) {
        if (row == 0) {
            return null;
        } else {
            return board.get(row - 1).get(col);
        }
    }

    public String toString() {
        return " ";
    }

}
