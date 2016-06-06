package com.credit.actions.tournaments;

import com.credit.managers.EMF;
import com.credit.managers.SessionManager;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import entities.TournamentsEntity;
import entities.UsersEntity;

import javax.persistence.EntityManager;
import java.util.Map;

/**
 * Created by Alexandre on 05/06/2016.
 */
public class ShowTournamentAction extends ActionSupport {

    private EntityManager em;
    private UsersEntity user;
    private TournamentsEntity tournament;
    private int id;

    public String execute()
    {
        em = EMF.createEntityManager();

        try {
            tournament = (TournamentsEntity) em.createQuery("select t from TournamentsEntity t where id = :id")
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (Exception e) {
            return ERROR;
        }

        user = SessionManager.getUser(em);
        em.close();

        return SUCCESS;
    }

    public TournamentsEntity getTournament() {
        return tournament;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UsersEntity getUser() {
        return user;
    }
}
