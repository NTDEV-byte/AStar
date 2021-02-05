import java.awt.BorderLayout;

import javax.swing.JPanel;

public class App extends JPanel{

			
			private Visualizer vis;
			private Ui menu;
				
			
					public App(Grid grid) { 
						vis = new Visualizer(grid);
						menu = new Ui(grid);
						this.setLayout(new BorderLayout());
						this.add(menu,BorderLayout.EAST);
						this.add(vis);
					}
}
