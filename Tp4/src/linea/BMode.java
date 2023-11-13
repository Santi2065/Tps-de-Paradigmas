package linea;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;


public class BMode extends Mode{

    public String toString() {
            return "B";
        }
    public boolean checkWin(Linea linea, int column, String player) {

        //win 4 en linea en diagonal para todas las posibles diagonales de cualquier tipo de tablero
        //diagonales de izquierda a derecha
        AtomicInteger count = new AtomicInteger();

        return IntStream.range(0, Linea.rows)
                .anyMatch(i -> IntStream.range(0, Linea.columns)
                        .anyMatch(j -> {
                            count.set(0);
                            boolean diagonal1 = i <= Linea.rows - 4 && j <= Linea.columns - 4 && IntStream.range(0, 4)
                                    .peek(k -> count.set(Linea.gameBoard.get(i + k).get(j + k).equals(player) ? count.incrementAndGet() : 0))
                                    .anyMatch(k -> count.get() == 4);
                            count.set(0);
                            boolean diagonal2 = i >= 3 && j <= Linea.columns - 4 && IntStream.range(0, 4)
                                    .peek(k -> count.set(Linea.gameBoard.get(i - k).get(j + k).equals(player) ? count.incrementAndGet() : 0))
                                    .anyMatch(k -> count.get() == 4);
                            return diagonal1 || diagonal2;
                        })
                );




    }}
