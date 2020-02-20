package ru.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.entity.WorkersEntity;
import ru.service.WorkService;

import java.util.Arrays;
import java.util.Map;

@RestController
@RequestMapping("/Workers")
public class WorkerRestController {
    @Autowired
    WorkService workService;

    @PostMapping(value="/imei", produces = "application/json")
    public WorkersEntity registration(@RequestParam Map<String, String> map) {
        System.out.println("worker>>" + map.get("imei"));
        WorkersEntity workersEntity = null;
        workersEntity = workService.worker(map.get("imei"));
        if (workersEntity != null)
            System.out.println("Name-> " + workersEntity.getName());
        else
            System.out.println("Не нашла ничего.");
        return workersEntity;
    }
    @PostMapping(value="/add")
    public WorkersEntity postDevision(@RequestParam Map<String, String> map) {
        WorkersEntity workersEntity;
        System.out.println("len=" + map.get("name") + "|" + map.get("imei") + map.get("iddivision"));

        workersEntity = workService.worker( map.get("imei"));
        if( workersEntity == null) {
            workersEntity = workService.workername(map.get("name"));
            if (workersEntity == null) {
                workersEntity = new WorkersEntity();
                workersEntity.setName(map.get("name"));
            }
        }
        workersEntity.setImei(map.get("imei"));
        workersEntity.setIddivision(Arrays.stream(map.get("iddivision").replace("[", "").replace("]", "").split(", ")).mapToInt(Integer::parseInt).toArray());
        System.out.println( workersEntity.getName() + "|" + workersEntity.getImei() + "|" + workersEntity.getIdworker() + "|" + workersEntity.getIddivision()[0]);
        if( workersEntity.getName().length() != 0)
            workService.update(workersEntity);
        return  workersEntity;
    }
}
