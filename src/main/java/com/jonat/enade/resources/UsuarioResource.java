/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jonat.enade.resources;

import com.jonat.enade.dao.UsuarioDAO;
import com.jonat.enade.model.Usuario;
import javax.ws.rs.Path;

/**
 *
 * @author jonat
 */
@Path("usuario")
public class UsuarioResource extends GenericResource<Usuario, UsuarioDAO> {

    public UsuarioResource() {
        super(UsuarioDAO.class);
    }

}
