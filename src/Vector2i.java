
public class Vector2i {
	
		public int x,y;
		
				public Vector2i(int x,int y) { 
					this.x = x;
					this.y = y;
				}
				
				public Vector2i(Vector2i vector) { 
					this.x = vector.x;
					this.y = vector.y;
				}
				
				
				public Vector2i add(Vector2i vector) { 
					 x+=vector.x;
					 y+=vector.y;
					 return this;
				}
				
				public Vector2i add(int amnt) { 
					 x+=amnt;
					 y+=amnt;
					 return this;
				}
				
				public String toString() {
					 return "x = "+x+"y = "+y; 
				}

				public boolean equals(Object obj) { 
					if(!(obj instanceof Vector2i)) return false;
					
					Vector2i vec = (Vector2i) obj;
					
					return this.x == vec.x && this.y == vec.y;
				}

}
