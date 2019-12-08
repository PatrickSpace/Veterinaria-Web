package org.ora.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.ora.entity.Mascota;
import org.ora.repository.IMascotaRepository;
import org.ora.service.IMascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
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
	public List<Mascota> buscarXnombre(String name) {
		return mR.findByNombreMascota(name);
	}

	@Override
	public void eliminar(Long id) {
		mR.deleteById(id);

	}

	@Override
	public List<Mascota> buscarXCliente(String cliente) {
		return mR.findBycliente(cliente);
	}

	@Override
	public List<Mascota> listarPerros() {

		return mR.listarPerros();
	}

	@Override
	public List<Mascota> listarGatos() {

		return mR.listarGatos();
	}

	@Override
	public Mascota getMasota(Long id) {
		Optional<Mascota> mascota = mR.findById(id);
		return mascota.get();
	}

	@Override
	public List<Mascota> listarPerroXCliente(Long id) {
		return mR.listarPerroXCliente(id);
	}

	@Override
	public List<Mascota> listarGatoXCliente(Long id) {
		return mR.listarGatoXCliente(id);
	}

}
