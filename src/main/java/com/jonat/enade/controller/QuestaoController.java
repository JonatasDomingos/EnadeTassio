/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jonat.enade.controller;

import com.jonat.enade.dao.QuestaoDAO;
import com.jonat.enade.model.Questao;
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
public class QuestaoController implements Serializable {

    Questao questao = new Questao();
    List<Questao> questoes = new ArrayList<>();

    public QuestaoController() {
        questoes = QuestaoDAO.getInstance().findAll();
        questao = new Questao();
    }

    public void gravar(ActionEvent actionEvent) {
        QuestaoDAO.getInstance().merge(questao);
        questoes = QuestaoDAO.getInstance().findAll();
        questao = new Questao();
    }

    public void remover(ActionEvent actionEvent) {
        QuestaoDAO.getInstance().remove(questao.getIdQuestao());
        questoes = QuestaoDAO.getInstance().findAll();
        questao = new Questao();
    }

    public Questao getQuestao() {
        return questao;
    }

    public void setQuestao(Questao questao) {
        this.questao = questao;
    }

    public List<Questao> getQuestoes() {
        return questoes;
    }

    public void setQuestoes(List<Questao> questoes) {
        this.questoes = questoes;
    }

}
