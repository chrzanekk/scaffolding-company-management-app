package pl.com.chrzanowski.scma.model;

import java.time.LocalDateTime;
import java.util.Objects;


public class FuelTypeDTO {

    private Long id;
    private String name;
    private LocalDateTime createDate;
    private LocalDateTime modifyDate;
    private LocalDateTime removeDate;

    public FuelTypeDTO(Long id, String name, LocalDateTime createDate, LocalDateTime modifyDate, LocalDateTime removeDate) {
        this.id = id;
        this.name = name;
        this.createDate = createDate;
        this.modifyDate = modifyDate;
        this.removeDate = removeDate;
    }

    private FuelTypeDTO(Builder builder) {
        id = builder.id;
        name = builder.name;
        createDate = builder.createDate;
        modifyDate = builder.modifyDate;
        removeDate = builder.removeDate;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public LocalDateTime getModifyDate() {
        return modifyDate;
    }

    public LocalDateTime getRemoveDate() {
        return removeDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FuelTypeDTO that = (FuelTypeDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(createDate, that.createDate) && Objects.equals(modifyDate, that.modifyDate) && Objects.equals(removeDate, that.removeDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, createDate, modifyDate, removeDate);
    }

    @Override
    public String toString() {
        return "FuelTypeDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createDate=" + createDate +
                ", modifyDate=" + modifyDate +
                ", removeDate=" + removeDate +
                '}';
    }


    public static final class Builder {
        private Long id;
        private String name;
        private LocalDateTime createDate;
        private LocalDateTime modifyDate;
        private LocalDateTime removeDate;

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

        public Builder createDate(LocalDateTime createDate) {
            this.createDate = createDate;
            return this;
        }

        public Builder modifyDate(LocalDateTime modifyDate) {
            this.modifyDate = modifyDate;
            return this;
        }

        public Builder removeDate(LocalDateTime removeDate) {
            this.removeDate = removeDate;
            return this;
        }

        public FuelTypeDTO build() {
            return new FuelTypeDTO(this);
        }
    }
}
