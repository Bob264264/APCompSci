import java.util.List;
import java.util.ArrayList;

public class SeatingTester{
	public static void main(String[] arg){
		List<Student> juniors = new ArrayList<Student>();
		String[] names = {"Anna", "Ben", "Caren", "David", "Evan",
						  "Fran", "Gina", "Holly", "Irene", "Justin"};
		int[] absences = {3, 1, 4, 1, 5, 9, 2, 6, 1, 3};
		for (int i = 0; i < names.length; i++)
			juniors.add(new Student(names[i],absences[i]));
		SeatingChart room213 = new SeatingChart(juniors, 3, 4);
		room213.removeAbsentStudents(4);
		room213.switchSeats (1,3,2,2);
		room213.switchSeats (1,1,2,2);
		System.out.println(room213);
	}
}