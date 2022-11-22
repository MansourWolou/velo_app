package com.formation.velo.controllers;

import com.formation.velo.model.Pump;
import com.formation.velo.service.PumpService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api")
public class PumpController {
    private final PumpService pumpService;


    public PumpController(PumpService pumpService) {
        this.pumpService = pumpService;
    }

    @GetMapping("pumps")
    public ResponseEntity<List<Pump>> getAll(){
        List<Pump> pump = pumpService.findAll();

        return ResponseEntity.ok(pump);
    }
    @GetMapping("pumps/{id}")
    public ResponseEntity<Optional<Pump>> getStationById(@PathVariable Integer id){
        Optional<Pump> pump = pumpService.findById(id);

        return ResponseEntity.ok(pump);
    }
    @PostMapping("pumps/add")
    public ResponseEntity<Pump> add(@RequestParam String ville ,
                                    @RequestParam String pop,
                                    @RequestParam String regName,
                                    @RequestParam String comArmCode,
                                    @RequestParam String depName,
                                    @RequestParam String prixNom,
                                    @RequestParam String comCode,
                                    @RequestParam String epicName,
                                    @RequestParam String depCode,
                                    @RequestParam String prixID,
                                    @RequestParam String sevicesService,
                                    @RequestParam String horairesAutomate24_24,
                                    @RequestParam String comArmName,
                                    @RequestParam Date prixMaj,
                                    @RequestParam String pumpId,
                                    @RequestParam String regCode,
                                    @RequestParam String adresse,
                                    @RequestParam double[] geom ,
                                    @RequestParam String epciCode,
                                    @RequestParam String cp,
                                    @RequestParam double prixValeur,
                                    @RequestParam String comName){

        Pump pump = pumpService.save(Pump.builder()
                        .ville(ville)
                        .pop(pop)
                        .regName(regName)
                        .comArmCode(comArmCode)
                        .depName(depName)
                        .prixNom(prixNom)
                        .comCode(comCode)
                        .epciName(epicName)
                        .depCode(depCode)
                        .prixID(prixID)
                        .servicesService(sevicesService)
                        .horairesAutomate24_24(horairesAutomate24_24)
                        .comArmName(comArmName)
                        .prixMaj(prixMaj)
                        .pumpId(pumpId)
                        .regCode(regCode)
                        .adresse(adresse)
                        .latitude(geom[0])
                        .longitude(geom[1])
                        .epciCode(epciCode)
                        .cp(cp)
                        .prixValeur(prixValeur)
                        .comName(comName)
                .build());
        return ResponseEntity.ok(pump);
    }
    @DeleteMapping("pumps/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id){
        pumpService.deleteById(id);
        return ResponseEntity.ok("deleted");
    }
    @PostMapping("pumps/update")
    public ResponseEntity<String> update(@RequestBody Pump pump){
        pumpService.save(pump);
        return ResponseEntity.ok("updated");
    }

}
