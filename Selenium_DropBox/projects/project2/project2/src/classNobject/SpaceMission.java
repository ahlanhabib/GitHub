package classNobject;

public class SpaceMission {
	String missionName;
	int numberOfMission;
	
	//Constructor 1
	
	public SpaceMission(){
	}
	
	//constructor 2
	public SpaceMission(String missionName){
		this.missionName = missionName;
		System.out.println(missionName);
	}
	//Constructor 3
	public SpaceMission(String missionName, int numberOfMission){
		this.missionName = missionName;
		this.numberOfMission = numberOfMission;
		System.out.println(missionName + "  number of mission: "+ numberOfMission);
	}
	
	public void setSpaceMissionValue(String missionName, int numberOfMission){
		this.missionName = missionName;
		this.numberOfMission = numberOfMission;
		System.out.println(missionName + "  number of mission: "+ numberOfMission);
	}

	public static void displayMission(){
		System.out.println(" space flight lift off");
	}
	
	public void displayEngine(){
		System.out.println(" Engine lift off");
	}	
	
}
