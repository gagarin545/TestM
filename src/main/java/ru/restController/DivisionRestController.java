package ru.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.entity.DivisionEntity;
import ru.service.DivisionService;

import java.util.List;

@RestController
@RequestMapping("/Division")
public class DivisionRestController {
    @Autowired
    DivisionService divisionService;

    @GetMapping( produces = "application/json")
    public List<DivisionEntity> divisionlist() {
        System.out.println("Отделы");
        return  divisionService.divisionlist();
    }
}
