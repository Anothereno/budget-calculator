package com.budgetcalculator.controller;

import com.budgetcalculator.utils.DateTransportObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Date;
import java.util.Locale;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/date")
public class DateController
{
	@RequestMapping(method = RequestMethod.GET, path = "/month")
	public String getRussianNameOfMonth()
	{
		Month month = LocalDate.now().getMonth();
		return month.getDisplayName(TextStyle.FULL_STANDALONE, new Locale(("ru")));
	}

	@RequestMapping(method = RequestMethod.GET, path = "/fullDate")
	public DateTransportObject getFullDate()
	{
		return new DateTransportObject(LocalDate.now());
	}
}
