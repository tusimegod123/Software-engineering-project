package com.project.softwareengineerinng.service;

import com.project.softwareengineerinng.model.BookHotel;
import com.project.softwareengineerinng.model.User;
import com.project.softwareengineerinng.repository.BookingRepository;
import com.project.softwareengineerinng.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    UserRepository userRepository;

    public  BookHotel  saveBooking(BookHotel bookHotel){
        return bookingRepository.save(bookHotel);
    }

    public  BookHotel save(BookHotel bookHotel, String email) {
        User retrivedUser = userRepository.findByEmail(email);
        bookHotel.getUserDetails().add(retrivedUser);
        return bookingRepository.save(bookHotel);
    }

    public <S extends BookHotel> Iterable<S> saveAll(Iterable<S> entities) {
        return bookingRepository.saveAll(entities);
    }

    public Optional<BookHotel> findById(Integer integer) {
        return bookingRepository.findById(integer);
    }

    public boolean existsById(Integer integer) {
        return bookingRepository.existsById(integer);
    }

    public List<BookHotel> findAll() {
        return bookingRepository.findAll();
    }

    public Iterable<BookHotel> findAllById(Iterable<Integer> integers) {
        return bookingRepository.findAllById(integers);
    }

    public long count() {
        return bookingRepository.count();
    }

    public void deleteById(Integer integer) {
        bookingRepository.deleteById(integer);
    }

    public void delete(BookHotel entity) {
        bookingRepository.delete(entity);
    }

    public void deleteAllById(Iterable<? extends Integer> integers) {
        bookingRepository.deleteAllById(integers);
    }

    public void deleteAll(Iterable<? extends BookHotel> entities) {
        bookingRepository.deleteAll(entities);
    }

    public void deleteAll() {
        bookingRepository.deleteAll();
    }
}
