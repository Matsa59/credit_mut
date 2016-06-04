package com.credit.actions.tournaments;

import com.credit.managers.EMF;
import com.opensymphony.xwork2.ActionSupport;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by Alexandre on 04/06/2016.
 */
public class IndexTournamentAction extends ActionSupport {

    private EntityManager em;
    private List tournaments;

    public String execute()
    {
        em = EMF.createEntityManager();
        List tournaments = em.createQuery("select t from TournamentsEntity t order by id desc").getResultList();
        em.close();

        return SUCCESS;
    }

    public List getTournaments() {
        return tournaments;
    }

    public void setTournaments(List tournaments) {
        this.tournaments = tournaments;
    }
}
