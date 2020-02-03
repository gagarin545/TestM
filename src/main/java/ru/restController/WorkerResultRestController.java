package ru.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.entity.WorkerResultEntity;
import ru.service.WorkerResultservice;

import java.util.List;

@RestController
@RequestMapping("/WorkerResult")
public class WorkerResultRestController {
    @Autowired
    WorkerResultservice workerResultservice;
    @GetMapping(value="/{iddivision}", produces = "application/json")
    public List<WorkerResultEntity> resultList(@PathVariable int[] iddivision) {
        System.out.println("resultworker");
        return  workerResultservice.incidenListWorkers( iddivision); }
}
