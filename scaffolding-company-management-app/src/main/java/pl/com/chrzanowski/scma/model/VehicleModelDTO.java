package pl.com.chrzanowski.scma.model;

import java.time.LocalDateTime;


public class VehicleModelDTO {
    private Long id;
    private String name;
    private LocalDateTime createDate;
    private LocalDateTime modifyDate;
    private LocalDateTime removeDate;
    private Long brandId;

    public VehicleModelDTO(Long id, String name, LocalDateTime createDate, LocalDateTime modifyDate, LocalDateTime removeDate, Long brandId) {
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

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public LocalDateTime getModifyDate() {
        return modifyDate;
    }

    public LocalDateTime getRemoveDate() {
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

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (createDate != null ? !createDate.equals(that.createDate) : that.createDate != null) return false;
        if (modifyDate != null ? !modifyDate.equals(that.modifyDate) : that.modifyDate != null) return false;
        if (removeDate != null ? !removeDate.equals(that.removeDate) : that.removeDate != null) return false;
        return brandId != null ? brandId.equals(that.brandId) : that.brandId == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (modifyDate != null ? modifyDate.hashCode() : 0);
        result = 31 * result + (removeDate != null ? removeDate.hashCode() : 0);
        result = 31 * result + (brandId != null ? brandId.hashCode() : 0);
        return result;
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
        private LocalDateTime createDate;
        private LocalDateTime modifyDate;
        private LocalDateTime removeDate;
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

        public Builder brandId(Long brandId) {
            this.brandId = brandId;
            return this;
        }

        public VehicleModelDTO build() {
            return new VehicleModelDTO(this);
        }
    }
}
