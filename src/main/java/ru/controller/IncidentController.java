package ru.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.entity.IncidentEntity;
import ru.service.IncidentService;

import java.util.List;

@Controller
@RequestMapping("/incident")
public class IncidentController {
    @Autowired
    IncidentService incidentService;

    @GetMapping(value="/{iddivision}")
    public ModelAndView view(@PathVariable int[] iddivision) {
        List<IncidentEntity> incidentEntity = incidentService.incidentlist(iddivision);

        if ( incidentEntity == null) {
            return new ModelAndView("IncidentList", HttpStatus.NOT_FOUND);
        }
        return new ModelAndView("IncidentList", "parcels", incidentEntity);
    }
}
