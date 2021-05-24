/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jonat.enade.resources;

import com.jonat.enade.dao.TipoUsuarioDAO;
import com.jonat.enade.model.TipoUsuario;
import javax.ws.rs.Path;

/**
 *
 * @author jonat
 */
@Path("tipousuario")
public class TipoUsuarioResource extends GenericResource<TipoUsuario, TipoUsuarioDAO> {

    public TipoUsuarioResource() {
        super(TipoUsuarioDAO.class);
    }

}
