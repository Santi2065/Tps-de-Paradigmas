package linea;

import java.util.ArrayList;
import java.util.stream.IntStream;
import java.util.stream.Collectors;

public class Linea{

    public static ArrayList<ArrayList<String>> gameBoard = new ArrayList<>();

    private static final String OUT_OF_RANGE = "Out of range";

    private boolean redWon = false;
    private boolean blueWon = false;
    public static int columns;
    public static int rows;
    private final Mode modo;

    private Turn turn = new RedTurn();

    public Linea(int columns, int rows, char modo){
        Linea.columns = columns;
        Linea.rows = rows;
        this.modo = Mode.selectMode(modo);
        IntStream.range(0, columns).forEach(i -> {
            ArrayList<String> column = new ArrayList<>();
            IntStream.range(0, rows).forEach(j -> column.add("| |"));
            gameBoard.add(column);
        });
    }

    public ArrayList<ArrayList<String>> getBoard(){
        return gameBoard;
    }

    public String show() {
        return IntStream.range(0, rows)
                .mapToObj(i -> IntStream.range(0, columns)
                .mapToObj(j -> gameBoard.get(j).get(i))
                .collect(Collectors.joining("")))
                .collect(Collectors.joining("\n"));
    }


    public boolean finished(){
        return redWon || blueWon|| completedBoard();
    }

    public void playRedAt(int column){
        if (column <= 0 || column > columns) {
            throw new RuntimeException(OUT_OF_RANGE);
        }
        turn = turn.RedTurn(column, turn);
        redWon = modo.checkWin(this, column,"|X|");
        if (redWon) {
            System.out.println("Red wins!");
            turn = new End();
        } else if (completedBoard()) {
            System.out.println("Draw!");
            turn = new End();
        }

    }

    public void playBlueAt(int columns){
        if (columns <= 0 || columns > Linea.columns) {
            throw new RuntimeException(OUT_OF_RANGE);
        }
        turn = turn.BlueTurn(columns, turn);
        blueWon = modo.checkWin(this, columns, "|O|");
        if (blueWon) {
            System.out.println("Blue wins!");
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

}
