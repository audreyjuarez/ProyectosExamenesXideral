package com.luv2code.springdemo.dao;

import java.util.List;

import com.luv2code.springdemo.entity.Mascota;

public interface MascotaDAO {

	public List<Mascota> getMascotas();

	public void saveMascota(Mascota theMascota);

	public Mascota getMascota(int theId);

	public void deleteMascota(int theId);
	
}
