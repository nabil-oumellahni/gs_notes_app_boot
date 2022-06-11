package com.gsnotes.services;

import com.gsnotes.bo.Module;

import java.util.List;

public interface IModuleService {
    public void addModule(Module module);

    public void updateModule(Module module);

    public List<Module> getAllModules();

    public void deleteModule(Long id);

    public Module getModuleById(Long id);
}
