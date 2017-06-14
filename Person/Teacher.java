public class Teacher extends Person implements Employable {
	private String subject;
	private int yearsExp;

	public Teacher (String n, int age, char gender, String s, int yr){
		super (n, age, gender);
		subject = s;
		yearsExp = yr;
	}
	public String getSubject() { return subject;}
	public int yearsExp() { return yearsExp;}
	public void setSubject(String s) { subject = s;}
	public void setYearsExp(int yr) { yearsExp = yr;}
	public boolean isEmployable(){
		return yearsExp > 5 && this.getAge() > 22;
	}
	
	public String toString() {
		return super.toString() + "Subject: "+ subject + ", Years Experience: " + yearsExp + "\n"; 
	}
}