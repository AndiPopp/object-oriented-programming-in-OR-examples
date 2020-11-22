package layout;

public class Movement {

	//the target the movement goes towards
	final Resource target;
	
	//the quantity of moving items
	final int quantity;

	//constructor
	public Movement(Resource target, int quantity) {
		this.target = target;
		this.quantity = quantity;
	}
}
