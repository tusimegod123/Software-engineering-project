package com.project.softwareengineerinng.service.Impl;

import com.project.softwareengineerinng.model.Stay;
import com.project.softwareengineerinng.repository.StayRepository;
import com.project.softwareengineerinng.service.StayService;
import com.sun.source.tree.ThrowTree;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StayServiceImpl implements StayService {
    private StayRepository stayRepository;

    public StayServiceImpl(StayRepository stayRepository) {
        this.stayRepository = stayRepository;
    }

    @Override
    public List<Stay> getListOfStay() {
        return stayRepository.findAll() ;
    }

    @Override
    public Stay createStay(Stay stay) {
        return stayRepository.save(stay);

    }

    @Override
    public Stay updateStay(Long stayId, Stay stay) {
        if(stayRepository.findById(stayId)==null) throw new IllegalArgumentException("No Stay with this Id found");
        stay.setStayId(stayId);
         return stayRepository.save(stay);
    }

    @Override
    public Stay findByStayId(Long stayId) {
        return stayRepository.findById(stayId).orElse(null);
    }
}
