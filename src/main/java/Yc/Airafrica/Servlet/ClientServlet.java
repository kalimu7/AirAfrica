package Yc.Airafrica.Servlet;
import Yc.Airafrica.Model.Booking;
import Yc.Airafrica.Model.Client;
import Yc.Airafrica.Model.Flight;
import Yc.Airafrica.Service.ClientService;
import Yc.Airafrica.Service.FlightService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "ClientServlet", value = "/Client")
public class ClientServlet extends HttpServlet {
    private ClientService clientService;
    private FlightService flightService;
    public void init() {
        this.clientService = new ClientService();
        this.flightService = new FlightService();
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws  IOException {
        String action = request.getParameter("action");
        PrintWriter out = response.getWriter();
        //out.println(action);
        switch (action){
            case "insert":
            InsertClient(request,response);
            break;
            case "login":
            loginClient(request,response);
            break;
            case "Search":
            searchFlight(request,response);
            break;
            case "book":

            BookFlight(request,response);
            break;
        }
    }

    private void BookFlight(HttpServletRequest request, HttpServletResponse response) {
        try {

            PrintWriter out = response.getWriter();
            out.println("hello world ");
            HttpSession session = request.getSession();
            UUID clientid = (UUID) session.getAttribute("code") ;
            LocalDate todaydate = LocalDate.now();
            String flightid = request.getParameter("flightid");
            UUID fid = UUID.fromString(flightid);



            Client client = new Client();
            client.setCode(clientid);
            Flight flight = new Flight();
            flight.setFlightid(fid);
            Booking booking = new Booking();
            booking.setClient(client);
            booking.setFlight(flight);
            booking.setReservationdate(todaydate);

            boolean added =  this.flightService.bookflight(booking);
            if(added){
                out.println("booked successfully");
            }else{
                out.println("cant make the booking");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void searchFlight(HttpServletRequest request, HttpServletResponse response) {

        try {
            PrintWriter out = response.getWriter();
            String departureCity = request.getParameter("from");
            String arrivalCity = request.getParameter("to");
            String date =  request.getParameter("when");
            LocalDate departureDate;
            if(date.isEmpty()){
                departureDate = null;
            }else{
                departureDate = LocalDate.parse(date);
            }

            List<Flight> flights = this.flightService.searchFlihgt(departureCity,arrivalCity,departureDate);
            request.setAttribute("data",flights);
            for(Flight fl : flights){
                out.println(fl.getArrivalcity());
                out.println(fl.getPrice());
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
            dispatcher.forward(request,response);

        }catch (Exception e){
            e.printStackTrace();
        }

    }


    public void destroy() {
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws  IOException {


        String action = request.getParameter("action");
        PrintWriter out = response.getWriter();

        switch (action){
            case "signup":
                ShowClientSignupForm(request,response);
                break;
            case "signin":
                ShowClientFormLogin(request,response);
                break;
            case "adminAuth":
                ShowAdminAuthPage(request,response);
                break;
            case "home":
                showhomepage(request,response);
                break;

        }

    }

    private void showhomepage(HttpServletRequest request, HttpServletResponse response) {
        try {
            RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
            dispatcher.forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    private void ShowAdminAuthPage(HttpServletRequest request, HttpServletResponse response) {
        try {
            String baseUrl = "http://localhost:8080/AirAfrica_war_exploded/";
            request.setAttribute("baseUrl",baseUrl);
            RequestDispatcher dispatcher = request.getRequestDispatcher("adminAuth.jsp");
            dispatcher.forward(request,response);
        }catch (ServletException | IOException e){
            e.printStackTrace();
        }
    }

    private void ShowClientSignupForm(HttpServletRequest request, HttpServletResponse response) {
        try{
            String baseUrl = "http://localhost:8080/AirAfrica_war_exploded/";
            request.setAttribute("baseUrl",baseUrl);
            RequestDispatcher dispatcher = request.getRequestDispatcher("userSignUpForm.jsp");
            dispatcher.forward(request,response);
        }catch(ServletException | IOException e){
            e.printStackTrace();
        }
    }

    private void ShowClientFormLogin(HttpServletRequest request, HttpServletResponse response) {
        try{
            String baseUrl = "http://localhost:8080/AirAfrica_war_exploded/";
            request.setAttribute("baseUrl",baseUrl);
            RequestDispatcher dispatcher = request.getRequestDispatcher("userSigninForm.jsp");
            dispatcher.forward(request,response);
        }catch(ServletException | IOException e){
            e.printStackTrace();
        }
    }

    private void InsertClient(HttpServletRequest request, HttpServletResponse response) throws  IOException{

        PrintWriter out = response.getWriter();
        String passport = request.getParameter("passport");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");
        Client client = new Client(password,firstName,lastName,email,phone);
        boolean isCreated = this.clientService.createClient(client);
        if(isCreated){
            out.println("created successfully");
        }else{
            out.println("there is a problem");
        }

    }

    private void loginClient(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession();
        try{
            String passport = request.getParameter("email");
            String password = request.getParameter("password");
            Client client =  this.clientService.login(passport,password);
            PrintWriter out = response.getWriter();
            if (client == null) {
                out.println("canot login");
            }else{
                out.println("login successfully");
                out.println("welcome back " + client.getFirstname());
                session.setAttribute("code",client.getCode());
                session.setAttribute("ClientAuth",true);

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}