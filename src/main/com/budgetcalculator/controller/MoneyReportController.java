package com.budgetcalculator.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/money")
public class MoneyReportController {
    @RequestMapping(method = RequestMethod.GET, path = "/get")
    public String get(){
        return "K EK";
    }
}
