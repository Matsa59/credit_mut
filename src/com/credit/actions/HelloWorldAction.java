package com.credit.actions;

import com.credit.managers.EMF;
import entities.UsersEntity;

import javax.ejb.Stateless;
import javax.persistence.*;

/**
 * Created by Alexandre on 09/05/2016.
 */
public class HelloWorldAction {
    private EntityManager em;

    private String name;

    public String execute() throws Exception {
        em = EMF.createEntityManager();
        UsersEntity user = (UsersEntity) em.find(UsersEntity.class, 1);
        em.close();
        return "success";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
