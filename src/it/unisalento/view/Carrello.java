package it.unisalento.view;

import it.unisalento.dao.Chart;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Carrello extends JPanel implements Runnable{
	private JTextArea area;
	private Chart chart;
	private Thread t;
	public Carrello(){
		chart=Chart.getIstance();
		t=new Thread(this);
		t.start();
		area=new JTextArea();
		add(area);
		aggiorna();
	}
	public void aggiorna(){
		area.setText("");
		for(int i=0;i<chart.getDim();i++){
			area.append(chart.getItem(i).getTitolo()+"\n");
			System.out.println(chart.getItem(i).getTitolo()+"\n");
		}
	}
	public void run(){
		try{
			while(true){
			t.sleep(1000);
			aggiorna();
			System.out.println("thread running");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
