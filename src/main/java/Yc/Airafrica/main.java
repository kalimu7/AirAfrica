package Yc.Airafrica;

import Yc.Airafrica.Dao.ClientDao;
import Yc.Airafrica.Database.DatabaseConnection;
import Yc.Airafrica.Model.Client;
import Yc.Airafrica.Model.Flight;
import Yc.Airafrica.Service.AdminService;
import Yc.Airafrica.Service.FlightService;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class main {
        public static void main(String args[]){

                DatabaseConnection.getInstance().getConnection();

                FlightService flightService = new FlightService();
                LocalDate date = LocalDate.parse("2023-10-23");
                List<Flight> flights =  flightService.searchFlihgt("casablanca","paris",date);
                for(Flight fl : flights){
                        System.out.println(fl.getDeparturecity());
                        System.out.println(fl.getPrice());
                }



        }
}
