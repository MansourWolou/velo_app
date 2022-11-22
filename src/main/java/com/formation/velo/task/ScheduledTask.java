package com.formation.velo.task;

import com.formation.velo.model.Station;
import com.formation.velo.service.PumpService;
import com.formation.velo.service.StationService;
import lombok.extern.java.Log;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component// spring va scanner la class et va la prendre en compte dans ces parametrage
@Log
public class ScheduledTask {
    private final StationService stationService;
    private final PumpService pumpService;

    public ScheduledTask(StationService stationService,PumpService pumpService ){
        this.stationService = stationService;
        this.pumpService = pumpService;
    }
    @Scheduled(fixedRate = 60000)
    public void searchNextMatchByCompetition(){
        log.info("\uD83E\uDD78 update stations");
        stationService.saveRecords();
        log.info("\uD83E\uDD78 update pump");
        pumpService.saveRecords();
    }
}
