package org.o7planning.spring.dao;

import java.util.List;

import org.o7planning.spring.model.Country;

//Data access object interface
public interface CountryDAO {
	public void addCountry(Country c);
	public void updateCountry(Country c);
	public List<Country> listCountries();
	public Country getCountryById(int id);
	public void removeCountry(int id);
}
