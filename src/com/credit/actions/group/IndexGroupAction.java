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
import java.util.Map;

/**
 * Created by Alexandre on 05/06/2016.
 */
public class IndexGroupAction extends ActionSupport {

    private Collection<GroupsEntity> groups;
    private GroupsEntity currentGroup;
    private int groupId = -1;
    private UsersEntity user;
    private EntityManager em;

    public IndexGroupAction()
    {
        em = EMF.createEntityManager();
        user = SessionManager.getUser(em);
    }

    public String execute()
    {
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

        em.close();

        return SUCCESS;
    }

    public String myGroupsExecute() {

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
