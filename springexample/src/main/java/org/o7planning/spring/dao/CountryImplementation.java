package org.o7planning.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.hibernate.bytecode.buildtime.spi.Logger;
import org.o7planning.spring.model.Country;
import org.springframework.stereotype.Repository;

//Use the Data Access Object interface inside this class to establish methods to access the database.
@Repository
public class CountryImplementation implements CountryDAO{



	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	//All of these are self explanatory,the only new thing (to me), is that the session factory actually works here
	
	@Override
	public void addCountry(Country c) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(c);
		System.out.println("Country saved successfully, Country Details="+ c);
	}

	@Override
	public void updateCountry(Country c) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(c);
		System.out.println("Country has been updated, Country Details" + c);
		
	}

	@Override
	public List<Country> listCountries() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Country> countryList = session.createQuery("from Country").list();
		for(Country c : countryList){
			System.out.println("Person List::"+c);
		}
		return countryList;
	}

	@Override
	public Country getCountryById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Country c = (Country)session.load(Country.class, new Integer(id));
		System.out.println("Country loaded successfully, Country details=" +c);
		return c;
	}

	@Override
	public void removeCountry(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Country c = (Country) session.load(Country.class, new Integer(id));
		if(null != c){
			session.delete(c);
		}
		System.out.println("Person deleted successfully, person details="+c);
	}

}
