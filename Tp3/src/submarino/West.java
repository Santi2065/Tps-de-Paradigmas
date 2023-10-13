package submarino;

public class West extends Direction{

    public String value;

    public West() {
        this.value = "Oeste";
    }

    public String getValue() {
        return value;
    }

    public Direction turnLeft() {
        return new South();
    }

    public Direction turnRight() {
        return new North();
    }

    public void moveFWD(Coordenada coordenada, int i) {
        coordenada.y = coordenada.y - i;
    }
}
