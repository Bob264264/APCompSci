import java.util.List;
import java.util.ArrayList;

public class HotelReservation{
	private final String[] roomNumbers = {"100A", "101A", "102A", "103A", "104A", "105A"};
 	private Reservation [] rooms;
 	private List<String> waitList;

 	public HotelReservation(){
 		rooms = new Reservation[roomNumbers.length];
 		waitList = new ArrayList<String>();
 	}
 	public Reservation requestRoom (String name){
 		for (int i = 0; i < rooms.length; i++)
 			if (rooms[i] == null){
 				rooms[i] = new Reservation(name, roomNumbers[i]);
 				return rooms[i];
 			}
 		waitList.add(name);
 		return null;
 	}
 	public Reservation cancelReassign(String name){
 		for (int i = 0; i < rooms.length; i++)
 			if (rooms[i].getName().equals(name)){
 				if (waitList.size() > 0){
 					rooms[i] = new Reservation(waitList.get(0), rooms[i].getRoomNumber());
 					waitList.remove(0);
 				}
 				else
 					rooms[i] = null;
				return rooms[i];
			}
		return null;
 	}
 	public String toString() {
		String out = "Hotel Rooms:\n";
		for (int i = 0; i < rooms.length; i++)
			if (rooms[i] != null)
				out += rooms[i] + "\n";
			else
				out += roomNumbers[i] + ": -------\n";
		out += "Waitlist:\n";
		for (String n : waitList)
			out+=n + "\n";
		return out;
	}

	public static void main(String[] args){
		HotelReservation hotel = new HotelReservation();
		hotel.requestRoom("Matthews");
		System.out.println(hotel);
		hotel.requestRoom("Williams");
		hotel.requestRoom("Hanford");
		hotel.requestRoom("Tompkins");
		System.out.println(hotel);
		hotel.requestRoom("Ryan");
		hotel.requestRoom("Alex");
		hotel.requestRoom("Alex2");
		hotel.requestRoom("Alex3");
		hotel.requestRoom("Brian");
		System.out.println(hotel);
		hotel.cancelReassign("Williams");
		hotel.cancelReassign("Tompkins");
		hotel.cancelReassign("Alex");
		System.out.println(hotel);
		hotel.cancelReassign("Alex3");
		System.out.println(hotel);
	}
}
