package submarino;

public class North extends Direction{
    public String value;

    public North() {
        this.value = "Norte";
    }

    public String getValue() {
        return value;
    }
    public Direction turnLeft() {
        return new West();
    }

    public Direction turnRight() {
        return new East();
    }



    public void moveFWD(Coordenada coordenada, int i) {
        coordenada.x = coordenada.x + i;
    }
}
