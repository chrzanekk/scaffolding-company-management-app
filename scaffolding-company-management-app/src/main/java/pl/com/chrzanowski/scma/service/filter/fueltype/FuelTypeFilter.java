package pl.com.chrzanowski.scma.service.filter.fueltype;


import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

public class FuelTypeFilter implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private Instant createDateStartWith;
    private Instant createDateEndWith;
    private Instant modifyDateStartWith;
    private Instant modifyDateEndWith;
    private Instant removeDateStartWith;
    private Instant removeDateEndWith;

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

    public Instant getCreateDateStartWith() {
        return createDateStartWith;
    }

    public Instant getCreateDateEndWith() {
        return createDateEndWith;
    }

    public Instant getModifyDateStartWith() {
        return modifyDateStartWith;
    }

    public Instant getModifyDateEndWith() {
        return modifyDateEndWith;
    }

    public Instant getRemoveDateStartWith() {
        return removeDateStartWith;
    }

    public Instant getRemoveDateEndWith() {
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

    public FuelTypeFilter setCreateDateStartWith(Instant createDateStartWith) {
        this.createDateStartWith = createDateStartWith;
        return this;
    }

    public FuelTypeFilter setCreateDateEndWith(Instant createDateEndWith) {
        this.createDateEndWith = createDateEndWith;
        return this;
    }

    public FuelTypeFilter setModifyDateStartWith(Instant modifyDateStartWith) {
        this.modifyDateStartWith = modifyDateStartWith;
        return this;
    }

    public FuelTypeFilter setModifyDateEndWith(Instant modifyDateEndWith) {
        this.modifyDateEndWith = modifyDateEndWith;
        return this;
    }

    public FuelTypeFilter setRemoveDateStartWith(Instant removeDateStartWith) {
        this.removeDateStartWith = removeDateStartWith;
        return this;
    }

    public FuelTypeFilter setRemoveDateEndWith(Instant removeDateEndWith) {
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
        private Instant createDateStartWith;
        private Instant createDateEndWith;
        private Instant modifyDateStartWith;
        private Instant modifyDateEndWith;
        private Instant removeDateStartWith;
        private Instant removeDateEndWith;

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

        public Builder createDateStartWith(Instant createDateStartWith) {
            this.createDateStartWith = createDateStartWith;
            return this;
        }

        public Builder createDateEndWith(Instant createDateEndWith) {
            this.createDateEndWith = createDateEndWith;
            return this;
        }

        public Builder modifyDateStartWith(Instant modifyDateStartWith) {
            this.modifyDateStartWith = modifyDateStartWith;
            return this;
        }

        public Builder modifyDateEndWith(Instant modifyDateEndWith) {
            this.modifyDateEndWith = modifyDateEndWith;
            return this;
        }

        public Builder removeDateStartWith(Instant removeDateStartWith) {
            this.removeDateStartWith = removeDateStartWith;
            return this;
        }

        public Builder removeDateEndWith(Instant removeDateEndWith) {
            this.removeDateEndWith = removeDateEndWith;
            return this;
        }

        public FuelTypeFilter build() {
            return new FuelTypeFilter(this);
        }
    }
}


