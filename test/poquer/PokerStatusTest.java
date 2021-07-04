package poquer;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
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
		
		picas1 = mock(Carta.class);
		picas2 = mock(Carta.class);
		corazones3 = mock(Carta.class);
		corazones1 = mock(Carta.class);
		corazones12 = mock(Carta.class);
		treboles1 = mock(Carta.class);
		diamantes1 = mock(Carta.class);
		diamantes3 = mock(Carta.class);
		
		diamantes11 = mock(Carta.class);
		picas10 = mock(Carta.class);
		
		diamantes4 = mock(Carta.class);
		diamantes5 = mock(Carta.class);
		
		//PALOS
		when(picas1.getPalo()).thenReturn("P");
		when(picas2.getPalo()).thenReturn("P");
		when(picas10.getPalo()).thenReturn("P");
		
		when(corazones1.getPalo()).thenReturn("C");
		when(corazones3.getPalo()).thenReturn("C");
		
		when(treboles1.getPalo()).thenReturn("T");
		
		when(diamantes1.getPalo()).thenReturn("D");
		when(diamantes3.getPalo()).thenReturn("D");
		when(diamantes11.getPalo()).thenReturn("D");
		when(diamantes4.getPalo()).thenReturn("D");
		when(diamantes5.getPalo()).thenReturn("D");
		
		
		//VALORES
		when(picas1.getValorNumerico()).thenReturn(1);
		when(picas2.getValorNumerico()).thenReturn(2);
		when(picas10.getValorNumerico()).thenReturn(10);
		
		when(corazones1.getValorNumerico()).thenReturn(1);
		when(corazones3.getValorNumerico()).thenReturn(3);
		when(corazones12.getValorNumerico()).thenReturn(12);
		
		when(treboles1.getValorNumerico()).thenReturn(1);
		
		when(diamantes1.getValorNumerico()).thenReturn(1);
		when(diamantes3.getValorNumerico()).thenReturn(3);
		when(diamantes11.getValorNumerico()).thenReturn(11);
		when(diamantes4.getValorNumerico()).thenReturn(4);
		when(diamantes5.getValorNumerico()).thenReturn(5);
		
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





















