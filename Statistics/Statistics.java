public class Statistics{
	int[] rolls;
	int min, max;
	double average, stdDev;
	public Statistics(){
		rolls = new int[1000];
		rollDice();
		calcStats();
	}

	private void rollDice(){
		for (int i = 0; i < rolls.length; i++)
			rolls[i] = (int)(Math.random()*6)+(int)(Math.random()*6)+(int)(Math.random()*6)+3;
	}
	private void calcStats(){
		int smallest = 999;
		int biggest = -1;
		int sum = 0;
		for (int i:rolls){
			if (i < smallest) smallest = i;
			if (i > biggest) biggest = i;
			sum+=i;
		}
		min = smallest;
		max = biggest;
		average = (double)sum/rolls.length;
		sum = 0;
		for (int i:rolls)
			sum += Math.pow((i-average), 2);
		stdDev = Math.sqrt((double)sum/rolls.length);
	}

	public int getMin(){return min;}
	public int getMax(){return max;}
	public double getAverage(){return average;}
	public double getStdDev(){return stdDev;}

	public void displayHistogram(){
		int[] freq = new int[19];
		for (int i:rolls)
			freq[i]++;
		System.out.println("Histogram:");
		for(int i = 3; i < freq.length; i++){
			System.out.printf("%2d | %3d | ", i, freq[i]);
			for (int j = 0; j < (freq[i]+4)/5; j++)
				System.out.print("*");
			System.out.println();
		}
	}

	public String toString(){
		String out = "";
		int count = 1;
		out+="Data:\n";
		for (int i:rolls){
			if (i < 10)
				out+=" ";
			out+=i;
			out+=" ";
			if (count % 25 == 0)
				out+="\n";
			count++;
		}
		return out;
	}

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