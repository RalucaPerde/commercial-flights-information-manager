package ro.siit.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "airlines")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Airline {

    @Id
    @Column
    @GeneratedValue
    private Long id;

    @Column(name = "airline_name")
    private String airlineName;

    @Column
    private String country;

    @Column
    private String iata;

    @Column
    private String icao;
}

