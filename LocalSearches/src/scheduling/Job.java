package scheduling;

//This class represents as job in a 
//single machine scheduling problem
public class Job {

	private String name;
	private int processingTime;
	private int realeaseDate;
	private int dueDate;
	
	//full parameter constructor
	public Job(String name, int processingTime, 
			int realeaseDate, int dueDate) {
		
		this.name = name;
		this.processingTime = processingTime;
		this.realeaseDate = realeaseDate;
		this.dueDate = dueDate;
	}
	
	//getter for the field name
	public String getName() {
		return name;
	}

	//get the completion time for a given opening date
	public int getCompletationDate(int openingDate){
		if (openingDate >= realeaseDate){
			//job is already released, to start at opening date
			return openingDate + processingTime;
		}
		else{
			//job needs to wait for release
			return realeaseDate + processingTime;
		}
	}
	
	//get the tardiness for a given opening date
	public int getTardiness(int openingDate){
		//calculate the completion date
		int completionDate = getCompletationDate(openingDate);
		//check if the job is actually tardy
		if (completionDate > dueDate){
			return completionDate - dueDate;
		}
		else{
			return 0;
		}
		
	}
	
}
