package it.unisalento.actionListener;

import it.unisalento.dbinterface.DBManager;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class UIListener implements WindowListener {
	public UIListener(){
	}
	@Override
	public void windowActivated(WindowEvent arg0) {
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		DBManager.getIstance().closeConnection();
		System.exit(0);
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
	}

}
