package Yc.Airafrica.Service;

import Yc.Airafrica.Dao.ClientDao;
import Yc.Airafrica.Model.Client;

import Yc.Airafrica.Model.Flight;
import org.mindrot.jbcrypt.BCrypt;

import java.util.List;


public class ClientService {
    private ClientDao clientDao;
    private boolean isSaved;
    public ClientService(){
        this.clientDao = new ClientDao();
    }
    public boolean createClient(Client client){
        this.isSaved = false;
        try{

                String hashedPassword = BCrypt.hashpw(client.getPassword(),BCrypt.gensalt());
                client.setPassword(hashedPassword);
                this.clientDao.SaveClient(client);
                this.isSaved = true;

        }catch (Exception e){
            e.printStackTrace();
        }
        return this.isSaved;
    }
    public Client login(String email,String password){
        Client client = this.clientDao.Login(email,password);
        return client;

    }
    public List<Flight> searchFlight(String departureCity,String arrivalCity){

        return null;
    }
}
