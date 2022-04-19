package com.project.softwareengineerinng.controller;

import com.project.softwareengineerinng.model.Reservation;
import com.project.softwareengineerinng.service.ReservationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {
    private ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }
    @GetMapping
    public List<Reservation> getReservations(){
        return reservationService.getReservations();
    }
    @PostMapping("/")
    public void saveReservation(@RequestBody Reservation reservation){
        reservationService.saveReservation(reservation);
    }
    @GetMapping("/{reservationId}")
    public Reservation getReservationById(@PathVariable Long reservationId){
        return reservationService.getReservationById(reservationId);
    }





}
