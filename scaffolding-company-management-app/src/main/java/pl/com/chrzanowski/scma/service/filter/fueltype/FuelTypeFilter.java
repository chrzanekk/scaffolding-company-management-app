package pl.com.chrzanowski.scma.service.filter.fueltype;


import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class FuelTypeFilter implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private LocalDateTime createDateStartWith;
    private LocalDateTime createDateEndWith;
    private LocalDateTime modifyDateStartWith;
    private LocalDateTime modifyDateEndWith;
    private LocalDateTime removeDateStartWith;
    private LocalDateTime removeDateEndWith;

    public FuelTypeFilter() {
    }


    private FuelTypeFilter(Builder builder) {
        setId(builder.id);
        setName(builder.name);
        setCreateDateStartWith(builder.createDateStartWith);
        setCreateDateEndWith(builder.createDateEndWith);
        setModifyDateStartWith(builder.modifyDateStartWith);
        setModifyDateEndWith(builder.modifyDateEndWith);
        setRemoveDateStartWith(builder.removeDateStartWith);
        setRemoveDateEndWith(builder.removeDateEndWith);
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

    public FuelTypeFilter setId(Long id) {
        this.id = id;
        return this;
    }

    public FuelTypeFilter setName(String name) {
        this.name = name;
        return this;
    }

    public FuelTypeFilter setCreateDateStartWith(LocalDateTime createDateStartWith) {
        this.createDateStartWith = createDateStartWith;
        return this;
    }

    public FuelTypeFilter setCreateDateEndWith(LocalDateTime createDateEndWith) {
        this.createDateEndWith = createDateEndWith;
        return this;
    }

    public FuelTypeFilter setModifyDateStartWith(LocalDateTime modifyDateStartWith) {
        this.modifyDateStartWith = modifyDateStartWith;
        return this;
    }

    public FuelTypeFilter setModifyDateEndWith(LocalDateTime modifyDateEndWith) {
        this.modifyDateEndWith = modifyDateEndWith;
        return this;
    }

    public FuelTypeFilter setRemoveDateStartWith(LocalDateTime removeDateStartWith) {
        this.removeDateStartWith = removeDateStartWith;
        return this;
    }

    public FuelTypeFilter setRemoveDateEndWith(LocalDateTime removeDateEndWith) {
        this.removeDateEndWith = removeDateEndWith;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FuelTypeFilter that = (FuelTypeFilter) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(createDateStartWith, that.createDateStartWith) && Objects.equals(createDateEndWith, that.createDateEndWith) && Objects.equals(modifyDateStartWith, that.modifyDateStartWith) && Objects.equals(modifyDateEndWith, that.modifyDateEndWith) && Objects.equals(removeDateStartWith, that.removeDateStartWith) && Objects.equals(removeDateEndWith, that.removeDateEndWith);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, createDateStartWith, createDateEndWith, modifyDateStartWith, modifyDateEndWith, removeDateStartWith, removeDateEndWith);
    }

    @Override
    public String toString() {
        return "FuelTypeCriteria{" +
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

        public static Builder builder() {
            return new Builder();
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

        public FuelTypeFilter build() {
            return new FuelTypeFilter(this);
        }
    }
}


