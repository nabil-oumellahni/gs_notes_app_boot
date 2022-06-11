package com.gsnotes.web.models;

import com.gsnotes.bo.Filiere;

import javax.validation.constraints.NotBlank;
import java.util.List;

public class NiveauModel {


    private Long idNiveau;
    @NotBlank(message = "This field is required")
    private String alias;
    @NotBlank(message = "This field is required")
    private String titre;
    private List<Module> modules;
    private Filiere filiere;

    public Long getIdNiveau() {
        return idNiveau;
    }

    public void setIdNiveau(Long idNiveau) {
        this.idNiveau = idNiveau;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public List<Module> getModules() {
        return modules;
    }

    public void setModules(List<Module> modules) {
        this.modules = modules;
    }
    public Filiere getFiliere() {
        return filiere;
    }

    public void setFiliere(Filiere filiere) {
        this.filiere = filiere;
    }

}
