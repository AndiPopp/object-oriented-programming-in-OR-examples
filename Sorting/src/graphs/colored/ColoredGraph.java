package graphs.colored;

import sorting.SortAlgorithms;
import graphs.*;

public class ColoredGraph extends Graph<Edge> {
	
	//Constructor which only accepts colored nodes
	public ColoredGraph(ColoredNode[] nodes, Edge[] edges) {
		super(nodes, edges);
	}
	
	//solve the node coloring problem with the heuristic
	public void solve(){
		//sort nodes by degree
		SortAlgorithms.selectionSort((ColoredNode[]) nodes, false);
		
		//color the nodes
		for (Node<Edge> node : nodes){
			((ColoredNode)node).color();
		}
	}
	
	//Print colors to console
	public void printColors(){
		for (Node<Edge> node : nodes){
			System.out.println(node.toString());
		}
	}
}
