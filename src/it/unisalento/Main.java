package it.unisalento;

import java.net.InetAddress;

import it.unisalento.view.Login;

public class Main {
	public static String EURO;
	public static void main(String[] args) {
		String os=System.getProperty("os.name");
		os=os.toLowerCase();
		if(os.contains("windows")){
			EURO="�";
		}
		else if (os.contains("osx")){
			
		}
		else{
			EURO="€";
		}
		Login l=new Login();

	}
}
