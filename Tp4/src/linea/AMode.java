package linea;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class AMode extends Mode{

    public String toString() {
        return "A";
    }

    public boolean checkWin(Linea linea, int column, String player) {
        //win if solo 4 en línea en filas y columnas.
        int count = 0;
        //chequeo filas
        for (int i = 0; i < linea.rows; i++) {
            if (Linea.gameBoard.get(column - 1).get(i).equals(player)) {
                count++;
            }
            else {
                count = 0;
            }
            if (count == 4) {
                return true;
            }
        }
        //chequeo columnas
        count = 0;
        for(int j =0; j < linea.rows; j++) {
            for (int i = 0; i < linea.columns; i++) {

            if (Linea.gameBoard.get(i).get(j).equals(player)) {
                count++;
            }
            else {
                count = 0;
            }
            if (count == 4) {
                return true;
            }
        }}

        return false;
    }


}
