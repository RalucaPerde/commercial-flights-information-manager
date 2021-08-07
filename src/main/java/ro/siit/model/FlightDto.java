package ro.siit.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FlightDto {

    @NotNull
    private Long id;

    @NotBlank
    private String flightNo;

    @NotEmpty
    private String departure;

    @NotEmpty
    private String arrival;

    @NotNull
    private Long departureAirportId;

    @NotNull
    private Long arrivalAirportId;

    private Long airportId;

    @NotNull
    private Long airlineId;


    public FlightDto(final String flightNo, final String departure, final String arrival, final Long departureAirportId,
                     final Long arrivalAirportId, final Long airlineId) {
        this.flightNo = flightNo;
        this.departure = departure;
        this.arrival = arrival;
        this.departureAirportId = departureAirportId;
        this.arrivalAirportId = arrivalAirportId;
        this.airlineId = airlineId;
    }

    public FlightDto(final Long id, final String flightNo, final String departure, final String arrival, final Long departureAirportId,
                     final Long arrivalAirportId, final Long airlineId) {
        this.id = id;
        this.flightNo = flightNo;
        this.departure = departure;
        this.arrival = arrival;
        this.departureAirportId = departureAirportId;
        this.arrivalAirportId = arrivalAirportId;
        this.airlineId = airlineId;
    }
}

