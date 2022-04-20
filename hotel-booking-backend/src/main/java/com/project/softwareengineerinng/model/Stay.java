package com.project.softwareengineerinng.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@Data
@Entity
public class Stay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stayId;
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer numberOfGuestsArrived;
    private Double totalPrice;
    private boolean isCheckedIn;

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "stay_Id")
    private List<ServiceReceived> serviceReceived;

    public Stay(LocalDate startDate, LocalDate endDate, Integer numberOfGuestsArrived, Double totalPrice,boolean isCheckedIn) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.numberOfGuestsArrived = numberOfGuestsArrived;
        this.totalPrice = totalPrice;
        this.isCheckedIn=isCheckedIn;
    }

    public void setServiceReceived(List<ServiceReceived> serviceReceived) {
        this.serviceReceived = serviceReceived;
        for (ServiceReceived s:serviceReceived){
            totalPrice+=s.getPrice();
        }
    }
}

