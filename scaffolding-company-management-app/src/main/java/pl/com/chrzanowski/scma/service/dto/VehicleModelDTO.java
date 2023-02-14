package pl.com.chrzanowski.scma.service.dto;

import java.time.Instant;
import java.util.Objects;


public class VehicleModelDTO {
    private Long id;
    private String name;
    private Instant createDate;
    private Instant modifyDate;
    private Instant removeDate;
    private Long brandId;

    public VehicleModelDTO(Long id, String name, Instant createDate, Instant modifyDate, Instant removeDate, Long brandId) {
        this.id = id;
        this.name = name;
        this.createDate = createDate;
        this.modifyDate = modifyDate;
        this.removeDate = removeDate;
        this.brandId = brandId;
    }

    private VehicleModelDTO(Builder builder) {
        id = builder.id;
        name = builder.name;
        createDate = builder.createDate;
        modifyDate = builder.modifyDate;
        removeDate = builder.removeDate;
        brandId = builder.brandId;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
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

    public Long getBrandId() {
        return brandId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VehicleModelDTO that = (VehicleModelDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(createDate, that.createDate) && Objects.equals(modifyDate, that.modifyDate) && Objects.equals(removeDate, that.removeDate) && Objects.equals(brandId, that.brandId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, createDate, modifyDate, removeDate, brandId);
    }

    @Override
    public String toString() {
        return "VehicleModelDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createDate=" + createDate +
                ", modifyDate=" + modifyDate +
                ", removeDate=" + removeDate +
                ", brandId=" + brandId +
                '}';
    }


    public static final class Builder {
        private Long id;
        private String name;
        private Instant createDate;
        private Instant modifyDate;
        private Instant removeDate;
        private Long brandId;

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

        public Builder brandId(Long brandId) {
            this.brandId = brandId;
            return this;
        }

        public VehicleModelDTO build() {
            return new VehicleModelDTO(this);
        }
    }
}
