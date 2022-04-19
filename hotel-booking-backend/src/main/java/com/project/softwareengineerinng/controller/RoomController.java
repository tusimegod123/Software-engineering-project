package com.project.softwareengineerinng.controller;

import com.project.softwareengineerinng.model.Room;
import com.project.softwareengineerinng.service.Impl.RoomServiceImpl;
import com.project.softwareengineerinng.service.RoomService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {
   private RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }
   @GetMapping
    public List<Room> getRooms(){
         return roomService.getRooms();
    }
    @GetMapping("/{roomId}")
    public Room getRoomById(@PathVariable Long roomId){
        return roomService.getRoomById(roomId);
    }
    @PostMapping("/")
    public Room createRoom(@RequestBody Room room){
         return roomService.createRoom(room);
    }
    @DeleteMapping("/{roomId}")
    public void deleteRoom(@PathVariable Long roomId){
        roomService.deleteRoom(roomId);
    }
    @PutMapping("/{roomId}")
    public Room updateRoom(@PathVariable Long roomId, @RequestBody Room room){
        return roomService.updateRoom(roomId,room);
    }











}
