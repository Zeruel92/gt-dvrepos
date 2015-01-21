package it.unisalento.dao;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

import it.unisalento.model.Libro;
import it.unisalento.view.ModificaLibro;

public class Libreria {
	ArrayList<Libro> libreria= new ArrayList<Libro>();
	ModificaLibro modifica;
	
	
	public void aggiungiLibro(Libro l)
	{
		libreria.add(libreria.indexOf(libreria.lastIndexOf(libreria)), l);
	}
	public void rimuoviLibro(Libro l){
		libreria.remove(l);
	}
	public void modificaLibro(Libro l)
	{
		modifica= new ModificaLibro(l);
	}
	
	
	
	public Libreria(ArrayList<Libro> libreria){
		this.libreria=libreria;
	}

}
