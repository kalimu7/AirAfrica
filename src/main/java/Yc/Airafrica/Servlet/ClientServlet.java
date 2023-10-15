package Yc.Airafrica.Servlet;
import Yc.Airafrica.Dao.ClientDao;
import Yc.Airafrica.Model.Client;
import Yc.Airafrica.Service.ClientService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ClientServlet", value = "/Client")
public class ClientServlet extends HttpServlet {
    private ClientService clientService;
    public void init() {
        this.clientService = new ClientService();
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
            case "loginAdmin":
            loginAdmin(request,response);
            break;
        }
    }

    private void loginAdmin(HttpServletRequest request, HttpServletResponse response) {

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
        Client client = new Client(passport,firstName,lastName,email,phone);
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