package ru.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.service.ResultService;

@Controller
@RequestMapping("/result")
public class ResultController {
    @Autowired
    ResultService resultService;

    @GetMapping("/{iddivision}")
    public ModelAndView incidentList(@PathVariable Integer[] iddivision) {
        return new ModelAndView("ResultList", "parcels", resultService.resultList(iddivision));   }

}
