package it.unisalento.view;

import it.unisalento.actionListener.LoginListener;

import java.awt.GridLayout;

import javax.swing.*;

public class Login extends JFrame {
	
	private JLabel luname;
	private JLabel lpass;
	private JTextField uname;
	private JPasswordField pass;
	private JPanel p;
	private JButton login;
	private JButton register;
	private LoginListener loginListener;
	public Login(){
		super("Libreria: Effettua Login");
		p=new JPanel();
		this.add(p);
		this.p.setLayout(new GridLayout(3,2));
		this.luname=new JLabel("Username: ");
		this.p.add(luname);
		this.uname=new JTextField(30);
		this.p.add(uname);
		this.lpass=new JLabel("Password :");
		this.pass=new JPasswordField();
		this.p.add(lpass);
		this.p.add(pass);
		this.login=new JButton("Login");
		this.register=new JButton("Registrati");
		this.p.add(login);
		this.p.add(register);
		loginListener=new LoginListener(this);
		this.login.addActionListener(loginListener);
		this.register.addActionListener(loginListener);
		this.login.setActionCommand(loginListener.ACTION_LOGIN);
		this.register.setActionCommand(loginListener.ACTION_REGISTER);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		this.pack();
	}
	public String getUsername(){
		return this.uname.getText();
	}
	public char[] getPassword(){
		return this.pass.getPassword();
	}
}


//TODO Implementare i controlli dei listener
