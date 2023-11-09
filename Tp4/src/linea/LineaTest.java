package linea;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LineaTest {

    @AfterEach
    public void tearDown() {
        Linea.gameBoard.clear();
    }

    @Test
    public void testEmptyBoard() {
        Linea linea = new Linea(3,4, 'A');
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                assertTrue(linea.getBoard().get(i).get(j).toString() == "| |");
            }
        }
    }

    @Test
    public void testShow() {
        Linea linea = new Linea(3,4, 'A');
        String expected = "| || || |\n| || || |\n| || || |\n| || || |";
        assertEquals(expected, linea.show());
    }

    @Test
    public void testAMode() {
        Linea linea = new Linea(3,4, 'A');
        String expected = "A";
        assertEquals(expected, linea.getMode().toString());
    }

    @Test
    public void testBMode() {
        Linea linea = new Linea(3,4, 'B');
        String expected = "B";
        assertEquals(expected, linea.getMode().toString());
    }

    @Test
    public void testCMode(){
        Linea linea = new Linea(3,4, 'C');
        String expected = "C";
        assertEquals(expected, linea.getMode().toString());
    }

    @Test
    public void testPlayRedAt() {
        Linea linea = new Linea(3,4, 'A');
        linea.playRedAt(0);
        String expected = "    \n    \nX   \n";
        assertEquals(expected, linea.show());
    }

    @Test
    public void testPlayBlueAt() {
        Linea linea = new Linea(3,4, 'A');
        linea.playRedAt(1);
        linea.playBlueAt(3);
        String expected = "    \n    \nO   \n";
        assertEquals(expected, linea.show());
    }

    @Test
    public void testPlayRedAtColumnFull() {
        Linea linea = new Linea(3,4, 'A');
        linea.playRedAt(0);
        linea.playRedAt(0);
        linea.playRedAt(0);
        linea.playRedAt(0);
        linea.playRedAt(0);
        String expected = "X   \nX   \nX   \n";
        assertEquals(expected, linea.show());
    }

    @Test
    public void testPlayBlueAtColumnFull() {
        Linea linea = new Linea(3,4, 'A');
        linea.playBlueAt(0);
        linea.playBlueAt(0);
        linea.playBlueAt(0);
        linea.playBlueAt(0);
        linea.playBlueAt(0);
        String expected = "O   \nO   \nO   \n";
        assertEquals(expected, linea.show());
    }

    @Test
    public void testRedWins() {
        Linea linea = new Linea(3,4, 'A');
        linea.playRedAt(0);
        linea.playRedAt(1);
        linea.playRedAt(2);
        linea.playRedAt(3);
        assertTrue(linea.finished());
    }
}