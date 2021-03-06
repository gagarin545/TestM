package ru.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.entity.IncidentEntity;
import ru.entity.ViewTest;
import ru.service.IncidentService;
import ru.test.StoreTest;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/incident")
public class IncidentController {
    @Autowired
    IncidentService incidentService;

    @GetMapping(value="/{iddivision}")
    public ModelAndView view(@PathVariable int[] iddivision) {
        return new ModelAndView("IncidentList", "parcels", incidentService.incidentlist(iddivision));
    }

    @GetMapping(value="/full/{n_incident}")
    public ModelAndView view_Full(@PathVariable long n_incident) {
        return new ModelAndView("IncidentFull", "incidеnt", incidentService.incident(n_incident));
    }
}
