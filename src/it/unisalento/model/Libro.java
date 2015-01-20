package it.unisalento.model;

public class Libro {
	private int idlibro;
	private String titolo;
	private String autore;
	private String casaedi;
	private float costo;
	private int giacenza;
	private String genere;
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
	public String getAutore() {
		return autore;
	}
	public void setAutore(String autore) {
		this.autore = autore;
	}
	public String getCasaedi() {
		return casaedi;
	}
	public void setCasaedi(String casaedi) {
		this.casaedi = casaedi;
	}
	public String getGenere() {
		return genere;
	}
	public void setGenere(String genere) {
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
	
	public Libro(int idlibro, String titolo, String autore, String casaedi, float costo, int giacenza, String genere ){
		this.idlibro=idlibro;
		this.titolo=titolo;
		this.autore=autore;
		this.casaedi=casaedi;
		this.costo=costo;
		this.giacenza=giacenza;
		this.genere=genere;
		
	}
}
