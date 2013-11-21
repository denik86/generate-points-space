import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;


public class Punto extends JPanel {
	
	private int x;
	private int y;
	private int i=1;
	private int n;

	public Punto(int cx, int cy)
	{
		x = cx;
		y = cy;
		n = -1;
	}
	
	public void paintComponent(Graphics gg){
		if(i==1){
			super.paintComponent(gg);
			i=0;
		}
		Graphics2D g = (Graphics2D) gg;
		g.setColor(Color.RED);
		g.fillOval(x-2, y-2, 5, 5);
		g.setColor(Color.BLACK);
		g.drawString(""+n, x+7, y);
		n++;
	}
	
	public void move(int xx,int yy)
	{
		x = xx;
		y = yy;
		repaint();
		
		
	}


}
