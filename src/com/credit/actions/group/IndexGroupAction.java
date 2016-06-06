package com.credit.actions.group;

import com.credit.managers.EMF;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import entities.GroupsEntity;
import entities.UsersEntity;

import javax.persistence.EntityManager;
import java.security.acl.Group;
import java.util.Collection;
import java.util.Map;

/**
 * Created by Alexandre on 05/06/2016.
 */
public class IndexGroupAction extends ActionSupport {

    private Collection<GroupsEntity> groups;
    private GroupsEntity currentGroup;
    private int groupId = -1;
    private UsersEntity user;

    public IndexGroupAction()
    {
        Map session = ActionContext.getContext().getSession();
        user = (UsersEntity)session.get("user_session");
    }

    public String execute()
    {
        EntityManager em = EMF.createEntityManager();
        groups = (Collection<GroupsEntity>) em.createQuery(
                "select g from GroupsEntity g where isPublic = 1 order by id"
        ).getResultList();

        if (groupId > 0) {
            for(GroupsEntity group : groups) {
                if (group.getId() == groupId) {
                    currentGroup = group;
                }
            }
        }

        return SUCCESS;
    }

    public String myGroupsExecute() {
        Map session = ActionContext.getContext().getSession();
        UsersEntity user = (UsersEntity)session.get("user_session");

        if (user == null) {
            return LOGIN;
        }

        groups = user.getGroupsEntities();

        if (groupId > 0) {
            for(GroupsEntity group : groups) {
                if (group.getId() == groupId) {
                    currentGroup = group;
                }
            }
        }

        groups = user.getGroupsEntities();
        return SUCCESS;
    }

    public Collection<GroupsEntity> getGroups() {
        return groups;
    }

    public GroupsEntity getCurrentGroup() {
        return currentGroup;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public UsersEntity getUser() {
        return user;
    }
}
