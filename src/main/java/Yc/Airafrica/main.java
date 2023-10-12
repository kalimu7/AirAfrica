package Yc.Airafrica;

import Yc.Airafrica.Dao.adminDao;
import Yc.Airafrica.Database.DatabaseConnection;
import Yc.Airafrica.Model.admin;

import java.util.Scanner;

public class main {
        public static void main(String args[]){
                DatabaseConnection.getInstance().getConnection();
                Scanner scanner = new Scanner(System.in);

                //add a Admin
                System.out.println("enter email");
                String email = scanner.nextLine();
                System.out.println("enter Password");
                String ps = scanner.nextLine();
                admin admin = new admin(email,ps);
                adminDao adminDao = new adminDao();
                adminDao.saveAdmin(admin);

        }
}
