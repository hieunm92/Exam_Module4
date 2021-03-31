package com.c1020g1.demo.repository;

import com.c1020g1.demo.model.Nation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface INationRepository extends JpaRepository<Nation, Long> {
    Nation findNationByName (String name);
}
