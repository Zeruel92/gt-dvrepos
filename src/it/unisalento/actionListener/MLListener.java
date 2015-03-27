package it.unisalento.actionListener;

import it.unisalento.view.ModificaLibro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MLListener implements ActionListener {
	ModificaLibro modifica;
	public MLListener(ModificaLibro modificalibro)
	{
		modifica=modificalibro;
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getActionCommand().equals("Ok"))
			modifica.modifica();
	}
}
