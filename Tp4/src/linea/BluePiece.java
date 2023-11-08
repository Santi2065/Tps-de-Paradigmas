package linea;

import java.util.ArrayList;
public class BluePiece extends Piece{

    public boolean isRed() {
        return false;
    }

    public boolean isBlue() {
        return true;
    }

    public Piece pieceBelow(ArrayList<ArrayList<Piece>> board, int row, int col) {
        if (row == 0) {
            return null;
        } else {
            return board.get(row - 1).get(col);
        }
    }

    public String toString() {
        return "O";
    }

}
