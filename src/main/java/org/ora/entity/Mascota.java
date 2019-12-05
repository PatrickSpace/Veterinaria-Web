package org.ora.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Mascota")
public class Mascota {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMascota;
	
	@Column(name = "nombreMascota",nullable = false,length = 40)
	private String nombreMascota;
	
	@Column(name = "fechaNacimiento",nullable = false)
	private Date fechaNacimiento;
	
	@Column(name="isPerro",nullable = false)//true si es perro
	private Boolean isPerro;
	
	@ManyToOne
	@JoinColumn(name = "dueño",nullable = false)
	private Cliente dueño;

	public Long getIdMascota() {
		return idMascota;
	}

	public void setIdMascota(Long idMascota) {
		this.idMascota = idMascota;
	}

	public String getNombreMascota() {
		return nombreMascota;
	}

	public void setNombreMascota(String nombreMascota) {
		this.nombreMascota = nombreMascota;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Boolean getIsPerro() {
		return isPerro;
	}

	public void setIsPerro(Boolean isPerro) {
		this.isPerro = isPerro;
	}

	public Cliente getDueño() {
		return dueño;
	}

	public void setDueño(Cliente dueño) {
		this.dueño = dueño;
	}
	
	
}
