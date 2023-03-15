package pl.com.chrzanowski.scma.domain;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "service_action_type")
public class ServiceActionType implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 250)
    @NotNull
    @NotBlank
    private String name;

    private Instant createDate;
    private Instant modifyDate;
    private Instant removeDate;

    @OneToMany(mappedBy = "workshop")
    private Set<WorkshopServiceActionType> workshops = new HashSet<>();

    public ServiceActionType(Long id, String name, Instant createDate, Instant modifyDate, Instant removeDate) {
        this.id = id;
        this.name = name;
        this.createDate = createDate;
        this.modifyDate = modifyDate;
        this.removeDate = removeDate;
    }

    public ServiceActionType() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Instant getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Instant createDate) {
        this.createDate = createDate;
    }

    public Instant getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Instant modifyDate) {
        this.modifyDate = modifyDate;
    }

    public Instant getRemoveDate() {
        return removeDate;
    }

    public void setRemoveDate(Instant removeDate) {
        this.removeDate = removeDate;
    }

    public Set<WorkshopServiceActionType> getWorkshops() {
        return workshops;
    }

    public void setWorkshops(Set<WorkshopServiceActionType> workshops) {
        this.workshops = workshops;
    }

    public ServiceActionType name(String name) {
        this.name = name;
        return this;
    }

    public ServiceActionType createDate(Instant createDate) {
        this.createDate = createDate;
        return this;
    }

    public ServiceActionType modifyDate(Instant modifyDate) {
        this.modifyDate = modifyDate;
        return this;
    }

    public ServiceActionType removeDate(Instant removeDate) {
        this.removeDate = removeDate;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ServiceActionType that = (ServiceActionType) o;

        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(name, that.name)) return false;
        if (!Objects.equals(createDate, that.createDate)) return false;
        if (!Objects.equals(modifyDate, that.modifyDate)) return false;
        if (!Objects.equals(removeDate, that.removeDate)) return false;
        return Objects.equals(workshops, that.workshops);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (modifyDate != null ? modifyDate.hashCode() : 0);
        result = 31 * result + (removeDate != null ? removeDate.hashCode() : 0);
        result = 31 * result + (workshops != null ? workshops.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ServiceActionType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createDate=" + createDate +
                ", modifyDate=" + modifyDate +
                ", removeDate=" + removeDate +
                ", workshops=" + workshops +
                '}';
    }
}
