package Yc.Airafrica;

import Yc.Airafrica.Dao.ClientDao;
import Yc.Airafrica.Database.DatabaseConnection;
import Yc.Airafrica.Model.Client;

import java.util.Scanner;

public class main {
        public static void main(String args[]){
                DatabaseConnection.getInstance().getConnection();
                Scanner scanner = new Scanner(System.in);

                //add a Admin

                Client client = new Client("fzefz","karim","mahjour","zefzef@mail.com","98765456");
                ClientDao clientDao = new ClientDao();
                clientDao.SaveClient(client);

        }
}
