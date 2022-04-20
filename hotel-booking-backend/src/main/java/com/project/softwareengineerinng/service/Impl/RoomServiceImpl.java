package com.project.softwareengineerinng.service.Impl;

import com.project.softwareengineerinng.model.Room;
import com.project.softwareengineerinng.repository.RoomRepository;
import com.project.softwareengineerinng.service.RoomService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoomServiceImpl implements RoomService {
    RoomRepository roomRepository;

    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public List<Room> getRooms() {
        return roomRepository.findAll();

    }

    @Override
    public Room getRoomById(Long roomId) {
        return roomRepository.findById(roomId).orElseThrow(() -> new IllegalArgumentException("No room with this Id found"));
    }

    @Override
    public Room createRoom(Room room) {
        return roomRepository.save(room);
    }

    @Override
    public void deleteRoom(Long roomId) {
        roomRepository.deleteById(roomId);

    }

    @Override
    public Room updateRoom(Long roomId, Room room) {
       if(roomRepository.findById(roomId)==null) throw new IllegalArgumentException("No room with this Id found");
       room.setRoomId(roomId);
        return roomRepository.save(room);
    }

    @Override
    public Room findByRoomNumber(Integer roomNumber) {
        return roomRepository.findByRoomNumber(roomNumber);
    }
}
