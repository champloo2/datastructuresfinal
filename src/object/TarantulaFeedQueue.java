package object;

import java.util.LinkedList;
import java.util.PriorityQueue;
//import java.util.Queue;
import java.util.Stack;



public class TarantulaFeedQueue {
	
	PriorityQueue<Tarantula> feederPQ = new PriorityQueue<Tarantula>();  
	LinkedList<Tarantula> saleList = new LinkedList<Tarantula>();
	
	//method to add a spider to feed
	public void enqueueForFeeding(Tarantula t) {
		feederPQ.add(t);
	}
	
	//method to feed spider
	//once spider is fed, add it to sell stack
	public void feedAndStack() {
		saleList.add(feederPQ.poll());
	}
	
	
	//be able to move tarantulas stack back to queue
	public void moveToFeedQ(String ID) {

	}
	
	//be able to make a sale
	
	//maybe re-make this class renamed
	
	//update tarantula size

}
