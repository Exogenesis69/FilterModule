package com.gridnine.testing.flightFilter;

import com.gridnine.testing.flightClassses.Flight;

import java.util.List;

public interface Filter {
    List<Flight> filter(List<Flight> flightList);
}
