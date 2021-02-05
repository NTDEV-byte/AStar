
public class Noeud {
			
	private Vector2i position;
	private Noeud parent;
	private double fCost;
	private double gCost; 
	private double hCost; 
	
	
			public Noeud(Noeud parent,Vector2i position,double gCost,double hCost) {
				 	this.parent = parent;
				 	this.position = position;
				 	this.gCost = gCost;
				 	this.hCost = hCost;
				 	this.fCost = gCost + hCost;
			}

			public Vector2i getPosition() {
				return position;
			}

			public void setPosition(Vector2i position) {
				this.position = position;
			}

			public Noeud getParent() {
				return parent;
			}

			public void setParent(Noeud parent) {
				this.parent = parent;
			}


			public double getfCost() {
				return fCost;
			}


			public void setfCost(double fCost) {
				this.fCost = fCost;
			}


			public double getgCost() {
				return gCost;
			}


			public void setgCost(double gCost) {
				this.gCost = gCost;
			}


			public double gethCost() {
				return hCost;
			}


			public void sethCost(double hCost) {
				this.hCost = hCost;
			}
			

}
