package submarino;

public class South extends Direction{

    public String toString() {
        return "Sur";
    }

    public Direction turnLeft() {
        return new East();
    }

    public Direction turnRight() {
        return new West();
    }

    public void moveFWD(Coordenada coordenada) {
        coordenada.xBackward();
    }
}
