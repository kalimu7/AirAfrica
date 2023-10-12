package Yc.Airafrica.Model;

import javax.persistence.*;

@Entity
@Table(name = "admin")
public class admin {

    @Id
    @Column(name="email")
    private String email;
    @Column(name="password")
    private String password;

    public admin(String email, String password) {
        super();
        this.email = email;
        this.password = password;
    }
    public admin(){

    }

    //insert an admin into db test only;

}
