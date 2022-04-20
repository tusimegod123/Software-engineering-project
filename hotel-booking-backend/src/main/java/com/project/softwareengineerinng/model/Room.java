package com.project.softwareengineerinng.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Data

@Entity
@Table(name = "Rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomId;
    @Column(unique = true)
    private Integer roomNumber;
    private String type;
    private Double price;
    private String bedType;
    private Integer numberOfBeds;
    private Integer maxNumberOfGuests;
    private boolean smoking;
    private String description;
    private boolean available;

    public Room(Integer roomNumber, String type, Double price, String bedType, Integer numberOfBeds,
            Integer maxNumberOfGuests, boolean smoking, String description, boolean available) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.price = price;
        this.bedType = bedType;
        this.numberOfBeds = numberOfBeds;
        this.maxNumberOfGuests = maxNumberOfGuests;
        this.smoking = smoking;
        this.description = description;
        this.available = available;

    }
}
