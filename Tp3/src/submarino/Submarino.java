
package submarino;

import java.util.ArrayList;

public class Submarino {
    public Coordenada coordenada;
    public ArrayList<Depth> depth;
    public Direction direction;
    public Submarino() {
        coordenada = new Coordenada(0,0);
        depth = new ArrayList<Depth>();
        depth.add(new Surface());
        direction = new North();
    }


    public void down() {
        depth = depth.get(depth.size()-1).down(depth);
    }

    public Coordenada position() {
        return this.coordenada;
    }

    public void up() {
        depth.remove(depth.size()-1);
    }

    public void turnLeft() {
        direction = direction.turnLeft();
    }

    public void turnRight() {
        direction = direction.turnRight();
    }

    public String direction() {return direction.toString();}

    public void moveFWD() {
        direction.moveFWD(coordenada);
    }

    public boolean launchICBM() {
        return depth.get(depth.size()-1).launchICBM();
    }
}

