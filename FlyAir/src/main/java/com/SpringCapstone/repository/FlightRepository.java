package com.SpringCapstone.repository;

import com.SpringCapstone.domain.Flight;



public interface FlightRepository {

	public void save(Flight flight) ;
	public Flight getFlightDetails(int flightId);
	
}
