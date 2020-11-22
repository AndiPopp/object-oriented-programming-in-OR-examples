package graphs.jobs;

public class CachingJob extends Job {

	//cached solution values
	int esd;
	int efd;
	int lsd;
	int lfd;
	
	//reset the cache values
	public void resetCache(){
		esd = -1;
		efd = -1;
		lsd = -1;
		lfd = -1;
	}
	
	//constructor
	public CachingJob(String name, int duration) {
		super(name, duration);
		resetCache();
	}
	
	//overload returning methods
	@Override
	public int ESD(){
		if (esd < 0){
			esd = super.ESD();
		}
		return esd;
	}

	@Override
	public int EFD() {
		if (efd < 0){
			efd = super.EFD();
		}
		return efd;
	}

	@Override
	public int LFD() {
		if (lfd < 0){
			lfd = super.LFD();
		}
		return lfd;
	}

	@Override
	public int LSD() {
		if (lsd < 0){
			lsd = super.LSD();
		}
		return lsd;
	}
}
