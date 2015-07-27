package com.epam.borshch.transport.additional;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.epam.borshch.transport.db.model.DriverModel;

/**
 * DriverForHireListGenerator
 * 
 * + contains methods, that randomly generates list of 10 drivers.
 * 
 * @author Slavko
 *
 */

public class DriversForHireListGenerator {

	private static String[] names = new String[] { "Igor", "Stepan", "Leon", "Weider", "Niger", "Les", "Lev", "Ditrich",
			"Semen", "Ivan", "Taras", "Petro" };

	public static List<DriverModel> generate() {
		List<DriverModel> driverList = new ArrayList<>();
		
		for(int i =0; i< 10; i++){
			driverList.add(new DriverModel());
			driverList.get(i).setName(nameGen());
			driverList.get(i).setAge(new Random().nextInt(30)+30);
			driverList.get(i).setExperienceLevel(new Random().nextInt(8)+1);
			driverList.get(i).setTelephoneNumber(""+(new Random().nextInt(999))+"-"+(new Random().nextInt(99))+"-"+(new Random().nextInt(99)));
			driverList.get(i).setTransportMastery(transportGen());
			driverList.get(i).setTransportId(0);
			driverList.get(i).setSalary(new Random().nextInt(5000)+2000);
		}		
		return driverList;
	}

	private static String nameGen() {
		StringBuffer name = new StringBuffer();
		name.append(names[new Random().nextInt(names.length - 1)] + " ");
		name.append(names[new Random().nextInt(names.length - 1)] + "ovych");
		return name.toString();
	}

	private static String transportGen() {

		String result = null;
		int i = new Random().nextInt(3);
		switch (i) {
		case 0:
			result = "bus";
			break;
		case 1:
			result = "tram";
			break;
		case 2:
			result = "trolley";
		}

		return result;
	}
}
