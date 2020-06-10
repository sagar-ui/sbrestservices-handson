package com.cognizant.handsOn2.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import com.cognizant.handsOn2.Country;
import com.cognizant.handsOn2.service.exception.CountryNotFoundException;
@Service
public class CountryService{
	 
	public Country getCountry(String code) throws CountryNotFoundException
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		List<Country> countries = (List)context.getBean("countryList", ArrayList.class);
		Country t=null;
		for(int i=0;i<countries.size();i++)
		{
			if(countries.get(i).getCode().equalsIgnoreCase(code))
			{
				t=countries.get(i);
			}
		}
		if(t==null)
		{
			throw new CountryNotFoundException();
		}
		return t;
	}

}
