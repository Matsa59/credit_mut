package com.credit.actions.user;

import com.credit.managers.EMF;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import entities.UsersEntity;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Map;

/**
 * Created by Alexandre on 03/06/2016.
 */
public class LoginUserAction extends ActionSupport {
    private EntityManager em;
    private String errorMessage;
    private UsersEntity userEntity;

    /**
     * Create a new user session
     * @return
     */
    public String execute() {
        Map session = ActionContext.getContext().getSession();

        if (session.get("user_session") != null) {
            return SUCCESS;
        }

        if (this.userEntity.getUsername() == null || this.userEntity.getPassword() == null) {
            return INPUT;
        }

        if (this.userEntity.getUsername().equals("") || this.userEntity.getPassword().equals("")) {
            errorMessage = "Username or password is empty.";
            return INPUT;
        }

        em = EMF.createEntityManager();

        Query query = em.createQuery(
                "SELECT u FROM UsersEntity u WHERE u.username = :username AND u.password = :password"
        );
        query.setParameter("username", userEntity.getUsername());
        query.setParameter("password", userEntity.getPassword());

        UsersEntity userEntity;

        try {
            userEntity = (UsersEntity) query.getSingleResult();
        } catch (Exception e) {
            errorMessage = "Username and/or password is incorrect.";
            return INPUT;
        }

        session.put("user_session", userEntity.getId());

        return SUCCESS;
    }

    /**
     * Remove user session
     * @return
     */
    public String remove()
    {
        Map session = ActionContext.getContext().getSession();
        session.remove("user_session");

        return SUCCESS;
    }

    /**
     * return user entity
     * @return
     */
    public UsersEntity getUserEntity() {
        return userEntity;
    }

    /**
     * define user entity (by form)
     * @param userEntity
     */
    public void setUserEntity(UsersEntity userEntity) {
        this.userEntity = userEntity;
    }

    /**
     * return error message
     * @return
     */
    public String getErrorMessage() {
        return errorMessage;
    }
}
