package layout;

public class Location {

	//the location's name
	final String name;
	
	//the distances to other locations
	Distance[] distances;

	//the resource at this location
	Resource resource;
	
	//constructor
	public Location(String name) {
		this.name = name;
	}
}
