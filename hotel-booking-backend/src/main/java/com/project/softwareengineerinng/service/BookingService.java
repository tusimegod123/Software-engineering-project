package com.project.softwareengineerinng.service;

import com.project.softwareengineerinng.model.BookHotel;
import com.project.softwareengineerinng.model.Room;
import com.project.softwareengineerinng.model.User;
import com.project.softwareengineerinng.repository.BookingRepository;
import com.project.softwareengineerinng.repository.UserRepository;
import com.project.softwareengineerinng.service.Impl.RoomServiceImpl;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    RoomServiceImpl roomService;

    @Autowired
    UserRepository userRepository;

    // public BookHotel saveBooking(BookHotel bookHotel, Integer id) {
    // Room room = roomService.findByRoomNumber(id);
    //
    // return bookingRepository.save(bookHotel);
    // }

    public BookHotel save(@NotNull BookHotel bookHotel, String email) {
        User retrivedUser = userRepository.findByEmail(email);
        var rooms = bookHotel.getRooms().stream().map(room -> {
            Room aRoom = (Room) roomService.findById(room.getRoomId());
            aRoom.setBookHotel(bookHotel);
            return aRoom;
        }).toList();
        bookHotel.setRooms(rooms);
        // System.out.println("Hotel booking: " + bookHotel.getRooms());
        // if(room!=null) bookHotel.getRooms().add(room);
        bookHotel.getUserDetails().add(retrivedUser);
        return bookingRepository.save(bookHotel);
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
