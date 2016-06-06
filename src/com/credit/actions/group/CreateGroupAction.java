package com.credit.actions.group;

import com.credit.managers.EMF;
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
        Map session = ActionContext.getContext().getSession();
        UsersEntity user = (UsersEntity)session.get("user_session");

        if (user == null) {
            return ERROR;
        }

        if (group == null) {
            return INPUT;
        }

        em = EMF.createEntityManager();
        em.getTransaction().begin();

        group.setOwner(user);
        group.getUsersEntities().add(user);
        group = em.merge(group);
        em.flush();

        em.getTransaction().commit();

        user.getGroupsEntitiesOwn().add(group);
        user.getGroupsEntities().add(group);

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
