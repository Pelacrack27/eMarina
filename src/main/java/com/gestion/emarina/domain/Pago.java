package com.gestion.emarina.domain;

import java.sql.Date;

import org.hibernate.annotations.GenericGenerator;

import com.gestion.emarina.enums.MetodoPago;
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
@Table(name = "pago")
public class Pago {

	
	@Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "id_pago", columnDefinition = "VARCHAR(36) NOT NULL")
    private String idPago;

	
	
	
	 @Enumerated(EnumType.STRING)
	    @Column(name = "metodopago", columnDefinition = "VARCHAR(45) NOT NULL")
	    private MetodoPago metodopago;

	 @Column(name = "fechapago", columnDefinition = "DATE NOT NULL")
	    private Date fechapago;
	 
	 @ManyToOne
	    @JoinColumn(name = "factura_id", columnDefinition = "VARCHAR(36) NOT NULL")
	    private Factura idfactura;
	 

	public String getIdPago() {
		return idPago;
	}




	public Factura getIdfactura() {
		return idfactura;
	}




	public void setIdfactura(Factura idfactura) {
		this.idfactura = idfactura;
	}




	public void setIdPago(String idPago) {
		this.idPago = idPago;
	}




	public Date getFechapago() {
		return fechapago;
	}




	public void setFechapago(Date fechapago) {
		this.fechapago = fechapago;
	}




	public MetodoPago getMetodopago() {
		return metodopago;
	}




	public void setMetodopago(MetodoPago metodopago) {
		this.metodopago = metodopago;
	}




	public Pago() {
		super();
	}




	public Pago(String idPago, MetodoPago metodopago) {
		super();
		this.idPago = idPago;
		this.metodopago = metodopago;
	}





	
}
