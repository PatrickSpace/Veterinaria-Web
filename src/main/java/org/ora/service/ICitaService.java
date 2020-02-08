package org.ora.service;

import java.util.Date;
import java.util.List;

import org.ora.entity.Cita;

public interface ICitaService {
	
	public void insert(Cita cita);
	
	public List<Cita> listar();
	
	public List<Cita> listarXFecha(Date dia);
	
	public List<Cita> listarCitasNext();
	
	public List<Cita> listarCitasHoy();
	
	public List<Cita> listarXMes(int mes,int anio);
	
	public void eliminar(Long id);
}
