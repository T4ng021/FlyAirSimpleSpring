package com.SpringCapstone.service;

import com.SpringCapstone.domain.Flight;
import com.SpringCapstone.repository.FlightRepository;
import com.SpringCapstone.repository.FlightRepositoryImpl;

public class FlightServiceImpl implements FlightService{
	
	private FlightRepository fl = new FlightRepositoryImpl();

	public void addFlight(Flight flight) {
		fl.save(flight);
	}

	public Flight searchFlight(int flightId) {
		return fl.getFlightDetails(flightId);
	}

}
