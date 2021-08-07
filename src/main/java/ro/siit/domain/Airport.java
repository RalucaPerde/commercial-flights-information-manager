package ro.siit.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "airports", uniqueConstraints = {@UniqueConstraint(
        name = "unique_airport_name", columnNames = {"airport_name"})})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Airport {

    @Id
    @Column
    @GeneratedValue
    private Long id;

    @Column(name = "airport_name")
    private String airportName;

    @Column
    private String city;

    @Column
    private String country;

    @Column
    private String iata;

    @Column
    private String icao;

    @Column
    private String latitude;

    @Column
    private String longitude;
}

