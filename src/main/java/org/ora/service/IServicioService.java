package org.ora.service;

import java.util.List;

import org.ora.entity.Servicio;

public interface IServicioService {

	public int insert(Servicio serv);
	
	public List<Servicio> listar();
	
	public List<Servicio> listarXnombre(String name);
	
	public void eliminar(Long id);
}
