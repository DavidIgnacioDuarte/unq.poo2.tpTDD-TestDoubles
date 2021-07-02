package poquer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class PokerStatus {

	
	public String verificar(String carta1, String carta2, String carta3, String carta4, String carta5) {
		
		ArrayList<String> cartas = new ArrayList<String>();
		cartas.add(carta1);
		cartas.add(carta2);
		cartas.add(carta3);
		cartas.add(carta4);
		cartas.add(carta5);
		
		ArrayList<Integer> numerosCartas = new ArrayList<Integer>();
		ArrayList<String> palosCartas = new ArrayList<String>();
		
		for(String carta:cartas) {
			numerosCartas.add(this.numero(carta));
			palosCartas.add(this.palo(carta));
		}
				
		if (this.hayPoker(numerosCartas)) {
			return "Poker";
		}
		else if (this.hayColor(palosCartas)) {
			return "Color";
		}
		else if (this.hayTrio(numerosCartas)) {
			return "Trio";
		}
		else {
			return "Nada";
		}
		
	}
	
	
	private String palo(String carta) {
		
		return carta.substring(carta.length()-1);
		
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
	
	
	private boolean hayPoker(ArrayList<Integer> numerosCartas) {
		
		for(int numero:numerosCartas) {
			
			//Las ocurrencias que el numero actual tiene en las cartas
			Integer ocurrencias = Collections.frequency(numerosCartas, numero);
			
			//Si dichas ocurrencias son 4, entonces hay Poker y se devuelve true
			if(ocurrencias == 4) {
				return true;
			}
		}
		
		return false;
		
	}
	
	
	private boolean hayColor(ArrayList<String> palosCartas) {
		
		for (String palo:palosCartas) {
			
			Integer vecesEnLaLista = Collections.frequency(palosCartas, palo);

			if (vecesEnLaLista == 5) {
				return true;
			}
		}
		
		return false ;
		
	}
	
	
	private boolean hayTrio(ArrayList<Integer> numerosCartas) {
		
		for(int numero:numerosCartas) {
			
			//Las ocurrencias que el numero actual tiene en las cartas
			Integer ocurrencias = Collections.frequency(numerosCartas, numero);
			
			//Si dichas ocurrencias son 4, entonces hay Poker y se devuelve true
			if(ocurrencias == 3) {
				return true;
			}
		}
		
		return false;
		
	}
	
	
}
