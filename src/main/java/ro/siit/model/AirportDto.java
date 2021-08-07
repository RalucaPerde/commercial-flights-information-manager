package ro.siit.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AirportDto {

    @NotNull
    private Long id;

    @NotBlank
    private String airportName;

    @NotBlank
    private String city;

    @NotBlank
    private String country;

    @NotBlank
    private String iata;

    @NotBlank
    private String icao;

    @NotBlank
    private String latitude;

    @NotBlank
    private String longitude;

    public AirportDto(final String airportName) {
        this.airportName = airportName;
    }

    public AirportDto(String airportName, String city, String country, String iata, String icao, String latitude, String longitude) {
        this.airportName = airportName;
        this.city = city;
        this.country = country;
        this.iata = iata;
        this.icao = icao;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}

