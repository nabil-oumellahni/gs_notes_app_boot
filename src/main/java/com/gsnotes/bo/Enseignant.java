package com.gsnotes.bo;



import javax.persistence.*;
import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name = "idEnseignant")
public class Enseignant extends Utilisateur {

	private String specialite;

	@OneToMany(mappedBy = "enseignant" , cascade = CascadeType.ALL, targetEntity = Module.class)
	private List<Module> modules;
	@OneToMany(mappedBy = "enseignant" , cascade = CascadeType.ALL, targetEntity = Filiere.class)
	private List<Filiere> filieres;

	public List<Module> getModules() {
		return modules;
	}

	public void setModules(List<Module> modules) {
		this.modules = modules;
	}

	public List<Filiere> getFilieres() {
		return filieres;
	}

	public void setFilieres(List<Filiere> filieres) {
		this.filieres = filieres;
	}

	public String getSpecialite() {
		return specialite;
	}

	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}

}