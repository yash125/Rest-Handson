package com.cognizant.service;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.exception.CountryNotFoundException;
import com.cognizant.model.Country;

@Service
public class CountryService {
	
	public Country getCountry(String id) throws CountryNotFoundException
	{
	
	ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
	List<Country> country = (List<Country>) context.getBean("countryList", java.util.List.class);
	
	for(int i=0;i<country.size();i++)
	{
		if((country.get(i).getCode()).equals(id))
			return country.get(i);
	}
	
	throw new CountryNotFoundException();
	
	}
	

}
