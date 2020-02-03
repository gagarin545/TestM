package ru.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.entity.WorkersEntity;
import ru.repository.WorkersEntityRepository;

import java.util.List;

@Service
public class WorkService {
    @Autowired
    WorkersEntityRepository workersEntityRepository;

    public List<WorkersEntity> worklist() { return workersEntityRepository.findAll();    }
    public WorkersEntity workGet(int id) { return workersEntityRepository.findById( id);    }
    public void update(WorkersEntity worker) { workersEntityRepository.saveAndFlush(worker);    }
    public WorkersEntity worker(String imei) { return  workersEntityRepository.findByimei( imei);   }
    public WorkersEntity workername(String name) { return workersEntityRepository.findByName( name);    }
}
