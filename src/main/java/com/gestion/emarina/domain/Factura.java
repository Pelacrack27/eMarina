package com.gestion.emarina.domain;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "factura")
public class Factura {

	
	@Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "id_factura", columnDefinition = "VARCHAR(36) NOT NULL")
    private String idFactura;
	
	
	@Column (name = "precio", columnDefinition = "DOUBLE NOT NULL")
	private double precio;
	
	
	 @ManyToOne
	    @JoinColumn(name = "reserva_id", columnDefinition = "VARCHAR(36) NOT NULL")
	    private ReservaAmarre idreservamarre;


	public String getIdFactura() {
		return idFactura;
	}


	public void setIdFactura(String idFactura) {
		this.idFactura = idFactura;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public ReservaAmarre getIdreservamarre() {
		return idreservamarre;
	}


	public void setIdreservamarre(ReservaAmarre idreservamarre) {
		this.idreservamarre = idreservamarre;
	}


	public Factura(String idFactura, double precio, ReservaAmarre idreservamarre) {
		super();
		this.idFactura = idFactura;
		this.precio = precio;
		this.idreservamarre = idreservamarre;
	}


	public Factura() {
		super();
	}
	
	
	 
	 
}
