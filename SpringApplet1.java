package MojApplet;

//zaimportowanie bibliotek 

import javax.swing.JApplet;
import java.awt.*;
import javax.swing.*;
import java.util.Timer;


public class SpringApplet1 extends JApplet {

	// prywatne pola do przechowywania obiektow danych klas
	
	private SimEngine obiekt3;
	private SimTask obiekt4;
	private Timer timer;
	
	
	public void init(){
		
		//stworzenie obiektow ktore uzyjemy w konstruktorze
		Vector2D z = new Vector2D(500,150);
		Vector2D v = new Vector2D(0,0);
		Vector2D xl = new Vector2D(500,80);
	
		//stworzenie obiektow danych klas
		obiekt3 = new SimEngine(10.0,5.0,2.0,100.0,z,v,xl,9.81);
		obiekt4 = new SimTask(obiekt3, this , 0.04);
		timer = new Timer(); //stworzenie obiektu klasy timer
		timer.scheduleAtFixedRate(obiekt4, 0, 5); // uzycie metody timera (zadanie, czas pierwszego wyswietlenia, czas powtarzania zadania)
		
	}
	
	public void paint(Graphics g){
	
	
		g.clearRect(0,0,getWidth(),getHeight()); // wyczyszczenie powierzchni appletu
		
		setBackground(Color.GREEN);
		
		//narysowanie grafiki 
		
		g.drawLine((int) obiekt3.getXl().x, (int) obiekt3.getXl().y,(int) obiekt3.getZ().x, (int) obiekt3.getZ().y);
		
		g.drawLine((int) obiekt3.getXl().x-40, (int) obiekt3.getXl().y,(int) obiekt3.getXl().x+40, (int) obiekt3.getXl().y);
		
		g.drawOval((int) obiekt3.getZ().x - 10, (int) obiekt3.getZ().y, 20, 20);
					
	}
	
}
