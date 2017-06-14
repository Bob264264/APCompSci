public class CollegeStudent extends Student implements Comparable<CollegeStudent>, Employable{
	private String year;
	private String major;
	private int projectedGradYear;

	public CollegeStudent(String n, int a, char gender, String id, double gpa, String yr, String mj, int gYr){
		super(n, a, gender, id, gpa);
		year = yr;
		major = mj;
		projectedGradYear = gYr;
	}

	public String getYear() { return year;}
	public String getMajor() { return major;}
	public int getProjectedGradYear() { return projectedGradYear;}
	public void setYear(String yr) { year = yr;}
	public void setMajor(String mj) { major = mj;}
	public void setProjectedGradYear(int gYr) { projectedGradYear = gYr;}
	public boolean isEmployable(){
		return this.getGPA() > 2.5 && (this.getAge() >= 18 && this.getAge() <= 22);
	}

	public int compareTo(CollegeStudent c){
		return this.getName().compareTo(c.getName());
	}
	
	public String toString() {
		return super.toString() + "Year: "+ year + ", Major: "+ major + ", Projected Graduation Year: " + projectedGradYear + "\n"; 
	}
}