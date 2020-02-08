package org.ora.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Servicio")
public class Servicio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idServicio;

	@Column(name = "intervalo", nullable = false)
	private int intervalo;

	@Column(name = "nombreServicio", nullable = false)
	private String nombreServicio;

	@Column(name = "descripcion", nullable = false)
	private String descripcion;

	// 0 para ambos 1 para perro 2 para gato
	@Column(name = "tipo", nullable = false)
	private int tipo;

	public String imprimirTipo() {
		String valor = "";
		switch (this.tipo) {
		case 0:
			valor = "Ambos";
			break;
		case 1:
			valor = "Perro";
			break;
		case 2:
			valor = "Gato";
			break;
		default:
			valor = "Ambos";
			break;
		}
		return valor;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public Long getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(Long idServicio) {
		this.idServicio = idServicio;
	}

	public int getIntervalo() {
		return intervalo;
	}

	public void setIntervalo(int intervalo) {
		this.intervalo = intervalo;
	}

	public String getNombreServicio() {
		return nombreServicio;
	}

	public void setNombreServicio(String nombreServicio) {
		this.nombreServicio = nombreServicio;
	}

}
