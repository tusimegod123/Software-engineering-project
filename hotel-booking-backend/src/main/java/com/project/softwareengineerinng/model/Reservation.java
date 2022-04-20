package com.project.softwareengineerinng.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@Data
@Entity
@Table(name = "reservations")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reservationId;
    private Integer reservationNumber;
    private LocalDate startDate;
    private LocalDate endDate;
    private Double totalPrice;
    private Integer numberOfGuests;
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL,mappedBy = "reservation")
    List<Room> rooms;

    public Reservation(Integer reservationNumber, LocalDate startDate, LocalDate endDate,
                       Double totalPrice, Integer numberOfGuests) {
        this.reservationNumber = reservationNumber;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalPrice = totalPrice;
        this.numberOfGuests = numberOfGuests;
    }
    public void addRoom(Room room){
        if(rooms==null){
            rooms=new ArrayList<>();
        }
        room.setReservation(this);
        room.setAvailable(false);
        rooms.add(room);
    }
}
