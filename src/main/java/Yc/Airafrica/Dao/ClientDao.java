package Yc.Airafrica.Dao;

import Yc.Airafrica.Model.Client;
import Yc.Airafrica.Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.mindrot.jbcrypt.BCrypt;

public class ClientDao {
    private boolean isSaved;
    public boolean  SaveClient(Client client){
        this.isSaved = false;
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(client);
            transaction.commit();
            this.isSaved = true;
        }catch (Exception e){
            e.printStackTrace();
            this.isSaved = false;
        }
        return this.isSaved;
    }
    public Client Login(String passportnumber,String password){
        Client client = new Client();
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            client = (Client) session.createQuery(" from Client c where c.email = :email ").setParameter("email",passportnumber).uniqueResult();
            transaction.commit();
            if(client != null && BCrypt.checkpw(password,client.getPassword())){
                return client;
            }else{
                return null;
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return client;
    }
}
