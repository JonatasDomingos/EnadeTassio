package com.jonat.enade.model;

import com.jonat.enade.model.Questao;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-05-23T21:27:59")
@StaticMetamodel(TipoQuestao.class)
public class TipoQuestao_ { 

    public static volatile SingularAttribute<TipoQuestao, Integer> idTipoQuestao;
    public static volatile SingularAttribute<TipoQuestao, String> nomeTipoQuestao;
    public static volatile ListAttribute<TipoQuestao, Questao> questaoList;

}