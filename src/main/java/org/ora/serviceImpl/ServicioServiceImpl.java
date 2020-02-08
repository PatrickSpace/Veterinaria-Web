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
	public int insert(Servicio serv, boolean nuevo) {
		int rpta = 0;
		if (nuevo == true) {
			rpta = sR.yaExsite(serv.getNombreServicio());
			if (rpta == 0) {
				sR.save(serv);
			}
		}else 
			sR.save(serv);
		return rpta;
	}

	@Override
	public List<Servicio> listar() {
		return sR.findAll();
	}

	@Override
	public List<Servicio> listarXnombre(String name) {
		
		String nombre = name.toUpperCase();
		return sR.findbyName(nombre);
	}

	@Override
	public void eliminar(Long id) {
		sR.deleteById(id);

	}

	@Override
	public Servicio buscarServicio(Long id) {
		return sR.buscarXid(id);
	}

}
