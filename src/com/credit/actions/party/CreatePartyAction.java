package com.credit.actions.party;

import com.credit.managers.EMF;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import entities.*;

import javax.persistence.EntityManager;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by Alexandre on 04/06/2016.
 */
public class CreatePartyAction extends ActionSupport {

    private EntityManager em;
    private UsersEntity user;
    private PartiesEntity party;
    private Collection<TournamentsEntity> tournaments;
    private int tournamentId;
    private ChoicesPartiesEntity[] choices;

    public String execute()
    {
        em = EMF.createEntityManager();
        Map session = ActionContext.getContext().getSession();

        if (session.get("user_session") == null) {
            return ERROR;
        }

        user = (UsersEntity)session.get("user_session");

        if (this.party == null) {
            tournaments = user.getTournamentsEntity();
            return INPUT;
        }

        TournamentsEntity tournament = null;

        try {
            tournament = (TournamentsEntity) em.createQuery("select t from TournamentsEntity t WHERE id = :id")
                    .setParameter("id", tournamentId)
                    .getSingleResult();
        } catch (Exception e){

        }

        party.setUsersEntity(user);
        party.setTournamentsEntity(tournament);
        //party.setChoicesPartiesEntity(null);

        em.getTransaction().begin();

        em.persist(party);
        em.flush();
        em.getTransaction().commit();

        em.getTransaction().begin();

        for(ChoicesPartiesEntity choice : choices) {
            choice.setPartiesEntity(party);
            em.persist(choice);
        }

        em.flush();
        em.getTransaction().commit();
        em.close();

        return SUCCESS;
    }

    public PartiesEntity getParty() {
        return party;
    }

    public void setParty(PartiesEntity party) {
        this.party = party;
    }

    public Collection<TournamentsEntity> getTournaments() {
        return tournaments;
    }

    /**
     * Check is user have been the same group as this new tournament
     * @return
     */
    private boolean checkUserAndTournamentGroup()
    {
        for(GroupsEntity group : party.getTournamentsEntity().getGroupsEntities()) {
            if (user.getGroupsEntities().contains(group)) {
                return true;
            }
        }

        return false;
    }

    public int getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(int tournamentId) {
        this.tournamentId = tournamentId;
    }

    public void setChoice(String[] choicesName) {
        this.choices = new ChoicesPartiesEntity[choicesName.length];

        for(int i = 0; i < choices.length; i++) {
            choices[i] = new ChoicesPartiesEntity();
            choices[i].setName(choicesName[i]);
        }
    }
}
