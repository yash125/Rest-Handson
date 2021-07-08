package com.cognizant.project;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.model.Country;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
@ComponentScan("com.cognizant")

public class RestDay1Application {
	private static final Logger LOGGER = LoggerFactory.getLogger(RestDay1Application.class);

	public static void main(String[] args) {
		SpringApplication.run(RestDay1Application.class, args);
		displayCountries();
		displayCountry();
	}
	
	public static void displayDate()
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
		SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);

	}
	
	public static void displayCountry()
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		Country country = (Country) context.getBean("in", Country.class);
		LOGGER.debug("Country : {}", country.toString());
	}
	public static void displayCountries()
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		List<Country> countryList = (List<Country>) context.getBean("countryList", ArrayList.class);
		LOGGER.debug("Start");
		for(int i=0;i<countryList.size();i++)
		{
			LOGGER.info("Country : {}", countryList.get(i).toString());
		}
		LOGGER.debug("END");
		
		
	}

}
