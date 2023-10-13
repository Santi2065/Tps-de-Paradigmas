package submarino;

public class South extends Direction{
    public String value;

    public South() {
        this.value = "Sur";
    }

    public String getValue() {
        return value;
    }

    public Direction turnLeft() {
        return new East();
    }

    public Direction turnRight() {
        return new West();
    }

    public void moveFWD(Coordenada coordenada, int i) {
        coordenada.x = coordenada.x - i;
    }
}
