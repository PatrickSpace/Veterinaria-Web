package org.ora.serviceImpl;

import java.util.Date;
import java.util.List;

import org.ora.entity.Cita;
import org.ora.repository.ICitaRepository;
import org.ora.service.ICitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CitaServiceImpl implements ICitaService {

	@Autowired
	private ICitaRepository cR;

	@Override
	public void insert(Cita cita) {
		cR.save(cita);

	}

	@Override
	public List<Cita> listar() {
		// TODO Auto-generated method stub
		return cR.findAll();
	}

	@Override
	public List<Cita> listarXFecha(Date dia) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cita> listarCitasNext() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cita> listarCitasHoy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cita> listarXMes(int mes, int anio) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(Long id) {
		cR.deleteById(id);

	}

}
