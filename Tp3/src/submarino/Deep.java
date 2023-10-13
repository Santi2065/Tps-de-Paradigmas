package submarino;

import java.util.ArrayList;

public class Deep extends Depth{

    public ArrayList down(ArrayList depth) {
        depth.add(new Deep());
        return depth;
    }

    public String getValue(){
        return "Deep";
    }

    public boolean launchICBM() {
        return false;
    }
}
