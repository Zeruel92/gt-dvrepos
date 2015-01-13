package it.unisalento.model;

public class Utente {
	private int idutente;
	private String nome;
	private String cognome;
	private String codfiscale;
	private String email;
	private String password;
	private int tipo;
	private String citta;
	private String provincia;
	private int telefono;
	private String indirizzo;
	public int getIdutente() {
		return idutente;
	}
	public void setIdutente(int idutente) {
		this.idutente = idutente;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getCodfiscale() {
		return codfiscale;
	}
	public void setCodfiscale(String codfiscale) {
		this.codfiscale = codfiscale;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public String getCitta() {
		return citta;
	}
	public void setCitta(String citta) {
		this.citta = citta;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	
	public Utente(int idutente, String nome, String cognome, String codfiscale, String email, String password, int tipo, String citta, String provincia, int telefono, String indirizzo) {
		
		this.idutente=idutente;
		this.nome=nome;
		this.cognome=cognome;
		this.codfiscale=codfiscale;
		this.email=email;
		this.password=password;
		this.tipo=tipo;
		this.citta=citta;
		this.provincia=provincia;
		this.telefono=telefono;
		this.indirizzo=indirizzo;
		
		
	}
	
}
