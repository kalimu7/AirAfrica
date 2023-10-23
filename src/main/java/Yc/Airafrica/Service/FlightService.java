package Yc.Airafrica.Service;

import Yc.Airafrica.Dao.FlightDao;
import Yc.Airafrica.Model.Flight;

import java.time.LocalDate;
import java.util.List;

public class FlightService {
    private FlightDao flightDao;
    public FlightService(){
        this.flightDao = new FlightDao();
    }
    public List<Flight> searchFlihgt(String departurecity, String arrivalCity, LocalDate date){

        return this.flightDao.searchFlight(departurecity,arrivalCity,date);
    }
}
