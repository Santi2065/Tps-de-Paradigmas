package submarino;

public class Coordenada {
    public int x;
    public int y;

    public Coordenada(int newX, int newY) {
        x = newX;
        y = newY;
    }

    public void yForward() {
        this.y += 1;
    }

    public void yBackward() {
        this.y -= 1;
    }
    public void xForward() {
        this.x += 1;
    }

    public void xBackward() {
        this.x -= 1;
    }

    public String toString() {
        return "(" + x + "," + y + ")";
    }


}
