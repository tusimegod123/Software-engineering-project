package com.project.softwareengineerinng.controller;

import com.project.softwareengineerinng.model.BookHotel;
import com.project.softwareengineerinng.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookingController {
    @Autowired
    BookingService bookingService;

    @GetMapping("/booking")
    private List<BookHotel> getBooking() {
        return bookingService.findAll();
    }

    @PostMapping("/booking")
    public void saveBooking(@RequestBody BookHotel bookHotel, Authentication authentication) {

        bookingService.save(bookHotel, authentication.getName());
    }
}
