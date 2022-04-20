package com.project.softwareengineerinng.repository;

import com.project.softwareengineerinng.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room,Long> {
    Room findByRoomNumber(Integer roomNumber);
}
