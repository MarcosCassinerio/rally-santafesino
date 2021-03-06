package com.rally.santafesino.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A Localidad_carrera.
 */
@Entity
@Table(name = "localidad_carrera")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Localidad_carrera implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @NotNull
    private Carrera id_carrera;

    @ManyToOne(optional = false)
    @NotNull
    private Localidad id_localidad;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Carrera getId_carrera() {
        return id_carrera;
    }

    public Localidad_carrera id_carrera(Carrera carrera) {
        this.id_carrera = carrera;
        return this;
    }

    public void setId_carrera(Carrera carrera) {
        this.id_carrera = carrera;
    }

    public Localidad getId_localidad() {
        return id_localidad;
    }

    public Localidad_carrera id_localidad(Localidad localidad) {
        this.id_localidad = localidad;
        return this;
    }

    public void setId_localidad(Localidad localidad) {
        this.id_localidad = localidad;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Localidad_carrera localidad_carrera = (Localidad_carrera) o;
        if (localidad_carrera.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), localidad_carrera.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Localidad_carrera{" +
            "id=" + getId() +
            "}";
    }
}
