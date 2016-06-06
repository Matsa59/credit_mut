package com.credit.actions.tournaments;

import com.credit.managers.EMF;
import com.credit.managers.SessionManager;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import entities.GroupsEntity;
import entities.TournamentsEntity;
import entities.UsersEntity;

import javax.persistence.EntityManager;
import java.security.acl.Group;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

/**
 * Created by Alexandre on 04/06/2016.
 */
public class CreateTournamentAction extends ActionSupport {
    private EntityManager em;
    private Collection<GroupsEntity> finalGroups;
    private TournamentsEntity tournament;
    private UsersEntity user;

    public String execute()
    {
        em = EMF.createEntityManager();
        user = SessionManager.getUser(em);

        if (user == null) {
            em.close();
            return ERROR;
        }

        if (tournament == null) {
            em.close();
            return INPUT;
        }

        if (finalGroups.size() < 1) {
            em.close();
            return INPUT;
        }

        tournament.setUsersEntity(user);

        em.getTransaction().begin();
        em.persist(tournament);

        for (int i = 0; i < finalGroups.size(); i++) {
            for (GroupsEntity entity : user.getGroupsEntities()) {
                if (((ArrayList<GroupsEntity>)finalGroups).get(i).getId() == entity.getId()) {
                    ((ArrayList<GroupsEntity>)finalGroups).set(i, entity);
                    entity.getTournamentsEntities().add(tournament);
                    em.persist(entity);
                    break;
                }
            }
        }
        em.flush();
        em.getTransaction().commit();
        em.close();

        return SUCCESS;
    }

    public TournamentsEntity getTournament() {
        return tournament;
    }

    public void setTournament(TournamentsEntity tournament) {
        this.tournament = tournament;
    }

    public Collection<GroupsEntity> getGroups() {
        return user.getGroupsEntities();
    }

    public void setFinalGroups(Collection<GroupsEntity> groups) {
        finalGroups = groups;
    }

    public Collection<GroupsEntity> getFinalGroups()
    {
        return finalGroups;
    }
}
