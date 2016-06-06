package com.credit.actions.party;

import com.credit.managers.EMF;
import com.credit.managers.SessionManager;
import com.opensymphony.xwork2.ActionSupport;
import entities.ChoicesPartiesEntity;
import entities.PartiesEntity;
import entities.UsersEntity;

import javax.persistence.EntityManager;

/**
 * Created by Alexandre on 04/06/2016.
 */
public class ShowPartyAction extends ActionSupport {

    private int partyId = -1;
    private PartiesEntity party;
    private int choice = -1;
    private UsersEntity user;

    public String execute()
    {
        if (partyId == -1) {
            return ERROR;
        }

        EntityManager em = EMF.createEntityManager();
        user = SessionManager.getUser(em);

        if (user == null) {
            em.close();
            return LOGIN;
        }

        try {
            party = (PartiesEntity)em.createQuery("select p from PartiesEntity p where id = :id")
                    .setParameter("id", partyId)
                    .getSingleResult();
        } catch (Exception e) {
            em.close();
            return ERROR;
        }

        if (choice == -1) {
            em.close();
            return INPUT;
        }

        em.getTransaction().begin();
        for(ChoicesPartiesEntity choice : party.getChoicesPartiesEntity()) {
            if (this.choice == choice.getId()) {
                choice.setIsResponse(true);
                em.persist(choice);
            } else {
                choice.setIsResponse(false);
                em.persist(choice);
            }
        }

        em.flush();
        em.getTransaction().commit();

        em.close();

        return SUCCESS;
    }

    public int getPartyId() {
        return partyId;
    }

    public void setPartyId(int partyId) {
        this.partyId = partyId;
    }

    public void setChoice(int choice) {
        this.choice = choice;
    }

    public UsersEntity getUser() {
        return user;
    }

    public PartiesEntity getParty() {
        return party;
    }
}
