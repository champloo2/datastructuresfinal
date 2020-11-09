package object;

public class Tarantula {
	
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
	
	
	
	

}
