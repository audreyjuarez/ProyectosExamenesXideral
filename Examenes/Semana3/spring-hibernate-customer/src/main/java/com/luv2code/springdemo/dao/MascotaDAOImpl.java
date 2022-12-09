package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Mascota;

@Repository
public class MascotaDAOImpl implements MascotaDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
			
	@Override
	public List<Mascota> getMascotas() {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// create a query  ... sort by last name
		Query<Mascota> theQuery = 
				currentSession.createQuery("from Mascota order by lastName",
											Mascota.class);
		
		// execute query and get result list
		List<Mascota> mascotas = theQuery.getResultList();
				
		// return the results		
		return mascotas;
	}

	@Override
	public void saveMascota(Mascota theMascota) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save/upate the customer ... finally LOL
		currentSession.saveOrUpdate(theMascota);
		
	}

	@Override
	public Mascota getMascota(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve/read from database using the primary key
		Mascota theMascota = currentSession.get(Mascota.class, theId);
		
		return theMascota;
	}

	@Override
	public void deleteMascota(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery("delete from Mascota where id=:mascotaId");
		theQuery.setParameter("mascotaId", theId);
		
		theQuery.executeUpdate();		
	}

}











