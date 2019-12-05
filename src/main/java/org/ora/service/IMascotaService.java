package org.ora.service;

import java.util.List;

import org.ora.entity.Mascota;

public interface IMascotaService {

	public void insert(Mascota mascota);
	
	public List<Mascota> listar();
	
	public List<Mascota> listarXnombre(String name);
	
	public List<Mascota> listarXDueño(String dueño);
	
	public void eliminar(Long id);
}
