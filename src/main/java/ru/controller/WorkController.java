package ru.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.entity.WorkersEntity;
import ru.service.WorkService;

import java.util.Map;

@Controller
@RequestMapping("/workers")
public class WorkController {
    @Autowired
    private WorkService workService;

    @GetMapping
    public ModelAndView list() {
        return new ModelAndView("WorkList", "parcels", workService.worklist());
    }
    @GetMapping(value="/{id}")
    public ModelAndView view(@PathVariable Integer id) {
        WorkersEntity worker = workService.workGet(id);
        if (worker == null) {
            return new ModelAndView("WorkList", HttpStatus.NOT_FOUND);
        }
        return new ModelAndView("WorkerForm", "parcel", worker);
    }
    @PostMapping(value="/imei", produces = "application/json")
    public ModelAndView registration(@RequestParam Map<String, String> map) {
        WorkersEntity worker = workService.worker( map.get("imei"));
        if (worker == null) {
            return new ModelAndView("WorkList", HttpStatus.NOT_FOUND);
        }
        return new ModelAndView("WorkerForm", "parcel", worker);
    }
    @PostMapping("/{id}")
    public String edit(@ModelAttribute WorkersEntity worker) {
        workService.update( worker);
        return "redirect:/workers";
    }

}
