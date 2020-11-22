package binpacking.collections;

import java.util.LinkedList;

public class BinList extends LinkedList<Bin> {

	public void print(){
		int i = 0;
		for(Bin bin : this){
			i++;
			System.out.print("Bin "+i+": ");
			System.out.println(bin.toString());
		}
	}
}
