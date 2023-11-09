package linea;

import java.util.ArrayList;
import java.util.stream.IntStream;
import java.util.stream.Collectors;

public class Linea{

    public static ArrayList<ArrayList<String>> gameBoard = new ArrayList<ArrayList<String>>();

    private static final String OUT_OF_RANGE = "Out of range";

    private boolean redWon = false;
    private boolean blueWon = false;

    private String winner = "";
    private int columns;
    private int rows;
    private Mode modo;

    private Turn turn = new RedTurn();

    public Linea(int columns, int rows, char modo){
        this.columns = columns;
        this.rows = rows;
        this.modo = Mode.selectMode(modo);
        IntStream.range(0, rows).forEach(i -> {
            ArrayList<String> row = new ArrayList<String>();
            IntStream.range(0, columns).forEach(j -> row.add("| |"));
            gameBoard.add(row);
        });
    }

    public ArrayList<ArrayList<String>> getBoard(){
        return gameBoard;
    }

    public String show() {
        return gameBoard.stream()
                .map(column -> column.stream()
                .collect(Collectors.joining("")))
                .collect(Collectors.joining("\n"));
    }


    public boolean finished(){

        return false;
    }

    public void playRedAt(int column){
        if (column <= 0 || column > columns) {
            throw new RuntimeException(OUT_OF_RANGE);
        }
        turn = turn.RedTurn(column, turn);
        redWon = modo.checkWin(this, column);
        if (redWon) {
            System.out.println("Red wins!");
            winner = "red";
            turn = new End();
        } else if (completedBoard()) {
            System.out.println("Draw!");
            turn = new End();
        }

    }

    public void playBlueAt(int columns){
        if (columns <= 0 || columns > this.columns) {
            throw new RuntimeException(OUT_OF_RANGE);
        }
        turn = turn.BlueTurn(columns, turn);
        blueWon = modo.checkWin(this, columns);
        if (blueWon) {
            System.out.println("Blue wins!");
            winner = "blue";
            turn = new End();
        } else if (completedBoard()) {
            System.out.println("Draw!");
            turn = new End();
        }
    }

    public boolean completedBoard(){
        return gameBoard.stream().allMatch(column -> column.stream().noneMatch(cell -> cell.equals("| |")));
    }


    public Object getMode() {
        return modo;
    }

    public String getWinner() {
        return winner;
    }
}
