package ru.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.entity.IncidentEntity;
import ru.entity.ViewTest;
import ru.service.IncidentService;
import ru.test.StoreTest;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Incident")
public class IncidentRestController {
    @Autowired
    IncidentService incidentService;

    @GetMapping(value="/test/{nincident}", produces = "application/json")
    public ViewTest getIncident(@PathVariable long nincident) {
        //IncidentEntity incident = incidentService.incident(nincident);
        //System.out.println("Techdata:выбрано->" + incident.getTechdata());
        //StoreTest storeTest = new StoreTest(incidentService.incident(nincident));
        try {
            return new StoreTest(incidentService.incident(nincident)).test();
        } catch (IOException e) {
           System.out.println(nincident + "-> Не тестится -" + e );
        }
        return null;
    }

    @GetMapping(value="/{iddivision}", produces = "application/json")
    public List<IncidentEntity> getIncidentList(@PathVariable int[] iddivision) {
        List<IncidentEntity> incidentEntity = incidentService.incidentlist(iddivision);
     //   System.out.println("Rest:выбрано->" + incidentEntity.size());
     //   incidentEntity.forEach( x-> System.out.println(x.getService()));
        System.out.print("Отдел ->");
        Arrays.stream( iddivision).forEach(x-> System.out.print(String.valueOf(x) + ' '));
        return incidentEntity;
    }
    @GetMapping(value="/burn/{iddivision}", produces = "application/json")
    public List<IncidentEntity> getIncidentBurn(@PathVariable int[] iddivision) {
        List<IncidentEntity> incidentEntity = incidentService.incidenListBurning( iddivision);
        //incidentEntity.forEach(s-> System.out.println(s.getControlterm() + "|" + s.getN_incident()));
        System.out.println("burn:выбрано->" + incidentEntity.size());
        Arrays.stream( iddivision).forEach(x-> System.out.print(x + ' '));
        return incidentEntity;
    }
    @GetMapping(value="/repet/{iddivision}", produces = "application/json")
    public List<IncidentEntity> getIncidentRepet(@PathVariable int[] iddivision) {
        List<IncidentEntity> incidentEntity = incidentService.incidentlistForRepet( iddivision);
        //incidentEntity.forEach(s-> System.out.println(s.getControlterm() + "|" + s.getN_incident()));
        System.out.println("repet:выбрано->" + incidentEntity.size());
        Arrays.stream( iddivision).forEach(x-> System.out.print(x + ' '));
        return incidentEntity;
    }
    @PostMapping(value="/till", produces = "application/json")
    public List<IncidentEntity> registration(@RequestParam Map<String, String> map) {
        Arrays.stream(map.get("iddivision").split(", ")).mapToInt(Integer::parseInt).forEach(x-> System.out.print(x + ' '));
        List<IncidentEntity> incidentEntity = incidentService.incidentlistForTillDay( Arrays.stream(map.get("iddivision").split(", ")).mapToInt(Integer::parseInt).toArray(), Integer.valueOf(map.get("day")));
        System.out.println("till:выбрано->" + incidentEntity.size());
        System.out.println( map.get("iddivision" ));
        return incidentEntity;
    }
}
