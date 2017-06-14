public class UberTester {

	public static void main(String[] args) {
		System.out.println("Creating Ubercars and UberRiders");
		UberCar c1 = new UberCar ("Williams","Main St");
		UberCar c2 = new UberCar ("Thomas","Broadway");
		UberCar c3 = new UberCar ("Richards","South Ave");
		
		UberRider r1 = new UberRider ("Main St", "Broadway");
		UberRider r2 = new UberRider ("Broadway", "Fifth Ave");
		UberRider r3 = new UberRider ("Fifth Ave","Main St");
		
		System.out.println("Riders Requesting Rides");
		if (r1.requestRide(c1))
			System.out.println("Thank you for riding with " + c1.getName());
		else
			if (r1.requestRide(c2))
				System.out.println("Thank you for riding with " + c2.getName());
			else
				if (r1.requestRide(c3))
					System.out.println("Thank you for riding with " + c3.getName());
				else
					System.out.println("Sorry no Uber cars in your area");
		if (r2.requestRide(c1))
			System.out.println("Thank you for riding with " + c1.getName());
		else
			if (r2.requestRide(c2))
				System.out.println("Thank you for riding with " + c2.getName());
			else
				if (r2.requestRide (c3))
					System.out.println("Thank you for riding with " + c3.getName());
				else
					System.out.println("Sorry no Uber cars in your area");		
		
		if (r3.requestRide(c1))
			System.out.println("Thank you for riding with " + c1.getName());
		else
			if (r3.requestRide(c2))
				System.out.println("Thank you for riding with " + c2.getName());
			else
				if (r3.requestRide (c3))
					System.out.println("Thank you for riding with " + c3.getName());
				else
					System.out.println("Sorry no Uber cars in your area");	
		System.out.println(c1 + "\n" + c2 + "\n" + c3);
		c1.hasArrived(r1.getEndLoc());
		System.out.println("  c1 has arrived to Broadway");
		if (r3.requestRide(c1))
			System.out.println("Thank you for riding with " + c1.getName());
		else
			if (r3.requestRide(c2))
				System.out.println("Thank you for riding with " + c2.getName());
			else
				if (r3.requestRide (c3))
					System.out.println("Thank you for riding with " + c3.getName());
				else
					System.out.println("Sorry no Uber cars in your area");	
		c2.hasArrived(r2.getEndLoc());
		System.out.println("  c2 has arrived to Fifth Ave");
		if (r3.requestRide(c1))
			System.out.println("Thank you for riding with " + c1.getName());
		else
			if (r3.requestRide(c2))
				System.out.println("Thank you for riding with " + c2.getName());
			else
				if (r3.requestRide (c3))
					System.out.println("Thank you for riding with " + c3.getName());
				else
					System.out.println("Sorry no Uber cars in your area");	
		
		System.out.println("\n" + c1 + "\n\n" + c2 + "\n\n"+ c3 );
	}

}
