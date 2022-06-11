package com.gsnotes.web.models;

import com.gsnotes.bo.Enseignant;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class FiliereModel {

    private Long idFiliere;
    @NotBlank(message = "This field is required")
    private String titreFiliere;
    @NotBlank(message = "This field is required")
    private String codeFiliere;
    private int anneeaccreditation;
    private int anneeFinaccreditation;
    //    association
    private Enseignant enseignant;
    public Long getIdFiliere() {
        return idFiliere;
    }

    public void setIdFiliere(Long idFiliere) {
        this.idFiliere = idFiliere;
    }

    @Override
    public String toString() {
        return "FiliereModel{" +
                "idFiliere=" + idFiliere +
                ", titreFiliere='" + titreFiliere + '\'' +
                ", codeFiliere='" + codeFiliere + '\'' +
                ", anneeaccreditation=" + anneeaccreditation +
                ", anneeFinaccreditation=" + anneeFinaccreditation +
                '}';
    }

    public String getTitreFiliere() {
        return titreFiliere;
    }

    public void setTitreFiliere(String titreFiliere) {
        this.titreFiliere = titreFiliere;
    }

    public String getCodeFiliere() {
        return codeFiliere;
    }

    public void setCodeFiliere(String codeFiliere) {
        this.codeFiliere = codeFiliere;
    }

    public int getAnneeaccreditation() {
        return anneeaccreditation;
    }

    public void setAnneeaccreditation(int anneeaccreditation) {
        this.anneeaccreditation = anneeaccreditation;
    }

    public int getAnneeFinaccreditation() {
        return anneeFinaccreditation;
    }

    public void setAnneeFinaccreditation(int anneeFinaccreditation) {
        this.anneeFinaccreditation = anneeFinaccreditation;
    }

    public Enseignant getEnseignant() {
        return enseignant;
    }

    public void setEnseignant(Enseignant enseignant) {
        this.enseignant = enseignant;
    }
}
