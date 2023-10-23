package Yc.Airafrica.Dao;

import Yc.Airafrica.Util.HibernateUtil;
import Yc.Airafrica.Model.Admin;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.mindrot.jbcrypt.BCrypt;



public class AdminDao {
    private boolean isLoged;

    public boolean loginAdmin(String email,String password){
        this.isLoged = false;
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            Admin admin = (Admin) session.createQuery("from Admin a where a.email = :email").setParameter("email",email).uniqueResult();

            if(admin != null && BCrypt.checkpw(password, admin.getPassword())){
                this.isLoged = true;
            }else{
                this.isLoged = false;
            }
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
        return this.isLoged;
    }

}
