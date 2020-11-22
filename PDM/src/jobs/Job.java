package jobs;

//Represents a job in a project scheduling problem
public class Job {
	
	//the job's name
	private String name;
	
	//the job's duration
	private int duration;
	
	//the job's predecessors and successors
	//empty pred array implies source
	//empty succ array implies sink
	private Job[] pred;
	private Job[] succ;

	//constructor setting all fields
	public Job(String name, int duration) {
		this.name = name;
		this.duration = duration;
		this.pred = new Job[0];
		this.succ = new Job[0];
	}

	//add predecessor or successor
	private static Job[] addJob(Job[] jobs, Job job){
		Job[] newJobs = new Job[jobs.length+1];
		for(int i = 0; i < jobs.length; i++){
			newJobs[i] = jobs[i]; 
		}
		newJobs[newJobs.length-1] = job;
		return newJobs;
	}
	
	//add predecessors and successors
	public void addPred(Job job) {
		pred = addJob(pred, job);
	}

	public void addSucc(Job job) {
		succ = addJob(succ, job);
	}
	
	//getters
	public String getName() {
		return name;
	}

	public double getDuration() {
		return duration;
	}
	
	public Job[] getPred() {
		return pred;
	}

	public Job[] getSucc() {
		return succ;
	}
	
	//SOLVE THE NODE
	//--------------
	
	//a static variable to measure solution performance
	public static int count = 0;
	
	//get the earliest start date
	public int ESD(){
		count ++;
		int start = 0;
		for(Job job : pred){
			if (job.EFD() > start){
				start = job.EFD();
			}
		}
		return start;
	}
	
	//get the earliest finishing date
	public int EFD(){
		return ESD() + duration;
	}
	
	//get the latest finishing data
	public int LFD(){
		count++;
		if (succ.length < 1) {
			return EFD();
		}
		int finish = succ[0].LSD();
		for(Job job : succ){
			if (job.LSD() < finish){
				finish = job.LSD();
			}
		}
		return finish;
	}

	//get the latest starting date
	public int LSD(){
		return LFD() - duration;
	}
	
	//get the slack
	public int slack(){
		return LSD() - ESD();
	}
}
