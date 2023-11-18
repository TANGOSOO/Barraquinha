package controller;

public class Comprador {

	private int id;
	private String nome;
	private int matricula;
	public CachorroQuente cachorroquente;
	
	public Comprador(int id, String nome, int matricula, CachorroQuente cachorroquente) {
		super();
		this.id=id;
		this.nome = nome;
		this.matricula = matricula;
		this.cachorroquente = cachorroquente;
	}
	
	public Comprador(String nome, int matricula, CachorroQuente cachorroquente) {
		super();
		this.nome = nome;
		this.matricula = matricula;
		this.cachorroquente = cachorroquente;
	}
	
	public Comprador(int id, String nome, int matricula) {
		super();
		this.id = id;
		this.nome = nome;
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	public String getCachorroquente() {
		return cachorroquente.cachorroQuenteIngredientes();
	}
	public void setCachorroquente(CachorroQuente cachorroquente) {
		this.cachorroquente = cachorroquente;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
