package linea;

public abstract class Turn {
    public abstract Turn nextTurn();
    public abstract Turn RedTurn(int column, Turn turn);
    public abstract Turn BlueTurn(int column, Turn turn);
}
