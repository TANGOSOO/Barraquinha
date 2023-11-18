package controller;

public class CachorroQuente {

	private int proteina;
	private int queijo;
	private int suco;
	private String adicionais;
	private double valor;
	
	public CachorroQuente(int proteina, int queijo, int suco, String adicionais, double valor) {
		super();
		this.proteina = proteina;
		this.queijo = queijo;
		this.suco = suco;
		this.adicionais = adicionais;
		this.valor = valor;
	}

	public String cachorroQuenteIngredientes() {
		return this.proteina + " " + this.queijo + " " + this.adicionais + " " + this.suco;
	}

	public int getProteina() {
		return proteina;
	}

	public void setProteina(int proteina) {
		this.proteina = proteina;
	}

	public int getQueijo() {
		return queijo;
	}

	public void setQueijo(int queijo) {
		this.queijo = queijo;
	}

	public int getSuco() {
		return suco;
	}

	public void setSuco(int suco) {
		this.suco = suco;
	}

	public String getAdicionais() {
		return adicionais;
	}

	public void setAdicionais(String adicionais) {
		this.adicionais = adicionais;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
}
