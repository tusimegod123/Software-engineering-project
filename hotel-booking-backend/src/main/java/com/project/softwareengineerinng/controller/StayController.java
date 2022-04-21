package com.project.softwareengineerinng.controller;

import com.project.softwareengineerinng.model.Room;
import com.project.softwareengineerinng.model.Stay;
import com.project.softwareengineerinng.service.StayService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = { "http://localhost:3000" })
@RestController
@RequestMapping("/api/stay")
public class StayController {
    private StayService stayService;
    public StayController(StayService stayService) {this.stayService = stayService;}

    @GetMapping
    public List<Stay> getListOfStay(){
        return stayService.getListOfStay();
    }

    @PostMapping("/")
    public Stay createStay(@RequestBody Stay stay){return stayService.createStay(stay);}

    @PutMapping("/{stayId}")
    public Stay updateStay(@PathVariable Long stayId, @RequestBody Stay stay){
        return stayService.updateStay(stayId,stay);
    }

    @GetMapping("/{stayId}")
    public Stay findStayById(@PathVariable Long stayId){
        return stayService.findByStayId(stayId);
    }


}
