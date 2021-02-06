import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Ui extends JPanel implements ActionListener{
	
		
		private JButton block;
		private JButton start;
		private JButton goal;
		private JButton find;
		private JButton clear;
		private Grid grid;
		
			
				public Ui(Grid grid) { 
					this.setPreferredSize(new Dimension(200,600));
					block = new JButton("Block");
					block.addActionListener(this);
					start = new JButton("Start");
					start.addActionListener(this);
					goal = new JButton("Goal");
					goal.addActionListener(this);
					find = new JButton("Find");
					find.addActionListener(this);
					clear = new JButton("Clear");
					clear.addActionListener(this);
					this.grid = grid;
					this.add(block);
					this.add(start);
					this.add(goal);
					this.add(find);
					this.add(clear);
				}

				@Override
				public void actionPerformed(ActionEvent e) {
					if(e.getSource() == block) { 
						grid.setStateIns(Grid.SOLID_BLOCK);
					}
					
					if(e.getSource() == start) { 
						grid.setStateIns(Grid.START_BLOCK);
					}
					
					if(e.getSource() == goal) {
						grid.setStateIns(Grid.GOAL_BLOCK);
					}
					
					if(e.getSource() == clear) {
						grid.clearAll();
					}
					
					if(e.getSource() == find) {
						double TStart = System.currentTimeMillis();
						Vector2i start = grid.getFirstStartingPosition();
						Vector2i goal = grid.getFirstGoalPosition();
						
						if(start!=null && goal!=null) {
							List<Noeud> path  = Astar.findPath(grid, start, goal);
							if(path!= null) {
								 if(path.size() >= 0) {
									 grid.setPath(path);
									 grid.showFoundPath();
									 JOptionPane.showMessageDialog(null,"Path Found ! in "+(System.currentTimeMillis() - TStart) +" ms");
								 }
							}
						}else {
							
							JOptionPane.showMessageDialog(null, "Please select a staring point and a goal point");
						}
					}
				}

}
