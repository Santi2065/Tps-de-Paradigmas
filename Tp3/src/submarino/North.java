package submarino;

public class North extends Direction {

    public String toString() {
        return "Norte";
    }
    public Direction turnLeft() {
        return new West();
    }

    public Direction turnRight() {
        return new East();
    }



    public void moveFWD(Coordenada coordenada) {
        coordenada.xForward();
    }
}
