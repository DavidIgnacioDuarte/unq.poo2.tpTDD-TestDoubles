package poquer;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CartaTest {

	Carta diamantes12;
	
	
	@BeforeEach
	void setUp() {
		
		diamantes12 = new Carta("D", "Q");
		
	}
	
	
	@Test
	void testConstructor() {
		
		assertEquals("D", diamantes12.getPalo());
		assertEquals("Q", diamantes12.getValor());
		assertEquals(12, diamantes12.valorNumerico());
		
	}
	
	
	void testComparacionesConCartas() {
		
		//exercise
		Carta picas13 = new Carta("P", "K");
		Carta corazones10 = new Carta("C", "10");
		Carta treboles12 = new Carta("T", "Q");
		Carta diamantes1 = new Carta("D", "1");
		
		//comparacion con valores
		assertTrue(diamantes12.tieneValorSuperior(corazones10));
		assertTrue(diamantes12.tieneValorSuperior(diamantes1));
		assertFalse(diamantes12.tieneValorSuperior(picas13));
		assertFalse(diamantes12.tieneValorSuperior(treboles12));
		
		//comparacion con palos
		assertTrue(diamantes12.tieneMismoPalo(diamantes1));
		assertFalse(diamantes12.tieneMismoPalo(picas13));
		assertFalse(diamantes12.tieneMismoPalo(corazones10));
		assertFalse(diamantes12.tieneMismoPalo(treboles12));
		
	}

}
