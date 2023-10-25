package Yc.Airafrica.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Setter
@Getter
@Table(name = "booking")
public class Booking {


    @Id
    @GeneratedValue
    @Column(name = "bookingid")
    private UUID code;


    @ManyToOne
    @JoinColumn(name = "clientid",referencedColumnName = "code")
    private Client client;


    @ManyToOne
    @JoinColumn(name = "flightid",referencedColumnName = "flightid")
    private Flight flight;


    @Column(name = "reservationdate")
    private LocalDate reservationdate;



}
