package submarino;

public class East extends Direction{

    public String value;

    public East() {
        this.value = "Este";
    }

    public String getValue() {
        return value;
    }

    public Direction turnLeft() {
        return new North();
    }
    public Direction turnRight() {
        return new South();
    }
    public void moveFWD(Coordenada coordenada, int i) {
        coordenada.y = coordenada.y + i;
    }
}
