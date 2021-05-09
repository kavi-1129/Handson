package com.cognizant.ormlearn.CountryRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.ormlearn.model.Country.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {

	// Using HQL
	
	@Query(value = "SELECT c FROM Country c WHERE c.name LIKE '%ou%' ORDER BY code")
	public List<Country> searchedCountryList();
	
	@Query(value = "SELECT c FROM Country c WHERE c.name LIKE 'Z%' ORDER BY code")
	public List<Country> alphabetIndexSearch();

}