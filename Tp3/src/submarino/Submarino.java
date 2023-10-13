
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

    public void processCommands(String commands) {
        for (char command : commands.toCharArray()) {
            switch (command) {
                case 'd':
                    this.down();
                    break;
                case 'u':
                    this.up();
                    break;
                case 'l':
                    this.turnLeft();
                    break;
                case 'r':
                    this.turnRight();
                    break;
                case 'f':
                    this.moveFWD(1);
                    break;
                case 'm':
                    if (!this.launchICBM()) {
                        System.out.println("¡El submarino se ha destruido!");
                        return;
                    }
                    break;
                default:
                    System.out.println("Comando desconocido: " + command);
            }
        }
    }

    public void down() {
        depth.get(depth.size()-1).down(depth);
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

    public String direction() {return direction.getValue();}

    public void moveFWD(int i) {
        if (i > 0){direction.moveFWD(coordenada, i);}
    }



    public boolean launchICBM() {
        return depth.get().launchICBM();
    }

    public static void main(String[] args) {
        Submarino submarino = new Submarino();
        submarino.processCommands("rfflff");
        System.out.println(submarino.position().x);
        System.out.println(submarino.position().y);
        System.out.println(submarino.depth.get().getValue());
        System.out.println(submarino.direction());
    }
}

