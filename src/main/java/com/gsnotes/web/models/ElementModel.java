package com.gsnotes.web.models;

import com.gsnotes.bo.Module;

import javax.validation.constraints.NotBlank;

public class ElementModel {
    private Long idMatiere;

    @NotBlank(message = "This field is required")
    private String nom;
    @NotBlank(message = "This field is required")
    private String code;
    private double currentCoefficient;
    //    association
    private Module module;

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public Long getIdMatiere() {
        return idMatiere;
    }

    public void setIdMatiere(Long idMatiere) {
        this.idMatiere = idMatiere;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getCurrentCoefficient() {
        return currentCoefficient;
    }

    public void setCurrentCoefficient(double currentCoefficient) {
        this.currentCoefficient = currentCoefficient;
    }
}
