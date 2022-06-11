package com.gsnotes.web.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class EnseignantModel {
    private Long idEnseignant;

    @NotBlank(message = "This field is required")
    private String nom;

    @NotBlank(message = "This field is required")
    private String prenom;


    private String specialite;
    public EnseignantModel(Long idEnseignant) {
        this.idEnseignant = idEnseignant;
    }
    public Long getIdEnseignant() {
        return idEnseignant;
    }

    public void setIdEnseignant(Long idEnseignant) {
        this.idEnseignant = idEnseignant;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }
}
