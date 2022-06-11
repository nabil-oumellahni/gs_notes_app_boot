package com.gsnotes.services.impl;


import com.gsnotes.bo.Enseignant;
import com.gsnotes.dao.IEnseignantDao;
import com.gsnotes.dao.IFiliereDao;
import com.gsnotes.services.IEnseignantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EnseignantServiceImpl implements IEnseignantService {
    @Autowired
    private IEnseignantDao enseignantDao;

    @Override
    public Enseignant getEnseignantById(Long id) {
        return enseignantDao.getById(id);
    }

    @Override
    public List<Enseignant> getAllEnseignants() {
        return enseignantDao.findAll();
    }
}
