package org.ora.service;

import java.util.List;

import org.ora.entity.Mascota;

public interface IMascotaService {

	public void insert(Mascota mascota);
	
	public Mascota getMasota(Long id);
	
	public List<Mascota> listar();
	
	public List<Mascota> listarPerros();	
	
	public List<Mascota> listarGatos();
	
	public List<Mascota> buscarXnombre(String name);
	
	public List<Mascota> buscarXCliente(String name);
	
	
	public List<Mascota> listarPerroXCliente(Long id);
	
	public List<Mascota> listarGatoXCliente(Long id);
	
	
	
	public void eliminar(Long id);
}
