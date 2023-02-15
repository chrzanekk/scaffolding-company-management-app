package pl.com.chrzanowski.scma.service.filter.vehicletype;

import java.time.LocalDateTime;
import java.util.Objects;

public class VehicleTypeFilter {

    private Long id;
    private String name;
    private LocalDateTime createDateStartWith;
    private LocalDateTime createDateEndWith;
    private LocalDateTime modifyDateStartWith;
    private LocalDateTime modifyDateEndWith;
    private LocalDateTime removeDateStartWith;
    private LocalDateTime removeDateEndWith;

    public VehicleTypeFilter() {
    }

    private VehicleTypeFilter(Builder builder) {
        id = builder.id;
        name = builder.name;
        createDateStartWith = builder.createDateStartWith;
        createDateEndWith = builder.createDateEndWith;
        modifyDateStartWith = builder.modifyDateStartWith;
        modifyDateEndWith = builder.modifyDateEndWith;
        removeDateStartWith = builder.removeDateStartWith;
        removeDateEndWith = builder.removeDateEndWith;
    }

    public static Builder builder() {
        return new Builder();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getCreateDateStartWith() {
        return createDateStartWith;
    }

    public LocalDateTime getCreateDateEndWith() {
        return createDateEndWith;
    }

    public LocalDateTime getModifyDateStartWith() {
        return modifyDateStartWith;
    }

    public LocalDateTime getModifyDateEndWith() {
        return modifyDateEndWith;
    }

    public LocalDateTime getRemoveDateStartWith() {
        return removeDateStartWith;
    }

    public LocalDateTime getRemoveDateEndWith() {
        return removeDateEndWith;
    }

    public VehicleTypeFilter setId(Long id) {
        this.id = id;
        return this;
    }

    public VehicleTypeFilter setName(String name) {
        this.name = name;
        return this;
    }

    public VehicleTypeFilter setCreateDateStartWith(LocalDateTime createDateStartWith) {
        this.createDateStartWith = createDateStartWith;
        return this;
    }

    public VehicleTypeFilter setCreateDateEndWith(LocalDateTime createDateEndWith) {
        this.createDateEndWith = createDateEndWith;
        return this;
    }

    public VehicleTypeFilter setModifyDateStartWith(LocalDateTime modifyDateStartWith) {
        this.modifyDateStartWith = modifyDateStartWith;
        return this;
    }

    public VehicleTypeFilter setModifyDateEndWith(LocalDateTime modifyDateEndWith) {
        this.modifyDateEndWith = modifyDateEndWith;
        return this;
    }

    public VehicleTypeFilter setRemoveDateStartWith(LocalDateTime removeDateStartWith) {
        this.removeDateStartWith = removeDateStartWith;
        return this;
    }

    public VehicleTypeFilter setRemoveDateEndWith(LocalDateTime removeDateEndWith) {
        this.removeDateEndWith = removeDateEndWith;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VehicleTypeFilter that = (VehicleTypeFilter) o;

        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(name, that.name)) return false;
        if (!Objects.equals(createDateStartWith, that.createDateStartWith))
            return false;
        if (!Objects.equals(createDateEndWith, that.createDateEndWith))
            return false;
        if (!Objects.equals(modifyDateStartWith, that.modifyDateStartWith))
            return false;
        if (!Objects.equals(modifyDateEndWith, that.modifyDateEndWith))
            return false;
        if (!Objects.equals(removeDateStartWith, that.removeDateStartWith))
            return false;
        return Objects.equals(removeDateEndWith, that.removeDateEndWith);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (createDateStartWith != null ? createDateStartWith.hashCode() : 0);
        result = 31 * result + (createDateEndWith != null ? createDateEndWith.hashCode() : 0);
        result = 31 * result + (modifyDateStartWith != null ? modifyDateStartWith.hashCode() : 0);
        result = 31 * result + (modifyDateEndWith != null ? modifyDateEndWith.hashCode() : 0);
        result = 31 * result + (removeDateStartWith != null ? removeDateStartWith.hashCode() : 0);
        result = 31 * result + (removeDateEndWith != null ? removeDateEndWith.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "VehicleTypeFilter{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createDateStartWith=" + createDateStartWith +
                ", createDateEndWith=" + createDateEndWith +
                ", modifyDateStartWith=" + modifyDateStartWith +
                ", modifyDateEndWith=" + modifyDateEndWith +
                ", removeDateStartWith=" + removeDateStartWith +
                ", removeDateEndWith=" + removeDateEndWith +
                '}';
    }

    public static final class Builder {
        private Long id;
        private String name;
        private LocalDateTime createDateStartWith;
        private LocalDateTime createDateEndWith;
        private LocalDateTime modifyDateStartWith;
        private LocalDateTime modifyDateEndWith;
        private LocalDateTime removeDateStartWith;
        private LocalDateTime removeDateEndWith;

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

        public Builder createDateStartWith(LocalDateTime createDateStartWith) {
            this.createDateStartWith = createDateStartWith;
            return this;
        }

        public Builder createDateEndWith(LocalDateTime createDateEndWith) {
            this.createDateEndWith = createDateEndWith;
            return this;
        }

        public Builder modifyDateStartWith(LocalDateTime modifyDateStartWith) {
            this.modifyDateStartWith = modifyDateStartWith;
            return this;
        }

        public Builder modifyDateEndWith(LocalDateTime modifyDateEndWith) {
            this.modifyDateEndWith = modifyDateEndWith;
            return this;
        }

        public Builder removeDateStartWith(LocalDateTime removeDateStartWith) {
            this.removeDateStartWith = removeDateStartWith;
            return this;
        }

        public Builder removeDateEndWith(LocalDateTime removeDateEndWith) {
            this.removeDateEndWith = removeDateEndWith;
            return this;
        }

        public VehicleTypeFilter build() {
            return new VehicleTypeFilter(this);
        }
    }
}
