package com.cognizant.ormlearn;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.model.Country.Country;
import com.cognizant.ormlearn.service.CountryService.CountryService;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@SpringBootApplication
public class OrmLearnApplication {

	private static CountryService countryService;

	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

	public static void main(String[] args) throws CountryNotFoundException {

		LOGGER.info("Inside main");

		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
		countryService = context.getBean(CountryService.class);

		testCountrySearch();
		testAlphabetIndexSearch();

		LOGGER.info("Start");
	}

	private static void testGetAllCountries() {

		LOGGER.info("Start");

		List<Country> countries = countryService.getAllCountries();

		LOGGER.debug("countries={}", countries);

		LOGGER.info("End");

	}

	private static void testGetAllCountriesByCode() throws CountryNotFoundException {

		Country country = countryService.findCountryByCode("IN");

		LOGGER.debug("Country:{}", country);

		LOGGER.info("End");
	}

	public static void testAddCountry() throws CountryNotFoundException {
		Country country = new Country();
		country.setCode("UK");
		country.setName("United Kingdom");

		countryService.addCountry(country);

		LOGGER.info("End");
	}

	public static void testUpdateCountry() {
		countryService.updateCountry("US", "America");

		LOGGER.info("End");
	}

	public static void testDeleteCountry() {
		countryService.deleteCountry("KW");

		LOGGER.info("End");
	}

	public static void testCountrySearch() throws CountryNotFoundException {

		List<Country> countries = countryService.countrySearch();

		LOGGER.debug("countries={}", countries);

		countries.forEach(c -> LOGGER.debug(c.getCode() + " " + c.getName()));

		LOGGER.info("End");

	}

	public static void testAlphabetIndexSearch() {
		LOGGER.info("Alphabet Index Based Search");

		List<Country> countries = countryService.alphabetSearch();

		LOGGER.debug("countries={}", countries);

		countries.forEach(c -> LOGGER.debug(c.getCode() + " " + c.getName()));
		LOGGER.info("End");

	}

}
