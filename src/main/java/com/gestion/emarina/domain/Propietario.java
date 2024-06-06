package com.gestion.emarina.domain;

import java.sql.Date;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import com.gestion.emarina.enums.Nacionalidad;


@Entity
@Table(name = "propietario")
public class Propietario {

	
	@Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "id_propietario", columnDefinition = "VARCHAR(36) NOT NULL")
    private String idPropietario;

	   
    @Column(name = "identificacion", columnDefinition = "VARCHAR(45) NOT NULL")
    private String identificacion;
	

	@Column (name = "nombre", columnDefinition = "VARCHAR(45) NOT NULL")
	private String nombre;
	
	@Column (name = "apellidos", columnDefinition = "VARCHAR(45) NOT NULL")
	private String apellidos;
	
	
	 @Column(name = "fnacimiento", columnDefinition = "DATE NOT NULL")
	    private Date fnacimiento;
	 
	 
	 @Column (name = "telefono", columnDefinition = "INT NOT NULL")
		private long telefono;
	 
	  @Enumerated(EnumType.STRING)
	    @Column(name = "nacionalidad", columnDefinition = "VARCHAR(45) NOT NULL")
	    private Nacionalidad nacionalidad;

	public Propietario() {
		super();
	}

	public Propietario(String idPropietario, String identificacion, String nombre, String apellidos, Date fnacimiento,
			long telefono, Nacionalidad nacionalidad) {
		super();
		this.idPropietario = idPropietario;
		this.identificacion = identificacion;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fnacimiento = fnacimiento;
		this.telefono = telefono;
		this.nacionalidad = nacionalidad;
	}

	public String getIdPropietario() {
		return idPropietario;
	}

	public void setIdPropietario(String idPropietario) {
		this.idPropietario = idPropietario;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Date getFnacimiento() {
		return fnacimiento;
	}

	public void setFnacimiento(Date fnacimiento) {
		this.fnacimiento = fnacimiento;
	}

	public long getTelefono() {
		return telefono;
	}

	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}

	public Nacionalidad getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(Nacionalidad nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	  
}
