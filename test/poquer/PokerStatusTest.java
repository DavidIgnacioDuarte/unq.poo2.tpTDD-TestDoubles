package poquer;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PokerStatusTest {

	
	PokerStatus pokerStatus;
	String picas1;
	String picas2;
	String corazones3;
	String corazones1;
	String treboles1;
	String diamantes1;
	String diamantes3;
	
	String diamantes11;
	String corazones12;
	String picas10;
	
	String diamantes4;
	String diamantes5;
	
	
	//SETUP Y TEARDOWN A LA VEZ(AL SER BEFOREACH)//
	@BeforeEach
	void setUp() {
		
		pokerStatus = new PokerStatus();
		
		picas1 = "1P";
		picas2 = "2P";
		corazones3 = "3C";
		corazones1 = "1C";
		treboles1 = "1T";
		diamantes1 = "1D";
		diamantes3 = "3D";
		
		diamantes11 = "11D";
		corazones12 = "12C";
		picas10 = "10P";
		
		diamantes4 = "4D";
		diamantes5 = "5D";
		
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





















