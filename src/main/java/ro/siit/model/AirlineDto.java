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
public class AirlineDto {

    @NotNull
    private Long id;

    @NotBlank
    private String airlineName;

    @NotBlank
    private String country;

    @NotBlank
    private String iata;

    @NotBlank
    private String icao;
}

