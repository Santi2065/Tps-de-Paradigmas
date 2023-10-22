package submarino.Depth;

import java.util.ArrayList;

public class Surface extends Depth {

    public ArrayList<Depth> down(ArrayList<Depth> depth) {
        depth.add(new FirstLevel());
        return depth;
    }

    @Override
    public ArrayList<Depth> up(ArrayList<Depth> depth) {
        return depth;
    }

    public String toString(){
        return "Surface";
    }

    public boolean launchICBM() {
        return true;
    }

    }

