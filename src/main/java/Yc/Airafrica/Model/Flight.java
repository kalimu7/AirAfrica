package Yc.Airafrica.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "flight")
public class Flight {

    @Id
    @GeneratedValue
    private UUID flightid;

    @Column(name = "departurecity")
    private  String departurecity;

    @Column(name = "arrivalcity")
    private String arrivalcity;

    @Column(name = "departuredate")
    private LocalDate departuredate;

    @Column(name = "departuretime")
    private LocalTime departuretime;

    @Column(name = "arrivaldate")
    private LocalDate arrivaldate;

    @Column(name = "arrivaltime")
    private LocalTime arrivaltime;

    @Column(name = "seatcapacity")
    private int seatcapacity = 30;


    @OneToMany(mappedBy = "flight",fetch = FetchType.EAGER)
    private List<Booking> bookings;


    public Flight() {

    }

    @Column(name = "price")
    private float price;

    public Flight(String departurecity, String arrivalcity, LocalDate departuredate, LocalTime departuretime, LocalDate arrivaldate, LocalTime arrivaltime,float price) {
        this.departurecity = departurecity;
        this.arrivalcity = arrivalcity;
        this.departuredate = departuredate;
        this.departuretime = departuretime;
        this.arrivaldate = arrivaldate;
        this.arrivaltime = arrivaltime;
        this.price = price;
    }
}
