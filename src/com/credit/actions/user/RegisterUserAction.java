package com.credit.actions.user;

import com.credit.managers.EMF;
import com.opensymphony.xwork2.ActionSupport;
import entities.UsersEntity;

import javax.persistence.EntityManager;
import java.util.LinkedList;

/**
 * Created by Alexandre on 03/06/2016.
 */
public class RegisterUserAction extends ActionSupport {
    private EntityManager em;
    private UsersEntity userEntity;
    private String errorMessage = "";

    public String execute()
    {
        if (
                userEntity.getPassword() == null
                || userEntity.getLastName() == null
                || userEntity.getFirstName() == null
                || userEntity.getEmail() == null
                || userEntity.getUsername() == null
        ) {
            return INPUT;
        }

        em = EMF.createEntityManager();

        long count = (long)em.createQuery(
                "SELECT count(*) " +
                "FROM UsersEntity u " +
                "WHERE u.username = :username" +
                " OR u.email = :email"
        ).setParameter("username", userEntity.getUsername())
        .setParameter("email", userEntity.getEmail())
        .getSingleResult();

        if (count != 0) {
            errorMessage = "Username or email already used";
            em.close();
            return INPUT;
        }

        em.getTransaction().begin();
        em.persist(userEntity);
        em.flush();
        em.getTransaction().commit();

        em.close();
        return SUCCESS;
    }

    public UsersEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UsersEntity userEntity) {
        this.userEntity = userEntity;
    }
}
