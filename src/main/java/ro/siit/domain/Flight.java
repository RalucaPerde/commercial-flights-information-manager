package ro.siit.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "flights")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Flight {

    @Id
    @Column
    @GeneratedValue
    private Long id;

    @Column(name = "flight_no")
    private String flightNo;

    @Column
    private LocalDateTime departure;

    @Column
    private LocalDateTime arrival;

    @ManyToOne
    @JoinColumn(name = "airport_departure_id", referencedColumnName = "id")
    private Airport departureAirport;

    @ManyToOne
    @JoinColumn(name = "airport_arrival_id", referencedColumnName = "id")
    private Airport arrivalAirport;

    @ManyToOne
    @JoinColumn(name = "airline_id", referencedColumnName = "id")
    private Airline airline;
}

