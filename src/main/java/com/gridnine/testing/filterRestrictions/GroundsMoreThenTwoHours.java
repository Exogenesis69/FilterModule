package com.gridnine.testing.filterRestrictions;

import com.gridnine.testing.flightClassses.Flight;
import com.gridnine.testing.flightClassses.Segment;
import com.gridnine.testing.flightFilter.Filter;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class GroundsMoreThenTwoHours implements Filter {
    private static List<Flight> list = new ArrayList<>();
    private long timeOnTheGround = 0;
    @Override
    public List<Flight> filter(List<Flight> flightList) {
        for (Flight flight : flightList) {
                List<Segment> segments = flight.getSegments();

                if (segments.size() > 1) {
                    for (int i = 0; i < segments.size() - 1; i++) {
                        timeOnTheGround += Math.abs(Duration.between(segments.get(i).getArrivalDate(), segments.get(i + 1).getDepartureDate()).toHours());
                    }
                    if (timeOnTheGround <= 2) {
                        list.add(flight);
                    }
                }
            }
            return list;
        }
    }
