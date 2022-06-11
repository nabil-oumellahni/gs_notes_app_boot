package com.gsnotes.services;

import com.gsnotes.bo.Enseignant;
import com.gsnotes.bo.Filiere;

import java.util.List;

public interface IEnseignantService {
    public Enseignant getEnseignantById(Long id);
    public List<Enseignant> getAllEnseignants();

}
