package graphs.cpm;

import graphs.Edge;
import graphs.jobs.*;

public class CPMExampleCached {
	
	public static void main(String[] args){
		PDMProblem P = example();
		P.printSolution();
	}
	
	private static PDMProblem example(){
		Job[] jobs = new Job[6];
		//construct jobs
		jobs[0] = new CachingJob("A", 3);
		jobs[1] = new CachingJob("B", 1);
		jobs[2] = new CachingJob("C", 8);
		jobs[3] = new CachingJob("D", 4);
		jobs[4] = new CachingJob("E", 2);
		jobs[5] = new CachingJob("F", 5);
		
		//build edges
		Edge[] edges = new Edge[7];
		edges[0] = new Edge(jobs[0], jobs[1]);
		edges[1] = new Edge(jobs[0], jobs[2]);
		edges[2] = new Edge(jobs[1], jobs[3]);
		edges[3] = new Edge(jobs[1], jobs[4]);
		edges[4] = new Edge(jobs[2], jobs[5]);
		edges[5] = new Edge(jobs[3], jobs[5]);
		edges[6] = new Edge(jobs[4], jobs[5]);
		
		return new PDMProblem(jobs, edges);
	}
}
