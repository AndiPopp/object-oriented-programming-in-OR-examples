package layout;

import localsearch.*;

public class LayoutProblemExample {
	
	static Location[] locations;
	
	private static void buildLocations(){
		//Locations
		locations = new Location[6];
		for(int i = 0; i < locations.length; i++){
			locations[i] = new Location(""+(i+1));
		}
		//calculate and add the distances
		for(int i = 0; i < locations.length; i++){
			//create an element for every OTHER location
			locations[i].distances = new Distance[locations.length-1];
			//build the distance objects
			int k = 0;
			for(int j = 0; j < locations.length;j++){
				//only for different locations
				if (i != j){
					double dist = 8; //always go 8 vertically
					dist += Math.abs(i%3 - j%3) * 12;
					locations[i].distances[k] 
							= new Distance(locations[j], dist);
					k++;
				}
			}
		}
	}

	private static Resource or = new Resource("OR");
	private static Resource xr = new Resource("XR");
	private static Resource p1 = new Resource("P1");
	private static Resource p2 = new Resource("P2");
	private static Resource  l = new Resource( "L");
	
	private static void buildRessources(){
		//Movements from or
		or.movements = new Movement[4];
		or.movements[0] = new Movement(xr, 12);
		or.movements[1] = new Movement(p1, 36);
		or.movements[2] = new Movement(p2, 42);
		or.movements[3] = new Movement( l,  4);
		//Movements from xr
		xr.movements = new Movement[3];
		xr.movements[0] = new Movement(p1, 52);
		xr.movements[1] = new Movement(p2, 63);
		xr.movements[2] = new Movement( l, 18);
		//Movements from p1
		p1.movements = new Movement[2];
		p1.movements[0] = new Movement(p2, 87);
		p1.movements[1] = new Movement( l, 39);
		//Movements from p2
		p2.movements = new Movement[1];
		p2.movements[0] = new Movement( l, 28);
		//Movements from l
		l.movements = new Movement[0];
	}
	
	private static Configuration startConfiguration(){
		Assignment[] assignments = new Assignment[locations.length];
		assignments[0] = new Assignment(or, locations[0]);
		assignments[1] = new Assignment(xr, locations[1]);
		assignments[2] = new Assignment(p1, locations[2]);
		assignments[3] = new Assignment(p2, locations[3]);
		assignments[4] = new Assignment(null, locations[4]);
		assignments[5] = new Assignment(l, locations[5]);
		return new Configuration(assignments);
	}
	
	public static void main(String[] args){
		buildLocations();
		buildRessources();
		Configuration config = startConfiguration();
		LocalSearches.hillClimbing(config);
	}
}
