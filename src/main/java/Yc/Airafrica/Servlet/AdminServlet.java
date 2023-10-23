package Yc.Airafrica.Servlet;

import Yc.Airafrica.Model.Flight;
import Yc.Airafrica.Service.AdminService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "AdminServlet", value = "/SAdmin")
public class AdminServlet extends HttpServlet {
    private AdminService adminService;
    public void init(){
        this.adminService = new AdminService();
    }

    private void dashboardAdmin(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<Flight> flights =  this.adminService.fetchFlights();
            request.setAttribute("data",flights);
            RequestDispatcher dispatcher = request.getRequestDispatcher("adminDashboard.jsp");
            dispatcher.forward(request, response);
        }catch (ServletException | IOException e){
            e.printStackTrace();
        }
    }

    private void ShowAdminAuthPage(HttpServletRequest request, HttpServletResponse response) {
        try {
            PrintWriter out = response.getWriter();
            out.println("hello");
            String baseUrl = "http://localhost:8080/AirAfrica_war_exploded/";
            request.setAttribute("baseUrl",baseUrl);
            RequestDispatcher dispatcher = request.getRequestDispatcher("adminAuth.jsp");
            dispatcher.forward(request,response);
        }catch (ServletException | IOException e){
            e.printStackTrace();
        }
    }
    private void showCreateFlight(HttpServletRequest request, HttpServletResponse response) {
        try {
            RequestDispatcher dispatcher = request.getRequestDispatcher("createFlight.jsp");
            dispatcher.forward(request,response);
        }catch (IOException | ServletException e){
            e.printStackTrace();
        }
    }
    private void showupdate(HttpServletRequest request, HttpServletResponse response) {
        try{

            PrintWriter out = response.getWriter();
            String id = request.getParameter("id");
            out.println("the id is " + id);
            UUID flightid = UUID.fromString(id);
            Flight flight = this.adminService.fetchupdate(flightid);
            RequestDispatcher dispatcher = request.getRequestDispatcher("updateFlight.jsp");
            request.setAttribute("data",flight);
            dispatcher.forward(request,response);
            out.println(flight.getDeparturecity());

        }catch (IOException  | ServletException e){
            e.printStackTrace();
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
            String action = request.getParameter("action");
            PrintWriter out = response.getWriter();
            out.println(action);

            switch (action){
                case "login":
                ShowAdminAuthPage(request,response);
                break;
                case "showCreate":
                showCreateFlight(request,response);
                break;
                case "Showupdate":
                showupdate(request,response);
                break;
                case "delete":
                //deleteflight(request,response);
                break;
                case "selectAll":

                break;
                case "Dashboard":
                dashboardAdmin(request,response);
                break;
            }
    }




    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");
        switch (action){
            case "authAdmin":
                AuthAdmin(request,response);
                break;
            case "create":
                createFlight(request,response);
                break;
            case "update":
                updateFlight(request,response);
                break;
            case "delete":
                deleteflight(request,response);
                break;
            case "selectAll":
                //dashboardAdmin(request,response);
                break;
        }
    }

    private void updateFlight(HttpServletRequest request, HttpServletResponse response) {
        try{
           PrintWriter out = response.getWriter();
           DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:MM");
           String id = request.getParameter("flightid");
           //UUID flightid = UUID.fromString(id);
           String departureCity = request.getParameter("departureCity");
           String arrivalCity = request.getParameter("arrivalCity");
           LocalDate dateDeparture = LocalDate.parse(request.getParameter("departureDate"));
           LocalTime timeDeparture  = LocalTime.parse(request.getParameter("departureTime"),formatter);
           LocalDate dateArrival = LocalDate.parse(request.getParameter("departureDate"));
           LocalTime timeArrival  = LocalTime.parse(request.getParameter("arrivalTime"),formatter);
           float price = Float.parseFloat(request.getParameter("price"));
           Flight flight = new Flight();
           flight.setFlightid(UUID.fromString(id));
           flight.setDeparturecity(departureCity);
           flight.setDeparturedate(dateDeparture);
           flight.setDeparturetime(timeDeparture);
           flight.setArrivaldate(dateArrival);
           flight.setArrivalcity(arrivalCity);
           flight.setArrivaltime(timeArrival);
           flight.setPrice(price);

           boolean added = this.adminService.updateFlight(flight);
           if(added){
               out.println("updated successfully");
           }else{
               out.println("there must be a problem");
           }

        }catch (IOException e){
            e.printStackTrace();
        }

    }

    private void createFlight(HttpServletRequest request, HttpServletResponse response) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:MM");

            String departureCity = request.getParameter("departureCity");
            String arrivalCity = request.getParameter("arrivalCity");
            LocalDate dateDeparture = LocalDate.parse(request.getParameter("departureDate"));
            LocalTime timeDeparture  = LocalTime.parse(request.getParameter("departureTime"),formatter);
            LocalDate dateArrival = LocalDate.parse(request.getParameter("departureDate"));
            LocalTime timeArrival  = LocalTime.parse(request.getParameter("arrivalTime"),formatter);
            float price = Float.parseFloat(request.getParameter("price"));
            PrintWriter out = response.getWriter();



            Flight flight = new Flight(departureCity,arrivalCity,dateDeparture,timeDeparture,dateArrival,timeArrival,price);
            boolean added = this.adminService.create(flight);
            if(added){
                out.println("added successfully");
            }else{
                out.println("there is a problem");
            }

        }catch (IOException e){
            e.printStackTrace();
        }


    }

    private void AuthAdmin(HttpServletRequest request, HttpServletResponse response) {
        try {
            PrintWriter out = response.getWriter();
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            boolean isLoged = this.adminService.AdminAuth(email, password);
            out.println("email " + email);
            out.println("password " + password);
            request.setAttribute("baseUrl","http://localhost:8080/AirAfrica_war_exploded/");

            HttpSession session = request.getSession();
            if (isLoged == true) {
                request.setAttribute("baseUrl","http://localhost:8080/AirAfrica_war_exploded/");
                out.println("loged in successfully");
                session.setAttribute("adminSession", true);
                response.sendRedirect("http://localhost:8080/AirAfrica_war_exploded/SAdmin?action=Dashboard");
                //RequestDispatcher dispatcher = request.getRequestDispatcher("adminDashboard.jsp");
                //dispatcher.forward(request, response);
            } else {
                out.println("cant log in");
                session.setAttribute("adminSession", false);
                session.setAttribute("warning","something doesnt match");
                response.sendRedirect("http://localhost:8080/AirAfrica_war_exploded/SAdmin?action=login");
                //RequestDispatcher dispatcher = request.getRequestDispatcher("adminAuth.jsp");
                //dispatcher.forward(request,response);
            }
        }catch ( IOException e){
            e.printStackTrace();
        }
    }
    private void deleteflight(HttpServletRequest request, HttpServletResponse response) {
        try{

            PrintWriter out = response.getWriter();
            String id = request.getParameter("id");
            UUID idflight = UUID.fromString(id);
            boolean deleted = this.adminService.delete(idflight);
            if(deleted){
                out.println("deleted successfully");
            }else{
                out.println("cant be deleted");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}