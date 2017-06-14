import java.util.List;
import java.util.ArrayList;

public class StackPlus2{
	private List<String> myList;
	public StackPlus2(){myList = new ArrayList<String>();}
	public void push(String s){myList.add(s);}
	public String pop(){return myList.remove(myList.size()-1);}
	public String top(){return myList.get(myList.size()-1);}
	public boolean isEmpty(){return myList.size() == 0;}
	public int getSize(){return myList.size();}
	public void duplicate(int n){
		StackPlus temp = new StackPlus();
		for (int i = myList.size()-1; i > n; i--)
			temp.push(this.pop());
		temp.push(this.top());
		while (temp.getSize() > 0)
			this.push(temp.pop());
	}
	public void swap(int n){
		StackPlus temp = new StackPlus();
		String top = this.pop();
		for (int i = myList.size()-1; i > n; i--)
			temp.push(this.pop());
		String bottom = this.pop();
		this.push(top);
		while (temp.getSize() > 0)
			this.push(temp.pop());
		this.push(bottom);
	}
	public String toString(){
		String out = "";
		for (int i = myList.size()-1; i >= 0; i--)
			out += myList.get(i) + "\n";
		return out;
	}
	public static void main(String[] args){
		String[] words = {"hi", "there", "how", "are", "you"};
		StackPlus myStack = new StackPlus();
		for (String s:words)
			myStack.push(s);
		System.out.println(myStack);
		myStack.swap(2);
		System.out.println(myStack);
		myStack.duplicate(3);
		System.out.println(myStack);
		myStack.duplicate(3);
		System.out.println(myStack);
		while (!myStack.isEmpty()){
			myStack.pop();
			System.out.println(myStack);
		}
	}
}