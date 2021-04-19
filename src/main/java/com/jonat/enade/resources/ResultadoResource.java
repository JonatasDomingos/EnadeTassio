/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jonat.enade.resources;

import com.jonat.enade.dao.ResultadoDAO;
import com.jonat.enade.model.Resultado;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author jonat
 */
@Path("resultado")
public class ResultadoResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/findAll")
    public List<Resultado> findAll() {
        List<Resultado> entityList = ResultadoDAO.getInstance().findAll();
        return entityList;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/find/{id}")
    public Resultado find(@PathParam("id") Integer id) {
        return ResultadoDAO.getInstance().find(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/merge")
    public String merge(Resultado entity) {
        try {
            ResultadoDAO.getInstance().merge(entity).toString();
            return "Registrado com sucesso!!";
        } catch (Exception e) {
            return "Erro ao salvar um registro! " + e.getMessage();
        }
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/removeAll")
    public String removeAll() {
        try {
            ResultadoDAO.getInstance().removeAll();
            return "Exclusão feita com sucesso!";
        } catch (Exception e) {
            return "Erro ao excluir o registro! " + e.getMessage();
        }
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/remove/{id}")
    public String remove(@PathParam("id") Integer id) {
        try {
            ResultadoDAO.getInstance().remove(id);
            return "Registro excluído com sucesso!";
        } catch (Exception e) {
            return "Erro ao excluir o registro! " + e.getMessage();
        }
    }

}
