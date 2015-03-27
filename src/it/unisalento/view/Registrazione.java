package it.unisalento.view;
import java.awt.*;
import javax.swing.*;


public class Registrazione extends JFrame 
{
	
	public JPanel p;
	public JLabel email,pass,pass2, nome, cognome, codfiscale, citta, provincia, tel, indirizzo;
	public JTextField temail,tpass,tpass2, tnome, tcognome, tcod, tcitta, tprovincia, ttel, tindirizzo;
	private JButton ok, canc;
	
	public Registrazione()
	{
		super("Registrazione");
		setVisible(true);
		setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		
		//Creazione dei pannelli
		JPanel k=new JPanel();
		p=new JPanel();
		this.add(k);
		this.p.setLayout(new GridLayout(10,2));
		JPanel b=new JPanel();
		k.setLayout(new BorderLayout());
		
			
		//Creazione dei componenti
		
		JLabel intro=new JLabel("Inserire correttamente i dati richiesti");
	
		email=new JLabel("E-mail valida: ");
		p.add(email);
		temail=new JTextField(20);
		p.add(temail);
		temail.setHorizontalAlignment(JTextField.RIGHT);
		pass=new JLabel("Password: ");
		p.add(pass);
		tpass=new JTextField(20);
		tpass.setHorizontalAlignment(JTextField.RIGHT);
		p.add(tpass);
		pass2=new JLabel("Reinserire la password: ");
		p.add(pass2);
		tpass2=new JTextField(20);
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
		citta=new JLabel("Cittˆ di residenza: ");
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
		canc=new JButton("Cancella");
		b.add(ok);
		b.add(canc);
		
		//Aggiungo i pannelli a k
		k.add(intro, BorderLayout.NORTH);
		k.add(p, BorderLayout.CENTER);
		k.add(b, BorderLayout.SOUTH);
		
		this.pack();
		this.setResizable(false);
		
		
		
		
		
		
	}
}
