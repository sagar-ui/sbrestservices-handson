package com.cognizant.handsOn2.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.handsOn2.Country;
import com.cognizant.handsOn2.service.CountryService;
import com.cognizant.handsOn2.service.exception.CountryNotFoundException;

@RestController
public class CountryController {
	private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);
	@Autowired CountryService countryService;
	@RequestMapping(value="/country",method=RequestMethod.GET)
	public Country getCountryIndia()
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		Country country = (Country) context.getBean("country", Country.class);
		LOGGER.debug("Country : {}", country.toString());
		return country;
	}
	@GetMapping("/countries")
	public List<Country> getAllCountries()
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		List<Country> countries = (List)context.getBean("countryList", ArrayList.class);
		LOGGER.debug("countryList : {}", countries);
		return countries;
	}
	@GetMapping("/countries/{code}")
	public Country getCountry (@PathVariable String code) throws CountryNotFoundException
	{
		return countryService.getCountry(code);
	}
}
