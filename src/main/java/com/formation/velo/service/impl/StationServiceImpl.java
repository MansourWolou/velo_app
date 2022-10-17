package com.formation.velo.service.impl;

import com.formation.velo.api.OpenDataNantesClient;
import com.formation.velo.api.OpenDataVeloNantes;
import com.formation.velo.model.Station;
import com.formation.velo.repository.StationRepository;
import com.formation.velo.service.StationService;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class StationServiceImpl implements StationService {

    private final StationRepository stationRepository;

    public StationServiceImpl(StationRepository repository) {
        this.stationRepository = repository;
    }

    @Override
    public List<Station> findAll() {
        return stationRepository.findAll();
    }

    @Override
    public Optional<Station> findById(Integer id) {
        return stationRepository.findById(id);
    }

    @Override
    public Station save(Station station) {
        return stationRepository.save(station);
    }

    @Override
    public void deleteById(Integer id) {
        stationRepository.deleteById(id);
    }

    @Override
    public void delete(Station station) {
        stationRepository.delete(station);
    }

    @Override
    public void saveRecords() {
        // 1 appel opendata
        String baseUrl = "https://data.nantesmetropole.fr/";
        Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        OpenDataNantesClient client = retrofit.create(OpenDataNantesClient.class);
        Call<OpenDataVeloNantes> openDataVeloNantesCall = client.getRecords();
        try {
            OpenDataVeloNantes openDataVeloNantes = openDataVeloNantesCall.execute().body();
             System.out.println(openDataVeloNantes.getRecords().length+"ici");

            // 2 Save records dans stations
            Arrays.stream(openDataVeloNantes.getRecords()).forEach(record -> {
                Optional<Station> station = findByRecordId(record.getRecordid());

                if (station.isPresent()){
                    // on update la station

                    station.get().setAvailableBikes(record.getField().getAvailableBikes());
                    station.get().setName(record.getField().getName());
                    station.get().setLongitude(record.getField().getPosition()[0]);
                    station.get().setLattitude(record.getField().getPosition()[1]);
                    station.get().setStatus(record.getField().getStatus());
                    station.get().setBikeStands(record.getField().getBikeStands());
                    station.get().setAvailableBikeStands(record.getField().getAvailableBikeStands());
                    station.get().setAddresse(record.getField().getAddress());
                    station.get().setRecordId(record.getRecordid());

                    save(station.get());
                } else  {
                    System.out.println("il est present");
                    // on crer lastation
                    Station newstation = Station.builder()
                            .recordId(record.getRecordid())
                            .name(record.getField().getName())
                            .lattitude(record.getField().getPosition()[1])
                            .longitude(record.getField().getPosition()[0])
                            .status(record.getField().getStatus())
                            .bikeStands(record.getField().getBikeStands())
                            .availableBikes(record.getField().getAvailableBikes())
                            .availableBikeStands(record.getField().getAvailableBikeStands())
                            .addresse(record.getField().getAddress())
                            .build();

                    save(newstation);
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public Optional<Station> findByRecordId(String recordId){
     return stationRepository.findByRecordId(recordId);
    }

}
