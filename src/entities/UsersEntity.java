package entities;

import javax.persistence.*;
import java.security.acl.Group;
import java.util.Collection;
import java.util.LinkedList;

/**
 * Created by Alexandre on 09/05/2016.
 */
@Entity
@Table(name = "users", schema = "credit_mut", catalog = "")
public class UsersEntity {
    private int id;
    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private Collection<PartiesEntity> partiesEntity;
    private Collection<GroupsEntity> groupsEntities;
    private Collection<ChoicesPartiesEntity> choicesPartiesEntities;

    public UsersEntity()
    {
        partiesEntity = new LinkedList<>();
        groupsEntities = new LinkedList<>();
        choicesPartiesEntities = new LinkedList<>();
    }

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "username", nullable = false, length = 48)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username.toLowerCase();
    }

    @Basic
    @Column(name = "password", nullable = false, length = 255)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersEntity that = (UsersEntity) o;

        if (id != that.id) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "email", nullable = false, length = 255)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "first_name", nullable = false, length = 48)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name", nullable = false, length = 48)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    private Collection<TournamentsEntity> tournamentsEntity;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "usersEntity")
    public Collection<TournamentsEntity> getTournamentsEntity() {
        return tournamentsEntity;
    }

    public void setTournamentsEntity(Collection<TournamentsEntity> tournamentsEntity) {
        this.tournamentsEntity = tournamentsEntity;
    }

    private Collection<GroupsEntity> groupsEntitiesOwn;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "owner")
    public Collection<GroupsEntity> getGroupsEntitiesOwn() {
        return groupsEntitiesOwn;
    }

    public void setGroupsEntitiesOwn(Collection<GroupsEntity> groupsEntitiesOwn) {
        this.groupsEntitiesOwn = groupsEntitiesOwn;
    }

    @OneToMany(mappedBy = "usersEntity")
    public Collection<PartiesEntity> getPartiesEntity() {
        return partiesEntity;
    }

    public void setPartiesEntity(Collection<PartiesEntity> partiesEntity) {
        this.partiesEntity = partiesEntity;
    }

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "usersEntities")
    public Collection<GroupsEntity> getGroupsEntities() {
        return groupsEntities;
    }

    public void setGroupsEntities(Collection<GroupsEntity> groupsEntities) {
        this.groupsEntities = groupsEntities;
    }

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "usersEntities")
    public Collection<ChoicesPartiesEntity> getChoicesPartiesEntities() {
        return choicesPartiesEntities;
    }

    public void setChoicesPartiesEntities(Collection<ChoicesPartiesEntity> choicesPartiesEntities) {
        this.choicesPartiesEntities = choicesPartiesEntities;
    }
}
