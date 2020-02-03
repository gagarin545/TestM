package ru.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.entity.DivisionEntity;
import ru.repository.DivisionEntityRepository;

import java.util.List;

@Service
public class DivisionService {
    @Autowired
    DivisionEntityRepository divisionEntityRepository;
    public List<DivisionEntity> divisionlist() { return divisionEntityRepository.findAll(Sort.by("namedivision"));    }
    public DivisionEntity divisionGet(long id) {    return divisionEntityRepository.findById( id);  }
}
