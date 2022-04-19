package com.project.softwareengineerinng.service.Impl;

import com.project.softwareengineerinng.model.Reservation;
import com.project.softwareengineerinng.repository.ReservationRepository;
import com.project.softwareengineerinng.service.ReservationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {
    private ReservationRepository reservationRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public List<Reservation> getReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public void saveReservation(Reservation reservation) {
        reservationRepository.save(reservation);
    }

    @Override
    public Reservation getReservationById(Long reservationId) {
        return reservationRepository.getById(reservationId);
    }
}
