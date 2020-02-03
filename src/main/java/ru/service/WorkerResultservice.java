package ru.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.entity.WorkerResultEntity;
import ru.repository.WorkerResultRepository;

import java.util.List;

@Service
public class WorkerResultservice {
    @Autowired
    WorkerResultRepository workerResultRepository;
    public List<WorkerResultEntity> incidenListWorkers(int[] iddivision) { return  workerResultRepository.findByallWorker( iddivision);}
}
