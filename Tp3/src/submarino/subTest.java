
package submarino;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class subTest {
	
	private Submarino subma;
	private Coordenada pos_nula = new Coordenada(0,0);
	private String first_level = "First Level";
	private Coordenada pos_adelante1 = new Coordenada(1,0);
	private String angulo_left = "Oeste";
	private String angulo_right = "Este";
	
	
	@BeforeEach
	public void init() {
		subma = new Submarino();
	}
	
	@Test
	public void Test01SubmarinoTienePosicionInicial() {
		assertEquals(pos_nula.x, subma.position().x);
		assertEquals(pos_nula.y, subma.position().y);
	}
	
	@Test
	public void Test02SubmarinoPuedeMoverseAbajo() {
		subma.down();
		assertEquals(first_level, subma.depth.get(subma.depth.size()-1).toString());
	}
	
	@Test
	public void Test03SubmarinoNoPuedeMoverseArriba() {
		subma.up();
		assertEquals(pos_nula.x, subma.position().x);
		assertEquals(pos_nula.y, subma.position().y);
	}
	
	@Test
	public void Test04SubmarinoPuedeMoverseAbajoYArriba() {
		subma.down();
		subma.up();
		assertEquals(pos_nula.x, subma.position().x);
		assertEquals(pos_nula.y, subma.position().y);
	}
	
	@Test
	public void Test05SubmarinoPuedeGirarIzq() {
		subma.turnLeft();
		assertEquals(angulo_left , subma.direction());
	}
	
	@Test
	public void Test06SubmarinoPuedeGirarDer() {
		subma.turnRight();
		assertEquals(angulo_right , subma.direction());
	}
	
	@Test
	public void Test07SubmarinoPuedeMoverseAdelante() {
		subma.moveFWD();
		assertEquals(pos_adelante1.x, subma.position().x);
		assertEquals(pos_adelante1.y, subma.position().y);

	}
	
	@Test
	public void Test08icbmPuedeDespegar() {
		assertTrue(subma.launchICBM());
	}
	
	@Test
	public void Test09icbmNoPuedeDespegar2Abajo() {
		subma.down();
		subma.down();
		assertFalse(subma.launchICBM());
	}
	
	@Test
	public void Test10icbmPuedeDespegarAlPrimerNivelSumergido() {
		subma.down();
		assertTrue(subma.launchICBM());
	}
	
	
}