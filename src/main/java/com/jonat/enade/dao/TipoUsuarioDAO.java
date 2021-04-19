/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jonat.enade.dao;

import com.jonat.enade.model.TipoUsuario;

/**
 *
 * @author jonat
 */
public class TipoUsuarioDAO extends GenericDAO<TipoUsuario, Integer> {

    public static TipoUsuarioDAO tipoUsuarioDAO;

    public TipoUsuarioDAO() {
        super(TipoUsuario.class);
    }

    public static TipoUsuarioDAO getInstance() {
        if (tipoUsuarioDAO == null) {
            tipoUsuarioDAO = new TipoUsuarioDAO();
        }
        return tipoUsuarioDAO;
    }

}
