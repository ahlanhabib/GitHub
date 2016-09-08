package classNobject;

public class House {

	public int address = 20;
	String houseName = "" ;
	String name;
	char letter = 'G';
	
	public void createBedRoom(){
		this.name = "downing street";
		System.out.println(name);
	}
	public void createKithcn(){
		System.out.println("we need to cook in the kitchen");
	}
	
	public void watchGameOfThrones(){
		System.out.println("we can watch movie and series....");
	}
	
	public int addTwoNumber(int num1, int num2, int num3){
		int total = num1 + num2 + num3;
		
		return total;
	}
	
	
}
