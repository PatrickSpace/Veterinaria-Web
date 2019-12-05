package org.ora.service;

import java.util.List;

import org.ora.entity.Cliente;

public interface IClienteService {

	public int insert(Cliente dueño);
	
	public List<Cliente> listar();
	
	public List<Cliente> listarXnombre(String name);
	
	public List<Cliente> listarXdni(String dni);
	
	public void eliminar(Long id);
	
	
}
