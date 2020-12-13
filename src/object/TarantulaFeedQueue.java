package object;

//import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;
//import java.util.Queue;
//import java.util.Stack;



public class TarantulaFeedQueue {
	
	PriorityQueue<Tarantula> feederPQ = new PriorityQueue<Tarantula>();  
	LinkedList<Tarantula> saleList = new LinkedList<Tarantula>();
	LinkedList<Tarantula> allTs = new LinkedList<Tarantula>();
	Scanner myObj = new Scanner(System.in);
	
	//method to add a spider to feed
	public void enqueueForFeeding(Tarantula t) {
		feederPQ.add(t);
		allTs.add(t);
	}
	
	//method to feed spider
	//once spider is fed, add it to sell stack
	private void feedAndStack() {
		Tarantula tToFeed = feederPQ.poll();
		tToFeed.setLastFeedDate();
		saleList.add(tToFeed);
		System.out.println("moving tarantula #" + tToFeed.nameId  +" to sales list");
		printInventory();
		whatToDo();
	}
	
	//besides enqueing, This is the only public methods used in the driver
	//all other methods come back to this one to ask the user
	//what they want to do
	public void whatToDo() {
		System.out.println("What do you want to do?"+"\n"  +"'s' to make a sale" +"\n"  + "'f' to feed" +"\n"  + "'q' to move sale item back to queue" +"\n"  + "any other input to update a size");
		//Scanner myObj = new Scanner(System.in);
		String userInput = myObj.nextLine();
		if(userInput.startsWith("s")) {
			makeASale();
			
		}
		else if (userInput.startsWith("f")) {
			feedAndStack();
			
		}
		else if(userInput.startsWith("q")) {
			moveToFeedQ();
		}
		else {
			updateSize();
		}
		//myObj.close();
	}
	
	
	//be able to move tarantulas stack back to queue
	private void moveToFeedQ() {
		Tarantula tToQueue = pickATarantula("feedq");
		feederPQ.add(tToQueue);
		saleList.remove(tToQueue);
		System.out.println("Tarantula #"+ tToQueue.nameId + " moved back to feeding queue and removed from sales list");
		printInventory();
		whatToDo();
	}
	
	//Removed the item from the inventory once it is sold
	private void makeASale() {
		//iterate through sales list
		Tarantula tToSell = pickATarantula("sell");
		
		saleList.remove(tToSell);
		allTs.remove(tToSell);
		System.out.println("Tarantula #" +tToSell.nameId+ " has been sold");
		printInventory();
		whatToDo();
	}

	
	//update tarantula size and print the size change
	private void updateSize() {
		Tarantula t = pickATarantula("update");
		System.out.print("Tarantula #" + t.nameId + " has grown from " + t.size + " inches ");
		t.growTarantula();
		System.out.println("to " + t.size + " inches.");
		
		//re-make the priority Q since the comparable value
		//has been updated
		PriorityQueue<Tarantula> tempQ = new PriorityQueue<Tarantula>(); 
		for(Tarantula tf: feederPQ) {
			tempQ.add(tf);
		}
		this.feederPQ = tempQ;
		
		
		printInventory();
		whatToDo();
	}
	
	
	//asks the user which tarantula to sell or feed
	private Tarantula pickATarantula(String action) {
		Tarantula returnObject = null;
		String userInput;
		
		if (action.equals("sell")) {
			//Scanner sellScan = new Scanner(System.in);
			for(Tarantula t: saleList) {
				System.out.println(t.printTarantulaData() +": Sell this Tarantula?");
				  // Create a Scanner object
			    userInput = myObj.nextLine();
			    boolean inputIsY = (userInput.startsWith("y"));
			    if(inputIsY) {
			    	returnObject = t;
			    	System.out.println("break");
			    	break;
			    }
			}
			//sellScan.close();
		}
		else if (action.equals("feedq")) {
			//Scanner feedScan = new Scanner(System.in);
			for(Tarantula t: feederPQ) {
				System.out.println(t.printTarantulaData()+": move this to the feeding queue?");
				  // Create a Scanner object
			    userInput = myObj.nextLine();
			    if(userInput.startsWith("y")) {
			    	returnObject = t;
			    	break;
			    }
				
			}
			//feedScan.close();
		}
		else {
			//Scanner updateScan = new Scanner(System.in);
			for(Tarantula t: allTs) {
				System.out.println(t.printTarantulaData() + ": update size?");
				userInput = myObj.nextLine();
				if(userInput.startsWith("y")) {
					returnObject = t;
					break;
				}
			}
			//updateScan.close();
		}
		
		return returnObject;
	}
	
	
	//prints both the feeding queue and the sales list
	//prints after almost all transactions/feedings
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
