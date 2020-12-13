package object;

//import java.time.format.DateTimeFormatter;
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
		System.out.println("moving tarantula #" + tToFeed.nameId  +" to sales list");
		printInventory();
	}
	
	
	//be able to move tarantulas stack back to queue
	public void moveToFeedQ(Tarantula t) {
		feederPQ.add(t);
		saleList.remove(t);
		System.out.println("Tarantula #"+ t.nameId + " moved back to feeding queue and removed from sales list");
		printInventory();
	}
	
	//be able to make a sale
	public void makeASale(Tarantula t) {
		saleList.remove(t);
		System.out.println("Tarantula #" +t.nameId+ " has been sold");
		printInventory();
	}

	
	//update tarantula size
	//re-order priority queue
	public void updateSize(Tarantula t) {
		System.out.print("Tarantula #" + t.nameId + " has grown from " + t.size + " inches ");
		t.growTarantula();
		System.out.println("to " + t.size + " inches.");
		printInventory();
	}
	
	private void printInventory() {
		//DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"); 
		System.out.println("printing feed queue");
		for(Tarantula t: feederPQ) {
			System.out.println(t.printTarantulaData());
			//System.out.println("item ID: " + t.nameId + " size: " + t.size + " last feed date: " + dtf.format(t.lastFeedDate));
		}
		System.out.println("printing sale list");
		for(Tarantula t: saleList) {
			System.out.println(t.printTarantulaData());
		}
		System.out.println();
	}
	

}
