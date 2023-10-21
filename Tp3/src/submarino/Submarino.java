
package submarino;

import java.util.ArrayList;

public class Submarino {
    public Coordenada coordenada;

    public ArrayList<Commands> commands;

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
                    this.moveFWD();
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

    public static void main(String[] args) {
        Submarino submarino = new Submarino();
        submarino.processCommands("rffrffrffrff");
        System.out.println(submarino.position().toString());
        System.out.println(submarino.direction());
        System.out.println(submarino.depth.get(submarino.depth.size()-1).toString());
    }
}

