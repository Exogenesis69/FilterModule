package com.gridnine.testing;

import com.gridnine.testing.flightClassses.Flight;
import com.gridnine.testing.flightClassses.Segment;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static java.time.LocalDateTime.of;

public class TestData {
    public static final LocalDateTime requestedDate = of(2023,5,28,15,00);

    public static final Segment seg1 = new Segment(of(2023,5,28,16,00),
            of(2023,5,28,18,00));

    public static final Segment seg2 = new Segment(of(2023,5,26,13,00),
            of(2023,5,25,18,00));

    public static final Segment seg3 = new Segment(of(2023,5,28,16,00),
            of(2023,5,28,18,00));

    public static final Segment seg4 = new Segment(of(2023,5,28,19,00),
            of(2023,5,28,23,00));

    public static final Segment seg5 = new Segment(of(2023,5,29,01,00),
            of(2023,5,29,10,00));

    public static final Segment seg6 = new Segment(of(2023,5,28,16,00),
            of(2023,5,28,11,00));


    public static final Flight fl1 = new Flight(Arrays.asList(seg1));

    public static final Flight fl2 = new Flight(Arrays.asList(seg2));

    public static final Flight fl3 = new Flight(Arrays.asList(seg3, seg4));

    public static final Flight fl4 = new Flight(Arrays.asList(seg3, seg4, seg5));

    public static final Flight fl5 = new Flight(Arrays.asList(seg6));

    public static List<Flight> getList() {
        return Arrays.asList(fl1,fl2,fl3,fl4,fl5);
    }
}
