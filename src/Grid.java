import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

import javax.swing.JOptionPane;

public class Grid {
			
			public static final int NO_BLOCK = 0;
			public static final int SOLID_BLOCK = 1;
			public static final int START_BLOCK = 2;
			public static final int GOAL_BLOCK = 3;
			public static final int CURRENT_BLOCK = 4;
			public static final int PATH_BLOCK = 5;
			
			public static final Color SOLID_COL = Color.red;
			public static final Color START_COL = Color.green;
			public static final Color GOAL_COL = Color.magenta;
			public static final Color CURRENT_COL = Color.yellow;
			public static final Color PATH_COL = Color.CYAN;
			
			
	private int width;
	private int height;
	private int cw,ch;
	private int cells[];
	private int stateIns = SOLID_BLOCK;
	private Vector2i start,goal;
	private List<Noeud> path;
 	
	
				public Grid(int width,int height,int cw,int ch) { 
					this.cw = cw;
					this.ch = ch;
					this.width = width / cw;
					this.height = height / ch;
					this.cells = new int[this.width * this.height];
				}
				
				public void setGrid(int x,int y) { 
					if(stateIns == START_BLOCK && countTarget(START_BLOCK) < 1) { 
						cells[x + y * width] = stateIns;
					}
					if(stateIns == GOAL_BLOCK && countTarget(GOAL_BLOCK) < 1) { 
						cells[x + y * width] = stateIns;
					}
					
					if(stateIns == SOLID_BLOCK) {
						cells[x + y * width] = stateIns;
					}
				}
				
				public void setGrid(int x,int y,int state) { 
					if(x >= 0 && x < width && y >= 0 && y < height)
					cells[x + y * width] = state;
				}
				
				public boolean inBounds(int x,int y) {
					 return x >= 0 && x < width && y >= 0 && y <= height;
				}
				
				private int countTarget(int type) { 
					int total = 0;
					for(int i=0;i<cells.length;i++) { 
						 if(cells[i] == type) {
							 total++;
						 }
					}
					return total;
				}

				public void showGrid(Graphics g) { 
					g.setColor(Color.white);
					for(int y=0;y<height;y++) { 
						for(int x=0;x<width;x++) {
							  if(cells[x + y * width] == SOLID_BLOCK) { 
								  g.setColor(SOLID_COL);
								  g.fillRect(x * cw , y * ch, cw, ch);
							  }
							  else
								  if(cells[x + y * width] == START_BLOCK) { 
									  g.setColor(START_COL);
									  g.fillRect(x * cw , y * ch, cw, ch);
								  }
								  else
									  if(cells[x + y * width] == GOAL_BLOCK) { 
										  g.setColor(GOAL_COL);
										  g.fillRect(x * cw , y * ch, cw, ch);
									  }
									  else
										  if(cells[x + y * width] == CURRENT_BLOCK) { 
											  g.setColor(CURRENT_COL);
											  g.fillRect(x * cw , y * ch, cw, ch);
										  }
										  else
											  if(cells[x + y * width] == PATH_BLOCK) { 
												  g.setColor(PATH_COL);
												  g.fillRect(x * cw , y * ch, cw, ch);
											  }
							  g.setColor(Color.DARK_GRAY);
							  g.drawLine(x * cw, 0 , x * cw, height * ch);
							  
						}
						  g.drawLine(0, y * ch, width * cw, y * ch);
						  
						  showFoundPath();
				
					}
				}
		
			public Vector2i getFirstStartingPosition() { 
				for(int y=0;y<height;y++) {
					 for(int x=0;x<width;x++) {
						  if(cells[x + y * width] == START_BLOCK) { 
							  start = new Vector2i(x,y);
							  return start;
						  }
					 }
				}
				return null;
			}
			
			public void showFoundPath() {
				if(path!=null) {
						for(int i=0;i<path.size();i++) {
							 if(i != 0) { 
								 Vector2i pos = path.get(i).getPosition();
								 cells[pos.x + pos.y * width] = PATH_BLOCK;
							 }
						}
					}
			}
			
			public Vector2i getFirstGoalPosition() { 
				for(int y=0;y<height;y++) {
					 for(int x=0;x<width;x++) {
						  if(cells[x + y * width] == GOAL_BLOCK) { 
							  goal = new Vector2i(x,y);
							  return goal;
						  }
					 }
				}
				return null;
			}
		
			public Vector2i getStarting() { 
				if(start!=null) {
					 return start;
				}
					JOptionPane.showMessageDialog(null, "start is null !!");
					return null;
			}
			
			public Vector2i getGoal() { 
				if(goal!=null) {
					 return goal;
				}
					JOptionPane.showMessageDialog(null, "Goal is null !!");
					return null;
			}
			
			public int getStateAt(int x,int y) { 
				if(x >= 0 && x < width && y >= 0 && y < height)
				 return cells[x + y * width];
				
				return NO_BLOCK;
			}

			public int getStateIns() {
				return stateIns;
			}
			
			public void clearAll() {
				 for(int i=0;i<cells.length;i++) {
					  cells[i] = NO_BLOCK;
				 }
				if(path!=null) path.clear();
			}
			
			public void setStateIns(int stateIns) {
					this.stateIns = stateIns;
			}

			public List<Noeud> getPath() {
				return path;
			}

			public void setPath(List<Noeud> path) {
				this.path = path;
			}
			
}
