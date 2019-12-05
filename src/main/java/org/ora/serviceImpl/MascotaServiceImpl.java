package org.ora.serviceImpl;

import java.util.List;

import org.ora.entity.Mascota;
import org.ora.repository.IMascotaRepository;
import org.ora.service.IMascotaService;
import org.springframework.beans.factory.annotation.Autowired;

public class MascotaServiceImpl implements IMascotaService {

	@Autowired
	private IMascotaRepository mR;

	@Override
	public void insert(Mascota mascota) {
		mR.save(mascota);
	}

	@Override
	public List<Mascota> listar() {
		return mR.findAll();
	}

	@Override
	public List<Mascota> listarXnombre(String name) {
		return mR.findByNombreMascota(name);
	}

	@Override
	public void eliminar(Long id) {
		mR.deleteById(id);

	}

	@Override
	public List<Mascota> listarXDueño(String dueño ) {
		return mR.findByDueño(dueño);
	}

}
