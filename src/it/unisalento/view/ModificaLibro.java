package it.unisalento.view;

import it.unisalento.model.Libro;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ModificaLibro extends JFrame
{
	private JFrame f;
	private JPanel p;
	private JLabel l1,l2,l3,l4,l5,l6,l7; 
	private JTextField t1, t2, t3,t4,t5,t6,t7;
	private ModificaLibro(Libro l)
	{
		f=new JFrame();
		f.setTitle("Modifica Libro");
		f.setVisible(true);
		f.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		Container c=this.getContentPane();
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

		c.add(p);
		
	}
	
}