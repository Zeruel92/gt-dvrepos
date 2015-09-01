package it.unisalento.view;

import it.unisalento.actionListener.AddettiListener;
import it.unisalento.dao.Utenti;
import it.unisalento.model.UListModel;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.Border;

public class GestioneAddetti extends JPanel {
	
	private JPanel p0,p1;
	private JButton b0,b1,b2;
	private JLabel l0,l1;
	private Vector<JRadioButton> rb;
	private ButtonGroup group;
	private Utenti users;
	
	public GestioneAddetti(){
		this.setLayout(new BorderLayout());
		p0=new JPanel();
		p0.setLayout(new GridLayout(0,3));
		this.add(p0);
		l0=new JLabel("Email");
		l1=new JLabel("Livello Utente");
		p0.add(new JLabel());
		p0.add(l0);
		p0.add(l1);
		users=Utenti.getIstance();
		group=new ButtonGroup();
		for(int i=0;i<users.getDim();i++){
			UListModel u=users.getUtente(i);
			JRadioButton r=new JRadioButton(Integer.toString(u.getId()));
			r.setActionCommand(Integer.toString(u.getId()));
			group.add(r);
			p0.add(r);
			p0.add(new JLabel(u.getEmail()));
			p0.add(new JLabel(Integer.toString(u.getTipo())));
		}
		b0=new JButton("Aggiungi");
		b1=new JButton("Cancella");
		b2=new JButton("Modifica");
		b0.addActionListener(new AddettiListener(this));
		b1.addActionListener(new AddettiListener(this));
		b2.addActionListener(new AddettiListener(this));
		b0.setActionCommand(AddettiListener.ACTION_ADD);
		b1.setActionCommand(AddettiListener.ACTION_DEL);
		b2.setActionCommand(AddettiListener.ACTION_EDIT);
		p1=new JPanel();
		p1.setLayout(new GridLayout(0,3));
		p1.add(b0);
		p1.add(b2);
		p1.add(b1);
		this.add(p0,BorderLayout.NORTH);
		this.add(p1,BorderLayout.SOUTH);
	}

	public ButtonGroup getGroup() {
		return group;
	}
}
 