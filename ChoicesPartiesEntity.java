package entities;

import javax.persistence.*;

/**
 * Created by Alexandre on 09/05/2016.
 */
@Entity
@Table(name = "choices_parties", schema = "credit_mut", catalog = "")
public class ChoicesPartiesEntity {
    private int id;
    private String name;

    @Id
    @Column(name = "id", nullable = false)
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ChoicesPartiesEntity that = (ChoicesPartiesEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    private PartiesEntity partiesEntity;

    @ManyToOne
    @JoinColumn (name = "party_id")
    public PartiesEntity getPartiesEntity() {
        return partiesEntity;
    }

    public void setPartiesEntity(PartiesEntity partiesEntity) {
        this.partiesEntity = partiesEntity;
    }
}
