package submarino.Directions;

import submarino.Coordenada;

public abstract class Direction {

    public abstract Direction turnLeft();

    public abstract Direction turnRight();

    

    public abstract void moveFWD(Coordenada coordenada);

}
