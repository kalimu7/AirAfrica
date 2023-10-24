package Yc.Airafrica.Dao;

import Yc.Airafrica.Model.Booking;
import Yc.Airafrica.Model.Flight;
import Yc.Airafrica.Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class FlightDao {
    private boolean added;
    public boolean create(Flight flight){
        this.added = false;
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            session.save(flight);
            transaction.commit();
            this.added = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return this.added;
    }
    public Flight fetchToupdate(UUID uuid){

        Transaction transaction = null;
        try{
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            Flight flight = session.get(Flight.class, uuid);
            transaction.commit();
            if (flight != null) {
                return flight;
            }


        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public boolean update(Flight flight) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            Flight flight1 = session.get(Flight.class,flight.getFlightid());
            flight1.setDeparturecity(flight.getDeparturecity());
            flight1.setDeparturedate(flight.getDeparturedate());
            flight1.setDeparturetime(flight.getDeparturetime());
            flight1.setArrivaldate(flight.getArrivaldate());
            flight1.setArrivalcity(flight.getArrivalcity());
            flight1.setArrivaltime(flight.getArrivaltime());
            flight1.setPrice(flight.getPrice());

            session.update(flight1);
            transaction.commit();
            session.close();
            return true;

        }catch (Exception e){
            e.printStackTrace();
        }
        return false;

    }
    public List<Flight> FetchAllFlight(){

        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            Query<Flight> query = session.createQuery("from Flight ");
            List<Flight> flights = query.list();
            transaction.commit();
            return flights;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public boolean delete(UUID flightid){
        Transaction transaction = null;
        try{
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            Flight flight = session.get(Flight.class,flightid);
            if(flight != null){
                session.delete(flight);
                transaction.commit();
                return true;
            }else {
                return false;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public List<Flight> searchFlight(String departurecity, String arrivalCity, LocalDate date){
        Transaction transaction = null;
        try{

            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            Query<Flight> query = null;
            transaction = session.beginTransaction();
            if(date == null){
                query =  session.createQuery("from Flight f where f.departurecity = :dcity and f.arrivalcity = :acity ",Flight.class).setParameter("dcity",departurecity).setParameter("acity",arrivalCity);
            }else{
                query =  session.createQuery("from Flight f where f.departurecity = :dcity and f.arrivalcity = :acity and f.departuredate = :date ",Flight.class).setParameter("dcity",departurecity).setParameter("acity",arrivalCity).setParameter("date",date);
            }
            List<Flight> flights = query.list();
            transaction.commit();
            return flights;

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public boolean bookflight(UUID flight,UUID clientid,LocalDate reservationdate){
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            session.save(Booking.class);


        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }


}
