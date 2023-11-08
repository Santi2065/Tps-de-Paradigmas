package linea;

public class BlueTurn extends Turn{

    public Turn nextTurn() {
        return new RedTurn();
    }

    public void RedTurn() {
        throw new RuntimeException("It is not Red's turn");
    }

    public void BlueTurn() {}
}
