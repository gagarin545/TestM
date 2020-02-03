package ru.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.entity.ResultEntity;
import ru.service.ResultService;

import java.util.List;

@RestController
@RequestMapping("/Result")
public class ResultRestController {
    @Autowired
    ResultService resultService;

    @GetMapping(value="/{iddivision}", produces = "application/json")
    public List<ResultEntity> resultList(@PathVariable Integer[] iddivision) {
        System.out.println( " result ");
        return    resultService.resultList( iddivision); }
}
