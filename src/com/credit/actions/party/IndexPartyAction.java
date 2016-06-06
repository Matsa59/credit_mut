package com.credit.actions.party;

import com.credit.managers.EMF;
import com.credit.managers.SessionManager;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import entities.PartiesEntity;
import entities.UsersEntity;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Map;

/**
 * Created by Alexandre on 04/06/2016.
 */
public class IndexPartyAction extends ActionSupport {

    private EntityManager em;
    private List parties;

    public String execute()
    {
        em = EMF.createEntityManager();

        parties = em.createQuery("SELECT p FROM PartiesEntity p WHERE isPublic = 1 AND tournamentsEntity = null order by id desc").getResultList();

        em.close();

        return SUCCESS;
    }

    public String myPartiesExecute()
    {
        em = EMF.createEntityManager();
        UsersEntity user = SessionManager.getUser(em);

        if (user == null) {
            em.close();
            return ERROR;
        }

        parties = em.createQuery(
                "SELECT p FROM PartiesEntity p WHERE isPublic = 1 AND p.usersEntity = :user AND tournamentsEntity = null order by id desc"
        ).setParameter("user", user)
        .getResultList();

        em.close();

        return SUCCESS;
    }

    public List<PartiesEntity> getParties() {
        return parties;
    }
}
