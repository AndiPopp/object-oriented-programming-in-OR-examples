package binpacking.linkedlists;

public class BinElement {
	//the bin element
	public Bin head;
	
	//the next element in the list
	public BinElement tail;

	//construct a new empty bin
	public BinElement(){
		this.head = new Bin();
	}
	
	//print bin to console
	public void print(){
		int i = 1;
		BinElement current = this;
		while(current != null){
			System.out.print("Bin " + i +":");
			System.out.println(current.head.toString());
			//next bin
			current = current.tail;
			i++;
		}
	}
}
