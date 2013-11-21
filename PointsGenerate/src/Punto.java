import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;


public class Punto extends JPanel {
	
	private int x;
	private int y;
	private int i=1;

	public Punto(int cx, int cy)
	{
		x = cx;
		y = cy;
	}
	
	public void paint(Graphics gg){
		if(i==1){
			super.paint(gg);
			i=0;
		}
		Graphics2D g = (Graphics2D) gg;
		g.setColor(Color.RED);
		g.fillOval(x, y, 10, 10);
	}
	
	public void move(int xx,int yy)
	{
		x = xx;
		y = yy;
		this.repaint();
	}


}
