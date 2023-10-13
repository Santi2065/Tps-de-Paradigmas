package submarino;

public class Coordenada {
    public int x;
    public int y;
    public int z;

    public Coordenada(int newX, int newY, int newZ) {
        x = newX;
        y = newY;
        z = newZ;
    }

    public boolean equals(Coordenada other) {
        return (x == other.x && y == other.y && z == other.z);
    }

    public void down(int i) { z = z - i; }

    public void up(int i) {
        z = z + i;
    }


}
