
package submarino;

public class Submarino {
    public Coordenada coordenada;
    public Direction direction;
    public int angle;
    public Submarino() {
        coordenada = new Coordenada(0,0,0);
        direction = new North();
    }
    public void down(int i) {
        coordenada.down(i);
    }

    public Coordenada position() {
        return this.coordenada;
    }

    public void up(int i) {
        if (coordenada.z + i < 0){
            coordenada.up(i);
        }
        else {
            coordenada.z = 0;
        }
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



    public boolean LaunchICBM() {
        if (coordenada.z <= -10){
            return false;
        }
        else{
        return true;
        }
    }
}