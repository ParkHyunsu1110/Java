package java_2020_11_25_3;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Building park = new Building();
		Building heo = new Building();
		Building gil = new Building();
		
		park.setAddress("경기도 화성시" );
		heo.setAddress("경기도 수원시");
		gil.setAddress("경기도 오산시");
		
		park.setMailNumber("18206-2");
		heo.setMailNumber("18202-1");
		gil.setMailNumber("18503");
		
		park.setHost("박현수");
		heo.setHost("허유림");
		gil.setHost("길지현");
		
		park.setheight(15);
		heo.setheight(70);
		gil.setheight(9);
		
		park.setMaxFloor(5);
		heo.setMaxFloor(14);
		gil.setMaxFloor(3);
		
		ArrayList<Building> buildingInfo = new ArrayList<>();
		buildingInfo.add(park);
		buildingInfo.add(heo);
		buildingInfo.add(gil);
		
		for(int i=0; i<buildingInfo.size(); i++) {
			System.out.println(buildingInfo.get(i).getMailNumber());
		}
	}
}
