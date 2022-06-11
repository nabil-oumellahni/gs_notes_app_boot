package com.gsnotes.services.impl;

import com.gsnotes.bo.Module;
import com.gsnotes.bo.Niveau;
import com.gsnotes.dao.IModuleDAO;
import com.gsnotes.services.IModuleService;
import com.gsnotes.utils.export.ExcelExporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ModuleServiceImpl implements IModuleService {
    @Autowired
    private IModuleDAO moduleDAO;


    @Override
    public void addModule(Module module) {
        moduleDAO.save(module);

    }


    @Override
    public void updateModule(Module module) {
        moduleDAO.save(module);
    }

    @Override
    public List<Module> getAllModules() {
        return moduleDAO.findAll();
    }

    @Override
    public void deleteModule(Long id) {
        moduleDAO.deleteById(id);
    }

    @Override
    public Module getModuleById(Long id) {
        return moduleDAO.getById(id);
    }
}
