package com.project.softwareengineerinng.service;

import com.project.softwareengineerinng.model.Stay;

import java.util.List;

public interface StayService {
    public abstract List<Stay> getListOfStay();
    public abstract Stay createStay(Stay stay);
    public abstract Stay updateStay(Long stayId,Stay stay);
    public abstract Stay findByStayId(Long stayId);


}
