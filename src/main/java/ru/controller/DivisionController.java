package ru.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.entity.DivisionEntity;
import ru.service.DivisionService;

@Controller
@RequestMapping("/division")
public class DivisionController {
    @Autowired
    DivisionService divisionService;

    @GetMapping
    public ModelAndView divisionlist() {
        return new ModelAndView("DivisionList", "parcels", divisionService.divisionlist());
    }
    @GetMapping(value="/{id}", produces = "application/json")
    public ModelAndView view(@PathVariable Integer id) {
        DivisionEntity division = divisionService.divisionGet(id);
        if (division == null) {
            return new ModelAndView("DivisionList", HttpStatus.NOT_FOUND);
        }
        return new ModelAndView("DivisionForm", "parcel", division);
    }
}
