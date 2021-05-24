/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jonat.enade.resources;

import com.jonat.enade.dao.ResultadoDAO;
import com.jonat.enade.model.Resultado;
import javax.ws.rs.Path;

/**
 *
 * @author jonat
 */
@Path("resultado")
public class ResultadoResource extends GenericResource<Resultado, ResultadoDAO> {

    public ResultadoResource() {
        super(ResultadoDAO.class);
    }

}
