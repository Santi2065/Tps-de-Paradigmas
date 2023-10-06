
package submarino;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class subTest {
	
	private Submarino subma;
	private SubPosition pos_nula;
	
	@BeforeEach
	subma = new Submarino();
	
	
	@Test
	public void Setup() {
		
	}
	
	@Test
	public void Test01SubmarinoTienePosicionInicial() {
		assertEquals(pos_nula,subma.position());
	}
	
	
	
}