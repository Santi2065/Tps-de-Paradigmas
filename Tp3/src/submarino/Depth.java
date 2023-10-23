package submarino;


import java.util.ArrayList;

public abstract class Depth {

    public abstract ArrayList<Depth> down(ArrayList<Depth> depth);

    public ArrayList<Depth> up(ArrayList<Depth> depth){
        depth.remove(depth.size()-1);
        return depth;
    }

    public abstract boolean launchICBM();

    }

