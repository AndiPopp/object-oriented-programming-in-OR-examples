package graphs.colored;

import graphs.*;

public class ColoredGraph extends Graph {
	
	//Constructor which only accepts colored nodes
	public ColoredGraph(ColoredNode[] nodes, Edge[] edges) {
		super(nodes, edges);
	}

	//Uses selection sort to sort the nodes descending by degree
	private void sortNodesByDegree(){
		for(int i = 0; i < nodes.length; i++){
			//find max
			int max = i;
			for (int j = i+1; j < nodes.length; j++){
				if (((ColoredNode)nodes[j]).deg() 
						> ((ColoredNode)nodes[max]).deg()){
					
					max = j;
				}
			}
			//swap
			Node swap = nodes[i];
			nodes[i] = nodes[max];
			nodes[max] = swap;
		}
	}
	
	//solve the node coloring problem with the heuristic
	public void solve(){
		//sort nodes by degree
		sortNodesByDegree();
		
		//color the nodes
		for (Node node : nodes){
			((ColoredNode)node).color();
		}
	}
	
	//Print colors to console
	public void printColors(){
		for (Node node : nodes){
			System.out.println(node.toString());
		}
	}
}
