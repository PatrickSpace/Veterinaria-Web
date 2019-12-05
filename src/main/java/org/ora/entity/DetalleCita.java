package org.ora.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "DetalleCita")
public class DetalleCita {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDetalleCita;
	
	@ManyToOne
	@JoinColumn(name = "servicio")
	private Servicio servicio;

	public Long getIdDetalleCita() {
		return idDetalleCita;
	}

	public void setIdDetalleCita(Long idDetalleCita) {
		this.idDetalleCita = idDetalleCita;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}
	
	

}
