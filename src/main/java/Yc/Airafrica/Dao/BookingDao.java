package Yc.Airafrica.Dao;

import Yc.Airafrica.Model.Booking;
import Yc.Airafrica.Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
}
