package com.SpringCapstone.repository;

import java.util.HashMap;
import java.util.Map;
import com.SpringCapstone.domain.Flight;

public class FlightRepositoryImpl implements FlightRepository{

	public FlightRepositoryImpl() {
		//TODO Auto-generated constructor stub
	}

	private static int count = 1001;
	
	private static Map<Integer, Flight> flightMap = new HashMap();

	public void save(Flight flight) {
		flight.setFlightId(count++);
		flightMap.put(flight.getFlightId(), flight);
	}

	public Flight getFlightDetails(int flightId) {
		return flightMap.get(flightId);
	}
}
