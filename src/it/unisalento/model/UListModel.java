package it.unisalento.model;

public class UListModel {
	
	private String email;
	private int id,tipo;
	
	public UListModel(int id,String email,int tipo){
		this.email=email;
		this.id=id;
		this.tipo=tipo;
	}
	public UListModel(){
		this.id=-1;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
}
