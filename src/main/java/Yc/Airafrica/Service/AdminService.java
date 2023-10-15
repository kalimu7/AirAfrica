package Yc.Airafrica.Service;

import Yc.Airafrica.Dao.AdminDao;

public class AdminService {

    private AdminDao adminDao;
    public AdminService(){
        this.adminDao = new AdminDao();
    }

    public boolean AdminAuth(String email,String password){
        boolean isLoged = this.adminDao.loginAdmin(email,password);
        return isLoged;
    }
}
