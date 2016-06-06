package entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.LinkedList;

/**
 * Created by Alexandre on 09/05/2016.
 */
@Entity
@Table(name = "groups", schema = "credit_mut", catalog = "")
public class GroupsEntity {
    private int id;
    private String name;
    private byte isPublic;
    private Collection<UsersEntity> usersEntities;
    private Collection<PartiesEntity> partiesEntities;
    private Collection<TournamentsEntity> tournamentsEntities;
    private UsersEntity owner;

    public GroupsEntity()
    {
        usersEntities = new LinkedList<>();
        partiesEntities = new LinkedList<>();
        tournamentsEntities = new LinkedList<>();
    }

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 64)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "is_public", nullable = false)
    public byte getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(byte isPublic) {
        this.isPublic = isPublic;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn (name = "user_id")
    public UsersEntity getOwner() {
        return owner;
    }

    public void setOwner(UsersEntity owner) {
        this.owner = owner;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_group", joinColumns = @JoinColumn(name = "group_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
    public Collection<UsersEntity> getUsersEntities () {
        return usersEntities;
    }

    public void setUsersEntities(Collection<UsersEntity> usersEntities) {
        this.usersEntities = usersEntities;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "group_party", joinColumns = @JoinColumn(name = "group_id"), inverseJoinColumns = @JoinColumn(name = "party_id"))
    public Collection<PartiesEntity> getPartiesEntities() {
        return partiesEntities;
    }

    public void setPartiesEntities(Collection<PartiesEntity> partiesEntities) {
        this.partiesEntities = partiesEntities;
    }

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "group_tournament", joinColumns = @JoinColumn(name = "group_id"), inverseJoinColumns = @JoinColumn(name = "tournament_id"))
    public Collection<TournamentsEntity> getTournamentsEntities() {
        return tournamentsEntities;
    }

    public void setTournamentsEntities(Collection<TournamentsEntity> tournamentsEntities) {
        this.tournamentsEntities = tournamentsEntities;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupsEntity that = (GroupsEntity) o;

        if (id != that.id) return false;
        if (isPublic != that.isPublic) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (int) isPublic;
        return result;
    }
}
