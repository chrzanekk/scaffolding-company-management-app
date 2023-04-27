package pl.com.chrzanowski.scma.service.dto;

import java.time.Instant;
import java.util.Objects;
import java.util.Set;

public class ServiceActionTypeDTO {

    private Long id;
    private String name;
    private Instant createDate;
    private Instant modifyDate;
    private Instant removeDate;

    private Set<WorkshopDTO> workshops;

    public ServiceActionTypeDTO() {
    }

    private ServiceActionTypeDTO(Builder builder) {
        id = builder.id;
        name = builder.name;
        createDate = builder.createDate;
        modifyDate = builder.modifyDate;
        removeDate = builder.removeDate;
        workshops = builder.workshops;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(ServiceActionTypeDTO copy) {
        Builder builder = new Builder();
        builder.id = copy.getId();
        builder.name = copy.getName();
        builder.createDate = copy.getCreateDate();
        builder.modifyDate = copy.getModifyDate();
        builder.removeDate = copy.getRemoveDate();
        builder.workshops = copy.getWorkshops();
        return builder;
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<WorkshopDTO> getWorkshops() {
        return workshops;
    }

    public Instant getCreateDate() {
        return createDate;
    }

    public Instant getModifyDate() {
        return modifyDate;
    }

    public Instant getRemoveDate() {
        return removeDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ServiceActionTypeDTO that = (ServiceActionTypeDTO) o;

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
        return "ServiceActionTypeDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createDate=" + createDate +
                ", modifyDate=" + modifyDate +
                ", removeDate=" + removeDate +
                ", workshops=" + workshops +
                '}';
    }


    public static final class Builder {
        private Long id;
        private String name;
        private Instant createDate;
        private Instant modifyDate;
        private Instant removeDate;
        private Set<WorkshopDTO> workshops;

        private Builder() {
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder createDate(Instant createDate) {
            this.createDate = createDate;
            return this;
        }

        public Builder modifyDate(Instant modifyDate) {
            this.modifyDate = modifyDate;
            return this;
        }

        public Builder removeDate(Instant removeDate) {
            this.removeDate = removeDate;
            return this;
        }

        public Builder workshops(Set<WorkshopDTO> workshops) {
            this.workshops = workshops;
            return this;
        }

        public ServiceActionTypeDTO build() {
            return new ServiceActionTypeDTO(this);
        }
    }
}
