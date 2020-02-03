package ru.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.entity.IncidentEntity;
import ru.repository.IncidentEntityRepository;

import java.util.List;

@Service
public class IncidentService {
    @Autowired
    private IncidentEntityRepository incidentEntityRepository;

    public List<IncidentEntity> incidentlist(int[] iddivision) { return incidentEntityRepository.findByallontime( iddivision);    }
    public IncidentEntity incident(Long n_incident) { return incidentEntityRepository.findByNumer( n_incident);  }
    public List<IncidentEntity> incidenListBurning(int[] iddivision) { return  incidentEntityRepository.findByallburning( iddivision);}
    public List<IncidentEntity> incidentlistForTillDay(int[] iddivision, int day ) { return  incidentEntityRepository.findByAllTillThisDay(iddivision, day);   }
    public List<IncidentEntity> incidentlistForRepet(int[] iddivision) { return  incidentEntityRepository.findByAllRepet(iddivision);   }
    public List<IncidentEntity> incidentlistForSeveralDay(int[] iddivision, int day ) { return  incidentEntityRepository.findByallOverdueonDay(iddivision, day);   }
    public List<IncidentEntity> incidentAll() { return  incidentEntityRepository.findAll();   }


}
