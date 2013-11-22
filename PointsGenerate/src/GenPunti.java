import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class GenPunti extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CoordinatePunto p[];
	private double dist[];
	private int idx; 
	private JButton gen;
	
	
	private JPanel bottone = new JPanel();
	private Punto a;
	
	
	public GenPunti()
	{
		a = new Punto(-10,-10);
		a.setBackground(Color.WHITE);
		a.setBounds(10, 10, 100, 100);
		
		getContentPane().add(a, BorderLayout.CENTER);
		getContentPane().add(bottone, BorderLayout.SOUTH);
		

		this.setSize(1000,700);
		this.setLocationRelativeTo(null);
		this.setResizable(false);

		
		p = new CoordinatePunto[100];
		idx = 0;
		
		

		gen = new JButton("Genera Problema");

		bottone.add(gen);
		bottone.setBackground(Color.GRAY);
		
		a.addMouseListener(new MouseListener()
		{
			public void mousePressed(MouseEvent e)
			{
				int x = e.getX();
				int y = e.getY();
				
				a.move(x, y);
				a.setVisible(true);
				a.repaint();
				p[idx] = new CoordinatePunto(x,y);
				idx++;
				
				System.out.println("Creato punto in " + x + ", " + y);
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
		
		gen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				FileWriter out = null;
				try {
					out = new FileWriter("prova.txt");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				BufferedWriter filebuf = new BufferedWriter(out);
				PrintWriter pr = new PrintWriter(filebuf);
				dist = new double[idx*idx];
				for(int i = 0; i < idx; i++)
					for(int j = 0; j < idx; j++)
					{
						double distance = Math.sqrt(   Math.pow((p[i].x - p[j].x),2) + Math.pow((p[i].y - p[j].y),2)  );
						dist[i*idx + j] = distance;
						pr.format(Locale.ENGLISH,"%.2f ",distance);
						
						System.out.format(Locale.ENGLISH,"%.2f ",distance);
						
					}
				pr.close();
				
				
				
			}

		});
		
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


