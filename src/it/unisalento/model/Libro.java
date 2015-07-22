package it.unisalento.model;

public class Libro {
	private int idlibro;
	private String titolo;
	private int idAutore;
	private int casaedi;
	private float costo;
	private int giacenza;
	private int genere;
	
	public int getIdlibro(){
		return idlibro;
	}
	public void setIdlibro(int idlibro)
	{
		this.idlibro=idlibro;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public int getAutore() {
		return idAutore;
	}
	public void setAutore(int autore) {
		this.idAutore = autore;
	}
	public int getCasaedi() {
		return casaedi;
	}
	public void setCasaedi(int casaedi) {
		this.casaedi = casaedi;
	}
	public int getGenere() {
		return genere;
	}
	public void setGenere(int genere) {
		this.genere = genere;
	}
	public float getCosto() {
		return costo;
	}
	public void setCosto(float costo) {
		this.costo = costo;
	}
	public int getGiacenza() {
		return giacenza;
	}
	public void setGiacenza(int giacenza) {
		this.giacenza = giacenza;
	}

	public Libro(int idlibro, String titolo, int idAutore, int casaedi, float costo, int giacenza,int genere ){
		this.idlibro=idlibro;
		this.titolo=titolo;
		this.idAutore=idAutore;
		this.casaedi=casaedi;
		this.costo=costo;
		this.giacenza=giacenza;
		this.genere=genere;

	}
	public Libro(){

	}
}
