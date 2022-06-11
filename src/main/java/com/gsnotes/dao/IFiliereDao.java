package com.gsnotes.dao;

import com.gsnotes.bo.Filiere;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IFiliereDao extends JpaRepository<Filiere, Long> {

//    public Filiere getFiliereByCode(String codeFiliere);
}
