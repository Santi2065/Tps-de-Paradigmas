package submarino;

import java.util.ArrayList;

public class Surface extends Depth {
    public void Surface() {}

        public ArrayList down(ArrayList depth) {
            depth.add(new FirstLevel());
            return depth;
        }

        public String getValue(){
            return "Surface";
        }

        public boolean launchICBM() {
            return true;
        }

    }

}
