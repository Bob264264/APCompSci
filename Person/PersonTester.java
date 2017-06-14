public class PersonTester{
	public static void main(String[] args){
		Person jay = new Person ("Jay", 35, 'M');
		System.out.println(jay);
		Student amy = new Student ("Amy", 15, 'F', "123321", 3.4);
		System.out.println(amy);
		Teacher james = new Teacher ("Gosling", 53, 'M', "Computer Science", 35);
		System.out.println(james);
		CollegeStudent aaron = new CollegeStudent ("Aaron", 18, 'M', "99099", 3.9,"Senior", "Computer Engineering", 2016);
		System.out.println(aaron);
		CollegeStudent c1 = new CollegeStudent ("Aaron",18, 'M', "99099",3.9,"Freshman", "Computer Engineering",2016);
		CollegeStudent c2 = new CollegeStudent ("Baron",19, 'M', "19191",3.9,"Sophomore", "Computer Engineering",2016);
		CollegeStudent c3 = new CollegeStudent ("Caren",20, 'F', "54321",3.9,"Junior", "Computer Engineering",2016);
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		System.out.println(c1.compareTo(c2));
		// Employable c = new CollegeStudent("Ron", 24, 'M', "123123", 4.0, "Sophomore", "Applied Physics", 2017);
		// Employable t = new Teacher("Matthew", 54, 'M', "Biochemistry", 20);
		// System.out.println(getBirthYear(c, 2017));
	}
	private static int getBirthYear(Employable e, int yr){
		return yr - ((Person)e).getAge();
	}
}