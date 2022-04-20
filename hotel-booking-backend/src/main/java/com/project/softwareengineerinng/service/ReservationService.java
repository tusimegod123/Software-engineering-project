package com.project.softwareengineerinng.service;

import com.project.softwareengineerinng.dto.CreateReservationDTO;
import com.project.softwareengineerinng.model.Reservation;

import java.util.List;

public interface ReservationService {
    public abstract List<Reservation> getReservations();
    public abstract void saveReservation(Reservation reservation);
    public abstract Reservation getReservationById(Long reservationId);

    Reservation createReservation(CreateReservationDTO reservationDTO);
}
