package com.gsnotes.services.impl;

import com.gsnotes.bo.Niveau;
import com.gsnotes.dao.INiveauDao;
import com.gsnotes.services.INiveauService;
import com.gsnotes.utils.export.ExcelExporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class NiveauServiceImpl implements INiveauService {
    @Autowired
    private INiveauDao niveauDao;

    @Override
    public void addNiveau(Niveau niveau) {
        niveauDao.save(niveau);
    }

    @Override
    public void updateNiveau(Niveau niveau) {
         niveauDao.save(niveau);
    }

    @Override
    public List<Niveau> getAllNiveaus() {

        return niveauDao.findAll();
    }

    @Override
    public void deleteNiveau(Long id) {
        niveauDao.deleteById(id);
    }

    @Override
    public Niveau getNiveauById(Long id) {
        return niveauDao.getById(id);
    }

    @Override
    public ExcelExporter prepareFiliereExport(List<Niveau> niveaus) {
        return null;
    }
}