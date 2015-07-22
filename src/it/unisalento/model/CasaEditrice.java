package it.unisalento.model;

public class CasaEditrice {
	private int id;
	private String nome;
	private String piva;
	
	public CasaEditrice(int id, String nome,String piva) {
		this.id = id;
		this.nome = nome;
		this.piva=piva;
	}

	public CasaEditrice(){
		this.id=-1;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPiva() {
		return piva;
	}

	public void setPiva(String piva) {
		this.piva = piva;
	}
}
