package linea;

public class End extends Turn {
    public Turn nextTurn() {
        return this;
    }

    public Turn RedTurn(int column, Turn turn) {
        throw new RuntimeException("Game ended!");
    }

    public Turn BlueTurn(int column, Turn turn) {
        throw new RuntimeException("Game ended!");
    }

}
