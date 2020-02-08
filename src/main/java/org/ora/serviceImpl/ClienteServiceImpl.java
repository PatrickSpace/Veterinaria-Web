package org.ora.serviceImpl;

import java.util.List;

import org.ora.entity.Cliente;
import org.ora.repository.IClienteRepository;
import org.ora.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements IClienteService {

	@Autowired
	private IClienteRepository dR;

	@Override
	public int insert(Cliente dueño, boolean nuevo) {
		int rpta = 0;
		if (nuevo == true) {
			rpta = dR.yaExisteDni(dueño.getDni());
			if (rpta == 0) {
				dR.save(dueño);
			}
		}else
		{
			rpta = 0;
			dR.save(dueño);
		}
		return rpta;
	}

	@Override
	public List<Cliente> listar() {
		return dR.findAll();
	}

	@Override
	public List<Cliente> listarXnombre(String name) {
		String nombre = name.toUpperCase();
		return dR.findByName(nombre);
	}

	@Override
	public void eliminar(Long id) {
		dR.deleteById(id);
	}

	@Override
	public List<Cliente> listarXdni(String dni) {
		return dR.findByDni(dni);
	}

	@Override
	public Cliente getCliente(Long id) {
		return  dR.getClienteXId(id);
	}

}
