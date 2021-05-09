package com.cognizant.ormlearn;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.model.Country.Country;
import com.cognizant.ormlearn.service.CountryService.CountryService;
import com.cognizant.ormlearn.service.stockservice.StockService;
import com.cognizant.ormlearn.stock.Stock;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@SpringBootApplication
public class OrmLearnApplication {

	private static CountryService countryService;
	private static StockService stockService;

	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

	public static void main(String[] args) throws CountryNotFoundException {
		LOGGER.info("Inside main");

		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
		//country service bean
		countryService = context.getBean(CountryService.class);
		//stock service bean
		stockService = context.getBean(StockService.class);
		
		testGetStockBasedOnDate();
		testGetStockBasedOnPrice();
		testStockTopVolumeSearch();
		testStockLowestVolumeSearch();
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
	
	
	public static void testGetStockBasedOnDate() {
		LOGGER.info("Stock in September 2019");
		List<Stock> stocks = stockService.stockDateSearch();

		LOGGER.debug("stock={}", stocks);
		stocks.forEach(s -> LOGGER.debug(s.getCode() + " " + s.getDate() + " " + s.getOpen() + " " + s.getClose() + " "+ s.getVolume()));
		LOGGER.info("End");
	}
	
	public static void testGetStockBasedOnPrice() {
		LOGGER.info("Stock Price greater than 1200");
		List<Stock> stocks = stockService.stockPriceSearch();

		LOGGER.debug("stock={}", stocks);
		stocks.forEach(s -> LOGGER.debug(s.getCode() + " " + s.getDate() + " " + s.getOpen() + " " + s.getClose() + " "+ s.getVolume()));
		LOGGER.info("End");
	}
	
	public static void testStockTopVolumeSearch() {
		LOGGER.info("Top Stock Volume");
		List<Stock> stocks = stockService.stockTopVolumeSearch();

		LOGGER.debug("stock={}", stocks);
		stocks.forEach(s -> LOGGER.debug(s.getCode() + " " + s.getDate() + " " + s.getOpen() + " " + s.getClose() + " "+ s.getVolume()));
		LOGGER.info("End");
	}
	
	public static void testStockLowestVolumeSearch() {
		LOGGER.info("Lowest Stock Volume");
		List<Stock> stocks = stockService.stockLowestVolumeSearch();

		LOGGER.debug("stock={}", stocks);
		stocks.forEach(s -> LOGGER.debug(s.getCode() + " " + s.getDate() + " " + s.getOpen() + " " + s.getClose() + " "+ s.getVolume()));
		LOGGER.info("End");
	}

}
