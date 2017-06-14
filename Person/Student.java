public class Student extends Person {
	private String StuID;
	private double StuGPA;

	public Student (String n, int a, char gender, String id, double gpa){
		super (n, a, gender);
		StuID = id;
		StuGPA = gpa;
	}
	public String getIDNum() { return StuID;}
	public double getGPA() { return StuGPA;}
	public void setIDNum(String id) { StuID = id;}
	public void setGPA(double gpa) { StuGPA = gpa;}
	
	public String toString() {
		return super.toString() + "StudentID: "+ StuID + ", GPA: " + StuGPA + "\n"; 
	}
}