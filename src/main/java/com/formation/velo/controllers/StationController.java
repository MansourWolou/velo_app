package com.formation.velo.controllers;

import com.formation.velo.model.Station;
import com.formation.velo.service.StationService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api")
public class StationController {
    private final StationService stationService;

    public StationController(StationService stationService) {
        this.stationService = stationService;
    }

    @GetMapping("stations")
    public ResponseEntity<List<Station>> getAll(){
        List<Station> station = stationService.findAll();

        return ResponseEntity.ok(station);
    }
    @GetMapping("stations/{id}")
    public ResponseEntity<Optional<Station>> getStationById(@PathVariable Integer id){
        Optional<Station> station = stationService.findById(id);

        return ResponseEntity.ok(station);
    }
    @PostMapping("stations/add")
    public ResponseEntity<Station> add(@RequestParam Double lattitude,@RequestParam Double longitude,@RequestParam String status,@RequestParam Integer bike_stands,@RequestParam Integer available_bikes,@RequestParam Integer available_bike_stands,@RequestParam String recordId,@RequestParam String addresse){

        Station station = stationService.save(Station.builder().lattitude(lattitude).longitude(longitude).status(status).bikeStands(bike_stands).availableBikes(available_bikes).availableBikeStands(available_bike_stands).recordId(recordId).addresse(addresse).build());
        return ResponseEntity.ok(station);
    }
    @DeleteMapping("stations/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id){
        stationService.deleteById(id);
        return ResponseEntity.ok("deleted");
    }
    @PostMapping("stations/update")
    public ResponseEntity<String> update(@RequestBody Station station){
        stationService.save(station);
        return ResponseEntity.ok("updated");
    }

}
