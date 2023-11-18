package controller;

public enum TipoEnumQueijo {

	MUSSARELA("Mussarela"),
	PRATO("Prato"),
	PARMESAO("Parmesão"),
	COALHO("Coalho");
	
	String nome;
	int i;
	
	TipoEnumQueijo(String nome){
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
