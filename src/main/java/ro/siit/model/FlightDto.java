package ro.siit.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FlightDto {


    @NotBlank
    private String flightNo;

    @NotNull
    private LocalDate departure;

    @NotNull
    private LocalDate arrival;

    @NotNull
    private Long departureAirportId;

    @NotNull
    private Long arrivalAirportId;

    @NotNull
    private Long airportId;

    @NotNull
    private Long airlineId;

    public FlightDto(final String flightNo, final LocalDate departure, final LocalDate arrival,
                     final Long departureAirportId, final Long arrivalAirportId, final Long airlineId) {
        this.flightNo = flightNo;
        this.departure = departure;
        this.arrival = arrival;
        this.departureAirportId = departureAirportId;
        this.arrivalAirportId = arrivalAirportId;
        this.airlineId = airlineId;
    }
}

