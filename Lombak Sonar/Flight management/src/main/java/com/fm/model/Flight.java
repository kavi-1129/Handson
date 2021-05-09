package com.fm.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Flight {

	private String id;
	private String flightType;
	private List<Passenger> passengers = new ArrayList<Passenger>();
	
	public boolean addPassenger(Passenger passenger) {
		if (flightType.equalsIgnoreCase("business")) {
			// If flight is business only VIP passengers added
			if (!passenger.isVip())
				return false;
		}
		passengers.add(passenger);
		return true;
	}

	public boolean removePassenger(Passenger passenger) {
		if (passenger.isVip())
			return false;

		passengers.remove(passenger);
		return true;
	}
}