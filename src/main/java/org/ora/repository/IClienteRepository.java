package org.ora.repository;

import java.util.List;

import org.ora.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IClienteRepository extends JpaRepository<Cliente, Long>{

	
	
	@Query("select count(d.dni) from Cliente d where d.dni = ?1")
	int yaExisteDni(String dni);
	
	@Query("select c from Cliente c where upper(c.name) like %?1%")
	List<Cliente> findByName(String nombre);
	
	@Query("select c from Cliente c where c.dni like %?1%")
	List<Cliente> findByDni(String dni);
	
	@Query("select c from Cliente c where c.idCliente = ?1")
	public Cliente getClienteXId(Long id);
}
