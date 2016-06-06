package com.credit.actions.group;

import com.credit.managers.EMF;
import com.credit.managers.SessionManager;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import entities.GroupsEntity;
import entities.UsersEntity;

import javax.persistence.EntityManager;
import java.util.Map;

/**
 * Created by Alexandre on 06/06/2016.
 */
public class InviteGroupAction extends ActionSupport {

    private int groupId;
    private String username;

    public String execute() {
        String result = SUCCESS;

        EntityManager em = EMF.createEntityManager();
        UsersEntity user = SessionManager.getUser(em);

        if (user == null) {
            em.close();
            return LOGIN;
        }

        try {
            UsersEntity newUser = (UsersEntity)em.createQuery("select u from UsersEntity u where username = :username")
                    .setParameter("username", username)
                    .getSingleResult();

            GroupsEntity group = (GroupsEntity)em.createQuery("select g from GroupsEntity g where id = :id")
                    .setParameter("id", groupId)
                    .getSingleResult();

            if (group.getOwner().getId() != user.getId()) {
                result = ERROR;
            } else {
                group.getUsersEntities().add(newUser);

                em.getTransaction().begin();
                em.persist(group);
                em.flush();
                em.getTransaction().commit();
                em.close();
            }
        } catch (Exception e) {
            result = ERROR;
            em.close();
        }

        return result;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
