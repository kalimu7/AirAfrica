package Yc.Airafrica.Model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "booking")
public class Booking {

    @Id
    @GeneratedValue
    @Column(name = "bookingid")
    private UUID code;


    @ManyToOne
    @JoinColumn(name = "clientid")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "flightid")
    private Flight flight;

    @Column(name = "reservationdate")
    private LocalDate reservationdate;




}
