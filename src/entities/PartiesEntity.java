package entities;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Alexandre on 09/05/2016.
 */
@Entity
@Table(name = "parties", schema = "credit_mut", catalog = "")
public class PartiesEntity {
    private int id;
    private byte isPublic;
    private String name;
    private TournamentsEntity tournamentsEntity;
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
    @Column(name = "is_public", nullable = false)
    public byte getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(byte isPublic) {
        this.isPublic = isPublic;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 64)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne
    @JoinColumn (name = "tournament_id")
    public TournamentsEntity getTournamentsEntity() {
        return tournamentsEntity;
    }

    public void setTournamentsEntity(TournamentsEntity tournamentsEntity) {
        this.tournamentsEntity = tournamentsEntity;
    }

    @ManyToOne
    @JoinColumn (name = "user_id")
    public UsersEntity getUsersEntity () {
        return usersEntity;
    }

    public void setUsersEntity(UsersEntity usersEntity) {
        this.usersEntity = usersEntity;
    }

    @ManyToMany (cascade = CascadeType.ALL, mappedBy = "partiesEntities")
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

        PartiesEntity that = (PartiesEntity) o;

        if (id != that.id) return false;
        if (isPublic != that.isPublic) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (int) isPublic;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    private Collection<ChoicesPartiesEntity> choicesPartiesEntity;

    @OneToMany(mappedBy = "partiesEntity")
    public Collection<ChoicesPartiesEntity> getChoicesPartiesEntity() {
        return choicesPartiesEntity;
    }

    public void setChoicesPartiesEntity(Collection<ChoicesPartiesEntity> choicesPartiesEntity) {
        this.choicesPartiesEntity = choicesPartiesEntity;
    }
}
