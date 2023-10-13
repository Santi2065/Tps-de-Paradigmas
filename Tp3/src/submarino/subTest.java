
package submarino;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;
class SubDirection {}

public class subTest {
	
	private Submarino subma;
	private Coordenada pos_nula = new Coordenada(0,0,0);
	private Coordenada pos_bajo10 = new Coordenada(0,0,-10);
	private Coordenada pos_adelante10 = new Coordenada(10,0,0);
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
		assertEquals(pos_nula.z, subma.position().z);
	}
	
	@Test
	public void Test02SubmarinoPuedeMoverseAbajo() {
		subma.down(10);
		assertEquals(pos_bajo10.x, subma.position().x);
		assertEquals(pos_bajo10.y, subma.position().y);
		assertEquals(pos_bajo10.z, subma.position().z);
	}
	
	@Test
	public void Test03SubmarinoNoPuedeMoverseArriba() {
		subma.up(10);
		assertEquals(pos_nula.x, subma.position().x);
		assertEquals(pos_nula.y, subma.position().y);
		assertEquals(pos_nula.z, subma.position().z);
	}
	
	@Test
	public void Test04SubmarinoPuedeMoverseAbajoYArriba() {
		subma.down(10);
		subma.up(10);
		assertEquals(pos_nula.x, subma.position().x);
		assertEquals(pos_nula.y, subma.position().y);
		assertEquals(pos_nula.z, subma.position().z);
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
		subma.moveFWD(10);
		assertEquals(pos_adelante10.x, subma.position().x);
		assertEquals(pos_adelante10.y, subma.position().y);
		assertEquals(pos_adelante10.z, subma.position().z);
	}
	
	@Test
	public void Test08SubmarinoNoPuedeMoverseAtras() {
		subma.moveFWD(-10);
		assertEquals(pos_nula.x, subma.position().x);
		assertEquals(pos_nula.y, subma.position().y);
		assertEquals(pos_nula.z, subma.position().z);
	}
	
	@Test
	public void Test09icbmPuedeDespegar() {
		assertTrue(subma.LaunchICBM());
	}
	
	@Test
	public void Test10icbmNoPuedeDespegar10abajo() {
		subma.down(10);
		assertFalse(subma.LaunchICBM());
	}
	
	@Test
	public void Test11icbmPuedeDespegarAlPrimerNivelSumergido() {
		subma.down(1);
		assertTrue(subma.LaunchICBM());
	}
	
	
}