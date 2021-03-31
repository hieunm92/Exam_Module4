package com.c1020g1.demo.service.city;

import com.c1020g1.demo.model.City;
import com.c1020g1.demo.model.Nation;
import com.c1020g1.demo.repository.ICityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService implements ICityService{

    @Autowired
    private ICityRepository cityRepository;

    @Override
    public List<City> findAll() {
        return cityRepository.findAll();
    }

    @Override
    public City findById(Long id) {
        return cityRepository.findById(id).get();
    }

    @Override
    public City save(City city) {
        return cityRepository.save(city);
    }

    @Override
    public void delete(Long id) {
    cityRepository.deleteById(id);
    }

    @Override
    public List<City> findCityName(String name) {
        return cityRepository.findCityByName(name);
    }

    @Override
    public List<City> findAllByNation(Nation nation) {
        return cityRepository.findAllByNation(nation);
    }

    @Override
    public Page<City> findAll(Pageable pageable) {
        return cityRepository.findAll(pageable);
    }
}
