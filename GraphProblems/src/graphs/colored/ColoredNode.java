package graphs.colored;

import graphs.*;

public class ColoredNode extends UndirectedNode {
	
	//the node's color, 0 or less indicating and uncolored node
	public int color;
	
	//constructor
	public ColoredNode(String name) {
		super(name);
		color = 0; //initialize as uncolored
	}
	
	//get the degree
	public int deg(){
		return this.getNeighbors().length;
	}
	
	//color the node with the lowest available color
	public void color(){
		//try out all colors in sequence
		for(int color=1;this.color <= 0;color++){
			//flag if the color is already used by neighbor
			//start with false
			boolean colorUsed = false;
			//check all neighbors
			for(Edge edge : this.getNeighbors()){
				//for safety, do an instanceof check before type casting
				if (edge.getStart() == this 
						&& edge.getEnd() instanceof ColoredNode){
					
					ColoredNode neighbor = (ColoredNode) edge.getEnd();
					colorUsed = (neighbor.color == color);
				}else if (edge.getEnd() == this 
                        && edge.getStart() instanceof ColoredNode){
					ColoredNode neighbor = (ColoredNode) edge.getStart();
					colorUsed = (neighbor.color == color);
				}
				//if we found a node with the same color, break for
				if (colorUsed) break;
			}
			
			//if we ran through for without finding another node of the 
			//color, use the color for this node
			if (!colorUsed) {
				this.color = color;
			}
		}
	}
	
	//Get name and color as String
	public String toString(){
		return "Node " + getName() + ": color " + color;
	}
}
