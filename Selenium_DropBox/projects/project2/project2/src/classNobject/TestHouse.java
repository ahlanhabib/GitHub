package classNobject;

public class TestHouse { // starting of class body

	
	public static void main(String[] args) { //starting of main method body
		
	    House whiteHouse = new House();
		whiteHouse.createBedRoom();
		whiteHouse.address = 32;
		System.out.println("Address : " + whiteHouse.address);
		whiteHouse.houseName = "President's House";
		System.out.println("Name of the White House is : " + whiteHouse.houseName);
		
		Office office = new Office();
		office.myOfficeSpace();
		
		House keyaHouse = new House();
		keyaHouse.name = "private House";
		System.out.println("Key's House is located in NYC: " + keyaHouse.name);
		
		int number = 10;
		System.out.println(number);
		
		int result = keyaHouse.addTwoNumber(10, 20,30);
		System.out.println(result);
		
		SpaceMission.displayMission();
		
		SpaceMission spaceMission = new SpaceMission("Venus Mission", 15);
		System.out.println(spaceMission.missionName);
		spaceMission.setSpaceMissionValue("Mars Mission", 20);
		
		spaceMission.displayEngine();
		

	} // end of main method

}//end of class
