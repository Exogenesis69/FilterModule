package com.gridnine.testing;

import com.gridnine.testing.filterRestrictions.ArrivalBeforeDeparture;
import com.gridnine.testing.filterRestrictions.FlightToTheCurrentPointInTime;
import com.gridnine.testing.filterRestrictions.GroundsMoreThenTwoHours;
import com.gridnine.testing.flightClassses.Flight;
import com.gridnine.testing.flightClassses.FlightBuilder;
import com.gridnine.testing.flightFilter.FilterBuilder;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Flight> flights = FlightBuilder.createFlights();

           FilterBuilder filterBuilder = new FilterBuilder();
           filterBuilder.setFlights(flights);

           filterBuilder.setFilter(new ArrivalBeforeDeparture());
           print(filterBuilder.returnFilter());

           filterBuilder.setFilter(new FlightToTheCurrentPointInTime());
           print(filterBuilder.returnFilter());

           filterBuilder.setFilter(new GroundsMoreThenTwoHours());
           print(filterBuilder.returnFilter());
    }
    public static void print (List<Flight> list) {
        list.forEach(System.out::println);
    }
}
