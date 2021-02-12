import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class AppAStar extends JPanel{

			
			/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
			private Visualizer vis;
			private Ui menu;
				
			
					public AppAStar(Grid grid) { 
						vis = new Visualizer(grid);
						menu = new Ui(grid);
						this.setLayout(new BorderLayout());
						this.add(menu,BorderLayout.EAST);
						this.add(vis);
					}
					
					public static void main(String args[]) { 
						Grid grid = new Grid(Visualizer.WIDTH,Visualizer.HEIGHT,Visualizer.WC,Visualizer.HC);
						JFrame window = new JFrame("AStar");
						window.setVisible(true);
						window.setResizable(false);
						window.setLocationRelativeTo(null);
						window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						window.add(new AppAStar(grid));
						window.pack();
				
			}
}
