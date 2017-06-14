public class UberCar{
	private String name, location;
	private boolean available;

	public UberCar(String nm, String loca){
		name = nm;
		location = loca;
		available = true;
	}

	public void setName(String nm){name = nm;}

	public String getName(){return name;}

	public void setLocation(String loca){location = loca;}

	public String getLocation(){return location;}

	public boolean isAvailable(){return available;}

	public void setUnavail(){available = false;}

	public void hasArrived(String loca){
		location = loca;
		available = true;
	}

	public String toString(){
		return "Driver's Name: " + name + "\nLocation: " + location +
		 "\nAvailable?: " + available;
	}
}