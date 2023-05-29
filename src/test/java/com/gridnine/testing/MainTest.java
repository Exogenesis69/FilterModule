package com.gridnine.testing;

import com.gridnine.testing.filterRestrictions.ArrivalBeforeDeparture;
import com.gridnine.testing.filterRestrictions.FlightToTheCurrentPointInTime;
import com.gridnine.testing.filterRestrictions.GroundsMoreThenTwoHours;
import com.gridnine.testing.flightClassses.Flight;
import com.gridnine.testing.flightFilter.FilterBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

class MainTest {

    List<Flight> testFlights;
    FilterBuilder filterBuilder = new FilterBuilder();

        @BeforeEach
        void setUp() {
            testFlights = TestData.getList();

        }

        @AfterEach
        void tearDown() {
            testFlights = null;
        }

        @Test
        public void FlightToTheCurrentPointTime(){
            filterBuilder.setFlights(testFlights);
            filterBuilder.setFilter(new FlightToTheCurrentPointInTime());
            List<Flight> expected = new ArrayList<>();
            List<Flight> actual = filterBuilder.returnFilter();
            Assertions.assertIterableEquals(expected, actual);
        }

        @Test
        public void ArrivalBeforeDeparture() {
            filterBuilder.setFlights(testFlights);
            filterBuilder.setFilter(new ArrivalBeforeDeparture());
            List<Flight> expected = new ArrayList<>();
            List<Flight> actual = filterBuilder.returnFilter();
            Assertions.assertIterableEquals(expected, actual);
        }

        @Test
        public void GroundTimeMoreThanTwoHours() {
            filterBuilder.setFilter(new GroundsMoreThenTwoHours());
            filterBuilder.setFlights(testFlights);
            List<Flight> expected = new ArrayList<>();
            List<Flight> actual = filterBuilder.returnFilter();
            Assertions.assertIterableEquals(expected, actual);
        }
    }