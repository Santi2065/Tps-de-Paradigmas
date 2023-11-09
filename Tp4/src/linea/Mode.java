package linea;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Mode {

    public static ArrayList<Mode> modes = new ArrayList<Mode>(Arrays.asList(new AMode(), new BMode(), new CMode()));

    public static Mode selectMode(char mode){
        List<Mode> chosen = modes.stream()
                .filter( m -> m.toString().equals(String.valueOf(mode)))
                .toList();
        return chosen.get(0);
    }

    public abstract boolean checkWin(Linea linea, int column);
}
