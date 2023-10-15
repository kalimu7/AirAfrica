package Yc.Airafrica.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "admin")
public class Admin {

    @Id
    @Column(name="email")
    private String email;
    @Column(name="password")
    private String password;

    public Admin(String email, String password) {
        super();
        this.email = email;
        this.password = password;
    }
    public Admin(){

    }

    //insert an admin into db test only;

}
