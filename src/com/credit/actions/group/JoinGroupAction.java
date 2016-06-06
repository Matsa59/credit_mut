package com.credit.actions.group;

import com.credit.managers.EMF;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import entities.GroupsEntity;
import entities.UsersEntity;

import javax.persistence.EntityManager;
import java.util.Map;

/**
 * Created by Alexandre on 06/06/2016.
 */
public class JoinGroupAction extends ActionSupport {

    private int groupId;

    public String execute() {
        Map session = ActionContext.getContext().getSession();
        UsersEntity user = (UsersEntity)session.get("user_session");

        if (user == null) {
            return LOGIN;
        }

        EntityManager em = EMF.createEntityManager();

        try {
            GroupsEntity group = (GroupsEntity)em.createQuery("select g from GroupsEntity g where id = :id")
                    .setParameter("id", groupId)
                    .getSingleResult();

            if (group.getIsPublic() == 0) {
                em.close();
                return ERROR;
            }

            group.getUsersEntities().add(user);
            user.getGroupsEntities().add(group);

            em.getTransaction().begin();
            em.merge(group);
            em.flush();
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            em.close();
            return ERROR;
        }

        return SUCCESS;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }
}
