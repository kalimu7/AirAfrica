package Yc.Airafrica.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "client")
public class Client {



    @Id
    @GeneratedValue
    @Column(name = "code")
    private UUID code;

    @Column(name = "password")
    private String password;

    @Column(name ="firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "email")
    private String email;

    @Column (name = "phone")
    private String phone;

    @OneToMany(mappedBy = "client",fetch = FetchType.EAGER)
    private List<Booking> bookings;


    public Client(String password , String firstname , String lastname , String email , String phone) {

        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
    }

    public Client() {

    }
}
