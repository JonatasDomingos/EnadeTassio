/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jonat.enade.controller;

import com.jonat.enade.dao.ProvaDAO;
import com.jonat.enade.model.Prova;
import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author jonat
 */
@Named
@ViewScoped
public class ProvaController implements Serializable {

    Prova prova = new Prova();
    List<Prova> provas = new ArrayList<>();

    public ProvaController() {
        provas = ProvaDAO.getInstance().findAll();
        prova = new Prova();
    }

    public void gravar(ActionEvent actionEvent) {
        ProvaDAO.getInstance().merge(prova);
        provas = ProvaDAO.getInstance().findAll();
        prova = new Prova();
    }

    public void remover(ActionEvent actionEvent) {
        ProvaDAO.getInstance().remove(prova.getIdProva());
        provas = ProvaDAO.getInstance().findAll();
        prova = new Prova();
    }

    public Prova getProva() {
        return prova;
    }

    public void setProva(Prova prova) {
        this.prova = prova;
    }

    public List<Prova> getProvas() {
        return provas;
    }

    public void setProvas(List<Prova> provas) {
        this.provas = provas;
    }

}
