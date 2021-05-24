/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jonat.enade.resources;

import com.jonat.enade.dao.TipoQuestaoDAO;
import com.jonat.enade.model.TipoQuestao;
import javax.ws.rs.Path;

/**
 *
 * @author jonat
 */
@Path("tipoquestao")
public class TipoQuestaoResource extends GenericResource<TipoQuestao, TipoQuestaoDAO> {

    public TipoQuestaoResource() {
        super(TipoQuestaoDAO.class);
    }

}
