package linea;

import java.util.stream.IntStream;

public class BlueTurn extends Turn{

    public Turn nextTurn() {
        return new RedTurn();
    }

    public Turn RedTurn(int column, Turn turn) {
        throw new RuntimeException("It is not Red's turn");
    }

    public Turn BlueTurn(int column, Turn turn) {
        int row = IntStream.range(0, Linea.rows)
                .filter(i -> Linea.gameBoard.get(column - 1).get(i)
                .equals("| |")).reduce((first, second) -> second)
                .orElseThrow(() -> new RuntimeException("Column is full"));

        Linea.gameBoard.get(column - 1).set(row, "|O|");

        return new RedTurn();
    }
}
