package com.gsnotes.services.impl;

import com.gsnotes.bo.Filiere;
import com.gsnotes.bo.Utilisateur;
import com.gsnotes.dao.IFiliereDao;
import com.gsnotes.dao.IUtilisateurDao;
import com.gsnotes.services.IFiliereService;
import com.gsnotes.utils.export.ExcelExporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class FiliereServiceImpl implements IFiliereService {

    @Autowired
    private IFiliereDao filiereDao;

    public List<Filiere> getAllFilieres() {

        return filiereDao.findAll();
    }

    @Override
    public void deleteFiliere(Long id) {
        filiereDao.deleteById(id);
    }

    public Filiere getFiliereById(Long id) {
        return filiereDao.getById(id);

    }
    @Override
    public void addFiliere(Filiere filiere) {
        filiereDao.save(filiere);

    }

    @Override
    public void updateFiliere(Filiere filiere) {
        filiereDao.save(filiere);

    }
    @Override
    public ExcelExporter prepareFiliereExport(List<Filiere> filieres) {
        String[] columnNames = new String[] { "Titre de filiere", "Annee d'accreditation", "Annee fin d'acreditation", "Code" };
        String[][] data = new String[filieres.size()][4];

        int i = 0;
        for (Filiere f : filieres) {
            data[i][0] = f.getTitreFiliere();
            data[i][1] = String.valueOf(f.getAnneeaccreditation());
            data[i][2] = String.valueOf(f.getAnneeFinaccreditation());
            data[i][3] = f.getCodeFiliere();

            i++;
        }

        return new ExcelExporter(columnNames, data, "filiers");

    }


}
