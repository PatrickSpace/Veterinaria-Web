package org.ora.repository;

import java.util.List;

import org.ora.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IClienteRepository extends JpaRepository<Cliente, Long>{

	
	
	@Query("select count(d.dni) from Cliente d where d.dni = ?1")
	int yaExisteDni(String dni);
	
	
	List<Cliente> findByName(String nombreDueño);
	
	List<Cliente> findByDni(String dni);
	
	
}
