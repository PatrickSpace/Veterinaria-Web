package org.ora.entity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Cita")
public class Cita {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCita;

	//fecha de cita que debe venir el paciente
	@Column(name = "fechaProyectada", nullable = false)
	private Date fechaProyectada;

	@Column(nullable = true, name = "fechaAtencion")
	private Date fechaAtencion;

	@OneToMany
	@JoinColumn(nullable = true, name = "DetalleCita")
	private List<DetalleCita> detalleCita;

	@ManyToOne
	@JoinColumn(name = "mascota", nullable = false)
	private Mascota mascota;
	
	@Column(nullable = false , name = "motivo")
	private String motivo;

	
	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public String getHoraCita() {
		DateFormat hora = new SimpleDateFormat("HH:mm");
		return hora.format(this.fechaProyectada);
	}
	
	public String getDiaCita() {
		DateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
		return fecha.format(this.fechaProyectada);
	}

	public Long getIdCita() {
		return idCita;
	}

	public void setIdCita(Long idCita) {
		this.idCita = idCita;
	}

	public Date getFechaAtencion() {
		return fechaAtencion;
	}

	public void setFechaAtencion(Date fechaAtencion) {
		this.fechaAtencion = fechaAtencion;
	}

	public List<DetalleCita> getDetalleCita() {
		return detalleCita;
	}

	public void setDetalleCita(List<DetalleCita> detalleCita) {
		this.detalleCita = detalleCita;
	}

	public Mascota getMascota() {
		return mascota;
	}

	public void setMascota(Mascota mascota) {
		this.mascota = mascota;
	}

	public Date getFechaProyectada() {
		return fechaProyectada;
	}

	public void setFechaProyectada(Date fechaProyectada) {
		this.fechaProyectada = fechaProyectada;
	}

	public Cita() {
		super();
		// TODO Auto-generated constructor stub
	}

}
