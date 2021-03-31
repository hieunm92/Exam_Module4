package com.c1020g1.demo.service.nation;

import com.c1020g1.demo.model.Nation;
import com.c1020g1.demo.repository.INationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NationService implements INationService{

    @Autowired
    private INationRepository nationRepository;

    @Override
    public List<Nation> findAll() {
        return nationRepository.findAll();
    }

    @Override
    public Nation findById(Long id) {
        return nationRepository.findById(id).get();
    }

    @Override
    public Nation save(Nation nation) {
        return nationRepository.save(nation);
    }

    @Override
    public void delete(Long id) {
nationRepository.deleteById(id);
    }

    @Override
    public Nation findByName(String name) {
        return nationRepository.findNationByName(name);
    }
}
