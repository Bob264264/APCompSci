import java.util.List;
public class SeatingChart{
	private Student[][] seats;
	public SeatingChart(List<Student> studentList, int rows, int cols){
		seats = new Student[rows][cols];
		for(int c = 0, i = 0; c < cols; c++)
			for (int r = 0; r < rows; r++, i++)
				if (i < studentList.size())
					seats[r][c] = studentList.get(i);
				else
					break;
	}
	public int removeAbsentStudents(int maxAbsent){
		int count = 0;
		for(int r = 0; r < seats.length; r++)
			for (int c = 0; c < seats[r].length; c++)
				if (seats[r][c] != null && seats[r][c].getAbsenceCount() > maxAbsent){
					seats[r][c] = null;
					count++;
				}
		return count;
	}
	public boolean switchSeats(int row1, int col1, int row2, int col2){
		if (seats[row1][col1] == seats[row2][col2])
			return false;
		Student temp = seats[row1][col1];
		seats[row1][col1] = seats[row2][col2];
		seats[row2][col2] = temp;
		return true;
	}
	public boolean isValidRow(int r){
		return (0 <= r && r < seats.length);
	}
	public boolean isValidCol(int c){
		return (0 <= c && c < seats[0].length);
	}
	public String toString(){
		int maxLength = 0;
		for (Student[]  row : seats)
			for (Student s : row)
				if (String.valueOf(s).length() > maxLength)
					maxLength = String.valueOf(s).length();
		String out = "";
		for (Student[]  row : seats){
			for (Student s : row){
				out += s;
				for (int i = 0; i < (maxLength + 3 - String.valueOf(s).length()); i++)
					out += " ";
			}
			out += "\n";
		}
		return out;
	}
}