package poquer;

public class Carta {

	
	private String palo;
	private String valor;
	
	
	public Carta(String palo, String valor) {
		this.valor = valor;
		this.palo = palo;
	}
	
	public String getValor() {
		return this.valor;
	}
	
	public String getPalo() {
		return this.palo;
	}
	
	public boolean tieneMismoPalo(Carta carta) {
		return this.palo == carta.getPalo();
	}

	public boolean tieneValorSuperior(Carta carta) {
		return this.getValorNumerico() > carta.getValorNumerico();
	}
	
	public Integer getValorNumerico() {
		return PokerStatus.getPokerStatus().getValores().indexOf(this.getValor()) + 1;
	}
	
}
