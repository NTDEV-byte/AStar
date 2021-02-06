import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

public class Visualizer extends JPanel{
	
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		public static final int WIDTH = 800;
		public static final int HEIGHT = 600;
		public static final int WC = 4;
		public static final int HC = 4;
		
		private Grid grid;
		private InputHandler input;
		
		public Visualizer(Grid grid) { 
			this.setPreferredSize(new Dimension(WIDTH,HEIGHT));
			input = new InputHandler();
			this.grid = grid;
			this.addMouseListener(input);
			this.addMouseMotionListener(input);
		}
		
		public void paint(Graphics g) { 
			g.setColor(Color.black);
			g.fillRect(0,0,getWidth(),getHeight());
			grid.showGrid(g);
			blockHandler();
			repaint();
		}

		private void blockHandler() { 
			if(input.mouseB == MouseEvent.BUTTON1) { 
				 grid.setGrid(getXCellLoc(), getYCellLoc());
			}
			else if(input.mouseB == MouseEvent.BUTTON3) { 
				 grid.setGrid(getXCellLoc(), getYCellLoc(),Grid.NO_BLOCK);
			}
		}
		
		public int getXCellLoc() { 
			return input.mouseX / WC;
		}
		
		public int getYCellLoc() { 
			return input.mouseY / HC;
		}
		
		public static int getWidthGrid() { 
			return WIDTH / WC;
		}

		public static int getHeightGrid() { 
			return HEIGHT / HC;
		}
}
