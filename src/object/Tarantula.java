package object;


public class Tarantula implements Comparable<Tarantula> {
	
	String nameId;
	int size;
	int lastFeedDate;
	public Tarantula(String nameId, int size, int lastFeedDate) {
		super();
		this.nameId = nameId;
		this.size = size;
		this.lastFeedDate = lastFeedDate;
	}
	public int getLastFeedDate() {
		return lastFeedDate;
	}
	public void setLastFeedDate(int lastFeedDate) {
		this.lastFeedDate = lastFeedDate;
	}
	//can be called to update size
	public void setSize(int s) {
		this.size = s;
	}
	
	//prioritized for feeding first if it is smaller
	@Override
	public int compareTo(Tarantula t) {
		if (size < t.size)
			return 1;
		else if(size > t.size)
			return -1;
		else return 0;
	}
	
	
	
	

}
