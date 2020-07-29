package com.budgetcalculator.utils;

import java.time.LocalDate;

public class DateTransportObject
{
	private LocalDate date;

	public DateTransportObject(LocalDate date)
	{
		this.date = date;
	}

	public LocalDate getDate()
	{
		return date;
	}

	public void setDate(LocalDate date)
	{
		this.date = date;
	}
}
