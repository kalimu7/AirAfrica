package Yc.Airafrica.Servlet;

import Yc.Airafrica.Service.AdminService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.hibernate.Session;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AdminServlet", value = "/SAdmin")
public class AdminServlet extends HttpServlet {
    private AdminService adminService;
    public void init(){
        this.adminService = new AdminService();
    }

    private void dashboardAdmin(HttpServletRequest request, HttpServletResponse response) {
        try {
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
    private void createFlight(HttpServletRequest request, HttpServletResponse response) {
        try {
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("createFlight.jsp");
            dispatcher.forward(request,response);

        }catch (IOException | ServletException e){
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
                case "create":
                createFlight(request,response);
                break;
                case "update":
                break;
                case "delete":
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
            case "showCreate":
                break;
            case "Showupdate":
                break;
            case "showDelete":
                break;
            case "selectAll":
                //dashboardAdmin(request,response);
                break;
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

}