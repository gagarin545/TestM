package ru.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.service.IncidentService;
import ru.test.StoreTest;

import java.io.IOException;

@Controller
@RequestMapping("/test")
public class TestViewController {

    @Autowired
    IncidentService incidentService;

    @GetMapping(value="/{nincident}", produces = "application/json")
    public ModelAndView getIncident(@PathVariable long nincident) {

        try {
            return new ModelAndView("TestList", "test", new StoreTest(incidentService.incident(nincident)).test());
        } catch (IOException e) {
            System.out.println(nincident + "-> Не тестится -" + e );
        }
        return new ModelAndView("IncidentList", HttpStatus.NOT_FOUND);
    }
}
