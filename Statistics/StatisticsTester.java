public class StatisticsTester{
	public static void main(String[] args){
		Statistics test = new Statistics();
		System.out.println("Min: " + test.getMin());
		System.out.println("Max: " + test.getMax());
		System.out.println("Average: " + test.getAverage());
		System.out.println("Standard Deviation: " + test.getStdDev());

		test.displayHistogram();
		System.out.println(test);
	}
}