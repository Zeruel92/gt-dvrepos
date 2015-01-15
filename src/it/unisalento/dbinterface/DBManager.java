package it.unisalento.dbinterface;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;

public class DBManager {
	private String password;
	private String username;
	private String server;
	private String database;
	private static Connection connect;
	private static DBManager istance;
	
	public static DBManager getIstance(){
		if(istance==null){
			istance=new DBManager();
		}
		return istance;
	}
	public DBManager(){	
		password="passwordlibreria";
		username="libreria";
		database="Libreria";
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String url="jdbc:mysql://"+server+"/"+database+"?user="+username+"&password="+password;
	        connect= (Connection)DriverManager.getConnection(url);
			System.out.println("Connessione al DB aperta");
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,"Server non disponibile riprovare piu' dopo");
			e.printStackTrace();
		}
		
	}
	
	public static Connection getConnect(){
		return connect;
	}
	
	public  ResultSet eseguiQuery(String query){
		ResultSet rs;
		try {
			if(connect.isClosed())
				System.out.println("Connessione interrotta");
		java.sql.Statement smt= connect.createStatement();
			 rs= smt.executeQuery(query);
			 //smt.close();
		} catch (SQLException e) {
			rs=null;
			e.printStackTrace();
			return null;
		}
		return rs;
	}
	public int inserisciNuovo(String sql){
		int ris=-1;
		try{
			ris=connect.createStatement().executeUpdate(sql);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return ris;
	}
	public static void closeConnection(){
		try {
			connect.close();
			System.out.println("Connessione al DB Chiusa");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

