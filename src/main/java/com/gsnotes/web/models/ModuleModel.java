package com.gsnotes.web.models;

import com.gsnotes.bo.Enseignant;
import com.gsnotes.bo.Niveau;

import javax.validation.constraints.NotBlank;

public class ModuleModel {
    private Long idModule;
    @NotBlank(message = "This field is required")
    private String titre;
    @NotBlank(message = "This field is required")
    private String code;
    // association
    private Niveau niveau;
    private Enseignant enseignant;

    public Enseignant getEnseignant() {
        return enseignant;
    }

    public void setEnseignant(Enseignant enseignant) {
        this.enseignant = enseignant;
    }

    public Long getIdNiveau(){
        return this.niveau.getIdNiveau();
    }
    public void setNiveauId(Long id){
        this.niveau.setIdNiveau(id);
    }


    public Niveau getNiveau() {
        return niveau;
    }

    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }
    public ModuleModel(Long idModule) {
        this.idModule = idModule;

    }
    public ModuleModel(){

    }


    public Long getIdModule() {
        return idModule;
    }

    public void setIdModule(Long idModule) {
        this.idModule = idModule;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
