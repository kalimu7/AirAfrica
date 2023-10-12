package Yc.Airafrica.Dao;

import Yc.Airafrica.Util.HibernateUtil;
import Yc.Airafrica.Model.admin;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class adminDao {
    public void saveAdmin(admin admin){
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(admin);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
