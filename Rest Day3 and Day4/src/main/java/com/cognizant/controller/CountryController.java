package com.cognizant.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.cognizant.exception.CountryNotFoundException;
import com.cognizant.model.Country;
import com.cognizant.service.CountryService;

@RestController
public class CountryController {

	@Autowired
	CountryService countryService;

	public static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);

	@GetMapping(value = "/country")
	public ResponseEntity<String> getCountryIndia() {

		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		var country = (Country) context.getBean("in", Country.class);
		return new ResponseEntity<>("Code: " + country.getCode() + " and Country: " + country.getName(), HttpStatus.OK);
	}

	@GetMapping(value = "/countries")
	@ResponseBody
	public static List<Country> getAllCountries() {

		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		List<Country> country = (List<Country>) context.getBean("countryList", java.util.List.class);
		return country;
	}

	@PostMapping(value = "/countries")
	@ResponseBody
	public static List<Country> getAllCountriess() {

		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		List<Country> country = (List<Country>) context.getBean("countryList", java.util.List.class);
		return country;

	}

	@GetMapping(value = "/countries/{id}")
	@ResponseBody
	public ResponseEntity<Country> getCountryName(@PathVariable("id") String id) throws CountryNotFoundException {
		Country c = countryService.getCountry(id);
		return new ResponseEntity<>(c, HttpStatus.OK);

	}

	@PostMapping(value = "/add")
	public void addCountry(@RequestBody @Valid Country country) {
		LOGGER.debug("Start");


		}
	}


