package com.luv2code.springdemo.service;

import java.util.List;

import com.luv2code.springdemo.entity.Mascota;

public interface MascotaService {

	public List<Mascota> getMascotas();

	public void saveMascota(Mascota theMascota);

	public Mascota getMascota(int theId);

	public void deleteMascota(int theId);

	
}
