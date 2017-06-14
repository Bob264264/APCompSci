public class CookieOrderTester{
	public static void main(String[] arg){
		MasterOrder myOrder = new MasterOrder();
		System.out.println ("There are " + myOrder.getTotalBoxes() + " boxes of cookies" );
		myOrder.addOrder (new CookieOrder ("Thin Mints", 1));
		myOrder.addOrder (new CookieOrder ("Samoas", 4));
		myOrder.addOrder (new CookieOrder ("Tagalongs", 5));
		myOrder.addOrder (new CookieOrder ("Thin Mints", 10));
		myOrder.addOrder (new CookieOrder ("Samoas", 5));
		myOrder.addOrder (new CookieOrder ("Shortbread", 7));
		myOrder.addOrder (new CookieOrder ("Shortbread", 3));
		myOrder.addOrder (new CookieOrder ("Trefoils", 4));
		System.out.println ("There are " + myOrder.getTotalBoxes() + " boxes of cookies" );
		System.out.println ("Complete List - " + myOrder);
		System.out.println (myOrder.removeVariety("Tagalongs") +  " removed. ");
		System.out.println (myOrder.removeVariety("Shortbread")+ " removed. ");
		System.out.println (myOrder.removeVariety ("Trefoils") + " removed. ");
		System.out.println (myOrder.removeVariety ("Samoas") + " removed. " );
		System.out.println ("There are " + myOrder.getTotalBoxes() + " boxes of cookies" );
		System.out.println ("Complete list: " + myOrder);
	}
}