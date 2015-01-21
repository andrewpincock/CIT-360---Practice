package net.codyconder.beans.carbean;

import java.util.ArrayList;

public class GarageBean implements java.io.Serializable {

	ArrayList<CarBean> parking = new ArrayList<CarBean>();
	
	public void addCar (CarBean aCar) {
		parking.add(aCar);
	}
	
	public ArrayList<CarBean> getCarList () {
		return parking;
	}
}
