package com.formation.velo.service.impl;

import com.formation.velo.api.OpenData;
import com.formation.velo.api.OpenDataNantesPumpClient;
import com.formation.velo.model.Pump;
import com.formation.velo.repository.PumpRepository;
import com.formation.velo.service.PumpService;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class PumpServiceImpl implements PumpService {
    private final PumpRepository pumpRepository;

    public PumpServiceImpl(PumpRepository pumpRepository) {
        this.pumpRepository = pumpRepository;
    }

    @Override
    public List<Pump> findAll() {
        return pumpRepository.findAll();
    }

    @Override
    public Optional<Pump> findById(Integer id) {
        return pumpRepository.findById(id);
    }

    @Override
    public Pump save(Pump pump) {
        return pumpRepository.save(pump);
    }

    @Override
    public void deleteById(Integer id) {
        pumpRepository.deleteById(id);
    }

    @Override
    public void delete(Pump pump) {
        pumpRepository.delete(pump);
    }


    @Override
    public void saveRecords() {
        // 1 appel opendata
        String baseUrl = "https://data.economie.gouv.fr/";
        Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        OpenDataNantesPumpClient client = retrofit.create(OpenDataNantesPumpClient.class);
        Call<OpenData> openDataNantesPumpClientCall = client.getRecords();
        try {
            OpenData openData = openDataNantesPumpClientCall.execute().body();
            System.out.println(openData.getRecords().length+"ici");

            Arrays.stream(openData.getRecords()).forEach(record -> {
                Optional<Pump> pump = findByRecordId(record.getRecordId());

                if (pump.isPresent()){
                    // on update la station
                    pump.get().setRecordId(record.getRecordId());
                    pump.get().setVille(record.getField().getVille());
                    pump.get().setPop(record.getField().getPop());
                    pump.get().setRegName(record.getField().getRegName());
                    pump.get().setComArmCode(record.getField().getComArmCode());
                    pump.get().setLatitude(record.getField().getGeom()[0]);
                    pump.get().setLongitude(record.getField().getGeom()[0]);
                    pump.get().setDepName(record.getField().getDepName());
                    pump.get().setPrixNom(record.getField().getPrixNom());
                    pump.get().setComCode(record.getField().getComCode());
                    pump.get().setEpicName(record.getField().getEpicName());
                    pump.get().setDepCode(record.getField().getDepCode());
                    pump.get().setPrixID(record.getField().getPrixID());
                    pump.get().setServicesService(record.getField().getServicesService());
                    pump.get().setHorairesAutomate24_24(record.getField().getHorairesAutomate24_24());
                    pump.get().setRegCode(record.getField().getRegCode());
                    pump.get().setComArmName(record.getField().getComArmName());
                    pump.get().setPrixMaj(record.getField().getPrixMaj());
                    pump.get().setPumpId(record.getField().getPumpId());
                    pump.get().setRegCode(record.getField().getRegCode());
                    pump.get().setAdresse(record.getField().getAddress());
                    pump.get().setEpciCode(record.getField().getEpicCode());
                    pump.get().setCp(record.getField().getCp());
                    pump.get().setPrixValeur(record.getField().getPrixValeur());
                    pump.get().setComName(record.getField().getComName());


                    save(pump.get());
                } else  {
                    System.out.println("il est present");
                    // on crer lastation
                    Pump newPump = Pump.builder()
                            .recordId(record.getRecordId())
                            .ville(record.getField().getVille())
                            .pop(record.getField().getPop())
                            .regName(record.getField().getRegName())
                            .comArmCode(record.getField().getComArmCode())
                            .depName(record.getField().getDepName())
                            .prixNom(record.getField().getPrixNom())
                            .comCode(record.getField().getComCode())
                            .epciName(record.getField().getEpicName())
                            .depCode(record.getField().getDepCode())
                            .prixID(record.getField().getPrixID())
                            .servicesService(record.getField().getServicesService())
                            .horairesAutomate24_24(record.getField().getHorairesAutomate24_24())
                            .comArmName(record.getField().getComArmName())
                            .prixMaj(record.getField().getPrixMaj())
                            .pumpId(record.getField().getPumpId())
                            .regCode(record.getField().getRegCode())
                            .latitude(record.getField().getGeom()[0])
                            .longitude(record.getField().getGeom()[1])
                            .addresse(record.getField().getAddress())
                            .epciCode(record.getField().getEpicCode())
                            .cp(record.getField().getCp())
                            .prixValeur(record.getField().getPrixValeur())
                            .comName(record.getField().getComName())
                            .build();

                    save(newPump);
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Optional<Pump> findByRecordId(String recordId) {
        return  pumpRepository.findByRecordId(recordId);
    }
}
