package Yc.Airafrica.Service;

import Yc.Airafrica.Dao.BookingDao;
import Yc.Airafrica.Dao.FlightDao;
import Yc.Airafrica.Model.Booking;
import Yc.Airafrica.Model.Flight;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class FlightService {
    private FlightDao flightDao;
    private BookingDao bookingdao;
    public FlightService(){
        this.bookingdao = new BookingDao();
        this.flightDao = new FlightDao();
    }
    public List<Flight> searchFlihgt(String departurecity, String arrivalCity, LocalDate date){

        return this.flightDao.searchFlight(departurecity,arrivalCity,date);
    }

    public boolean bookflight(Booking booking){
        return this.bookingdao.addBooking(booking);
    }

}
