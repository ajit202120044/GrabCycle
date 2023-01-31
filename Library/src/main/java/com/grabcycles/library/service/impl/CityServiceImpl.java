package com.grabcycles.library.service.impl;

import com.grabcycles.library.model.City;
import com.grabcycles.library.repository.CityRepository;
import com.grabcycles.library.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository cityRepository;

    @Override
    public List<City> getAll() {
        return cityRepository.findAll();
    }
}
