package com.cognizant.ormlearn.service.CountryService;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.ormlearn.CountryRepository.CountryRepository;
import com.cognizant.ormlearn.model.Country.Country;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@Service
public class CountryService {

	@Autowired
	CountryRepository countryRepository;

	@Transactional
	public List<Country> getAllCountries() {
		return countryRepository.findAll();
	}

	@Transactional
	public Country findCountryByCode(String code) throws CountryNotFoundException {
		Optional<Country> result = countryRepository.findById(code);

		if (!result.isPresent())
			throw new CountryNotFoundException("Not Found");

		Country resultedCountry = result.get();
		return resultedCountry;
	}

	@Transactional
	public void addCountry(Country country) {
		countryRepository.save(country);
	}

	@Transactional
	public void updateCountry(String code, String name) {
		Optional<Country> result = countryRepository.findById(code);
		result.get().setName(name);	
	}
	
	@Transactional
	public void deleteCountry(String code) {
		countryRepository.deleteById(code);
	}
	
	public List<Country> countrySearch() {
		return countryRepository.searchedCountryList();
	}
	
	public List<Country> alphabetSearch() {
		return countryRepository.alphabetIndexSearch();
	}
	

}
