package linea;

public class RedTurn extends Turn{

    public Turn nextTurn(){
        return new BlueTurn();
    }

    public void RedTurn(){}

    public void BlueTurn(){
        System.out.println("It is not Blue's turn");
    }
}
