public class Person {
	private String pName;
	private int pAge;
	private char pGender;

	public Person (String n, int a, char g) {
		pName = n;
		pAge = a;
		pGender = g;
	}
	public String getName() { return pName; }
	public int getAge() { return pAge;}
	public char getGender() { return pGender;}
	public void setName (String n) {pName = n; }
	public void setAge (int a) {pAge = a; }
	public void setGender (char g) { pGender = g;}
	
	public String toString () {
		return pName + ", Age: " + pAge + ", Gender: " + pGender + "\n"; 
	}
}