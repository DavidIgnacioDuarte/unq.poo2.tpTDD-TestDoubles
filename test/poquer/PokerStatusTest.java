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
		
	}
	

	
	@Test
	void hayPokerDeAses() {
		
		//EXERCISE//
		boolean resultado = pokerStatus.verificar(picas1, corazones1, corazones3, diamantes1, treboles1);
		
		//VERIFY//
		assertTrue(resultado);
		
		resultado = pokerStatus.verificar(diamantes1, picas2, picas1, corazones1, treboles1);
		
		assertTrue(resultado);
		
		resultado = pokerStatus.verificar(corazones1, diamantes1, diamantes11, picas1, treboles1);
		
		assertTrue(resultado);
		
	}
	
	
	
	@Test
	void noHayPoker() {
		
		//EXERCISE//
		boolean resultado = pokerStatus.verificar(picas1, corazones1, corazones3, diamantes3, treboles1);
				
		//VERIFY//
		assertFalse(resultado);
		
		resultado = pokerStatus.verificar(corazones12, picas10, diamantes11, picas1, treboles1);
		
		assertFalse(resultado);
		
		resultado = pokerStatus.verificar(picas1, diamantes1, treboles1, corazones12, corazones3);
		
		assertFalse(resultado);
		
	}

}





















