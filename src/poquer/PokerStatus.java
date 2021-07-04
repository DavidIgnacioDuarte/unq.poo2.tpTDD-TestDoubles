package poquer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PokerStatus {

	
	private static PokerStatus instance;
	private List<String> valores = Arrays.asList("1","2","3","4","5","6","7","8","9","10","J","Q","K");
	
	
	//SINGLETON POR LOS VALORES DE LOS PALOS
	public static PokerStatus getPokerStatus() {
		if(instance == null) {
			instance = new PokerStatus();
		}
		return instance;
	}
	
	public List<String> getValores() {
		return this.valores;
	}
	
	public String verificar(Carta carta1, Carta carta2, Carta carta3, Carta carta4, Carta carta5) {
		
		ArrayList<Carta> cartas = new ArrayList<Carta>();
		cartas.add(carta1);
		cartas.add(carta2);
		cartas.add(carta3);
		cartas.add(carta4);
		cartas.add(carta5);
		
		ArrayList<Integer> numerosCartas = new ArrayList<Integer>();
		ArrayList<String> palosCartas = new ArrayList<String>();
		
		for(Carta carta:cartas) {
			numerosCartas.add(carta.valorNumerico());
			palosCartas.add(carta.getPalo());
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
	
	
	private boolean hayPoker(ArrayList<Integer> numerosCartas) {
		
		for(int numero:numerosCartas) {
			
			//Las ocurrencias que el numero actual tiene en las cartas
			int ocurrencias = Collections.frequency(numerosCartas, numero);
			
			//Si dichas ocurrencias son 4, entonces hay Poker y se devuelve true
			if(ocurrencias == 4) {
				return true;
			}
		}
		
		return false;
		
	}
	
	
	private boolean hayColor(ArrayList<String> palosCartas) {
		
		for (String palo:palosCartas) {
			
			int ocurrencias = Collections.frequency(palosCartas, palo);

			if (ocurrencias == 5) {
				return true;
			}
		}
		
		return false ;
		
	}
	
	
	private boolean hayTrio(ArrayList<Integer> numerosCartas) {
		
		for(int numero:numerosCartas) {
			
			//Las ocurrencias que el numero actual tiene en las cartas
			int ocurrencias = Collections.frequency(numerosCartas, numero);
			
			//Si dichas ocurrencias son 4, entonces hay Poker y se devuelve true
			if(ocurrencias == 3) {
				return true;
			}
		}
		
		return false;
		
	}
	
	
}
