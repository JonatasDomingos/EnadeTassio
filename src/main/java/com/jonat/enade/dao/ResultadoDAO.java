/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jonat.enade.dao;

import com.jonat.enade.model.Resultado;
import java.util.List;

/**
 *
 * @author jonat
 */
public class ResultadoDAO extends GenericDAO<Resultado, Integer> {

    public ResultadoDAO() {
        super(Resultado.class);
    }

    public List<Resultado> findResultadosUsuario(Integer idUsuario) {
        return entityManager.createNamedQuery("Resultado.findByIdUsuario", Resultado.class)
                .setParameter("idUsuario", idUsuario).getResultList();
    }
    
    public List<Resultado> findUltimosDezResultados() {
        return entityManager.createQuery("from Resultado r ORDER BY r.idResultado DESC", Resultado.class).setMaxResults(10).getResultList();
    }

}
