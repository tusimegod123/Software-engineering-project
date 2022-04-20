//package com.project.softwareengineerinng.service.Impl;
//
//import com.project.softwareengineerinng.dto.CreateReservationDTO;
//import com.project.softwareengineerinng.model.Reservation;
//import com.project.softwareengineerinng.model.Room;
//import com.project.softwareengineerinng.repository.ReservationRepository;
//import com.project.softwareengineerinng.service.ReservationService;
//import com.project.softwareengineerinng.service.RoomService;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class ReservationServiceImpl implements ReservationService {
//    @Autowired
//    private RoomService roomService;
//    @Autowired
//    ModelMapper modelMapper;
//
//    private ReservationRepository reservationRepository;
//
//    public ReservationServiceImpl(ReservationRepository reservationRepository) {
//        this.reservationRepository = reservationRepository;
//    }
//
//    @Override
//    public List<Reservation> getReservations() {
//        return reservationRepository.findAll();
//    }
//
//    @Override
//    public void saveReservation(Reservation reservation) {
//        reservationRepository.save(reservation);
//    }
//
//    @Override
//    public Reservation getReservationById(Long reservationId) {
//        return reservationRepository.getById(reservationId);
//    }
//
//    @Override
//    public Reservation createReservation(CreateReservationDTO reservationDTO) {
//        Reservation reservation = modelMapper.map(reservationDTO, Reservation.class);
//        reservationRepository.save(reservation);
//
//        reservationDTO.getRoomNumbers().forEach(roomNumber -> {
//            var room = roomService.findByRoomNumber(roomNumber);
//            if(room!=null) reservation.addRoom(room);
//        });
//        return reservationRepository.save(reservation);
//    }
//}
