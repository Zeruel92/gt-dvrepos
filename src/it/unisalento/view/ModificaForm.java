package it.unisalento.view;

import java.awt.GridLayout;

import it.unisalento.dao.Autori;
import it.unisalento.dao.CaseEditrici;
import it.unisalento.dao.Generi;
import it.unisalento.model.Libro;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ModificaForm extends JFrame{
	
	private JButton confirm;
	private JButton cancel;
	private JTextField t0,t1,t2,t3,t4,t5;
	private JLabel l0,l1,l2,l3,l4,l5;
	private Libro l;
	private JComboBox combo0,combo1,combo2;
	
	public ModificaForm(Libro l,int type){
		if(type==0){
			this.l=l;
			editl();
		}
		else{
			addl();
		}
	}
	private void editl(){
		this.setTitle("Modifica:"+this.l.getTitolo());
		JPanel p=new JPanel();
		p.setLayout(new GridLayout(0,2));
		this.getContentPane().add(p);
		t0=new JTextField();
		t0.setText(l.getTitolo());
		l0=new JLabel("Titolo");
		l1=new JLabel("Autore");
		p.add(l0);
		p.add(t0);
		p.add(l1);
	    combo0=new JComboBox(Autori.getIstance().getArray());
		combo0.setSelectedIndex(l.getAutore()-1);
		p.add(combo0);
		l2=new JLabel("Casa Editrice");
		p.add(l2);
		combo1=new JComboBox(CaseEditrici.getIstance().getArray());
		combo1.setSelectedIndex(l.getCasaedi()-1);
		p.add(combo1);
		l3=new JLabel("Genere");
		p.add(l3);
		combo2=new JComboBox(Generi.getIstance().getArray());
		combo2.setSelectedIndex(l.getGenere()-1);
		p.add(combo2);
		l4=new JLabel("Costo");
		t1=new JTextField();
		t1.setText(Float.toString(l.getCosto()));
		p.add(l4);
		p.add(t1);
		l5=new JLabel("Giacenza");
		t2=new JTextField();
		t2.setText(Integer.toString(l.getGiacenza()));
		p.add(l5);
		p.add(t2);
		confirm=new JButton("Applica");
		cancel=new JButton("Annulla");
		p.add(confirm);
		p.add(cancel);
		pack();
		//TODO Aggiungere i Listener
	}
	private void addl(){
		//TODO Form aggiunta libro
	}
}

/* Form di Modifica, permette l'aggiunta e la modifica dei record della Libreria
 * l'attributo type indica il tipo di operazione da effettuare.
 * Se viene invocato il costrutture con attributo Libro, le operazioni verranno effettuate sulla 
 * tabella Libro, e cosi via...
 */