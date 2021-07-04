package poquer;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PokerStatusTest {

	
	PokerStatus pokerStatus;
	Carta picas1;
	Carta picas2;
	Carta corazones3;
	Carta corazones1;
	Carta treboles1;
	Carta diamantes1;
	Carta diamantes3;
	
	Carta diamantes11;
	Carta corazones12;
	Carta picas10;
	
	Carta diamantes4;
	Carta diamantes5;
	
	
	//SETUP Y TEARDOWN A LA VEZ(AL SER BEFOREACH)//
	@BeforeEach
	void setUp() {
		
		pokerStatus = PokerStatus.getPokerStatus();
		
		picas1 = new Carta("P", "1");
		picas2 = new Carta("P", "2");
		corazones3 = new Carta("C", "3");
		corazones1 = new Carta("C", "1");
		treboles1 = new Carta("T", "1");
		diamantes1 = new Carta("D", "1");
		diamantes3 = new Carta("D", "3");
		
		diamantes11 = new Carta("D", "J");
		corazones12 = new Carta("C", "Q");
		picas10 = new Carta("P", "10");
		
		diamantes4 = new Carta("D", "4");
		diamantes5 = new Carta("D", "5");
		
	}
	

	
	@Test
	void hayPokerDeAses() {
		
		//EXERCISE//
		String resultado = pokerStatus.verificar(picas1, corazones1, corazones3, diamantes1, treboles1);
		
		//VERIFY//
		assertEquals("Poker", resultado);
		
		resultado = pokerStatus.verificar(diamantes1, picas2, picas1, corazones1, treboles1);
		
		assertEquals("Poker", resultado);
		
		resultado = pokerStatus.verificar(corazones1, diamantes1, diamantes11, picas1, treboles1);
		
		assertEquals("Poker", resultado);
		
	}
	
	
	
	@Test
	void noHayPoker() {
		
		//EXERCISE//
		String resultado = pokerStatus.verificar(picas1, corazones1, corazones3, diamantes3, treboles1);
				
		//VERIFY//
		assertNotEquals("Poker", resultado);
		
		resultado = pokerStatus.verificar(corazones12, picas10, diamantes11, picas1, treboles1);
		
		assertNotEquals("Poker", resultado);
		
		resultado = pokerStatus.verificar(picas1, diamantes1, treboles1, corazones12, corazones3);
		
		assertNotEquals("Poker", resultado);
		
	}
	
	
	@Test
	void hayColor() {
		
		//EXERCISE//
		String resultado = pokerStatus.verificar(diamantes1, diamantes11, diamantes3, diamantes4, diamantes5);
				
		//VERIFY//
		assertEquals("Color", resultado);
		
		
		//DIFERENTE ORDEN
		resultado = pokerStatus.verificar(diamantes11, diamantes3, diamantes1, diamantes5, diamantes4);
		
		assertEquals("Color", resultado);
		
	}
	
	
	@Test
	void noHayColor() {
		
		//EXERCISE//
		String resultado = pokerStatus.verificar(diamantes1, diamantes11, diamantes3, diamantes4, picas1);
						
		//VERIFY//
		assertNotEquals("Color", resultado);
		
		resultado = pokerStatus.verificar(corazones12, diamantes11, diamantes3, diamantes4, picas1);
		
		assertNotEquals("Color", resultado);
		
	}
	
	
	@Test
	void hayTrio() {
		
		//EXERCISE//
		String resultado = pokerStatus.verificar(diamantes1, diamantes11, diamantes3, corazones1, picas1);
								
		//VERIFY//
		assertEquals("Trio", resultado);
		
		resultado = pokerStatus.verificar(corazones12, corazones3, treboles1, corazones1, picas1);
		
		assertEquals("Trio", resultado);
		
	}
	
	
	@Test
	void noHayTrio() {
		
		//Hay Poker
		String resultado = pokerStatus.verificar(diamantes1, treboles1, diamantes3, corazones1, picas1);

		assertNotEquals("Trio", resultado);
		assertEquals("Poker", resultado);
		
		//Hay Color
		resultado = pokerStatus.verificar(diamantes1, diamantes11, diamantes3, diamantes4, diamantes5);

		assertNotEquals("Trio", resultado);
		assertEquals("Color", resultado);
		
	}
	
	
	@Test
	void noHayNada() {
		
		String resultado = pokerStatus.verificar(diamantes1, treboles1, diamantes3, corazones12, picas10);

		assertEquals("Nada", resultado);
		
	}

}





















