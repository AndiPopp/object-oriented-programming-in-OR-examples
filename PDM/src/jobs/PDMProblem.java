package jobs;


public class PDMProblem {

	//the jobs in this problems 
	//precedence diagram
	Job[] jobs;

	//constructor
	public PDMProblem(Job[] jobs) {
		this.jobs = jobs;
	}
	
	//print solution
	public void printSolution(){
		//print header
		System.out.println("Job: ESD, EFD, LSD, LDF, Slack");
		System.out.println("------------------------------");
		//print jobs
		for(Job job : jobs){
			System.out.print("Job " + job.getName());
			System.out.print(": " + job.ESD());
			System.out.print(", " + job.EFD());
			System.out.print(", " + job.LSD());
			System.out.print(", " + job.LFD());
			System.out.println(", " + job.slack());
		}
		//print performance information
		System.out.println();
		System.out.println("Solved in "+Job.count+" recursions");
	}
	
	
}
