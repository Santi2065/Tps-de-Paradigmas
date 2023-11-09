package linea;

public class BMode extends Mode{

        public String toString() {
            return "B";
        }

        public boolean checkWin(Linea linea, int column,String player) {
            //chequear diagonales
            int count = 0;
            int i = 0;
            int j = 0;
            //diagonal izquierda
            while (i < linea.rows && j < linea.columns) {
                if (Linea.gameBoard.get(i).get(j).equals(player)) {
                    count++;
                }
                else {
                    count = 0;
                }
                if (count == 4) {
                    return true;
                }
                i++;
                j++;
            }
            //diagonal derecha
            count = 0;
            i = 0;
            j = linea.columns - 1;
            while (i < linea.rows && j >= 0) {
                if (Linea.gameBoard.get(i).get(j).equals(player)) {
                    count++;
                }
                else {
                    count = 0;
                }
                if (count == 4) {
                    return true;
                }
                i++;
                j--;
            }
            return false;
        }
}
