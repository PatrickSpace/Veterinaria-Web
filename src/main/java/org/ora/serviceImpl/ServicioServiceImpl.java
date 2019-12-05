package org.ora.serviceImpl;

import java.util.List;

import org.ora.entity.Servicio;
import org.ora.repository.IServcioRepository;
import org.ora.service.IServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioServiceImpl implements IServicioService {

	@Autowired
	private IServcioRepository sR;

	@Override
	public int insert(Servicio serv) {
		int rpta = 0;
		rpta = sR.yaExsite(serv.getNombreServicio());
		if (rpta == 0) {
			sR.save(serv);
		}
		return rpta;
	}

	@Override
	public List<Servicio> listar() {
		return sR.findAll();
	}

	@Override
	public List<Servicio> listarXnombre(String name) {
		return sR.findbyName(name);
	}

	@Override
	public void eliminar(Long id) {
		sR.deleteById(id);

	}

}
