package it.unisalento.view;

import it.unisalento.actionListener.MLListener;
import it.unisalento.model.Libro;

import java.awt.*;

import javax.swing.*;

public class ModificaLibro extends JFrame
{
	private JFrame f;
	private JPanel p;
	private JLabel l1,l2,l3,l4,l5,l6,l7; 
	private JTextField t1, t2, t3,t4,t5,t6,t7;
	private JButton ok;
	String temp;
	int temp1;
	float temp2;
	
	private void modifica(Libro l)
	{
		temp=t1.getText();
		temp1=Integer.parseInt(temp);
		l.setIdlibro(temp1);
		
		temp=t2.getText();
		l.setTitolo(temp);
		
		temp=t3.getText();
		l.setAutore(temp);
		
		temp=t4.getText();
		l.setCasaedi(temp);
		
		temp=t5.getText();
		temp2=Float.parseFloat(temp);
		l.setCosto(temp2);
		
		temp=t6.getText();
		temp1=Integer.parseInt(temp);
		l.setGiacenza(temp1);
		
		temp=t7.getText();
		l.setGenere(temp);
		
	}
	
	
	public ModificaLibro(Libro l)
	{
		f=new JFrame();
		f.setTitle("Modifica Libro");
		f.setVisible(true);
		f.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		Container c=this.getContentPane();
		c.setLayout(new BorderLayout());
		p.setLayout(new GridLayout(7,2));
		l1=new JLabel("ID Libro");
		l1=new JLabel("Titolo");
		l3=new JLabel("Autore");
		l4=new JLabel("Casa Editrice");
		l5=new JLabel("Costo");
		l6=new JLabel("Giacenza");
		l7=new JLabel("Genere");
		t1.setText(Integer.toString(l.getIdlibro()));
		t2.setText(l.getTitolo());
		t3.setText(l.getAutore());
		t4.setText(l.getCasaedi());
		t5.setText(Float.toString(l.getCosto()));
		t6.setText(Integer.toString(l.getGiacenza()));
		t7.setText(l.getGenere());
		
		
		p.add(l1);
		p.add(t1);
		p.add(l2);
		p.add(t2);
		p.add(l3);
		p.add(t3);
		p.add(l4);
		p.add(t4);
		p.add(l5);
		p.add(t5);
		p.add(l6);
		p.add(t6);
		p.add(l7);
		p.add(t7);

		c.add(p, BorderLayout.CENTER);
		
		ok= new JButton("OK");
		ok.addActionListener(new MLListener(this));
		ok.setActionCommand("Ok");
		
		c.add(ok, BorderLayout.SOUTH);
		
		pack();
		
	}
	
}