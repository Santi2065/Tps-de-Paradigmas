package submarino;

public class Coordenada {
    public int x;
    public int y;

    public Coordenada(int newX, int newY) {
        x = newX;
        y = newY;
    }

    public boolean equals(Coordenada other) {
        return (x == other.x && y == other.y);
    }


}
