package com.gestion.emarina.domain;

import java.sql.Date;

import org.hibernate.annotations.GenericGenerator;

import com.gestion.emarina.enums.Nacionalidad;
import com.gestion.emarina.enums.Propulsion;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "barco")
public class Barco {

	@Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "id_barco", columnDefinition = "VARCHAR(36) NOT NULL")
    private String idBarco;
	
  
    @Column(name = "matricula", columnDefinition = "VARCHAR(45) NOT NULL")
    private String matricula;
	

	@Column (name = "eslora", columnDefinition = "DOUBLE NOT NULL")
	private double eslora;
	
	@Column (name = "manga", columnDefinition = "DOUBLE NOT NULL")
	private double manga;
	
	 
	 @Enumerated(EnumType.STRING)
	    @Column(name = "propulsion", columnDefinition = "VARCHAR(45) NOT NULL")
	    private Propulsion propulsion;
	 
	 
	 @Column(name = "iscatamaran", columnDefinition = "TINYINT (1) NOT NULL")
	    private boolean iscatamaran;
	 
	 @Column(name = "ocupantes", columnDefinition = "INT NOT NULL")
	    private long ocupantes;
	 
	 @Column(name = "telefono_armador", columnDefinition = "INT NULL")
	    private Long telefono_armador;
	 
	 
	  @Enumerated(EnumType.STRING)
	    @Column(name = "nacionalidad", columnDefinition = "VARCHAR(45) NOT NULL")
	    private Nacionalidad nacionalidad;
	 
	  @ManyToOne
	    @JoinColumn(name = "propietario_id", columnDefinition = "VARCHAR(36) NOT NULL")
	    private Propietario idpropietario;

	public Barco() {
		super();
	}

	public Barco(String idBarco, String matricula, double eslora, double manga, Propulsion propulsion,
			boolean iscatamaran, Long ocupantes, Nacionalidad nacionalidad, Propietario idpropietario) {
		super();
		this.idBarco = idBarco;
		this.matricula = matricula;
		this.eslora = eslora;
		this.manga = manga;
		this.propulsion = propulsion;
		this.iscatamaran = iscatamaran;
		this.ocupantes = ocupantes;
		this.nacionalidad = nacionalidad;
		this.idpropietario = idpropietario;
	}

	
	
	public String getIdBarco() {
		return idBarco;
	}

	public void setIdBarco(String idBarco) {
		this.idBarco = idBarco;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public double getEslora() {
		return eslora;
	}

	public void setEslora(double eslora) {
		this.eslora = eslora;
	}

	public double getManga() {
		return manga;
	}

	public void setManga(double manga) {
		this.manga = manga;
	}

	public Propulsion getPropulsion() {
		return propulsion;
	}

	public void setPropulsion(Propulsion propulsion) {
		this.propulsion = propulsion;
	}

	public boolean isIscatamaran() {
		return iscatamaran;
	}

	public void setIscatamaran(boolean iscatamaran) {
		this.iscatamaran = iscatamaran;
	}

	public long getOcupantes() {
		return ocupantes;
	}

	public void setOcupantes(Long ocupantes) {
		this.ocupantes = ocupantes;
	}

	

	public Long getTelefono_armador() {
		return telefono_armador;
	}

	public void setTelefono_armador(Long telefono_armador) {
		this.telefono_armador = telefono_armador;
	}

	public Nacionalidad getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(Nacionalidad nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public Propietario getIdpropietario() {
		return idpropietario;
	}

	public void setIdpropietario(Propietario idpropietario) {
		this.idpropietario = idpropietario;
	}

	public void setOcupantes(long ocupantes) {
		this.ocupantes = ocupantes;
	}

	
  
	  
}
