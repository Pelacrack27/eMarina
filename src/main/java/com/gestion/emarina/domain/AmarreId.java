package com.gestion.emarina.domain;

import java.io.Serializable;

import jakarta.persistence.Column;

public class AmarreId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "letra", columnDefinition = "VARCHAR(1) NOT NULL")
    private String letra;

    @Column(name = "numero", columnDefinition = "VARCHAR(2) NOT NULL")
    private String numero;

    
    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
    
}
