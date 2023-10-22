package submarino.Depth;

import java.util.ArrayList;

public class Deep extends Depth {

    public ArrayList<Depth> down(ArrayList<Depth> depth) {
        depth.add(new Deep());
        return depth;
    }

    public String toString(){
        return "Deep";
    }

    public boolean launchICBM() {
        return false;
    }
}
