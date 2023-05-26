package com.gridnine.testing;

import com.gridnine.testing.flightClassses.Flight;
import com.gridnine.testing.flightClassses.FlightBuilder;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Flight> flights = FlightBuilder.createFlights();
        //System.out.println(flights);
    }
}
