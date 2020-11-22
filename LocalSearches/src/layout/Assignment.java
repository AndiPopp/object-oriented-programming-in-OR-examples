package layout;

public class Assignment {

	//the resource to be assigned
	final Resource resource;
	
	//the location the resource is assigned to
	final Location location;

	//constructor
	public Assignment(Resource resource, Location location) {
		this.resource = resource;
		this.location = location;
	}
	
	//to string
	public String toString(){
		if (resource == null){
			return location.name + " <- ";
		}else{
			return location.name + " <- " + resource.name;
		}
	}
}
