package Yc.Airafrica.Dao;

import Yc.Airafrica.Model.Booking;
import Yc.Airafrica.Model.Flight;
import Yc.Airafrica.Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.UUID;

public class BookingDao {
    private boolean added;
    public boolean addBooking(Booking booking){

        try {

            this.added = false;
            Transaction transaction = null;
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            session.save(booking);
            transaction.commit();
            this.added = true;

        }catch (Exception e){
            e.printStackTrace();
        }
        return this.added;
    }

    public boolean decreaseflight(Flight flight, int seats ){
        try{
            Transaction transaction = null;
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            Flight flight1 =  session.get(Flight.class,flight.getFlightid());
            flight1.setSeatcapacity(flight.getSeatcapacity() - seats );
            session.update(flight1);
            transaction.commit();
            return true;

        }catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }

}
