import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;


public class GenPunti extends JFrame {
	
	private CoordinatePunto p[];
	private double dist[];
	private int idx; 
	
	public GenPunti()
	{
		p = new CoordinatePunto[100];
		dist = new double[100 * 100];
		idx = 0;
		final Punto a = new Punto(0,0);
		a.setVisible(false);
		JFrame frame = new JFrame("Punti");
		frame.setSize(500,300);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		final Container c = frame.getContentPane();
		c.add(a);
		
		c.addMouseListener(new MouseListener()
		{
			public void mousePressed(MouseEvent e)
			{
				int x = e.getX();
				int y = e.getY();
				
				System.out.println("mouse " + x + "" + y);
				a.move(x, y);
				a.setVisible(true);
				a.repaint();
				p[idx] = new CoordinatePunto(x,y);
				idx++;
				for(int i = 0; i < idx; i++)
				{
					
				}

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}


			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		 frame.setLocationRelativeTo(null);
	}
	
	
	class CoordinatePunto
	{
		private int x;
		private int y;
		public CoordinatePunto(int x,int y)
		{
			this.x = x;
			this.y = y;
		}
		
	}
}

