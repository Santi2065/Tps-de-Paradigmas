package linea;

public class RedTurn extends Turn{

    public Turn nextTurn(){
        return new BlueTurn();
    }

    public Turn RedTurn(int column, Turn turn){
        Linea.gameBoard.get(column - 1).remove(Linea.gameBoard.get(column - 1).size() - 1);
        Linea.gameBoard.get(column - 1).add("|X|");
        return new BlueTurn();
    }

    public Turn BlueTurn(int column, Turn turn){throw new RuntimeException("It is not Blue's turn");}
}
