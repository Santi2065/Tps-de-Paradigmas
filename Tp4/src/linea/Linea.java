package linea;

import java.util.ArrayList;
import java.util.stream.IntStream;
import java.util.stream.Collectors;

public class Linea{

    private ArrayList<ArrayList<String>> gameBoard = new ArrayList<ArrayList<String>>();
    private int columns;
    private int rows;
    private Mode modo;

    public Linea(int columns, int rows, char modo){
        this.columns = columns;
        this.rows = rows;
        this.modo = Mode.selectMode(modo);
        IntStream.range(0, columns).forEach(i -> gameBoard.add(new ArrayList<>()));
    }

    public ArrayList<ArrayList<String>> getBoard(){
        return gameBoard;
    }

    public String show() {
        return IntStream.range(0, rows)
                .mapToObj(i -> "\n" + IntStream.range(0, columns)
                .mapToObj(j -> gameBoard.get(j).size() > rows - 1 - i ? gameBoard.get(j).get(rows - 1 - i) : "| |")
                .collect(Collectors.joining()))
                .collect(Collectors.joining());
    }


    public boolean finished(){

        return false;
    }

    public void playRedAt(int columns){
        for(int r = gameBoard.size() - 1; r >= 0; r--){
            if(gameBoard.get(r).get(columns).toString().equals(" ")){
                gameBoard.get(r).set(columns, "X");
                break;
            }
        }
    }

    public void playBlueAt(int columns){
        for(int r = gameBoard.size() - 1; r >= 0; r--){
            if(gameBoard.get(r).get(columns).toString().equals(" ")){
                gameBoard.get(r).set(columns, "O");
                break;
            }
        }
    }


    public Object getMode() {
        return modo;
    }
}
