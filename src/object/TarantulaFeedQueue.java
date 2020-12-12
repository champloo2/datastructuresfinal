package object;

import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.PriorityQueue;
//import java.util.Queue;
//import java.util.Stack;



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
		Tarantula tToFeed = feederPQ.poll();
		tToFeed.setLastFeedDate();
		saleList.add(tToFeed);
	}
	
	
	//be able to move tarantulas stack back to queue
	public void moveToFeedQ(Tarantula t) {
		feederPQ.add(t);
		saleList.remove(t);
	}
	
	//be able to make a sale
	
	//maybe re-make this class renamed
	
	//update tarantula size
	//re-order priority queue
	public void updateSize(Tarantula t) {
		t.growTarantula();
	}
	
	public void printFeedingQueue() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"); 
		System.out.println("print feed queue");
		for(Tarantula t: feederPQ) {
			System.out.println("item ID: " + t.nameId + " size: " + t.size + " last feed date: " + dtf.format(t.lastFeedDate));
		}
	}
	//needs to check both ffeeder and sales list for the spider

}
