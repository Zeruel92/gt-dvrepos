package it.unisalento.view;

import java.awt.GridLayout;

import it.unisalento.dao.Autori;
import it.unisalento.dao.CaseEditrici;
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
		JComboBox combo=new JComboBox(Autori.getIstance().getArray());
		combo.setSelectedIndex(l.getAutore()-1);
		p.add(combo);
		l2=new JLabel("Casa Editrice");
		p.add(l2);
		JComboBox combo2=new JComboBox(CaseEditrici.getIstance().getArray());
		combo2.setSelectedIndex(l.getCasaedi()-1);
		p.add(combo2);
		confirm=new JButton("Applica");
		cancel=new JButton("Annulla");
		p.add(confirm);
		p.add(cancel);
		pack();
	}
	private void addl(){
		
	}
}

/* Form di Modifica, permette l'aggiunta e la modifica dei record della Libreria
 * l'attributo type indica il tipo di operazione da effettuare.
 * Se viene invocato il costrutture con attributo Libro, le operazioni verranno effettuate sulla 
 * tabella Libro, e cosi via...
 */