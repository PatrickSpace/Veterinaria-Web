package org.ora.repository;

import java.util.List;

import org.ora.entity.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IMascotaRepository extends JpaRepository<Mascota, Long> {

	List<Mascota> findByNombreMascota(String nombreMascota);

	List<Mascota> findBycliente(String cliente);

	@Query("select m from Mascota m where m.isPerro = true")
	List<Mascota> listarPerros();

	@Query("select m from Mascota m where m.isPerro = false")
	List<Mascota> listarGatos();

	@Query("select m from Mascota m join Cliente c on m.cliente = c.idCliente where m.isPerro = true and m.cliente.idCliente = ?1")
	List<Mascota> listarPerroXCliente(Long id);

	@Query("select m from Mascota m join Cliente c on m.cliente = c.idCliente where m.isPerro = false and m.cliente.idCliente = ?1")
	List<Mascota> listarGatoXCliente(Long id);

}
