/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jonat.enade.controller;

import com.jonat.enade.dao.FactoryDAO;
import com.jonat.enade.dao.ResultadoDAO;
import com.jonat.enade.model.Resultado;
import com.jonat.enade.model.Usuario;
import com.jonat.enade.util.Constants;
import javax.faces.event.ActionEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jonat
 */
@Named
@SessionScoped
public class ResultadoController implements Serializable {

    private final FactoryDAO factoryDAO = new FactoryDAO();
    private final Class<ResultadoDAO> daoClass;

    HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
    Resultado resultado = new Resultado();
    List<Resultado> resultados = new ArrayList<>();

    public ResultadoController() {
        daoClass = ResultadoDAO.class;
        resultados = factoryDAO.getInstance(daoClass).findResultadosUsuario(getUsuarioLogado().getIdUsuario());
        resultado = new Resultado();
    }

    public void gravar(ActionEvent actionEvent) {
        factoryDAO.getInstance(daoClass).merge(resultado);
        resultados = factoryDAO.getInstance(daoClass).findResultadosUsuario(getUsuarioLogado().getIdUsuario());
        resultado = new Resultado();
    }

    private Usuario getUsuarioLogado() {
        return (Usuario) session.getAttribute(Constants.HTTP_SESSION_ATRIBUTE_LOGADO);
    }

    public Resultado getResultado() {
        return resultado;
    }

    public void setResultado(Resultado resultado) {
        this.resultado = resultado;
    }

    public List<Resultado> getResultados() {
        return resultados;
    }

    public void setResultados(List<Resultado> resultados) {
        this.resultados = resultados;
    }

}
