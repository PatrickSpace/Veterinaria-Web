package org.ora.service;

import java.util.List;

import org.ora.entity.Servicio;

public interface IServicioService {

	public int insert(Servicio serv, boolean nuevo);
	
	public List<Servicio> listar();
	
	public List<Servicio> listarXnombre(String name);
	
	public void eliminar(Long id);
	
	public Servicio buscarServicio(Long id);
}
