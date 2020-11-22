package graphs.jobs;

import graphs.*;

public class Job extends Node{
	
	//the job's duration
	private int duration;

	//constructor
	public Job(String name, int duration) {
		super(name);
		this.duration = duration;
	}
	
	//getters
	public double getDuration() {
		return duration;
	}
	
	//SOLVE THE NODE
	//--------------
	
	//a static variable to measure solution performance
	public static int count = 0;
	
	//get the earliest start date
	public int ESD(){
		count++;
		int start = 0; //variable for return value
		for(Edge edge : this.getInboud()){
			Job pred = (Job) edge.getStart();
			if (pred.EFD() > start){
				start = pred.EFD();
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
		//check if this is a sink node
		if (this.getOutbound().length < 1) {
			return EFD();
		}
		//initialize with the first successor
		Job succ = (Job) this.getOutbound()[0].getEnd();
		int finish = succ.LSD();
		//check all successors
		for(Edge edge : this.getOutbound()){
			succ = (Job) edge.getEnd();
			if (succ.LSD() < finish){
				finish = succ.LSD();
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
