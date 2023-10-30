package Yc.Airafrica;

import Yc.Airafrica.Dao.ClientDao;
import Yc.Airafrica.Dao.FlightDao;
import Yc.Airafrica.Database.DatabaseConnection;
import Yc.Airafrica.Model.Client;
import Yc.Airafrica.Model.Flight;
import Yc.Airafrica.Service.AdminService;
import Yc.Airafrica.Service.FlightService;
import Yc.Airafrica.Util.HibernateUtil;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class main {
        public static void main(String args[]) {

                DatabaseConnection.getInstance().getConnection();

                //HibernateUtil.getSessionFactory().getCurrentSession();
                FlightDao flightDao = new FlightDao();
                FlightDao flightDao1 = new FlightDao();
                System.out.println("first one " + flightDao);
                System.out.println("first one " + flightDao1);

        }
}
