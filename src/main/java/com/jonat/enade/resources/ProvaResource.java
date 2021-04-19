/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jonat.enade.resources;

import com.jonat.enade.dao.ProvaDAO;
import com.jonat.enade.model.Prova;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author jonat
 */
@Path("prova")
public class ProvaResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/findAll")
    public List<Prova> findAll() {
        List<Prova> entityList = ProvaDAO.getInstance().findAll();
        return entityList;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/find/{id}")
    public Prova find(@PathParam("id") Integer id) {
        return ProvaDAO.getInstance().find(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/merge")
    public String merge(Prova entity) {
        try {
            ProvaDAO.getInstance().merge(entity).toString();
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
            ProvaDAO.getInstance().removeAll();
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
            ProvaDAO.getInstance().remove(id);
            return "Registro excluído com sucesso!";
        } catch (Exception e) {
            return "Erro ao excluir o registro! " + e.getMessage();
        }
    }
    
//    @GET
//    public Response ping(){
//        return Response
//                .ok("ping")
//                .build();
//    }

}
