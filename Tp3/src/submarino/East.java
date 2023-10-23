package submarino;

public class East extends Direction {

    public String toString() {
        return "Este";
    }

    public Direction turnLeft() {
        return new North();
    }
    public Direction turnRight() {
        return new South();
    }
    public void moveFWD(Coordenada coordenada) {
        coordenada.yForward();
    }
}
