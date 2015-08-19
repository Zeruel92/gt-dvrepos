package it.unisalento.view;

import java.awt.GridLayout;

import it.unisalento.actionListener.ModificaListener;
import it.unisalento.dao.Autori;
import it.unisalento.dao.CaseEditrici;
import it.unisalento.dao.Generi;
import it.unisalento.model.Autore;
import it.unisalento.model.CasaEditrice;
import it.unisalento.model.Genere;
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
	private JTextField t0,t1,t2;
	private JLabel l0,l1,l2,l3,l4,l5;
	private Libro l;
	private Autore a;
	private Genere g;
	private CasaEditrice c;
	private JComboBox combo0,combo1,combo2;
	
	public ModificaForm(Libro l){
		this.l=l;
		if(l.getIdlibro()!=-1){
			editl();
		}
		else{
			addl();
		}
	}
	public ModificaForm(Autore a){
		if(a.getId()!=-1){
			this.a=a;
			edita();
		}
		else{
			adda();
		}
	}
	public ModificaForm(CasaEditrice c){
		if(c.getId()!=-1){
			this.c=c;
			editc();
		}
		else{
			addc();
		}
	}
	public ModificaForm(Genere g){
		if(g.getId()!=-1){
			this.g=g;
			editg();
		}
		else{
			addg();
		}
	}
	/*Campi usati per il libro:
	 * t0:titolo
	 * combo0 autore
	 * combo1 casaed
	 * combo2 genere
	 * t1: costo
	 * t2 giacenza
	 */
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
		confirm.setActionCommand(ModificaListener.ACTION_APPLY_EDITL);
		confirm.addActionListener(new ModificaListener(this));
		cancel=new JButton("Annulla");
		cancel.setActionCommand(ModificaListener.ACTION_CANCEL);
		cancel.addActionListener(new ModificaListener(this));
		p.add(confirm);
		p.add(cancel);
		pack();
	}
	private void addl(){
		this.setTitle("Aggiungi nuovo libro");
		JPanel p=new JPanel();
		p.setLayout(new GridLayout(0,2));
		this.getContentPane().add(p);
		t0=new JTextField();
		l0=new JLabel("Titolo");
		l1=new JLabel("Autore");
		p.add(l0);
		p.add(t0);
		p.add(l1);
	    combo0=new JComboBox(Autori.getIstance().getArray());
		p.add(combo0);
		l2=new JLabel("Casa Editrice");
		p.add(l2);
		combo1=new JComboBox(CaseEditrici.getIstance().getArray());
		p.add(combo1);
		l3=new JLabel("Genere");
		p.add(l3);
		combo2=new JComboBox(Generi.getIstance().getArray());
		p.add(combo2);
		l4=new JLabel("Costo");
		t1=new JTextField();
		p.add(l4);
		p.add(t1);
		l5=new JLabel("Giacenza");
		t2=new JTextField();
		p.add(l5);
		p.add(t2);
		confirm=new JButton("Applica");
		confirm.setActionCommand(ModificaListener.ACTION_APPLY_ADDL);
		confirm.addActionListener(new ModificaListener(this));
		cancel=new JButton("Annulla");
		cancel.setActionCommand(ModificaListener.ACTION_CANCEL);
		cancel.addActionListener(new ModificaListener(this));
		p.add(confirm);
		p.add(cancel);
		pack();
	}
	private void edita(){
		this.setTitle("Modifica Autore: "+a.getNome()+" "+a.getCognome());
		JPanel p=new JPanel();
		p.setLayout(new GridLayout(0,2));
		this.getContentPane().add(p);
		t0=new JTextField();
		t0.setText(a.getNome());
		JLabel l0=new JLabel("Nome");
		JLabel l1=new JLabel("Cognome");
		t1=new JTextField();
		t1.setText(a.getCognome());
		p.add(l0);
		p.add(t0);
		p.add(l1);
		p.add(t1);
		confirm=new JButton("Applica");
		confirm.setActionCommand(ModificaListener.ACTION_APPLY_EDITA);
		confirm.addActionListener(new ModificaListener(this));
		cancel=new JButton("Annulla");
		cancel.setActionCommand(ModificaListener.ACTION_CANCEL);
		cancel.addActionListener(new ModificaListener(this));
		p.add(confirm);
		p.add(cancel);
		pack();
	}
	private void adda(){
		this.setTitle("Aggiungi nuovo autore");
		JPanel p=new JPanel();
		p.setLayout(new GridLayout(0,2));
		this.getContentPane().add(p);
		t0=new JTextField();
		JLabel l0=new JLabel("Nome");
		JLabel l1=new JLabel("Cognome");
		t1=new JTextField();
		p.add(l0);
		p.add(t0);
		p.add(l1);
		p.add(t1);
		confirm=new JButton("Applica");
		confirm.setActionCommand(ModificaListener.ACTION_APPLY_ADDAU);
		confirm.addActionListener(new ModificaListener(this));
		cancel=new JButton("Annulla");
		cancel.setActionCommand(ModificaListener.ACTION_CANCEL);
		cancel.addActionListener(new ModificaListener(this));
		p.add(confirm);
		p.add(cancel);
		pack();
	}
	private void editc(){
		this.setTitle("Modifica della CasaEditrice: "+c.getNome());
		JPanel p=new JPanel();
		p.setLayout(new GridLayout(0,2));
		this.getContentPane().add(p);
		t0=new JTextField();
		t0.setText(c.getNome());
		JLabel l0=new JLabel("Nome");
		JLabel l1=new JLabel("P.IVA");
		t1=new JTextField();
		t1.setText(c.getPiva());
		p.add(l0);
		p.add(t0);
		p.add(l1);
		p.add(t1);
		confirm=new JButton("Applica");
		confirm.setActionCommand(ModificaListener.ACTION_APPLY_EDITCAS);
		confirm.addActionListener(new ModificaListener(this));
		cancel=new JButton("Annulla");
		cancel.setActionCommand(ModificaListener.ACTION_CANCEL);
		cancel.addActionListener(new ModificaListener(this));
		p.add(confirm);
		p.add(cancel);
		pack();
	}
	private void addc(){
		this.setTitle("Aggiungi nuova CasaEditrice");
		JPanel p=new JPanel();
		p.setLayout(new GridLayout(0,2));
		this.getContentPane().add(p);
		t0=new JTextField();
		JLabel l0=new JLabel("Nome");
		JLabel l1=new JLabel("P.IVA");
		t1=new JTextField();
		p.add(l0);
		p.add(t0);
		p.add(l1);
		p.add(t1);
		confirm=new JButton("Applica");
		confirm.setActionCommand(ModificaListener.ACTION_APPLY_ADDCAS);
		confirm.addActionListener(new ModificaListener(this));
		cancel=new JButton("Annulla");
		cancel.setActionCommand(ModificaListener.ACTION_CANCEL);
		cancel.addActionListener(new ModificaListener(this));
		p.add(confirm);
		p.add(cancel);
		pack();
	}
	private void editg(){
		this.setTitle("Modifica del Genere: "+g.getNome());
		JPanel p=new JPanel();
		p.setLayout(new GridLayout(0,2));
		this.getContentPane().add(p);
		t0=new JTextField();
		t0.setText(g.getNome());
		JLabel l0=new JLabel("Nome");
		p.add(l0);
		p.add(t0);
		confirm=new JButton("Applica");
		confirm.setActionCommand(ModificaListener.ACTION_APPLY_EDITGEN);
		confirm.addActionListener(new ModificaListener(this));
		cancel=new JButton("Annulla");
		cancel.setActionCommand(ModificaListener.ACTION_CANCEL);
		cancel.addActionListener(new ModificaListener(this));
		p.add(confirm);
		p.add(cancel);
		pack();
	}
	private void addg(){
		this.setTitle("Aggiungi nuovo Genere");
		JPanel p=new JPanel();
		p.setLayout(new GridLayout(0,2));
		this.getContentPane().add(p);
		t0=new JTextField();
		JLabel l0=new JLabel("Nome");
		p.add(l0);
		p.add(t0);
		confirm=new JButton("Applica");
		confirm.setActionCommand(ModificaListener.ACTION_APPLY_ADDGEN);
		confirm.addActionListener(new ModificaListener(this));
		cancel=new JButton("Annulla");
		cancel.setActionCommand(ModificaListener.ACTION_CANCEL);
		cancel.addActionListener(new ModificaListener(this));
		p.add(confirm);
		p.add(cancel);
		pack();
	}
	public Libro getLibro(){
		this.l.setTitolo(t0.getText());
		this.l.setAutore(combo0.getSelectedIndex()+1);
		this.l.setGenere(combo2.getSelectedIndex()+1);
		this.l.setCasaedi(combo1.getSelectedIndex()+1);
		this.l.setCosto(Float.parseFloat(t1.getText()));
		this.l.setGiacenza(Integer.parseInt(t2.getText()));
		return this.l;
	}
}
/* Form di Modifica, permette l'aggiunta e la modifica dei record della Libreria
 * l'attributo type indica il tipo di operazione da effettuare.
 * Se viene invocato il costrutture con attributo Libro, le operazioni verranno effettuate sulla 
 * tabella Libro, e cosi via...
 */