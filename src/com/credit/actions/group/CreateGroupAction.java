package com.credit.actions.group;

import com.credit.managers.EMF;
import com.credit.managers.SessionManager;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import entities.GroupsEntity;
import entities.UsersEntity;

import javax.persistence.EntityManager;
import java.security.acl.Group;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by Alexandre on 05/06/2016.
 */
public class CreateGroupAction extends ActionSupport {

    private GroupsEntity group;
    private EntityManager em;

    public String execute()
    {
        em = EMF.createEntityManager();
        UsersEntity user = SessionManager.getUser(em);

        if (user == null) {
            em.close();
            return ERROR;
        }

        if (group == null) {
            em.close();
            return INPUT;
        }

        em.getTransaction().begin();

        group.setOwner(user);
        group.getUsersEntities().add(user);
        em.persist(group);
        em.flush();
        em.getTransaction().commit();

        em.close();

        return SUCCESS;
    }

    public GroupsEntity getGroup() {
        return group;
    }

    public void setGroup(GroupsEntity group) {
        this.group = group;
    }
}
