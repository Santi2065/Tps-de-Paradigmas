package linea;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class AMode extends Mode{

    public String toString() {
        return "A";
    }

    public boolean checkWin(Linea linea, int column, String player) {
        //win if solo 4 en línea en filas y columnas.
        //chequeo filas
        AtomicInteger count1 = new AtomicInteger();
        boolean result = IntStream.range(0, Linea.rows)
                .peek(i -> count1.set(Linea.gameBoard.get(column - 1).get(i).equals(player) ? count1.incrementAndGet() : 0))
                .anyMatch(i -> count1.get() == 4);

        //chequeo columnas
        AtomicInteger count2 = new AtomicInteger();
        boolean result2 = IntStream.range(0, Linea.rows)
                .anyMatch(j -> {
                    count2.set(0);
                    return IntStream.range(0, Linea.columns)
                            .peek(i -> count2.set(Linea.gameBoard.get(i).get(j).equals(player) ? count2.incrementAndGet() : 0))
                            .anyMatch(i -> count2.get() == 4);
                });



        return result ||result2;
    }


}
