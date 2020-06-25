package com.budgetcalculator.budgetcalculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MoneyReportController {
    @GetMapping("/")
    public String get(){
        return "KEK";
    }
}
