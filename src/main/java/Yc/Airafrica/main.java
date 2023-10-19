package Yc.Airafrica;

import Yc.Airafrica.Dao.ClientDao;
import Yc.Airafrica.Database.DatabaseConnection;
import Yc.Airafrica.Model.Client;
import Yc.Airafrica.Service.AdminService;

import java.util.Scanner;

public class main {
        public static void main(String args[]){
                DatabaseConnection.getInstance().getConnection();

                AdminService adminService = new AdminService();
                adminService.AdminAuth("admin@admin.com","admin");


        }
}
