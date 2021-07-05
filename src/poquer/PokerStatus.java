package poquer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PokerStatus {

	
	private static PokerStatus instance;
	private List<String> valores = Arrays.asList("1","2","3","4","5","6","7","8","9","10","J","Q","K");
	private List<String> valoresJuegos = Arrays.asList("Nada", "Trio", "Color", "Poker");
	
	
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
	
	
	public boolean leGanaA(List<Carta> mano1, List<Carta> mano2) {
		
		String juegoMano1 = this.verificar(mano1.get(0),mano1.get(1),mano1.get(2),mano1.get(3),mano1.get(4));
		String juegoMano2 = this.verificar(mano2.get(0),mano2.get(1),mano2.get(2),mano2.get(3),mano2.get(4));
		
		Integer valorJuegoMano1 = valoresJuegos.indexOf(juegoMano1);
		Integer valorJuegoMano2 = valoresJuegos.indexOf(juegoMano2);
		
		if (valorJuegoMano1 == valorJuegoMano2) {
			return this.sumaJuego(mano1) > this.sumaJuego(mano2); 
		}
		
		return valorJuegoMano1 > valorJuegoMano2;
		
	}
	
	
	public Integer sumaJuego(List<Carta> mano) {
		
		Integer suma= mano.stream()
	  			.map(carta -> carta.getValorNumerico())
	  			.reduce(0, Integer::sum);
		return suma;
		
	}
	
	
	public String verificar(Carta carta1, Carta carta2, Carta carta3, Carta carta4, Carta carta5) {
		
		List<Integer> numerosCartas = Arrays.asList(carta1.getValorNumerico(),carta2.getValorNumerico(),carta3.getValorNumerico(), carta4.getValorNumerico(),carta5.getValorNumerico());

		List<String> palosCartas = Arrays.asList(carta1.getPalo(),carta2.getPalo(),carta3.getPalo(), carta4.getPalo(),carta5.getPalo());
				
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
	
	
	private boolean hayPoker(List<Integer> numerosCartas) {
		
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
	
	
	private boolean hayColor(List<String> palosCartas) {
		
		for (String palo:palosCartas) {
			
			int ocurrencias = Collections.frequency(palosCartas, palo);

			if (ocurrencias == 5) {
				return true;
			}
		}
		
		return false ;
		
	}
	
	
	private boolean hayTrio(List<Integer> numerosCartas) {
		
		for(int numero:numerosCartas) {
			
			//Las ocurrencias que el numero actual tiene en las cartas
			int ocurrencias = Collections.frequency(numerosCartas, numero);
			
			//Si dichas ocurrencias son 3, entonces hay Trio y se devuelve true
			if(ocurrencias == 3) {
				return true;
			}
		}
		
		return false;
		
	}
	
	
}
