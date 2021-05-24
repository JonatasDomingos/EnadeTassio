/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jonat.enade.controller;

import com.jonat.enade.dao.FactoryDAO;
import com.jonat.enade.dao.UsuarioDAO;
import com.jonat.enade.model.TipoUsuario;
import com.jonat.enade.model.Usuario;
import com.google.common.hash.Hashing;
import javax.faces.event.ActionEvent;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author jonat
 */
@Named
@ViewScoped
public class UsuarioController implements Serializable {

    private final FactoryDAO factoryDAO = new FactoryDAO();
    private final Class<UsuarioDAO> daoClass;

    Usuario usuario = new Usuario();
    List<Usuario> usuarios = new ArrayList<>();

    public UsuarioController() {
        daoClass = UsuarioDAO.class;
        usuarios = factoryDAO.getInstance(daoClass).findAll();
        usuario = new Usuario();
    }

    public void gravar(ActionEvent actionEvent) {
        String senhaCriptografada = Hashing.sha256().hashString(usuario.getSenha(), StandardCharsets.UTF_8).toString();
        usuario.setSenha(senhaCriptografada);
        if (usuario.getTipoUsuarioidTipoUsuario() == null) {
            TipoUsuario tipoUsuario = new TipoUsuario();
            tipoUsuario.setIdTipoUsuario(1);
            usuario.setTipoUsuarioidTipoUsuario(tipoUsuario);
        }
        factoryDAO.getInstance(daoClass).merge(usuario);
        usuarios = factoryDAO.getInstance(daoClass).findAll();
        usuario = new Usuario();
    }

    public void remover(ActionEvent actionEvent) {
        factoryDAO.getInstance(daoClass).remove(usuario.getIdUsuario());
        usuarios = factoryDAO.getInstance(daoClass).findAll();
        usuario = new Usuario();
    }

    public void onRowEdit(RowEditEvent event) {
        Usuario obj = (Usuario) event.getObject();
        setUsuario(obj);
        gravar(null);
        FacesMessage msg = new FacesMessage("Editado", obj.toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowCancel(RowEditEvent<Usuario> event) {
        FacesMessage msg = new FacesMessage("Cancelado", event.getObject().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

}
