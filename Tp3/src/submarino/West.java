package submarino;

public class West extends Direction {

    public String toString() {
        return "Oeste";
    }

    public Direction turnLeft() {
        return new South();
    }

    public Direction turnRight() {
        return new North();
    }

    public void moveFWD(Coordenada coordenada) {
        coordenada.yBackward();
    }
}
