package Yc.Airafrica.Service;

import Yc.Airafrica.Dao.AdminDao;
import Yc.Airafrica.Dao.FlightDao;
import Yc.Airafrica.Model.Flight;

import java.util.List;
import java.util.UUID;

public class AdminService {

    private AdminDao adminDao;
    private FlightDao flightDao;
    public AdminService(){
        this.adminDao = new AdminDao();
        this.flightDao = new FlightDao();
    }

    public boolean AdminAuth(String email,String password){
        boolean isLoged = this.adminDao.loginAdmin(email,password);
        return isLoged;
    }
    public boolean create(Flight flight){
        boolean added = this.flightDao.create(flight);
        return added;
    }
    public Flight fetchupdate(UUID flightid){
        return this.flightDao.fetchToupdate(flightid);
    }
    public boolean updateFlight(Flight flight){
        return this.flightDao.update(flight);

    }

    public List<Flight> fetchFlights(){
        return  this.flightDao.FetchAllFlight();
    }
    public boolean delete(UUID flightid){
        return this.flightDao.delete(flightid);
    }


}
