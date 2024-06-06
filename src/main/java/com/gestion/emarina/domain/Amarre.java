package com.gestion.emarina.domain;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "amarre")
public class Amarre {

	
	@EmbeddedId
    private AmarreId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "limitesamarre_id", columnDefinition = "VARCHAR(36) NOT NULL")
    private LimiteAmarre limiteAmarre;

	public AmarreId getId() {
		return id;
	}

	public void setId(AmarreId id) {
		this.id = id;
	}

	public LimiteAmarre getLimiteAmarre() {
		return limiteAmarre;
	}

	public void setLimiteAmarre(LimiteAmarre limiteAmarre) {
		this.limiteAmarre = limiteAmarre;
	}

	public Amarre(AmarreId id, LimiteAmarre limiteAmarre) {
		super();
		this.id = id;
		this.limiteAmarre = limiteAmarre;
	}

	public Amarre() {
		super();
	}
    
    
    
}
