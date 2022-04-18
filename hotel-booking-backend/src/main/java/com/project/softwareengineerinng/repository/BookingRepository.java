package com.project.softwareengineerinng.repository;

import com.project.softwareengineerinng.model.BookHotel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookingRepository extends JpaRepository<BookHotel, Integer> {
}
