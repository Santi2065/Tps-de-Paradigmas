package linea;

public class CMode extends Mode{

        Mode a = new AMode();
        Mode b = new BMode();

        public String toString() {
            return "C";
        }

        public boolean checkWin(Linea linea, int column,String player   ) {
            return a.checkWin(linea, column, player) || b.checkWin(linea, column, player);
        }
}
