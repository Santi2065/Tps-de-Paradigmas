
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
	private SubDirection dir_izq90;
	private SubDirection dir_der90;
	
	
	@BeforeEach
	subma = new Submarino();
	
	@Test
	public void Test01Setup(){}
	
	@Test
	public void Test02SubmarinoTienePosicionInicial() {
		assertEquals(pos_nula , subma.position());
	}
	
	@Test
	public void Test03SubmarinoPuedeMoverseAbajo() {
		subma.command("d");
		assertEquals(pos_bajo10 , subma.position());
	}
	
	@Test
	public void Test04SubmarinoNoPuedeMoverseArriba() {
		subma.command("u");
		assertEquals(pos_nula , subma.position());
	}
	
	@Test
	public void Test05SubmarinoPuedeMoverseAbajoYArriba() {
		subma.command("d");
		subma.command("u");
		assertEquals(pos_nula , subma.position());
	}
	
	@Test
	public void Test06SubmarinoPuedeMoverseMismoComando() {
		subma.command("du");
		assertEquals(pos_nula , subma.position());
	}
	
	@Test
	public void Test07SubmarinoPuedeGirarIzq() {
		subma.command("l");
		assertEquals(dir_izq90 , subma.direction());
	}
	
	@Test
	public void Test08SubmarinoPuedeGirarDer() {
		subma.command("r");
		assertEquals(dir_der90 , subma.direction());
	}
	
	@Test
	public void Test09SubmarinoPuedeMoverseAdelante() {
		subma.command("f");
		assertEquals(pos_adelante10 , subma.position());
	}
	
	@Test
	public void Test10icbmPuedeDespegar() {
		assertTrue(subma.command("m"));
	}
	
	@Test
	public void Test11icbmNoPuedeDespegar2UnidadesAbajo() {
		subma.command("dd"));
		assertFalse(subma.command("m"));
	}
	
	@Test
	public void Test12icbmPuedeDespegar1UnidadAbajo() {
		subma.command("d");
		assertTrue(subma.command("m"));
	}
	
}