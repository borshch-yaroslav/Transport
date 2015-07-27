package com.epam.borshch.transport.additional;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.epam.borshch.transport.db.model.TransportModel;

/**
 *TransportToBuyListGenerator
 * 
 * + contains methods, that randomly generates list of 20 transports to buy.
 * 
 * @author Slavko
 *
 */

public class TransportToBuyListGenerator {

	public static List<TransportModel> generate() {
		List<TransportModel> transportList = new ArrayList<>();
		
		for(int i =0; i< 20; i++){
			transportList.add(new TransportModel());
			transportList.get(i).setType(typeGen());
			transportList.get(i).setRouteNumber(0);
			transportList.get(i).setCapacity(new Random().nextInt(50)+20);
			transportList.get(i).setModel(""+(new Random().nextInt(432))+" "+(new Random().nextInt(9459))+"-"+(new Random().nextInt(99)));
			transportList.get(i).setYear(new Random().nextInt(25)+1990);
			transportList.get(i).setUpkeep(new Random().nextInt(300)+200);
			transportList.get(i).setDriverId(0);
			transportList.get(i).setValue(new Random().nextInt(9000)+1000);
		}		
		return transportList;
	}

	private static String typeGen() {

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
