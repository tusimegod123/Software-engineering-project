package com.project.softwareengineerinng.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class BookHotel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bookingId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfArrival;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfDeparture;
    private int numberOfRooms;
    private String otherReservations;

    @ManyToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    @JoinTable(name = "users_bookings", joinColumns = @JoinColumn(name = "bookingId"), inverseJoinColumns = @JoinColumn(name = "id"))
    private Set<User> userDetails = new HashSet<>();

}
