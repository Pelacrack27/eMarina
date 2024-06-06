package com.gestion.emarina.domain;

import java.sql.Date;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "reservaamarre")
public class ReservaAmarre {

	@Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "id_reservamarre", columnDefinition = "VARCHAR(36) NOT NULL")
    private String idReservamarre;

	 @Column(name = "fechainicio", columnDefinition = "DATE NOT NULL")
	    private Date fechainicio;
	 
	 @Column(name = "fechafin", columnDefinition = "DATE NOT NULL")
	    private Date fechafin;
	 
	 @ManyToOne
	    @JoinColumns({
	        @JoinColumn(name = "amarre_letra", referencedColumnName = "letra", columnDefinition = "VARCHAR(1) NOT NULL"),
	        @JoinColumn(name = "amarre_numero", referencedColumnName = "numero", columnDefinition = "VARCHAR(2) NOT NULL")
	    })
	    private Amarre amarre;
	 
	 
	 @ManyToOne
	    @JoinColumn(name = "barco_id", columnDefinition = "VARCHAR(36) NOT NULL")
	    private Barco idbarco;


	public String getIdReservamarre() {
		return idReservamarre;
	}


	public void setIdReservamarre(String idReservamarre) {
		this.idReservamarre = idReservamarre;
	}


	public Date getFechainicio() {
		return fechainicio;
	}


	public void setFechainicio(Date fechainicio) {
		this.fechainicio = fechainicio;
	}


	public Date getFechafin() {
		return fechafin;
	}


	public void setFechafin(Date fechafin) {
		this.fechafin = fechafin;
	}


	public Amarre getAmarre() {
		return amarre;
	}


	public void setAmarre(Amarre amarre) {
		this.amarre = amarre;
	}


	public Barco getIdbarco() {
		return idbarco;
	}


	public void setIdbarco(Barco idbarco) {
		this.idbarco = idbarco;
	}


	public ReservaAmarre(String idReservamarre, Date fechainicio, Date fechafin, Amarre amarre, Barco idbarco) {
		super();
		this.idReservamarre = idReservamarre;
		this.fechainicio = fechainicio;
		this.fechafin = fechafin;
		this.amarre = amarre;
		this.idbarco = idbarco;
	}


	public ReservaAmarre() {
		super();
	}

	 
	 
	 
}
