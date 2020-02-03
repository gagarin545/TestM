package ru.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.entity.ResultEntity;
import ru.repository.ResultEntityRepository;

import java.util.List;

@Service
public class ResultService {
    @Autowired
    private ResultEntityRepository resultEntityRepository;

    public List<ResultEntity> resultList(Integer[] iddivision) {        return resultEntityRepository.findByOnDivision(iddivision);  }
}
