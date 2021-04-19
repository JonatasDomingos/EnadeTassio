/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jonat.enade.dao;

import com.jonat.enade.model.Prova;

/**
 *
 * @author jonat
 */
public class ProvaDAO extends GenericDAO<Prova, Integer> {

    public static ProvaDAO provaDAO;

    public ProvaDAO() {
        super(Prova.class);
    }

    public static ProvaDAO getInstance() {
        if (provaDAO == null) {
            provaDAO = new ProvaDAO();
        }
        return provaDAO;
    }

}