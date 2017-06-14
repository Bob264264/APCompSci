public class UberRider{
	private String startLoc, endLoc;

	public UberRider(String start, String end){
		startLoc = start;
		endLoc = end;
	}

	public void setStartLoc(String loca){startLoc = loca;}

	public String getStartLoc(){return startLoc;}

	public void setEndLoc(String loca){endLoc = loca;}

	public String getEndLoc(){return endLoc;}

	public boolean requestRide(UberCar r){
		if (startLoc.equals(r.getLocation()) && r.isAvailable()){
			r.setUnavail();
			return true;
		}
		return false;
	}

	public String toString(){
		return "Starting Location: " + startLoc + "\nDestination Location: " + endLoc;
	}
}