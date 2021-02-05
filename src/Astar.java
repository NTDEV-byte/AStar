import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Astar {
	
		
			private Astar() {
				
			}
	
		private static class TrieuseDeNoeud implements Comparator<Noeud>{
			@Override
			public int compare(Noeud o1, Noeud o2) {
				if(o1.getfCost() > o2.getfCost()) return 1;
				if(o2.getfCost() < o1.getfCost()) return -1;
				return 0;
			} 
		}
		
			public static List<Noeud> findPath(Grid grid,Vector2i start,Vector2i goal) { 
				List<Noeud> openList = new ArrayList<Noeud>();
				List<Noeud> closedList = new ArrayList<Noeud>();
				
				
				Noeud current = new Noeud(null,start,0,getDistance(start,goal));
				
				openList.add(current);
				
				TrieuseDeNoeud trieuse = new Astar.TrieuseDeNoeud();
				
				
				while(openList.size() > 0) { 
					
					
					Collections.sort(openList,trieuse);
					current = openList.get(0);
						if(current.getPosition().equals(goal)) {
								List<Noeud> path = new ArrayList<Noeud>();
								while(current.getParent() != null) { 
									 path.add(current);
									 current = current.getParent();
								}
								openList.clear();
								closedList.clear();
								return path;
						}
						
						
					openList.remove(current);
					closedList.add(current); //visité 
					
					for(int i=0;i<9;i++) { 
						if(i == 4) continue;
						int xi = (i % 3) - 1;
						int yi = (i / 3) - 1;
						int x = current.getPosition().x;
						int y = current.getPosition().y;
						
						Vector2i currentPosition = new Vector2i(current.getPosition().x + xi, current.getPosition().y + yi);
						if(!grid.inBounds(currentPosition.x,currentPosition.y)) continue;
						int block_at = grid.getStateAt(currentPosition.x, currentPosition.y);
						if(block_at == Grid.SOLID_BLOCK) continue;
						if(grid.inBounds((x + xi), (y + yi))) {
							if((!currentPosition.equals(start)) && (!currentPosition.equals(goal))  ) { 
								grid.setGrid((x + xi), (y + yi), Grid.CURRENT_BLOCK);
							}
						}
						double gCost = current.getgCost() + getDistance(current.getPosition(),currentPosition);
						double hCost = getDistance(currentPosition,goal);
						Noeud noeud = new Noeud(current,currentPosition,gCost,hCost);
						if(inVec(currentPosition,closedList)) continue;
						if(!inVec(currentPosition,openList)) openList.add(noeud);
					}
				}
					
				System.out.println("no path found !");
				
				closedList.clear();
				return null;
			}

			public static boolean inVec(Vector2i position,List<Noeud> nodes) { 
					for(Noeud n : nodes) { 
						if(position.equals(n.getPosition())) {
							 return true;
						}
					}
					return false;
			}
			
			public static double getDistance(Vector2i a,Vector2i b) {
				double dx = a.x - b.x;
				double dy = a.y - b.y;
				
				return Math.sqrt(dx * dx + dy * dy);
			}
}
