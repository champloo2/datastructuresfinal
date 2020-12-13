package object;

import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatter;

public class Tarantula implements Comparable<Tarantula> {
	
	String nameId;
	double size;
	LocalDateTime lastFeedDate;
	public Tarantula(String nameId, double size) {
		super();
		this.nameId = nameId;
		this.size = size;
		setLastFeedDate();
	}
	
	
	public LocalDateTime getLastFeedDate() {
		return lastFeedDate;
	}
	//the feed time is automatically set to the current date/time
	public void setLastFeedDate() {	
		   LocalDateTime now = LocalDateTime.now();  
		this.lastFeedDate = now;
	}
	//can be called to update size
	//Since tarantulas grow when they molt, it is assumed
	//that with each molt, it grows by 30%, an alternative to having the user input the new size
	public void growTarantula() {
		this.size = this.size*1.3;
	}
	
	//prioritized for feeding first if it is smaller
	@Override
	public int compareTo(Tarantula t) {
		if (this.size < t.size)
			return 1;
		else if(this.size > t.size)
			return -1;
		else return 0;
	}
	
	public String printTarantulaData() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		return "item ID: " + this.nameId + " size: " + this.size + " last feed date: " + dtf.format(this.lastFeedDate);
	}
	
	
	
	

}
