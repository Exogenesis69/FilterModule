package com.gridnine.testing.filterRestrictions;


import com.gridnine.testing.flightClassses.Flight;
import com.gridnine.testing.flightClassses.Segment;
import com.gridnine.testing.flightFilter.Filter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//исключить вылет до текущего момента времени
public class FlightToTheCurrentPointInTime implements Filter {
    private static List<Flight> list = new ArrayList<>();

    @Override
    public List<Flight> filter(List<Flight> flightList) {
        for (Flight flight : flightList) {
            for (Segment seg : flight.getSegments()) {
                if (seg.getDepartureDate().isBefore(LocalDateTime.now())) {
                    list.add(flight);
                }
            }
        }
        return list;
    }
}
