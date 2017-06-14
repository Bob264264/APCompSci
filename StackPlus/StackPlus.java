import java.util.List;
import java.util.ArrayList;

public class StackPlus{
	private List<String> myList;
	public StackPlus(){myList = new ArrayList<String>();}
	public StackPlus(String[] n){
		this();
		for (String i:n) myList.add(i);
	}
	public StackPlus(List<String> n){
		this();
		for (String i:n) myList.add(i);
	}
	public void push(String o){myList.add(o);}
	public String pop(){return myList.remove(myList.size()-1);}
	public String top(){return myList.get(myList.size()-1);}
	public boolean isEmpty(){return (myList.size() == 0);}
	public int getSize(){return myList.size();}
	public void duplicate(int n){myList.add(n, myList.get(n));}
	public void swap(int n){
		myList.add(n,this.pop());
		this.push(myList.remove(n+1));
	}
	public String toString(){
		String out = "";
		for (int i = myList.size()-1; i >= 0; i--)
			out += myList.get(i) + "\n";
		return out;
	}
	public static void main(String[] args){
		String[] words = {"hi", "there", "how", "are", "you"};
		StackPlus myStack = new StackPlus(words);
		System.out.println(myStack);
		myStack.swap(2);
		System.out.println(myStack);
		myStack.duplicate(3);
		myStack.duplicate(3);
		System.out.println(myStack);
	}
}