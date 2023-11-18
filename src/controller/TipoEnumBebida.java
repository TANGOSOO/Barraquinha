package controller;

public enum TipoEnumBebida {

	COCACOLA("Coca-Cola"),
	DELRIO("Del Rio"),
	SUCODOCHAVES("Suco do Chaves");
	
	String nome;
	int i;
	
	TipoEnumBebida(String nome){
		this.nome=nome;
		this.i=this.ordinal()+1;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}
}
