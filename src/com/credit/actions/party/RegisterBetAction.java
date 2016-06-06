package com.credit.actions.party;

import com.credit.managers.EMF;
import com.credit.managers.SessionManager;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import entities.ChoicesPartiesEntity;
import entities.UsersEntity;

import javax.persistence.EntityManager;
import java.util.Map;

/**
 * Created by Alexandre on 05/06/2016.
 */
public class RegisterBetAction extends ActionSupport {

    private int choiceId = -1;

    public String execute() {

        EntityManager em = EMF.createEntityManager();
        UsersEntity user = SessionManager.getUser(em);

        if (user == null) {
            em.close();
            return LOGIN;
        }


        try {
            ChoicesPartiesEntity choice = (ChoicesPartiesEntity)em.createQuery(
                    "select c FROM ChoicesPartiesEntity c where  id = :id"
            ).setParameter("id", choiceId).getSingleResult();

            for(ChoicesPartiesEntity entity : user.getChoicesPartiesEntities()) {
                if (entity.getPartiesEntity() == choice.getPartiesEntity()) {
                    em.close();
                    return ERROR;
                }
            }

            user.getChoicesPartiesEntities().add(choice);
            choice.getUsersEntities().add(user);

            em.getTransaction().begin();
            em.persist(choice);
            em.flush();
            em.getTransaction().commit();

        } catch (Exception e) {
            em.close();
            return ERROR;
        }

        em.close();

        return SUCCESS;
    }

    public int getChoiceId() {
        return choiceId;
    }

    public void setChoiceId(int choiceId) {
        this.choiceId = choiceId;
    }
}
