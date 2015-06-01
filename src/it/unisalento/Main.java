package it.unisalento;

import java.util.Currency;

import it.unisalento.view.Login;

public class Main {
	public static String EURO;
	public static void main(String[] args) {
		Currency valuta=Currency.getInstance("EUR");
		EURO=valuta.getSymbol();
		Login l=new Login();

	}
}
