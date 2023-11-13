package linea;

import java.util.stream.IntStream;

public class RedTurn extends Turn{


    public Turn RedTurn(int column, Turn turn){
        int row = IntStream.range(0, Linea.rows)
         .filter(i -> Linea.gameBoard.get(column - 1).get(i)
         .equals("| |")).reduce((first, second) -> second)
         .orElseThrow(() -> new RuntimeException("Column is full"));

        Linea.gameBoard.get(column - 1).set(row, "|X|");

        return new BlueTurn();
    }

    public Turn BlueTurn(int column, Turn turn){throw new RuntimeException("It is not Blue's turn");}
}
