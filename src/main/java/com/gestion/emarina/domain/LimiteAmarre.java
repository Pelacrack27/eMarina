package com.gestion.emarina.domain;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "limiteamarre")
public class LimiteAmarre {

	
	@Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "id_limiteamarre", columnDefinition = "VARCHAR(36) NOT NULL")
    private String idLimiteamarre;

	@Column(name = "letra_amarre", columnDefinition = "VARCHAR(1) NOT NULL")
    private String letraAmarre;

    @Column(name = "esloramax", columnDefinition = "DOUBLE NOT NULL")
    private double esloraMax;

    @Column(name = "mangamax", columnDefinition = "DOUBLE NOT NULL")
    private double mangaMax;
    
  

    public String getIdLimiteamarre() {
		return idLimiteamarre;
	}

	public void setIdLimiteamarre(String idLimiteamarre) {
		this.idLimiteamarre = idLimiteamarre;
	}

	public String getLetraAmarre() {
        return letraAmarre;
    }

    public void setLetraAmarre(String letraAmarre) {
        this.letraAmarre = letraAmarre;
    }

    public double getEsloraMax() {
        return esloraMax;
    }

    public void setEsloraMax(double esloraMax) {
        this.esloraMax = esloraMax;
    }

    public double getMangaMax() {
        return mangaMax;
    }

    public void setMangaMax(double mangaMax) {
        this.mangaMax = mangaMax;
    }

	public LimiteAmarre(String idLimiteamarre, String letraAmarre, double esloraMax, double mangaMax) {
		super();
		this.idLimiteamarre = idLimiteamarre;
		this.letraAmarre = letraAmarre;
		this.esloraMax = esloraMax;
		this.mangaMax = mangaMax;
	}

	public LimiteAmarre() {
		super();
	}
    
    
}
