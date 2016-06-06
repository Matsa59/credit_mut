package entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

/**
 * Created by Alexandre on 09/05/2016.
 */
@Entity
@Table(name = "tournaments", schema = "credit_mut", catalog = "")
public class TournamentsEntity {
    private int id;
    private String name;
    private byte isPublic;
    private Collection<PartiesEntity> partiesEntity;
    private UsersEntity usersEntity;
    private Collection<GroupsEntity> groupsEntities;

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

    @ManyToOne
    @JoinColumn (name = "user_id")
    public UsersEntity getUsersEntity () {
        return usersEntity;
    }

    public void setUsersEntity(UsersEntity usersEntity) {
        this.usersEntity = usersEntity;
    }

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "tournamentsEntities")
    public Collection<GroupsEntity> getGroupsEntities() {
        return groupsEntities;
    }

    public void setGroupsEntities(Collection<GroupsEntity> groupsEntities) {
        this.groupsEntities = groupsEntities;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TournamentsEntity that = (TournamentsEntity) o;

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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tournamentsEntity", cascade = CascadeType.ALL)
    public Collection<PartiesEntity> getPartiesEntity() {
        return partiesEntity;
    }

    public void setPartiesEntity(Collection<PartiesEntity> partiesEntity) {
        this.partiesEntity = partiesEntity;
    }
}
