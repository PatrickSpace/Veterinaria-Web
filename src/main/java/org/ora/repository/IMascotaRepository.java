package org.ora.repository;

import java.util.List;

import org.ora.entity.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMascotaRepository extends JpaRepository<Mascota, Long>{

	List<Mascota> findByNombreMascota(String nombreMascota);
	
	List<Mascota> findByDueño(String dueño);
	

	
}
