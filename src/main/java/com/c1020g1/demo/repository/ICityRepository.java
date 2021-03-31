package com.c1020g1.demo.repository;

import com.c1020g1.demo.model.City;
import com.c1020g1.demo.model.Nation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICityRepository extends JpaRepository<City,Long> {
    Page<City> findAllByOrderByIdAsc(Pageable pageable);
    List<City> findCityByName (String name);
    List<City> findAllByNation (Nation nation);
}
