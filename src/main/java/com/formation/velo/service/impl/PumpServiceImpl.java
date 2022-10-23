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
        /*
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

            // 2 Save records dans stations
            Arrays.stream(openData.getRecords()).forEach(record -> {
                Optional<Pump> pump = findByRecordId(record.getRecordId());

                if (pump.isPresent()){
                    // on update la station
                    pump.get().setVille(record.getField().);
                    pump.get().setRecordId(record.getRecordId());

                    save(pump.get());
                } else  {
                    System.out.println("il est present");
                    // on crer lastation
                    Pump newPump = Pump.builder()
                            .recordId(record.getRecordId())
                            .name(record.getField().getName())
                            .lattitude(record.getField().getPosition()[1])
                            .longitude(record.getField().getPosition()[0])
                            .status(record.getField().getStatus())
                            .bikeStands(record.getField().getBikeStands())
                            .availableBikes(record.getField().getAvailableBikes())
                            .availableBikeStands(record.getField().getAvailableBikeStands())
                            .addresse(record.getField().getAddress())
                            .build();

                    save(newPump);
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    */
    }

    @Override
    public Optional<Pump> findByRecordId(String recordId) {
        return  pumpRepository.findByRecordId(recordId);
    }
}
