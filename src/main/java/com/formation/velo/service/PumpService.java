package com.formation.velo.service;

import com.formation.velo.model.Pump;

import java.util.List;
import java.util.Optional;

public interface PumpService  {

    List<Pump> findAll();
    Optional<Pump> findById(Integer id);
    Pump save(Pump pump);

    void deleteById(Integer id);

    void delete(Pump pump);

    public void saveRecords();

    Optional<Pump> findByRecordId(String recordId);
}
