package com.c1020g1.demo.service.city;

import com.c1020g1.demo.model.City;
import com.c1020g1.demo.model.Nation;
import com.c1020g1.demo.service.IService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICityService extends IService<City> {
    List<City> findCityName(String name);

    List<City> findAllByNation(Nation nation);

    Page<City> findAll(Pageable pageable);
}
