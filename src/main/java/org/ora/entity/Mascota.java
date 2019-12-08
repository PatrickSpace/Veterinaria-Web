package org.ora.entity;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Mascota")
public class Mascota {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMascota;

	@Column(name = "nombreMascota", nullable = false, length = 40)
	private String nombreMascota;

	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "fechaNacimiento", nullable = false)
	private Date fechaNacimiento;

	@Column(name = "isPerro", nullable = false) // true si es perro
	private Boolean isPerro;

	@ManyToOne
	@JoinColumn(name = "Cliente", nullable = false)
	private Cliente cliente;

	private Period periodo() {
		LocalDate datenac = this.fechaNacimiento.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate hoy = LocalDate.now();
		Period period = Period.between(datenac, hoy);
		return period;
	}

	public int getMonth() {

		int meses = 0;
		meses = periodo().getMonths();
		return meses;
	}

	public int getYears() {
		int year = 0;
		year = periodo().getYears();
		return year;
	}

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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
