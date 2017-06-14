public class Reservation{
	private String name;
	private String roomNum;

	public Reservation(String nam, String num){
		name = nam;
		roomNum = num;
	}
	public String getName(){return name;}
	public String getRoomNumber(){return roomNum;}
	public String toString(){return roomNum + ": " + name;}
}