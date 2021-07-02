package poquer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class PokerStatus {

	
	public boolean verificar(String carta1, String carta2, String carta3, String carta4, String carta5) {
		
		ArrayList<String> cartas = new ArrayList<String>();
		cartas.add(carta1);
		cartas.add(carta2);
		cartas.add(carta3);
		cartas.add(carta4);
		cartas.add(carta5);
		
		ArrayList<Integer> numerosCartas = new ArrayList<Integer>();
		for(String carta:cartas) {
			numerosCartas.add(this.numero(carta));
		}
				
		for(int numero:numerosCartas) {
			
			//Las ocurrencias que el numero actual tiene en las cartas
			Integer ocurrencias = Collections.frequency(numerosCartas, numero);
			
			//Si dichas ocurrencias son 4, entonces hay Poker y se devuelve true
			if(ocurrencias == 4) {
				return true;
			}
		}
		
		//Una vez recorrida la lista y nunca cumplida la condición del if, significa que no hay poker.
		return false;
		
	}
	
	
	private int numero(String carta) {
		
		String valorTexto;
		int numero;
		
		if (carta.length() == 3) {
			valorTexto = carta.substring(0,2);
			numero = Integer.parseInt(valorTexto);
		} 
		else {
			valorTexto = carta.substring(0,1);
			numero = Integer.parseInt(valorTexto);
		}
		
		return numero;
		
	}
	
	
}
