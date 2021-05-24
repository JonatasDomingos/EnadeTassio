/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jonat.enade.resources;

import com.jonat.enade.dao.QuestaoDAO;
import com.jonat.enade.model.Questao;
import javax.ws.rs.Path;

/**
 *
 * @author jonat
 */
@Path("questao")
public class QuestaoResource extends GenericResource<Questao, QuestaoDAO> {

    public QuestaoResource() {
        super(QuestaoDAO.class);
    }

}
