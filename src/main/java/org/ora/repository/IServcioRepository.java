package org.ora.repository;

import java.util.List;

import org.ora.entity.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IServcioRepository extends JpaRepository<Servicio, Long> {

	@Query("select count(s.nombreServicio) from Servicio s where s.nombreServicio=?1")
	public int yaExsite(String nombreServicio);
	
	@Query("select s from Servicio s where s.nombreServicio like %?1%")
	public List<Servicio> findbyName(String nombreServicio);
}
