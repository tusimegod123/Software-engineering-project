package com.project.softwareengineerinng.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@Data
@Entity
@Table(name = "Services")
public class ServiceReceived {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long serviceId;
    private LocalDate date;
    private String description;
    private Double price;
//    @ManyToOne
////    @JoinColumn(name ="stay_id")
////    @JsonIgnore
//    private Stay stay;

    public ServiceReceived(LocalDate date, String description, Double price) {
        this.date = date;
        this.description = description;
        this.price = price;
    }
}
