package controller;

public enum TipoEnumProteina {

	SALSICHA("Salsicha"),
	LINGUICA("Linguiça"),
	FRANGO("Frango"),
	BACON("Bacon");
	
	String nome;
	int i;
	
	TipoEnumProteina(String nome){
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
