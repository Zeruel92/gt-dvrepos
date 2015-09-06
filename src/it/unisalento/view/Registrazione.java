package it.unisalento.view;
import it.unisalento.actionListener.RegListener;
import it.unisalento.businesslogic.Digest;

import java.awt.*;

import javax.swing.*;


public class Registrazione extends JFrame 
{
	
	private JPanel p;
	private JLabel email,pass,pass2, nome, cognome, codfiscale, citta, provincia, tel, indirizzo;
	private JTextField temail, tnome, tcognome, tcod, tcitta, tprovincia, ttel, tindirizzo;
	private JPasswordField tpass,tpass2;
	private JButton ok, canc;
	private Font f;
	
	public Registrazione()
	{
		super("Registrazione");
		setVisible(true);
		setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		
		//Creazione dei pannelli
		JPanel k=new JPanel();
		p=new JPanel();
		this.add(k);
		this.p.setLayout(new GridLayout(11,2));
		JPanel b=new JPanel();
		k.setLayout(new BorderLayout());
		
			
		//Creazione dei componenti
		
		Font f=new Font("TimesRoman", Font.PLAIN, 14);
		JLabel intro=new JLabel("Inserire correttamente i dati richiesti.");
		intro.setFont(f);
		
		JLabel vuoto1=new JLabel("");
		JLabel vuoto2=new JLabel("");
		p.add(vuoto1);
		p.add(vuoto2);
		email=new JLabel("E-mail valida: ");
		p.add(email);
		temail=new JTextField(20);
		p.add(temail);
		temail.setHorizontalAlignment(JTextField.RIGHT);
		pass=new JLabel("Password: ");
		p.add(pass);
		tpass=new JPasswordField(20);
		tpass.setHorizontalAlignment(JTextField.RIGHT);
		p.add(tpass);
		pass2=new JLabel("Reinserire la password: ");
		p.add(pass2);
		tpass2=new JPasswordField(20);
		tpass2.setHorizontalAlignment(JTextField.RIGHT);
		p.add(tpass2);
		nome=new JLabel("Nome: ");
		p.add(nome);
		tnome=new JTextField(20);
		tnome.setHorizontalAlignment(JTextField.RIGHT);
		p.add(tnome);
		cognome=new JLabel("Cognome:" );
		p.add(cognome);
		tcognome=new JTextField(20);
		tcognome.setHorizontalAlignment(JTextField.RIGHT);
		p.add(tcognome);
		codfiscale=new JLabel("Codice Fiscale:" );
		p.add(codfiscale);
		tcod=new JTextField(20);
		tcod.setHorizontalAlignment(JTextField.RIGHT);
		p.add(tcod);
		citta=new JLabel("Citta\' di residenza: ");
		p.add(citta);
		tcitta=new JTextField(20);
		tcitta.setHorizontalAlignment(JTextField.RIGHT);
		p.add(tcitta);
		provincia=new JLabel("Provincia di: ");
		p.add(provincia);
		tprovincia=new JTextField(20);
		tprovincia.setHorizontalAlignment(JTextField.RIGHT);
		p.add(tprovincia);
		indirizzo=new JLabel("Indirizzo di abitazione: ");
		p.add(indirizzo);
		tindirizzo=new JTextField(20);
		tindirizzo.setHorizontalAlignment(JTextField.RIGHT);
		p.add(tindirizzo);
		tel=new JLabel("Numero telefonico: ");
		p.add(tel);
		ttel=new JTextField(20);
		ttel.setHorizontalAlignment(JTextField.RIGHT);
		p.add(ttel);
		
		//Creo bottoni
		ok=new JButton("Conferma");
		ok.setActionCommand("Ok");
		ok.addActionListener(new RegListener(this));
		canc=new JButton("Cancella");
		canc.setActionCommand("Canc");
		canc.addActionListener(new RegListener(this));
		b.add(ok);
		b.add(canc);
		
		//Aggiungo i pannelli a k
		k.add(intro, BorderLayout.NORTH);
		
		k.add(p, BorderLayout.CENTER);
		k.add(b, BorderLayout.SOUTH);
		
		this.setResizable(false); 
		this.pack();
	}
	public String getNome(){
		return tnome.getText();
	}
	public String getCognome(){
		return tcognome.getText();
	}
	public String getPassword1(){
		String password= new String (tpass.getPassword());
		Digest d= new Digest(password);
		return d.getResult();
	}
	public String getPassword2(){
		String password= new String (tpass2.getPassword());
		Digest d= new Digest(password);
		return d.getResult();
	}
	public String getEmail(){
		return temail.getText();
	}
	public String getCod(){
		return tcod.getText();
	}
	public String getCitta(){
		return tcitta.getText();
	}
	public String getProvincia(){
		return tprovincia.getText();
	}
	public String getTel(){
		return ttel.getText();
	}
	public String getIndirizzo(){
		return tindirizzo.getText();
	}
}
