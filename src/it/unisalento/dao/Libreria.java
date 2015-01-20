package it.unisalento.dao;
import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

import it.unisalento.model.Libro;

public class Libreria {
	ArrayList<Libro> libreria= new ArrayList<Libro>();
	public void AggiungiLibro(Libro l)
	{
		libreria.add(libreria.indexOf(libreria.lastIndexOf(libreria)), l);
	}
	public void RimuoviLibro(Libro l){
		libreria.remove(l);
	}
	public void ModificaLibro(Libro l)
	{
		
	}
	
	
	
	public Libreria(ArrayList<Libro> libreria){
		this.libreria=libreria;
	}
	

}
