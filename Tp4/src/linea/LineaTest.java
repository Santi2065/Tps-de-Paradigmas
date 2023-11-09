package linea;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
                assertTrue(linea.getBoard().get(j).get(i).toString() == "| |");
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
        linea.playRedAt(1);
        String expected =   "| || || |\n" +
                            "| || || |\n" +
                            "| || || |\n" +
                            "|X|| || |";
        assertEquals(expected, linea.show());
    }

    @Test
    public void testPlayBlueAt() {
        Linea linea = new Linea(3,4, 'A');
        linea.playRedAt(1);
        linea.playBlueAt(3);
        String expected =   "| || || |\n" +
                            "| || || |\n" +
                            "| || || |\n" +
                            "|X|| ||O|";
        assertEquals(expected, linea.show());
    }

    @Test
    public void testPlayRedAtColumnFull() {
        Linea linea = new Linea(3,4, 'A');
        linea.playRedAt(1);
        linea.playBlueAt(2);
        linea.playRedAt(1);
        linea.playBlueAt(2);
        linea.playRedAt(1);
        linea.playBlueAt(2);
        linea.playRedAt(1);
        linea.playBlueAt(2);
        String expected = "|X||O|| |\n" +
                          "|X||O|| |\n" +
                          "|X||O|| |\n" +
                          "|X||O|| |";
        assertEquals(expected, linea.show());
        assertThrows(RuntimeException.class, () -> linea.playRedAt(1));
    }

    @Test
    public void testPlayBlueAtColumnFull() {
        Linea linea = new Linea(3,4, 'A');
        linea.playRedAt(1);
        linea.playBlueAt(2);
        linea.playRedAt(1);
        linea.playBlueAt(2);
        linea.playRedAt(1);
        linea.playBlueAt(2);
        linea.playRedAt(1);
        linea.playBlueAt(2);
        String expected = "|X||O|| |\n" +
                          "|X||O|| |\n" +
                          "|X||O|| |\n" +
                          "|X||O|| |";
        assertEquals(expected, linea.show());
        assertThrows(RuntimeException.class, () -> linea.playBlueAt(2));
    }

    @Test
    public void testRedWinsVertical() {
        Linea linea = new Linea(3,4, 'A');
        linea.playRedAt(1);
        linea.playBlueAt(2);
        linea.playRedAt(1);
        linea.playBlueAt(2);
        linea.playRedAt(1);
        linea.playBlueAt(2);
        linea.playRedAt(1);
        assertTrue(linea.finished());
    }

    @Test
    public void testBlueWinsHorizontal() {
        Linea linea = new Linea(4,4, 'A');
        linea.playRedAt(1);
        linea.playBlueAt(1);
        linea.playRedAt(2);
        linea.playBlueAt(2);
        linea.playRedAt(3);
        linea.playBlueAt(3);
        linea.playRedAt(2);
        linea.playBlueAt(4);
        linea.playRedAt(3);
        linea.playBlueAt(4);
        assertTrue(linea.finished());
    }

    @Test
    public void testRedWinsDiagonal() {
        Linea linea = new Linea(4,4, 'B');
        linea.playRedAt(1);
        linea.playBlueAt(2);
        linea.playRedAt(2);
        linea.playBlueAt(3);
        linea.playRedAt(3);
        linea.playBlueAt(4);
        linea.playRedAt(3);
        linea.playBlueAt(4);
        linea.playRedAt(4);
        linea.playBlueAt(1);
        linea.playRedAt(4);
        assertTrue(linea.finished());
    }

    @Test
    public void testDraw() {
        Linea linea = new Linea(4,4, 'A');
        linea.playRedAt(1);
        linea.playBlueAt(2);
        linea.playRedAt(3);
        linea.playBlueAt(4);
        linea.playRedAt(2);
        linea.playBlueAt(1);
        linea.playRedAt(4);
        linea.playBlueAt(3);
        linea.playRedAt(1);
        linea.playBlueAt(2);
        linea.playRedAt(3);
        linea.playBlueAt(4);
        linea.playRedAt(2);
        linea.playBlueAt(1);
        linea.playRedAt(4);
        linea.playBlueAt(3);
        assertTrue(linea.finished());
    }

    @Test
    public void testRedWinsVerticalCMode() {
        Linea linea = new Linea(3,4, 'C');
        linea.playRedAt(1);
        linea.playBlueAt(2);
        linea.playRedAt(1);
        linea.playBlueAt(2);
        linea.playRedAt(1);
        linea.playBlueAt(2);
        linea.playRedAt(1);
        assertTrue(linea.finished());
    }
}