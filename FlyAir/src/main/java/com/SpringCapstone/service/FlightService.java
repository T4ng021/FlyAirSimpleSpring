package com.SpringCapstone.service;

import com.SpringCapstone.domain.Flight;

public interface FlightService {

	public void addFlight(Flight flight);
	public Flight searchFlight(int flightId);
}
