package binpacking.arrays;

public class BinArray {
	
	//the capacitated array of bins
	private Bin[] bins;
	
	//the size of the individual bins, i.e. 
	//capacity of its item array
	private int binSize;
	
	//constructs empty array of bins holding a specific
	//maximum of bins with item array size binSize
	public BinArray(int maxNumber, int binSize){
		bins = new Bin[maxNumber];
		this.binSize = binSize; 
	}
	
	//return the length of the bins array
	public int getMaxBins(){
		return bins.length;
	}
	
	//prints the bin's contents to the console
	public void print(){
		for(int i = 0; i < bins.length; i++){
			if (bins[i] != null){
				System.out.println("Bin " + (i+1) 
						+ ":"+bins[i].toString());
			}
		}
	}
	
	//get the bin at position i, create it if necessary
	public Bin getBin(int i){
		//if there is no bin, create it
		if (bins[i] == null){
			bins[i] = new Bin(binSize);
		}
		
		//get the bin
		return bins[i];
	}
}
