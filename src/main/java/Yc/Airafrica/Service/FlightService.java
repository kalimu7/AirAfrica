package Yc.Airafrica.Service;

import Yc.Airafrica.Dao.FlightDao;
import Yc.Airafrica.Model.Flight;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class FlightService {
    private FlightDao flightDao;
    public FlightService(){
        this.flightDao = new FlightDao();
    }
    public List<Flight> searchFlihgt(String departurecity, String arrivalCity, LocalDate date){

        return this.flightDao.searchFlight(departurecity,arrivalCity,date);
    }

    public boolean bookflight(UUID flight,UUID clientid,LocalDate reservationdate){
        return false;
    }

}
