
package submarino;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SubPosition {}
class SubDirection {}

public class subTest {
	
	private Submarino subma;
	private SubPosition pos_nula;
	private SubPosition pos_bajo10;
	private SubPosition pos_adelante10;
	private SubDirection dir_izq45;
	private SubDirection dir_der45;
	
	
	@BeforeEach
	subma = new Submarino();
	
	@Test
	public void Setup() {}
	
	@Test
	public void Test01SubmarinoTienePosicionInicial() {
		assertEquals(pos_nula , subma.position());
	}
	
	@Test
	public void Test02SubmarinoPuedeMoverseAbajo() {
		subma.down(10);
		assertEquals(pos_bajo10 , subma.position());
	}
	
	@Test
	public void Test03SubmarinoNoPuedeMoverseArriba() {
		subma.up(10);
		assertEquals(pos_nula , subma.position());
	}
	
	@Test
	public void Test04SubmarinoPuedeMoverseAbajoYArriba() {
		subma.down(10);
		subma.up(10);
		assertEquals(pos_nula , subma.position());
	}
	
	@Test
	public void Test05SubmarinoPuedeGirarIzq() {
		subma.turnLeft(45);
		assertEquals(dir_izq45 , subma.direction());
	}
	
	@Test
	public void Test06SubmarinoPuedeGirarDer() {
		subma.turnRight(45);
		assertEquals(dir_der45 , subma.direction());
	}
	
	@Test
	public void Test07SubmarinoPuedeMoverseAdelante() {
		subma.moveFWD(10);
		assertEquals(pos_adelante10 , subma.position());
	}
	
	@Test
	public void Test08SubmarinoNoPuedeMoverseAtras() {
		subma.moveFWD(-10);
		assertEquals(pos_nula , subma.position());
	}
	
	@Test
	public void Test09icbmPuedeDespegar() {
		assertTrue(subma.LaunchICBM());
	}
	
	@Test
	public void Test10icbmNoPuedeDespegar10abajo() {
		subma.down(10);
		assertFalse(subma.LaunchICBM);
	}
	
	@Test
	public void Test11icbmPuedeDespegarAlPrimerNivelSumergido() {
		subma.down(1);
		assertTrue(subma.LaunchICBM());
	}
	
	
}