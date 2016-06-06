package com.credit.managers;

import com.opensymphony.xwork2.ActionContext;
import entities.UsersEntity;

import javax.persistence.EntityManager;
import java.util.Map;

/**
 * Created by Alexandre on 06/06/2016.
 */
public class SessionManager {
    public static UsersEntity getUser(EntityManager em)
    {
        Map session = ActionContext.getContext().getSession();

        if (session.get("user_session") == null) {
            return null;
        }

        int userId = (int)session.get("user_session");
        UsersEntity user = (UsersEntity)em.createQuery("select u from UsersEntity u where id = :id")
                .setParameter("id", userId)
                .getSingleResult();

        return user;
    }
}
