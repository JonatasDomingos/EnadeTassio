/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jonat.enade.resources;

import com.jonat.enade.dao.ProvaDAO;
import com.jonat.enade.model.Prova;
import javax.ws.rs.Path;

/**
 *
 * @author jonat
 */
@Path("prova")
public class ProvaResource extends GenericResource<Prova, ProvaDAO> {

    public ProvaResource() {
        super(ProvaDAO.class);
    }

}
