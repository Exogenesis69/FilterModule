package com.gridnine.testing.filterRestrictions;

import com.gridnine.testing.flightClassses.Flight;
import com.gridnine.testing.flightClassses.Segment;
import com.gridnine.testing.flightFilter.Filter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ArrivalBeforeDeparture implements Filter {

    private static List<Flight> list = new ArrayList<>();

    @Override
    public List<Flight> filter(List<Flight> flightList) {
        for (Flight flight : flightList) {
            if (flight.getSegments().size() == 1) {//Перелет состоит из одного сегмента

                LocalDateTime arrival = flight.getSegments().get(0).getArrivalDate();
                LocalDateTime departure = flight.getSegments().get(0).getDepartureDate();

                if (arrival.isAfter(departure))
                    list.add(flight);
            } else {
                List<Segment> segmentList = flight.getSegments();// Перелет состоит из нескольких сегментов

                for (int i = 0; i < segmentList.size() - 1; i++) {
                    LocalDateTime arrival = segmentList.get(i).getArrivalDate();
                    LocalDateTime departure = segmentList.get(i).getDepartureDate();
                    LocalDateTime nextDeparture = segmentList.get(i + 1).getDepartureDate();

                    if (arrival.isAfter(departure) || nextDeparture.isAfter(arrival))
                        list.add(flight);
                }
            }
        }
        return list;
    }
}


