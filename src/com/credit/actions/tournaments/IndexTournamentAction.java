package com.credit.actions.tournaments;

import com.credit.managers.EMF;
import com.credit.managers.SessionManager;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import entities.GroupsEntity;
import entities.TournamentsEntity;
import entities.UsersEntity;

import javax.persistence.EntityManager;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by Alexandre on 04/06/2016.
 */
public class IndexTournamentAction extends ActionSupport {

    private EntityManager em;
    private List tournaments;
    private List groupsTournaments;

    public String execute() {
        em = EMF.createEntityManager();
        UsersEntity user = SessionManager.getUser(em);

        tournaments = em.createQuery("select t from TournamentsEntity t where isPublic = 1 order by id desc").getResultList();
        em.close();

        if (user == null) {
            return SUCCESS;
        }

        groupsTournaments = new LinkedList<>();

        for(GroupsEntity group : user.getGroupsEntities()) {
            for(TournamentsEntity tournament : group.getTournamentsEntities()) {
                if (!groupsTournaments.contains(tournament)) {
                    groupsTournaments.add(tournament);
                }
            }
        }

        return SUCCESS;
    }

    public String myTournamentsExecute() {
        em = EMF.createEntityManager();
        UsersEntity user = SessionManager.getUser(em);

        if (user == null) {
            em.close();
            return ERROR;
        }

        tournaments = em.createQuery(
                "select t from TournamentsEntity t where usersEntity = :user AND isPublic = 1")
                .setParameter("user", user)
                .getResultList();

        groupsTournaments = em.createQuery(
                "select t from TournamentsEntity t where usersEntity = :user AND isPublic = 0")
                .setParameter("user", user)
                .getResultList();
        em.close();

        return SUCCESS;
    }

    public List getTournaments() {
        return tournaments;
    }

    public void setTournaments(List tournaments) {
        this.tournaments = tournaments;
    }

    public List getGroupsTournaments() {
        return groupsTournaments;
    }
}
