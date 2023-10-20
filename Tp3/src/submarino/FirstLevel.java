package submarino;

import java.util.ArrayList;

public class FirstLevel extends Depth{
    public ArrayList<Depth> down(ArrayList depth) {
        depth.add(new Deep());
        return depth;
    }

    public String toString(){
        return "First Level";
    }

    public boolean launchICBM() {
        return true;
    }

}
