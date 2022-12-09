package com.luv2code.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.luv2code.springdemo.dao.MascotaDAO;
import com.luv2code.springdemo.entity.Mascota;


@Service
public class MascotaServiceImpl implements MascotaService {

	// need to inject customer dao
	@Autowired
	private MascotaDAO mascotaDAO;
	
	@Override
	@Transactional
	public List<Mascota> getMascotas() {
		return mascotaDAO.getMascotas();
	}

	@Override
	@Transactional
	public void saveMascota(Mascota theMascota) {
		mascotaDAO.saveMascota(theMascota);
		
	}

	@Override
	@Transactional
	public Mascota getMascota(int theId) {
		return mascotaDAO.getMascota(theId);
	}

	@Override
	@Transactional
	public void deleteMascota(int theId) {
		mascotaDAO.deleteMascota(theId);
		
	}
}





