package com.gsnotes.services.impl;

import com.gsnotes.bo.Element;
import com.gsnotes.dao.IElementDAO;
import com.gsnotes.services.IElementService;
import com.gsnotes.utils.export.ExcelExporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ElementServiceImpl implements IElementService {
    @Autowired
    IElementDAO elementDAO ;
    @Override
    public void addElement(Element element) {
          elementDAO.save(element);
    }

    @Override
    public void updateElement(Element element) {
        elementDAO.save(element);
    }

    @Override
    public List<Element> getAllElements() {
        return elementDAO.findAll();
    }

    @Override
    public void deleteElement(Long id) {
        elementDAO.deleteById(id);
    }

    @Override
    public Element getElementById(Long id) {
        return elementDAO.getById(id);
    }

    @Override
    public ExcelExporter prepareElementExport(List<Element> elements) {
        return null;
    }
}
