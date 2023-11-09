package linea;

public class BlueTurn extends Turn{

    public Turn nextTurn() {
        return new RedTurn();
    }

    public Turn RedTurn(int column, Turn turn) {
        throw new RuntimeException("It is not Red's turn");
    }

    public Turn BlueTurn(int column, Turn turn) {
        // clean last row of column before adding new piece but not delete whole row only the last piece
        // so that the format of the gameboard is preserved
        Linea.gameBoard.get(column - 1).remove(Linea.gameBoard.get(column - 1).size() - 1);
        Linea.gameBoard.get(column - 1).add("|O|");


        return new RedTurn();
    }
}
