package com.project.softwareengineerinng.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateReservationDTO implements Serializable {
    private Integer reservationNumber;
    private LocalDate startDate;
    private LocalDate endDate;
    private Double totalPrice;
    private Integer numberOfGuests;
    private List<Integer> roomNumbers;
}
