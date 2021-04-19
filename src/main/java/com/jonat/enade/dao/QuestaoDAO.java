/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jonat.enade.dao;

import com.jonat.enade.model.Questao;

/**
 *
 * @author jonat
 */
public class QuestaoDAO extends GenericDAO<Questao, Integer> {

    public static QuestaoDAO questaoDAO;

    public QuestaoDAO() {
        super(Questao.class);
    }

    public static QuestaoDAO getInstance() {
        if (questaoDAO == null) {
            questaoDAO = new QuestaoDAO();
        }
        return questaoDAO;
    }

}
