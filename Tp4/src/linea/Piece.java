package linea;

import java.util.ArrayList;

public abstract class Piece {
    public abstract boolean isRed();
    public abstract boolean isBlue();
    public abstract Piece pieceBelow(ArrayList<ArrayList<Piece>> board, int row, int col);
}
